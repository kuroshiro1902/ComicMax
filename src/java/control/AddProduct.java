/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author user
 */
@WebServlet(name = "AddProduct", urlPatterns = {"/addproduct"})
public class AddProduct extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        BookDAO bookDAO = new BookDAO();
        
        String name = request.getParameter("name").trim();
        String[] cate_id = request.getParameterValues("category_id");
        List<Integer> category_ids = new ArrayList<>();
        for(String id : cate_id){
            if(id != null){
                category_ids.add(Integer.valueOf(id));
            }
        }
        String img = request.getParameter("img");
        String language = request.getParameter("language");
        int author_id=Integer.parseInt(request.getParameter("author_id"));
        int publisher_id=Integer.parseInt(request.getParameter("publisher_id"));
        String author_name = request.getParameter("author_name");
        String publisher_name = request.getParameter("publisher_name");
        float price = Float.parseFloat(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        
//        PrintWriter out = response.getWriter();
//        out.println(name+"\n");
//        out.println(img+"\n");
//        out.println(language+"\n");
//        out.println(author_id+"\n");
//        out.println(author_name+"\n");
//        out.println(publisher_id+"\n");
//        out.println(publisher_name.equals(""));
//        out.println(price+"\n");
//        out.println(amount+"\n");

        bookDAO.addProduct(name, category_ids, img, language, author_name, author_id, publisher_name, publisher_id, price, amount);
        
        response.sendRedirect("./admin?selected=pedit");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
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
