/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control.api;

import com.google.gson.Gson;
import dao.BookDAO;
import dao.ItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import model.Account;
import model.Item;

/**
 *
 * @author emsin
 */
public class CartAPI extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartAPI</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartAPI at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        response.setContentType("application/json");
        Gson gson = new Gson();
        BufferedReader reader = request.getReader();
        //Get data from fetch body
        Item item = gson.fromJson(reader, Item.class);
        Account a = (Account)request.getSession().getAttribute("account");
        item.setUsername(a.getUsername());
        new ItemDAO().modifyItemInCart(item);
        PrintWriter out = response.getWriter();
	out.print(gson.toJson(item));
        out.flush();
    }
    /** 
     * Handles the HTTP <code>DELETE</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();
        BufferedReader reader = request.getReader();
        //Get data from fetch body
        int pid = gson.fromJson(reader, Integer.class);
        Account a = (Account)request.getSession().getAttribute("account"); //lay ra account dang dang nhap
        String username = a.getUsername();
        Item item = new Item(username, pid);
        new ItemDAO().deleteItem(item);

        PrintWriter out = response.getWriter();
	out.print(gson.toJson(item)); //tra nguoc lai data cho fe
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
