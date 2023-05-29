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
import model.PageData;
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
        //get Params
        String search = request.getParameter("search");
//        String[] cids = request.getParameterValues("category");
        String[] cids = request.getParameterValues("category")!=null? request.getParameterValues("category") : null;
        String auid = request.getParameter("author");
        String pubid = request.getParameter("publisher");
        String id_order = request.getParameter("id_order");
        String price_order = request.getParameter("price_order");
        String page_index = request.getParameter("page_index");
        //
        String ans;
        search = Utils.searchPrepocessor(search);
        List<Book> list = bookdao.searchBooks(search, cids, auid, pubid, page_index, PageData.amount_per_page+"",id_order,price_order ); 
        int total = bookdao.getCount(search, cids, auid, pubid);
        PageData currentPageData = new PageData(list,total, page_index);
        ans = new Gson().toJson(currentPageData);
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
