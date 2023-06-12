/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.BookDAO;
import dao.CommentDAO;
import dao.DeliveryItemDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Book;
import model.Comment;
import model.DeliveryItem;

/**
 *
 * @author emsin
 */
public class Product extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
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
        response.setContentType("text/html;charset=UTF-8");
        Account account = (Account) request.getSession().getAttribute("account"); 
        int pid= Integer.parseInt(request.getParameter("pid"));
        Book book= new BookDAO().getBookById(pid);
        List<Comment> comments = new CommentDAO().getAllCommentsByBookId(pid);
        boolean didUserBuyProduct = new DeliveryItemDAO().didUserBuyProduct(account, book);
                
        request.setAttribute("book", book);
        request.setAttribute("comments",comments );
        request.setAttribute("didUserBuyProduct",didUserBuyProduct );
        request.getRequestDispatcher("product.jsp").forward(request, response);
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
        //Sua comment
        try {
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("account");
            String username = account.getUsername();
            String content = request.getParameter("content");
            int id = Integer.parseInt(request.getParameter("id"));
            new CommentDAO().modifyComment(content,username, id);
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        String currentUrl = request.getRequestURL().toString();
        String queryString = request.getQueryString();
        currentUrl += "?" + queryString;
        response.sendRedirect(currentUrl);
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
