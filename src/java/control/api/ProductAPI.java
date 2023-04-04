/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control.api;

import com.google.gson.Gson;
import dao.BookDAO;
import model.Book;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import model.Account;

/**
 *
 * @author emsin
 */
class PostData{
    private int pid, amount;
    private String username;

    public PostData(int pid, int amount) {
        this.pid = pid;
        this.amount = amount;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
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
        String pid= request.getParameter("pid");
        Book book = new BookDAO().getBookById(Integer.parseInt(pid));
        String bookJson = gson.toJson(book);
        PrintWriter out = response.getWriter();
	out.print(bookJson);
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
        PostData body = gson.fromJson(reader, PostData.class);
        Account a = (Account)request.getSession().getAttribute("account");
        body.setUsername(a.getUsername());
        // query here////////////////////////////////////////////////
        PrintWriter out = response.getWriter();
	out.print(gson.toJson(body));
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
