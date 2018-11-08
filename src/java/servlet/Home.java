
package servlet;

import control.NewsDAO;
import control.NewsToJson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.News;

/**
 *
 * @author TruongDao
 */
public class Home extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
            //        response.sendRedirect("index.html");
//        String appPath = request.getServletContext().getRealPath("/json/news.json");
//        appPath = appPath.replace('\\', '/');
//        new NewsToJson().get(appPath);        
        ArrayList<News> listNews = new News().DataToNews();
        NewsDAO newsDao = new NewsDAO("LapTrinhWeb", "sa", "1");
        newsDao.insert(listNews);
        HttpSession session = request.getSession();
        if (session.isNew()){
            session.setAttribute("user", "");
            session.setAttribute("pass", "");
            RequestDispatcher rd = request.getRequestDispatcher("Main");
            rd.forward(request, response);
        }
        else{
            String user = session.getAttribute("user").toString();
            String pass = session.getAttribute("pass").toString();
            if (user.equals("")&&pass.equals("")){
                RequestDispatcher rd1 = request.getRequestDispatcher("Main");
                rd1.forward(request, response);
            }else{
                RequestDispatcher rd2 = request.getRequestDispatcher("MainPrivate");
                rd2.forward(request, response);
            }
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
