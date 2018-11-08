
package servlet;

import control.NewsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.News;

/**
 *
 * @author TruongDao
 */
public class NewsServlet extends HttpServlet {

   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        int sl = Integer.parseInt(request.getParameter("sl"));
        int offset = Integer.parseInt(request.getParameter("offset"));
        ArrayList<News> listNews = new NewsDAO("LapTrinhWeb", "sa", "1").select(offset, sl);
        PrintWriter pw = response.getWriter();
        pw.write(new News().newsToJson(listNews));
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
