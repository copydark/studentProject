
package jnflsicCourseDataProcess;

import jnflsicDatabase.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jnflsicDataProcess.Pages;
import jnflsicDataProcess.Student;

public class CourseManage {
    private static Pages p;
    public static Course[] getCourse(String keyword, int departmentID, String area, int numOfRecordPrePage, int curPage){
       p = new Pages(curPage, numOfRecordPrePage);
       
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "Select courseID, courseName, courseDescription, courseActive, courseValue, coursePreReq, courseDepartmentID, courseArea FROM jnflsic_sch_info.ic_course";

            String where="";
            if(!keyword.equals("")){
                where = " where (courseName like '%"+keyword+"%')";
                if(departmentID!=-1){
                    where += " and courseDepartmentID="+departmentID;
                }
                if(!area.equals("N/A")){
                    where += " and courseArea = '"+area+"'";
                }
            }else if(departmentID!=-1){
                where = " where courseDepartmentID="+departmentID;
                if(!area.equals("N/A")){
                    where += " and courseArea = '"+area+"'";
                }
            }else{
                if(!area.equals("N/A")){
                    where += " where courseArea = '"+area+"'";
                }
            }
            setTotalPage(where);
            String limit = " limit " + p.getFirstNumOfRecords() +","+p.getNumRecordsPrePages();
            
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
//            System.out.println(sql);
            sql+=where+limit;
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            rs.last();
            
            int size = rs.getRow();
            if(size == 0){
                return null;
            }
            rs.beforeFirst();
            
            int numOfRows = numOfRecordPrePage;
            if(size<numOfRecordPrePage){
                numOfRows = size;
            }

           Course []c = new Course[numOfRows];
           int i = 0;
            while(rs.next()){
                c[i] = new Course();
                c[i].setCourseID(rs.getInt(1));
                System.out.println(rs.getString(8));
                c[i].setName(rs.getString(2));
                c[i].setDescription(rs.getString(3));
                c[i].setActive(rs.getBoolean(4));
                c[i].setcredit(rs.getInt(5));
                c[i].setPreReq(rs.getString(6));
                c[i].setDepartmentID(rs.getInt(7));
                c[i].setArea(rs.getString(8));
                
                i++;
            }  
            ps.close();
            con.close();
            return c;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    
    
    private static void setTotalPage(String where){
        String countSQL = "Select count(courseID) FROM jnflsic_sch_info.ic_course";
        try {
            int row = connectDatabase.numberOfRow(countSQL+where);
            p.setTotalPages(row);
        } catch (Exception ex) {
            Logger.getLogger(CourseManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int getTotalPages(){
        return p.getTotalPages();
    }
}
