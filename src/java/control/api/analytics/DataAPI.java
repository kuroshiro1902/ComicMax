/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control.api.analytics;

import dao.AccountDAO;
import dao.BookDAO;
import dao.DeliveryItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;

/**
 *
 * @author emsin
 */
public class DataAPI extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        //count books
        int countBooks = new BookDAO().getCountBooks();
        String countBooksJson = "\"countBooks\":"+countBooks;
        //count accounts
        int countAccounts = new AccountDAO().countAccount();
        String countAccountsJson = "\"countAccounts\":"+countAccounts;
        //
        int currentMonth = LocalDate.now().getMonthValue();
        //current month sold
        int currentMonthSold = new DeliveryItemDAO().getAmountByMonth(currentMonth);
        String currentMonthSoldJson = "\"currentMonthSold\":"+currentMonthSold;
        //current month revenue
        float currentMonthRevenue = new DeliveryItemDAO().getRevenueByMonth(currentMonth);
        String currentMonthRevenueJson = "\"currentMonthRevenue\":"+currentMonthRevenue;
        out.print("{"
                +countBooksJson+","
                +countAccountsJson+","
                +currentMonthSoldJson+","
                +currentMonthRevenueJson
                +"}");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DataAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
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
