package context;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public Connection getConnection()throws Exception {        
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber +
                ";databaseName="+dbName;//+"; integratedSecurity=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");         
        return DriverManager.getConnection(url, userID, password);
//        return DriverManager.getConnection(url);
    }
    
    /*Insert your other code right after this comment*/
   
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "ComicMax";
    private final String portNumber = "1143";
    private final String userID = "sa";
    private final String password = "admin";
  
 
}
class Test{
    public static void main(String[] args) {
        DBContext db = new DBContext();
        Connection con =null;
        try {
            con = db.getConnection();
            System.out.println("ket noi thang cong");
        } catch (Exception e) {
            System.out.println("ket noi that bai"+ e.getMessage());
        }
    }
}  