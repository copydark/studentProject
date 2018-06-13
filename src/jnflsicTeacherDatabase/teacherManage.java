
package jnflsicTeacherDatabase;

import jnflsicDatabase.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import jnflsicDataProcess.Pages;
import jnflsicTeacherDataProcess.Teacher;
public class teacherManage {
    private static Pages p;
    
//    public static byte[] hexStringToBytes(String hexString) {
//        if (hexString == null || hexString.equals("")) {
//            return null;
//        }
//        hexString = hexString.toUpperCase();
//        int length = hexString.length() / 2;
//        char[] hexChars = hexString.toCharArray();
//        byte[] d = new byte[length];
//        for (int i = 0; i < length; i++) {
//            int pos = i * 2;
//            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
//        }
//        return d;
//    }
//    
//    private static byte charToByte(char c) {
//        return (byte) "0123456789abcdef".indexOf(c);
//    }
    
    public static Teacher[] getTeacher(String keyword, String pos, String deg, int depID, String v, String has,  int numOfRecordPrePage, int curPage){
       p = new Pages(curPage-1, numOfRecordPrePage);
//       int vInt = v?1:0;
//       int hInt = has?1:0;
       
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "Select teaID, teaSurName, teaMidname, teaFirname, teaValid, RegDate, userName, password, degree, graduSchool, position, Major, depID, teaCertificate, phone, sex, Birthday FROM jnflsic_sch_info.ic_teacher";

            String where="";
            int gate = 0;
            if(!keyword.equals("")){
                where = " where (teaSurName like '%"+keyword+"%' or teaMidname like '%"+keyword+"%' or teaFirname like '%"+keyword+"%' or userName like '%"+keyword+"%')";
                gate++;
//String countSQL = "Select count(stuID) FROM jnflsic_sch_info.ic_student";
            }
            
            if(gate==0){
                if(!pos.equals("ALL")){
                    where += " where (position like '%"+pos+"%')";
                    gate++;
                }
            }else{
                if(!pos.equals("ALL")){
                    where += " AND (position like '%"+pos+"%')";
                }
            }
            
            if(gate==0){
                if(!deg.equals("")){
                    where += " where (degree like '%"+deg+"%')";
                    gate++;
                }
            }else{
                if(!deg.equals("")){
                    where += " AND (degree like '%"+deg+"%')";
                }
            }
            
            if(gate==0){
                if(depID!=0){
                    where += " where (depID="+depID+")";
                    gate++;
                }
            }else{
                if(depID!=0){
                    where += " AND (depID="+depID+")";
                }
            }
            
            if(gate==0){
                if(!v.equals("ALL")){
                    int vInt = 0;
                    if(v.equals("Valid")){
                        vInt = 1;
                    }
                    where += " where (teaValid="+vInt+")";
                    gate++;
                }
            }else{
                if(!v.equals("ALL")){
                    int vInt = 0;
                    if(v.equals("Valid")){
                        vInt = 1;
                    }
                    where += " AND (teaValid="+vInt+")";
                }
            }
            
            if(gate==0){
                if(!has.equals("ALL")){
                    int hInt = 0;
                    if(has.equals("Yes")){
                        hInt = 1;
                    }
                    where += " where (teaCertificate="+hInt+")";
                    gate++;
                }
            }else{
                if(!has.equals("ALL")){
                    int hInt = 0;
                    if(has.equals("Yes")){
                        hInt = 1;
                    }
                    where += " AND (teaCertificate="+hInt+")";
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

           Teacher []t = new Teacher[numOfRows];
           int i = 0;
            while(rs.next()){
                t[i] = new Teacher();
//teaID, teaSurName, teaMidname, teaFirname, teaValid, RegDate, userName, password, 
//degree, graduSchool, position, Major, depID, teaCertificate, phone, sex, Birthday
                t[i].setTeaID(rs.getInt(1));
                t[i].setLastName(rs.getString(2));           
                t[i].setMiddleName(rs.getString(3));
                t[i].setFristName(rs.getString(4));
                t[i].setValid(rs.getBoolean(5));
                //rs.getDate(6) regDate
                t[i].setUserName(rs.getString(7));
                t[i].setPassword(rs.getString(8).toCharArray());
                t[i].setDegree(rs.getString(9));
                t[i].setGraduateSchool(rs.getString(10));
                t[i].setPosition(rs.getString(11));
                t[i].setMajor(rs.getString(12));
                t[i].setDepartmentID(rs.getInt(13));
                t[i].setHasCertificate(rs.getBoolean(14));
                t[i].setPhone(rs.getString(15));
                t[i].setSex(rs.getString(16).charAt(0));
                Calendar c = Calendar.getInstance();
                c.setTime(rs.getDate(17));
                t[i].setBirthday(c);
                i++;
            }               
            ps.close();
            con.close();
            return t;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    
    
    private static void setTotalPage(String where){
        String countSQL = "Select count(teaID) FROM jnflsic_sch_info.ic_teacher";
        try {
            int row = connectDatabase.numberOfRow(countSQL+where);
            p.setTotalPages(row);
        } catch (Exception ex) {
            Logger.getLogger(teacherManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int getTotalPages(){
        return p.getTotalPages();
    }
}
