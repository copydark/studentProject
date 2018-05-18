
package jnflsicDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import jnflsicDataProcess.Student;

public class studentData {
    
    private static boolean checkHash(int hash){
        try {
            String sql = "Select stuID from jnflsic_sch_info.ic_student where stuID = ?";
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
    
    public static boolean insertData(Student s) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "INSERT INTO jnflsic_sch_info.ic_student (stuID, first_name, middle_name, last_name, sex, birthdate, grade, enrollYear, phone, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);
            String fN = s.getFName();
            String mN = s.getMName();
            String lN = s.getLName();
            
            ps.setInt(1, toHash(fN+mN+lN));
            ps.setString(2, fN);
            ps.setString(3, mN);
            ps.setString(4, lN);
            ps.setString(5,String.valueOf(s.getSex()));

            java.util.Date utilDate = s.getBirthday().getTime();
            java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
            ps.setDate(6, sqlDate);
            
            ps.setInt(7, s.getGrade());
            ps.setInt(8, s.getYear());
            ps.setString(9, s.getPhone());
            ps.setString(10, s.getAdd());

            int rs = ps.executeUpdate();
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "New Student Added");
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
    
    public static boolean updateData(Student s){
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "UPDATE jnflsic_sch_info.ic_student SET stuID = ?, first_name = ?, middle_name = ?, last_name = ?, sex = ?, birthdate = ?, grade = ?, enrollYear = ?, phone = ?, address = ? WHERE stuID = ?;";
            
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            String fN = s.getFName();
            String mN = s.getMName();
            String lN = s.getLName();
            
            ps.setInt(1, toHash(fN+mN+lN));
            ps.setString(2, fN);
            ps.setString(3, mN);
            ps.setString(4, lN);
            ps.setString(5,String.valueOf(s.getSex()));

            java.util.Date utilDate = s.getBirthday().getTime();
            java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
            ps.setDate(6, sqlDate);
            
            ps.setInt(7, s.getGrade());
            ps.setInt(8, s.getYear());
            ps.setString(9, s.getPhone());
            ps.setString(10, s.getAdd());
            ps.setInt(11, s.getID());
            System.out.println(ps);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "Student Data Updated");
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

    public static boolean delateData(Student s) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "DELETE FROM jnflsic_sch_info.ic_student WHERE ic_student.stuID = ?";
            
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            System.out.println(sql);
            ps = con.prepareStatement(sql);

            ps.setInt(1, s.getID());
            System.out.println(ps);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "Student Data Delete");
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
