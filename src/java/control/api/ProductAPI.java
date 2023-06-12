/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control.api;

import com.google.gson.Gson;
import dao.BookDAO;
import dao.ItemDAO;
import model.Book;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.List;
import model.Account;
import model.Item;
/**
 *
 * @author emsin
 */
public class ProductAPI extends HttpServlet {
   
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
        
        response.setContentType("application/json");
        Gson gson = new Gson();
        BookDAO bookDao = new BookDAO();
        String pid= request.getParameter("pid");
        Book book = bookDao.getBookById(Integer.parseInt(pid));
        List<Book> relatedBooks = bookDao.getRelatedBooks(book);
        String bookJson = gson.toJson(book);
        String relatedBooksJson = gson.toJson(relatedBooks);
        PrintWriter out = response.getWriter();
	out.print("{\"book\":"+bookJson+",\"relatedBooks\":"+relatedBooksJson+"}");
        out.flush();
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
        response.setContentType("application/json");
        Gson gson = new Gson();
        BufferedReader reader = request.getReader();
        //Get data from fetch body
        Item item = gson.fromJson(reader, Item.class);
        Account a = (Account)request.getSession().getAttribute("account");
        item.setUsername(a.getUsername());
        new ItemDAO().addItemToCart(item);
        // query here////////////////////////////////////////////////
        item.setImg(new BookDAO().getBookById(item.getPid()).getImg());
        PrintWriter out = response.getWriter();
	out.print(gson.toJson(item));
        out.flush();
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
