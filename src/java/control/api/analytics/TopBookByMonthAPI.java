/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control.api.analytics;

import com.google.gson.Gson;
import dao.AccountDAO;
import dao.BookDAO;
import dao.DeliveryItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;

/**
 *
 * @author emsin
 */
@WebServlet(name="TopBookByMonthAPI", urlPatterns={"/topbookbymonthapi"})
public class TopBookByMonthAPI extends HttpServlet {
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
        Gson gson = new Gson();
        int month = Integer.parseInt(request.getParameter("month"));
        Book topBook =  new BookDAO().getTopBookByMonth(month);
        String topbookjson = gson.toJson(topBook);
        int amount = new DeliveryItemDAO().getAmountByBookAndMonth(topBook, month);
        PrintWriter out = response.getWriter();
        out.print("{\"topBook\":"+topbookjson+",\"amount\":"+amount+"}");
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
