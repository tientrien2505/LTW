/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Qldt;

/**
 *
 * @author TruongDao
 */
public class LoginServlet extends HttpServlet {

   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            if (session.isNew()){
                session.setAttribute("user", "");
                session.setAttribute("pass", "");
                RequestDispatcher rd = request.getRequestDispatcher("Main");
                rd.forward(request, response);
            }
            else{
                String user = request.getParameter("ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtTaiKhoa");
                String pass = request.getParameter("ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtMatKhau");
                String mainQLDT = "http://qldt.ptit.edu.vn/";
                String defaultQLDT = "http://qldt.ptit.edu.vn/default.aspx";

                Qldt http = new Qldt();

                CookieHandler.setDefault(new CookieManager());

                try {
                    http.GetCookie(mainQLDT);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                String postParams = http.getFormParams(user, pass);
                try {
                    http.sendPost(defaultQLDT, postParams);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                PrintWriter pw = response.getWriter();
                boolean success = http.checkLogin(user);
                if (success){
                    pw.write("true");
                    session.setAttribute("user", user);
                    session.setAttribute("pass", pass);
                    RequestDispatcher rd = request.getRequestDispatcher("MainPrivate");
                    rd.forward(request, response);
                }else{
                    pw.write("false");
                    session.setAttribute("user", "");
                    session.setAttribute("pass", "");
                    RequestDispatcher rd = request.getRequestDispatcher("Main");
                    rd.forward(request, response);
                }
            }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
