
package jnflsicDepDatabase;

import jnflsicDatabase.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import jnflsicDepDataProcess.Department;

public class DepartmentData {
    
    private static boolean checkHash(int hash){
        try {
            String sql = "Select depID from jnflsic_sch_info.ic_department where depID = ?";
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
    
    public static boolean insertData(Department d) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "INSERT INTO jnflsic_sch_info.ic_department (depID, depName, depPhone, depDescription, depLeader) VALUES (?, ?, ?, ?, ?);";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);

            String depName = d.getName();
            String depPhone = d.getPhone();
            String depDesc = d.getDes();
            String depLeader = d.getLeader();
            ps.setInt(1, toHash(depName));
            ps.setString(2, depName);
            ps.setString(3, depPhone);
            ps.setString(4, depDesc);
            ps.setString(5, depLeader);
            System.out.println(ps);
            int rs = ps.executeUpdate();
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "New Department Added");
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
    
    public static boolean updateData(Department d){
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "UPDATE jnflsic_sch_info.ic_department SET depID = ?, depName = ?, depPhone = ?, depDescription = ?, depLeader = ? WHERE depID = ?;";
            
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            String depName = d.getName();            
            ps.setInt(1, toHash(depName));
            ps.setString(2, depName);
            ps.setString(3, d.getPhone());
            ps.setString(4, d.getDes());
            ps.setString(5, d.getLeader());
            ps.setString(6, d.getID()+"");
            System.out.println(ps);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "Department Data Updated");
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

    public static boolean delateData(Department d) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "DELETE FROM jnflsic_sch_info.ic_department WHERE ic_department.depID = ?";
            
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            System.out.println(sql);
            ps = con.prepareStatement(sql);

            ps.setInt(1, d.getID());
            System.out.println(ps);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "Department Data Delete");
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
