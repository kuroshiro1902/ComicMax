/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import com.google.gson.Gson;
import dao.AccountDAO;
import dao.DeliveryItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.MonthData;

/**
 *
 * @author emsin
 */
@MultipartConfig
public class Account extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @return 
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Gson gson = new Gson();
        HttpSession session = request.getSession();
        DeliveryItemDAO delidao = new DeliveryItemDAO();
        model.Account account = (model.Account) session.getAttribute("account");
        if (account == null) {
            response.sendRedirect("./account.jsp");
        }
        List<MonthData> monthDatas = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            monthDatas.add(new MonthData(i, delidao.getDoneDeliveryItemsByUserNameAndMonth(account.getUsername(), i).size()));
        }
        request.removeAttribute("message");
        request.setAttribute("monthDatas", gson.toJson(monthDatas));
        request.setAttribute("deliveringAmount", delidao.getOrderDeliveryItemsByUserName(account.getUsername()).size());
        request.setAttribute("doneAmount", delidao.getDoneDeliveryItemsByUserName(account.getUsername()).size());
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
        try {
            request.getRequestDispatcher("account.jsp").forward(request, response);
        } catch (Exception e) {
            
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
        processRequest(request, response);
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm");
        if(!password.equals(confirmPassword)){
            request.setAttribute("message", "Password does not match!");
             //dòng 92
        }
        else if(password.equals("")){
            request.setAttribute("message", "Password can not be empty!");
        }
        else{
            HttpSession session = request.getSession();
            model.Account account = (model.Account) session.getAttribute("account");
            String fullname = request.getParameter("fullname");
            String username = account.getUsername();
            // Lấy tệp tin từ yêu cầu
            Part avatarPart = request.getPart("avatar");
            if(avatarPart!=null){
                // Lưu tệp tin vào thư mục chỉ định
                String uploadDirectory = "C:/Users/emsin/OneDrive/Documents/NetBeansProjects/ComicMax/web/img/avatar";
                String fileName = UUID.randomUUID().toString() + "_" + avatarPart.getSubmittedFileName();
                String uploadPath = uploadDirectory + File.separator + fileName;
                avatarPart.write(uploadPath);
                new AccountDAO().updateAccount(account, fullname, username, password, "./img/avatar/"+fileName);
                account.setAvatar("./img/avatar/"+fileName);
            }
            else{
                new AccountDAO().updateAccount(account, fullname, username, password, null);
            }
        }
        try {
            request.getRequestDispatcher("./account.jsp").forward(request, response);
        } catch (Exception e) {
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
