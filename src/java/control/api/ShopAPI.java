/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control.api;

import com.google.gson.Gson;
import dao.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.Utils;
import java.util.List;
import model.Book;
/**
 *
 * @author emsin
 */
public class ShopAPI extends HttpServlet {
//    private final Gson gson = new Gson();
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        BookDAO bookdao = new BookDAO();
        //search
        String search = request.getParameter("search");
        String[] cids = request.getParameterValues("cid");
        String auid = request.getParameter("auid");
        String pubid = request.getParameter("pubid");
        String page_index = request.getParameter("pindex");
        String amount_per_page = "12";
        String ans;
        if(search!=null && !search.equals("")){
            search = Utils.searchPrepocessor(search);
            ans = new Gson().toJson(
                bookdao.filterBooksByCategories(
                    bookdao.searchBooks(search, null, auid, pubid, page_index, amount_per_page),
                    cids
                    )
            );
        }
        else{
            ans = new Gson().toJson(new BookDAO().getTop(12));
        }
        //category

        out.print(ans);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
