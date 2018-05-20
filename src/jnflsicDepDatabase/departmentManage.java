
package jnflsicDepDatabase;

import jnflsicDatabase.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import jnflsicDataProcess.Pages;
import jnflsicDepDataProcess.Department;

public class departmentManage {
    private static Pages p;
    public static Department[] getDepartment(String keyword, String leader, int numOfRecordPrePage, int curPage){
       p = new Pages(curPage, numOfRecordPrePage);
       
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "Select depID, depname, depPhone, depDescription, depLeader FROM jnflsic_sch_info.ic_department";

            String where="";
            if(!keyword.equals("")){
                where = " where (depname like '%"+keyword+"%')";
                if(!leader.equals("")){
                    where += " (depLeader like '%"+leader+"%')";
                }
            //String countSQL = "Select count(stuID) FROM jnflsic_sch_info.ic_student";
            }else{
                if(!leader.equals("")){
                    where = " where (depLeader like '%"+leader+"%')";
                }
            }
            setTotalPage(where);
            String limit = " limit " + p.getFirstNumOfRecords() +","+p.getNumRecordsPrePages();
            
            //sql+=where;
            //p.setTotalPages(year);
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

           Department []d = new Department[numOfRows];
           int i = 0;
            while(rs.next()){
                d[i] = new Department();
                d[i].setID(rs.getInt(1));
                d[i].setName(rs.getString(2));           
                d[i].setPhone(rs.getString(3));
                d[i].setDescription(rs.getString(4));
                d[i].setLeader(rs.getString(5));
                i++;
            }               
            ps.close();
            con.close();
            return d;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    
    
    private static void setTotalPage(String where){
        String countSQL = "Select count(depID) FROM jnflsic_sch_info.ic_department";
        try {
            int row = connectDatabase.numberOfRow(countSQL+where);
            p.setTotalPages(row);
        } catch (Exception ex) {
            Logger.getLogger(departmentManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int getTotalPages(){
        return p.getTotalPages();
    }
}
