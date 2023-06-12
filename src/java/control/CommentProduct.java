/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.CommentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Comment;

/**
 *
 * @author emsin
 */
@WebServlet(name = "CommentProduct", urlPatterns = {"/comment"})
public class CommentProduct extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Comment</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Comment at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            /*Hàm này dùng để delete comment vì sự kiện delete gọi bằng link*/
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        String username = account.getUsername();
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        String method = request.getParameter("method");
        if(method.equals("delete")){
            try {
                String id = request.getParameter("id");
                new CommentDAO().deleteComment(username, Integer.parseInt(id));
                response.sendRedirect("./product?pid=" + book_id);
            } catch (Exception ex) {
                Logger.getLogger(CommentProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        /*Còn hàm này dùng để thêm comment vì sự kiện thêm comment gọi bằng form*/
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        String username = account.getUsername();
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        String content = request.getParameter("content").trim();
        String _rating = request.getParameter("rating");
            if(_rating == null) _rating ="5";
        int rating = Integer.parseInt(_rating);
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Comment comment = new Comment(username, book_id, content, timestamp, rating, 0);
        try {
            new CommentDAO().addComment(comment);
            response.sendRedirect("./product?pid=" + book_id);

        } catch (Exception ex) {
            Logger.getLogger(CommentProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
