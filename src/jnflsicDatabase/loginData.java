package jnflsicDatabase;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jnflsicDataProcess.Admin;

public class loginData {

    private static ResultSet rs;

    //md5 encryption

    private static String getMD5(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    //create admin account
//    public static boolean createAccount(Admin ad){
//        int res;
//        //INSERT INTO `jnflsic_sch_info`.`ic_admin` (`adminID`, `adminName`, `adminPassword`) VALUES (NULL, 'shen', MD5('123456as'));
//        try {           
//            String sql = "INSERT INTO `jnflsic_sch_info`.`ic_admin` (`adminID`, `adminName`, `adminPassword`) VALUES (NULL, '"+ad.getName()+"', MD5('"+ad.getPass()+"'));";
//            connectDatabase data = new connectDatabase(sql);
//            res = data.pst.executeUpdate();
//            if(res>0){
//                data.close();
//                return true;
//            }
//            data.close();
//        }  catch (SQLException e) {  
//        }
//        return false;
//    }

    //login account
    public static boolean login(Admin ad){
        try {
            String sql = "SELECT adminName, adminPassword FROM ic_admin WHERE adminName = ? and adminPassword = ?";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);
            ps.setString(1, ad.getName());
            ps.setString(2, getMD5(ad.getPass()));

            rs = ps.executeQuery();  
            if (rs.next()) {
                ps.close();
                con.close();
                return true;
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
}
