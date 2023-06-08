package control;

import dao.BookDAO;
import dao.Utils;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

import model.Book;
import model.PageData;

/**
 *
 * @author emsin
 */
//@WebServlet(name="Admin", urlPatterns={"/Admin/*"})
public class Admin extends HttpServlet {

    private String setValue(String param, String defaultValue) {
        return param == null ? defaultValue : param;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void editOption(HttpServletRequest request, HttpServletResponse response) {
        BookDAO bookdao = new BookDAO();
        //get Params
        String search = this.setValue(request.getParameter("search"), ""); //search words
        String index = this.setValue(request.getParameter("index"), "1");  //page_index
        //get Datas
        search = Utils.searchPrepocessor(search);
        List<Book> list = bookdao.searchBooks(search, null, null, null, null, null, null, null);
        int total = bookdao.getCount(search, null, null, null);
        PageData currentPageData = new PageData(list, total, index);
        //set Params
        request.setAttribute("index", index);
        request.setAttribute("count", currentPageData.getCount());
        request.setAttribute("products", currentPageData.getList());
        request.setAttribute("selected", "pedit");
    }

    protected void analyticsOption(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("selected", "analytics");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String selected = this.setValue(request.getParameter("selected"), "pedit"); //menu admin
        if (selected.equals("pedit")) {
            this.editOption(request, response);
        }
        switch (selected) {
            case "pedit":
                this.editOption(request, response);
                break;
            case "analytics":
                this.analyticsOption(request,response);
                break;
            default:
                this.editOption(request, response);
                break;
        }

        request.getRequestDispatcher("admin.jsp").forward(request, response);

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
