/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.BookDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author emsin
 */
@WebServlet(name="Admin", urlPatterns={"/Admin"})
public class Admin extends HttpServlet {
   private String setValue(String param, String defaultValue){
       return param == null? defaultValue : param;
   }
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        BookDAO bookdao = new BookDAO();
        String selected = this.setValue(request.getParameter("selected"),"pedit"); //menu admin
        String search = this.setValue(request.getParameter("selected"), ""); //search words
        if(selected.equals("pedit")){
            String index = this.setValue(request.getParameter("index"),"1");  //page_index
            request.setAttribute("products", bookdao.getBooksByPageIndex(Integer.parseInt(index), 10, null, null));
            
//            request.setAttribute("products", bookdao.pagingByBookList(bookdao.getAllBooks(),Integer.parseInt(index),10));
            request.setAttribute("selected", selected);
            request.setAttribute("index", index);
            request.setAttribute("count", new BookDAO().getCount());
        }
        request.getRequestDispatcher("admin.jsp?selected=pedit").forward(request, response);
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
