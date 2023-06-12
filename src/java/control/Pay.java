/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DeliveryItemDAO;
import dao.ItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.DeliveryItem;
import model.Item;

/**
 *
 * @author emsin
 */
public class Pay extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("account");
            String username = account.getUsername();

            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String note = request.getParameter("note");
            String payment = request.getParameter("payment");

            DeliveryItemDAO deliveryItemDAO = new DeliveryItemDAO();
            List<Item> items = (List<Item>) session.getAttribute("items");
            List<DeliveryItem> deliveryitems = new ArrayList<>();
            for (Item item : items) {
                int book_id = item.getPid();
                int amount = item.getAmount();
                DeliveryItem deliveryitem = new DeliveryItem(username, book_id, amount, payment, address, phone, email, note, null, null, 0);
                deliveryItemDAO.addDeliveryItem(deliveryitem);
                deliveryitems.add(deliveryitem);
            }
            session.removeAttribute("items");
            float totalPrice = (float) session.getAttribute("totalPrice"); 
            session.removeAttribute("totalPrice");
            request.setAttribute("deliveryitems", deliveryitems);
            request.setAttribute("totalPrice", totalPrice);
            request.getRequestDispatcher("/done.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("./");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
