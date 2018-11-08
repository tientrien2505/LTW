/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.News;
import model.SubContent;

/**
 *
 * @author TruongDao
 */
public class NewsDAO {
    private Connection conn = null;
    private Statement stm = null;
    private PreparedStatement  pstm = null;
    private String database = "";
    private String user = "";
    private String pass = "";        

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public NewsDAO(String database, String user, String pass) {
        this.database = database;
        this.user = user;
        this.pass = pass;        
//        String connectionUrl = "jdbc:sqlserver://TRUONGDAO-PC\\KHANGHOA:1433;"
//                        + "database="+database+";"
//                        + "user="+user+";"
//                        + "password="+pass+";"
////                        + "encrypt=true;integratedSecurity=true;"
////                        + "trustServerCertificate=false;"
////                        + "hostNameInCertificate=*.database.windows.net;"
//                        + "loginTimeout=30;";
        String connectionUrl = "jdbc:sqlserver://localhost;Instance=TRUONGDAO-PC\\KHANGHOA:1433;databaseName="+database+";user="+user+";password="+pass;
        try{
            System.out.println("start");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           this.conn = DriverManager.getConnection(connectionUrl); 
            System.out.println("end");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void insert(ArrayList<News> listNews){              
        try {
            checkExist(listNews);
            for (News news : listNews){
                String query = "INSERT INTO dbo.news (link,image,title,contents,time) values"+
                "(?,?,?,?,?)";  
                pstm = conn.prepareStatement(query);
                String link = news.getLink();
                pstm.setString(1, link);
                String image = news.getImage();
                pstm.setString(2, image);
                String title = news.getTitle();
                pstm.setString(3, title);
                String content = news.getContent();
                pstm.setString(4, content);
                Timestamp time = news.getTime();
                pstm.setTimestamp(5, time);
                pstm.executeUpdate();
                SubContent subContent = new SubContent().dataToSubContent(link, time);
                insertSubContent(subContent);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void insertSubContent(SubContent subContent){
        try {
            String query = "INSERT INTO dbo.subContent (h1,h2,subContent,time,link) values"+
                    "(?,?,?,?,?)";
            pstm = conn.prepareStatement(query);
            String h1 = subContent.getH1();
            pstm.setString(1, h1);
            String h2 = subContent.getH2();
            pstm.setString(2, h2);
            String content = subContent.getContent();
            pstm.setString(3, content);            
            Timestamp time = subContent.getTime();
            pstm.setTimestamp(4, time);
            String link = subContent.getLink();
            pstm.setString(5, link);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void checkExist(ArrayList<News> listNews){
        try {
            ArrayList<News> list = listNews;
            String query = "SELECT link FROM dbo.news";
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs == null)
                return ;
            while(rs.next()){
                String link = rs.getNString("link");
                for (int i = 0; i < listNews.size(); i++){                    
                    if (listNews.get(i).getLink().equals(link)){
                        list.remove(i);
                        break;
                    }
                }
            }
            listNews = list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public SubContent selectSubContent(String link){
        try {
            String query = "SELECT * FROM dbo.subContent WHERE link="+link+";";
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            int i = 0;            
            SubContent subCotent = new SubContent();
            subCotent.setH1(rs.getNString("h1"));
            subCotent.setH2(rs.getNString("h2"));
            subCotent.setContent(rs.getNString("subContent"));
            subCotent.setTime(rs.getTimestamp("time"));
            subCotent.setLink(rs.getNString("link"));            
            return subCotent;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public ArrayList<News> select(int offset, int n){
        ArrayList<News> listNews = new ArrayList<News>();
        int sl = n+offset;
        try {
            String query = "SELECT TOP "+sl+" * FROM dbo.news ORDER BY id DESC";
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            int i = 0;
            while(rs.next()){
                if (i < offset){
                    i++;
                    continue;
                }
                News news = new News();
                news.setLink(rs.getNString("link"));
                news.setImage(rs.getNString("image"));
                news.setContent(rs.getNString("contents"));
                news.setTime(rs.getTimestamp("time"));
                news.setTitle(rs.getNString("title"));
                listNews.add(news);
            }
            return listNews;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listNews;
    }
    public static void main(String[] args) {
//        ArrayList<News> listNews = new News().DataToNews();
//        NewsDAO newsDao = new NewsDAO("LapTrinhWeb", "sa", "1");
////        newsDao.insert(listNews);
//        ArrayList<News> listNews = newsDao.select(0, 118);        
//        for (News news : listNews){
//            SubContent subContent = new SubContent
//            newsDao.insertSubContent(subContent);
//        }
    }
}
