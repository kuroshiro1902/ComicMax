package control;

import dao.BookDAO;
import dao.DeliveryItemDAO;
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
    protected void deliveryOption(HttpServletRequest request, HttpServletResponse response) {
        String type = request.getParameter("type");
        String startTime = request.getParameter("start-time");
        String endTime = request.getParameter("end-time");
        if(type==null) type="order";
        switch (type) {
            case "order":
                request.setAttribute("deliveryItemList", new DeliveryItemDAO().getAllOrderDeliveryItemsByTime(startTime, endTime));
                request.setAttribute("type", "order");
                break;
            case "done":
                request.setAttribute("deliveryItemList", new DeliveryItemDAO().getAllDoneDeliveryItemsByTime(startTime, endTime));
                request.setAttribute("type", "done");
                break;
            default:
                request.setAttribute("deliveryItemList", new DeliveryItemDAO().getAllOrderDeliveryItemsByTime(startTime, endTime));
                request.setAttribute("type", "order");
                break;
        }
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        request.setAttribute("selected", "delivery");
        
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
            case "delivery":
                this.deliveryOption(request,response);
                break;
            default:
                this.editOption(request, response);
                break;
        }

        request.getRequestDispatcher("admin.jsp").forward(request, response);

    }

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
