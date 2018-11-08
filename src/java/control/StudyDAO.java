/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author TruongDao
 */
public class StudyDAO {
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

    public StudyDAO(String database, String user, String pass) {
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
    
}
