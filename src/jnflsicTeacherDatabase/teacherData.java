
package jnflsicTeacherDatabase;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jnflsicDatabase.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import jnflsicTeacherDataProcess.Teacher;

public class teacherData {
    
    private static boolean checkHash(int hash){
        try {
            String sql = "Select teaID from jnflsic_sch_info.ic_teacher where teaID = ?";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, hash);
            ResultSet rs = ps.executeQuery();      
            System.out.println(ps);
            
            if(rs.next()){
                ps.close();
                con.close();
                //System.out.println("true");
                return true;
            }   
            ps.close();
            con.close();
        }  catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    private static int toHash(String Name){
        int hashCode = -1;
        int offset = 0;
        do{
            hashCode = Math.abs((Name).hashCode())+offset;
            offset++;
            //hashCode += offset;
            //System.out.println(checkHash(hashCode));
        }while(checkHash(hashCode));
        return hashCode;
    }
    
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
    
    public static boolean insertData(Teacher t) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "INSERT INTO jnflsic_sch_info.ic_teacher (teaID, teaSurName, teaMidName, teaFirName, teaValid, RegDate, userName, password, degree, graduSchool, position, Major, depID, teaCertificate, phone, sex, Birthday) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);
            
            String fN = t.getFristName();
            String mN = t.getMiddleName();
            String lN = t.getLastName();
            
            ps.setInt(1, toHash(fN+mN+lN));
            
            ps.setString(2, lN);
            ps.setString(3, mN);
            ps.setString(4, fN);
            ps.setBoolean(5, t.isValid());
            //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date d = new java.util.Date();
            //df.format(d);
            java.sql.Date sqlD = new java.sql.Date(d.getTime());
            ps.setDate(6, sqlD);
            
            ps.setString(7,t.getUserName());
            
            ps.setString(8,getMD5(String.valueOf(t.getPassword())));
            ps.setString(9, t.getDegree());
            ps.setString(10, t.getGraduateSchool());
            ps.setString(11, t.getPosition());
            ps.setString(12, t.getMajor());
            
            int depID = getDepartmentID(t.getDepartment());
            ps.setInt(13, depID);
            ps.setBoolean(14, t.isHasCertificate());
            ps.setString(15, t.getPhone());
            ps.setString(16, String.valueOf(t.getSex()));
            
            java.util.Date utilDate = t.getBirthday().getTime();
            java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
            ps.setDate(17, sqlDate);
            System.out.println(ps);
            int rs = ps.executeUpdate();
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "New Teacher Added");
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
    
    public static boolean updateData(Teacher t){
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "UPDATE jnflsic_sch_info.ic_teacher SET teaID = ?, teaSurName = ?, teaMidName = ?, teaFirName = ?, teaValid = ?, RegDate = ?, userName = ?, password = ?, degree = ?, graduSchool = ?, position = ?, Major = ?, depID = ?, teaCertificate = ?, phone = ?, sex = ?, Birthday = ? WHERE teaID = ?;";
            
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            String fN = t.getFristName();
            String mN = t.getMiddleName();
            String lN = t.getLastName();
            
            ps.setInt(1, toHash(fN+mN+lN));
            ps.setString(2, lN);
            ps.setString(3, mN);
            ps.setString(4, fN);
            ps.setBoolean(5, t.isValid());
            
            
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
            ps.setDate(6, sqlDate);
//            java.util.Date utilDate = t.getBirthday().getTime();
//            java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
//            ps.setDate(6, sqlDate);
            
            ps.setString(7, t.getUserName());
            ps.setString(8, getMD5(String.valueOf(t.getPassword())));
            ps.setString(9, t.getGraduateSchool());
            ps.setString(10, t.getPosition());
            ps.setString(11, t.getMajor());
            ps.setInt(12, getDepartmentID(t.getDepartment()));
            ps.setBoolean(13, t.isHasCertificate());
            //phone = ?, sex = ?, Birthday = ?
            ps.setString(14, t.getPhone());
            ps.setString(15, String.valueOf(t.getSex()));
            java.util.Date uDate = t.getBirthday().getTime();
            java.sql.Date sDate=new java.sql.Date(uDate.getTime());
            ps.setDate(16, sDate);
            
            System.out.println(ps);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "Teacher Data Updated");
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

    public static boolean delateData(Teacher t) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "DELETE FROM jnflsic_sch_info.ic_teacher WHERE ic_teacher.teaID = ?";
            
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            System.out.println(sql);
            ps = con.prepareStatement(sql);

            ps.setInt(1, t.getTeaID());
            System.out.println(ps);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "Teacher Data Delete");
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
     
    public static String[] getDepartmentList(){
        String departmentList[] = null;
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "SELECT depName FROM ic_department;";
            int numOfRecored = connectDatabase.numberOfRow("SELECT count(depName) FROM ic_department;");
            departmentList = new String[numOfRecored];
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while(rs.next()) {
                departmentList[i] = rs.getString(1);
                i++;
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return departmentList;
    }
    
    public static String getDepartName(int dID){
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "SELECT depName FROM ic_department where depID = '"+dID+"';";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);
            
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            if(rs.next()) {
//                JOptionPane.showMessageDialog(null, "New Course Added");
                String depName = rs.getString(1);
                ps.close();
                con.close();
                return depName;
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    
    public static int getDepartmentID(String department) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "SELECT depID FROM ic_department where depName = '"+department+"';";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);
            
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            if(rs.next()) {
//                JOptionPane.showMessageDialog(null, "New Course Added");
                int depID = rs.getInt(1);
                ps.close();
                con.close();
                return depID;
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return -1;}
}
