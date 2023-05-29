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
import java.io.BufferedReader;
import model.Book;

/**
 *
 * @author emsin
 */
public class EditProductAPI extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        Gson gson = new Gson();
        BufferedReader reader = request.getReader();
        //Get data from fetch body
        Book book = gson.fromJson(reader, Book.class);
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(new BookDAO().modifyProduct(book)));
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        Gson gson = new Gson();
        BufferedReader reader = request.getReader();
        //Get data from fetch body
        int id = gson.fromJson(reader, Integer.class);
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(new BookDAO().deleteProduct(id)));
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            updateProduct(request, response);
        } catch (Exception ex) {
            PrintWriter out = response.getWriter();
            String ans = new Gson().toJson("null");
            out.print(ans);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            updateProduct(request, response);
        } catch (Exception ex) {
            PrintWriter out = response.getWriter();
            String ans = new Gson().toJson("null");
            out.print(ans);
        }
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            deleteProduct(request, response);
        } catch (Exception ex) {
            PrintWriter out = response.getWriter();
            String ans = new Gson().toJson("failed");
            out.print(ans);
        }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
