
package jnflsicCourseDatabase;

import jnflsicDatabase.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import jnflsicCourseDataProcess.Course;

public class CourseData {
    
    private static boolean checkHash(int hash){
        try {
            String sql = "Select courseID from jnflsic_sch_info.ic_course where courseID = ?";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, hash);
            ResultSet rs = ps.executeQuery();      
            System.out.println(ps);
            
            if(rs.next()){
                ps.close();
                con.close();
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
        }while(checkHash(hashCode));
        return hashCode;
    }
    
    public static boolean insertData(Course c) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "INSERT INTO jnflsic_sch_info.ic_course (courseID, courseName, courseDescription, courseActive, courseValue, coursePreReq, courseDepartmentID, courseArea) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);

            String courseName = c.getCourseName();
            ps.setInt(1, toHash(courseName));
            ps.setString(2, courseName);
            ps.setString(3, c.getDescription());
            ps.setBoolean(4, c.getActive());
            ps.setString(5, c.getCredit()+"");
            ps.setString(6, c.getPReq());
            ps.setString(7, c.getDepartmentID()+"");
            ps.setString(8, c.getArea());
            
            System.out.println(ps);
            int rs = ps.executeUpdate();
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "New Course Added");
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
    
    public static int getDepartID(String dName){
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "SELECT depID FROM ic_department where depName = '"+dName+"';";
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
        return -1;
    }
    
    public static boolean updateData(Course c){
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "UPDATE jnflsic_sch_info.ic_course SET courseID = ?, courseName = ?, courseDescription = ?, courseActive = ?, courseValue = ?, coursePreReq = ?, courseDepartmentID = ?, courseArea = ? WHERE courseID = ?;";
            //String sql = "UPDATE jnflsic_sch_info.ic_department SET depID = ?, depName = ?, depPhone = ?, depDescription = ?, depLeader = ? WHERE depID = ?;";
            
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            String courseName = c.getCourseName();            
            ps.setInt(1, toHash(courseName));
            ps.setString(2, courseName);
            ps.setString(3, c.getDescription());
            ps.setBoolean(4, c.getActive());
            ps.setInt(5, c.getCredit());
            ps.setString(6, c.getPReq());
            ps.setInt(7, c.getDepartmentID());
            ps.setString(8,c.getArea());
            ps.setInt(9,c.getCourseID());
            System.out.println(ps);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "Course Data Updated");
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

    public static boolean delateData(Course c) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "DELETE FROM jnflsic_sch_info.ic_course WHERE ic_course.courseID = ?";
            
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            System.out.println(sql);
            ps = con.prepareStatement(sql);

            ps.setInt(1, c.getCourseID());
            System.out.println(ps);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "Course Data Delete");
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
