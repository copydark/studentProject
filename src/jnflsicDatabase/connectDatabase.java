
package jnflsicDatabase;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException; 
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectDatabase {
    public static final String url = "jdbc:mysql://127.0.0.1/jnflsic_sch_info?useUnicode=true&characterEncoding=utf-8";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "";  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
//    public connectDatabase(){  
//        try {
//            Class.forName(name);//指定连接类型  
//            conn = DriverManager.getConnection(url, user, password);//获取连接  
////            pst = conn.prepareStatement(sql);//准备执行语句  
//        } catch (Exception e) {  
//        }  
//    }  
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
            Class.forName(name);//指定连接类型  
            return DriverManager.getConnection(url, user, password);//获取连接  
    }
    
    public static int numberOfColumn(String sql){
        int columnCount = 0;
        try {
            //connectDatabase db = connectDatabase(("Select * from "+tableName));
            Connection db = getConnection();
            PreparedStatement pst = db.prepareStatement(sql);
            ResultSet rset = pst.executeQuery();
            ResultSetMetaData rsmd = rset.getMetaData() ; 
            columnCount = rsmd.getColumnCount();
            pst.close();
            db.close();
            //return columnCount;
        } catch (Exception ex) {
            Logger.getLogger(connectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnCount;
    }
    
    public static int numberOfRow(String sql){
        int row = 0;
        try {
            Connection db = getConnection();
            PreparedStatement pst = db.prepareStatement(sql);
            ResultSet rset = pst.executeQuery();
            row = (rset.next())?(rset.getInt(1)):0;
            pst.close();
            db.close();
            //return columnCount;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }
    
    public void close() {  
        try {
            this.pst.close(); 
            this.conn.close();  
             
        } catch (SQLException e) {  
            System.out.println(e);
        }  
    }  
}
