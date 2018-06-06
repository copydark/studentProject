
package jnflsicDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jnflsicCourseDataProcess.CourseManage;
import jnflsicDataProcess.Pages;
import jnflsicDataProcess.Student;

public class studentData {
    
    private static Pages p;
    
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
    
    private static void setTotalPage(int courseID, String where){
        String countSQL = "select count(ic_student.stuID), ic_class.studentID from ic_student left join ic_class on ic_student.stuID = ic_class.studentID and ic_class.courseID = "+courseID+" where ic_class.studentID is NULL";
        try {
            int row = connectDatabase.numberOfRow(countSQL+where);
            System.out.println("pppppppp"+row);
            p.setTotalPages(row);
        } catch (Exception ex) {
            Logger.getLogger(CourseManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static int getCourseID(String courseInfo){
        //"CourseID: "+rs.getString(1)+" Course Name: "+rs.getString(2)
        return Integer.parseInt(courseInfo.substring(courseInfo.indexOf(" ")+1, courseInfo.indexOf(" Course Name:")));
        
    }
    
    private static int[] getStudentID(String studentName){
        if(studentName.equals("")||studentName==null){
            return null;
        }
        
        int stuID[];
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            //String name[] = tName.split(" ");
            //teaFirName, teaMiddle, teaSurName
            String sql = "SELECT stuID FROM ic_student where first_name like '%"+studentName+"%' or middle_name like '%"+studentName+"%' or last_name like '%"+studentName+"%'";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);
            
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            rs.last();
            int row = rs.getRow();
            rs.beforeFirst();
            stuID = new int[row];
            
            int i = 0;
            
            while(rs.next()) {
//                JOptionPane.showMessageDialog(null, "New Course Added");
                stuID[i] = rs.getInt(1);
                i++;
            }

            ps.close();
            con.close();
            return stuID;
        } catch (Exception e) {
            System.err.println("ClassData.studentData error" + e);
        }
        return null;
    }
    
    public static String[] getStudentList(String name, String grade){
        String stuList[];
        String sql = "select ic_student.stuID, ic_student.first_name, ic_student.middle_name, ic_student.last_name, ic_student.grade from ic_student";
        String where = "";
        if(!name.equals("")){
            where += " where (first_name like '%"+name+"%' or middle_name like '%"+name+"%' or last_name like '%"+name+"%')";
            if(grade.equals("ALL")){
                where += " and (grade = 10 or grade = 11 or grade = 12)";
            }else{
                where += " and grade = "+grade;
            }
        }else{
            if(grade.equals("ALL")){
                where += " where grade = 10 or grade = 11 or grade = 12";
            }else{
                where += " where grade = "+grade;
            }
        }
        sql+=where;
        try{
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);
            //ps.setInt(1, courseID);
            System.out.println(ps);
            
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            rs.last();
            int row = rs.getRow();
            rs.beforeFirst();
            stuList = new String[row];
            int i = 0;
            while(rs.next()){
                stuList[i] = "StudentID: "+rs.getString(1)+","+"Student Name: "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+", Grade: "+rs.getString(5);
                //System.out.println("list"+stuList[i]);
                i++;
            }

            ps.close();
            con.close();
            return stuList;
        }catch(Exception e){
            System.err.println("studentData.getStudentList ERROR: "+ e);
        }
        return null;
    }
    
    public static String[] getStudentList(String name, int grade, String courseInfo, int curPage, int numOfRecordPrePage){
        String stuList[];
        p = new Pages(curPage, numOfRecordPrePage);
        int[] stuID = getStudentID(name);
        int courseID = getCourseID(courseInfo);
        String stuIDGroup = "";
//        if(stuID==null){
//            return null;
//        }
        if(stuID!=null){
            for(int i = 0; i<stuID.length; i++){
                stuIDGroup += stuID[i]+",";
            }
             //delete the last ,
            stuIDGroup= stuIDGroup.substring(0, stuIDGroup.length()-1);
        }

        //select ic_student.stuID, ic_student.first_name, ic_student.middle_name, ic_student.last_name, ic_student.grade, ic_class.studentID from ic_student left join ic_class on ic_student.stuID = ic_class.studentID and ic_class.courseID=102 where ic_class.studentID is NULL and ic_student.grade = 10 and ic_student.stuID = 198688928
        String sql = "select ic_student.stuID, ic_student.first_name, ic_student.middle_name, ic_student.last_name, ic_student.grade, ic_class.studentID from ic_student left join ic_class on ic_student.stuID = ic_class.studentID and ic_class.courseID = ? where ic_class.studentID is NULL";
        String where = "";
//        System.out.println("grade:"+grade);
        if(grade!=0){
            grade = grade+9;
            where += " and ic_student.grade = "+grade; 
            if(stuID!=null && stuID.length>0){
                where += " and find_in_set(ic_student.stuID, '"+stuIDGroup+"')";
            }
        }else{
            if(stuID!=null && stuID.length>0){
                where += " and find_in_set(ic_student.stuID, '"+stuIDGroup+"')";
            }
        }
        
        String limit = " limit "+p.getFirstNumOfRecords()+", "+p.getNumRecordsPrePages();
        setTotalPage(courseID, where);
        if(p.getTotalPages()==0){
            limit = " limit "+0+", "+p.getNumRecordsPrePages();
        }
        sql+=where+limit;
        try{
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, courseID);
            System.out.println(ps);
            
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            rs.last();
            int row = rs.getRow();
            rs.beforeFirst();
            stuList = new String[row];
            int i = 0;
            while(rs.next()){
                stuList[i] = "StudentID: "+rs.getString(1)+","+"Student Name: "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+", Grade: "+rs.getString(5);
                System.out.println("list"+stuList[i]);
                i++;
            }

            ps.close();
            con.close();
            return stuList;
        }catch(Exception e){
            System.err.println("studentData.getStudentList ERROR: "+ e);
        }
        return null;
//        p = new Pages(curPage, numOfRecordPrePage);
//        try {
//            String sql = "Select stuID, first_name, middle_name, last_name, grade from jnflsic_sch_info.ic_student";
//            
//            if(grade!=0){
//                grade = grade+9;
//            }
//            System.out.println(grade);
//            String where ="";
//            if(!name.equals("")){
//                where="where first_name like '%"+name+"%' or middel_name like '%"+name+"%' or last_name like '%"+name+"%'";
//                if(grade>=10){
//                    where =" and grade="+ grade;
//                }
//            }else{
//                if(grade>=10){
//                    where=" where grade="+ grade;
//                }
//            }
//            
//            setTotalPage(where);
//            
//            sql += where +" limit "+ p.getFirstNumOfRecords() +","+p.getNumRecordsPrePages();
//            Connection con = connectDatabase.getConnection();
//            PreparedStatement ps = con.prepareStatement(sql);
//            System.out.println(ps);
//            ResultSet rs = ps.executeQuery();      
//            System.out.println(ps);
//            rs.last();
//            int row = rs.getRow();
//            rs.beforeFirst();
//            String nameData[] = new String[row];
//            int i = 0;
//            while(rs.next()){
//                nameData[i]= "StudentID: "+rs.getInt(1)+" Name: "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+ " Grade:"+ rs.getInt(5);
//                i++;
//            }   
//            ps.close();
//            con.close();
//            return nameData;
//        }  catch (Exception e) {
//            System.out.println(e);
//        }
//        return null;
    }
    
    public static int getTotalPages() {
        return p.getTotalPages();
    }
    
    public static Pages getP(){
        return p;
    }
}
