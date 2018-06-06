
package jnflsicClassDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jnflsicCourseDataProcess.Course;
import jnflsicCourseDataProcess.CourseManage;
import jnflsicDataProcess.Pages;
import jnflsicDataProcess.Student;
import jnflsicDatabase.connectDatabase;

public class ClassData {
    private static Pages p;
//    public static Student[] getNOTInClassStuList(String studentName, String CourseInfo, int grade){
//        //select ic_student.stuID, ic_student.first_name, ic_student.middle_name, ic_student.last_name, ic_student.grade, ic_class.studentID from ic_student left join ic_class on ic_student.stuID = ic_class.studentID and ic_class.courseID=102 where ic_class.studentID is NULL and ic_student.grade = 10
//        String sql = "select ic_student.stuID, ic_student.first_name, ic_student.middle_name, ic_student.last_name, ic_student.grade, ic_class.studentID from ic_student left join ic_class on ic_student.stuID = ic_class.studentID and ic_class.courseID = ? where ic_class.studentID is NULL";
//        int stuID[] = getStudentID(studentName);
//        int CourseID = getCourseID(CourseInfo);
//        if(grade)
//        String where = " and ic_student.grade = 10";    
//        try{
//            Connection con = connectDatabase.getConnection();
//            PreparedStatement ps;
//            
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, CourseID);
//            System.out.println(ps);
//            
//            ResultSet rs = ps.executeQuery();
//            //int rs = ps.executeUpdate();
//            rs.last();
//            int row = rs.getRow();
//            rs.beforeFirst();
//            stuID = new int[row];
//            
//            int i = 0;
//            
//            while(rs.next()) {
////                JOptionPane.showMessageDialog(null, "New Course Added");
//                stuID[i] = stuID[i];
//                i++;
//            }
//
//            ps.close();
//            con.close();
//            return stuID;
//        }catch(Exception e){
//            System.err.println("ClassData.getNOTInClassStuList "+e);
//        }
//    }
    
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
                stuID[i] = stuID[i];
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
    
    public static int getNumStuInClass(int courseID){
        if(courseID<=0){
            return -1;
        }
        
        int num=0;
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            //String name[] = tName.split(" ");
            //teaFirName, teaMiddle, teaSurName
            String sql = "SELECT count(studentID) FROM ic_class where courseID = "+courseID;
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);
            
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                num = rs.getInt(1);
            }

            ps.close();
            con.close();
            return num;
        } catch (Exception e) {
            System.err.println("ClassData.studentData error" + e);
        }
        return 0;
    }
    
    public static int getTotalPages(){
        return p.getTotalPages();
    }
    
    public static Pages getP(){
        return p;
    }
    
    public static Student[] getStudentList(String courseInfo, int curPage, int numOfRecordPrePage){
        Student stuList[];
        p = new Pages(curPage, numOfRecordPrePage);
        int courseID = getCourseID(courseInfo);

        //select ic_student.stuID, ic_student.first_name, ic_student.middle_name, ic_student.last_name, ic_student.grade, ic_class.studentID from ic_student left join ic_class on ic_student.stuID = ic_class.studentID and ic_class.courseID=102 where ic_class.studentID is NULL and ic_student.grade = 10 and ic_student.stuID = 198688928
        String sql = "select ic_student.stuID, ic_student.first_name, ic_student.middle_name, ic_student.last_name, ic_student.grade, ic_class.studentID from ic_student left join ic_class on ic_student.stuID = ic_class.studentID and ic_class.courseID = ? where ic_class.studentID is Not NULL";
        String where = "";
        
        String limit = " limit "+p.getFirstNumOfRecords()+", "+p.getNumRecordsPrePages();
        setTotalPage(courseID, where);

        sql+=where;
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
            stuList = new Student[row];
            int i = 0;
            while(rs.next()){
                stuList[i] = new Student();
                stuList[i].setID(rs.getInt(1));
                stuList[i].setFName(rs.getString(2));
                stuList[i].setMName(rs.getString(3));
                stuList[i].setLName(rs.getString(4));
                stuList[i].setGrade(rs.getInt(5));
                System.out.println("list"+stuList[i].getID());
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
    
    private static void setTotalPage(int courseID, String where){
        String countSQL = "select count(ic_student.stuID), ic_class.studentID from ic_student left join ic_class on ic_student.stuID = ic_class.studentID and ic_class.courseID = "+courseID+" where ic_class.studentID is Not NULL";
        try {
            int row = connectDatabase.numberOfRow(countSQL+where);
            System.out.println("pppppppp"+row);
            p.setTotalPages(row);
        } catch (Exception ex) {
            Logger.getLogger(CourseManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean AddRecored(String studentInfo, String courseInfo) {
        String studentID = studentInfo.substring(studentInfo.indexOf(" ")+1, studentInfo.indexOf(","));
        int courseID = getCourseID(courseInfo);
        String sql = "INSERT INTO `jnflsic_sch_info`.`ic_class` (`studentID`, `courseID`, `gradeID`) VALUES ('"+studentID+"', '"+courseID+"', '0')";
        try {
                //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
                //String sql = "INSERT INTO jnflsic_sch_info.ic_student (stuID, first_name, middle_name, last_name, sex, birthdate, grade, enrollYear, phone, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                Connection con = connectDatabase.getConnection();
                PreparedStatement ps;

                ps = con.prepareStatement(sql);

                int rs = ps.executeUpdate();
                if (rs>0) {
                    JOptionPane.showMessageDialog(null, "New Student "+studentID+"Added to "+courseID+"class");
                    ps.close();
                    con.close();
                    return true;
                }

                ps.close();
                con.close();
            } catch (Exception e) {
                System.err.println("ClassData.AddRecored has a Error: " +e);
            }
            return false;
    }
    
    public static boolean RemoveRecored(int studentID, int courseID){
        try{
            String sql = "DELETE FROM jnflsic_sch_info.ic_class WHERE ic_class.studentID = ? and ic_class.courseID = ?";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            System.out.println(sql);
            ps = con.prepareStatement(sql);

            ps.setInt(1, studentID);
            ps.setInt(2, courseID);
            System.out.println("delete"+ps);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "Student studentID:"+studentID+" remove from course: "+courseID);
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
    
    public static boolean RemoveRecored(int studentID, String courseInfo) {
        int courseID = getCourseID(courseInfo);
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "DELETE FROM jnflsic_sch_info.ic_class WHERE ic_class.studentID = ? and ic_class.courseID = ?";
            
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            System.out.println(sql);
            ps = con.prepareStatement(sql);

            ps.setInt(1, studentID);
            ps.setInt(2, courseID);
            System.out.println("delete"+ps);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "Student studentID:"+studentID+" remove from course: "+courseID);
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

    public static Course[] getCourseList(String studentInfo) {
        int studentID = Integer.parseInt(studentInfo.substring(studentInfo.indexOf(" ")+1,studentInfo.indexOf(",")));
        //select ic_course.courseID, ic_course.courseName, ic_course.courseDepartmentID from ic_course where ic_course.courseID = any (select ic_class.courseID from ic_student left join ic_class on ic_student.stuID = ic_class.studentID and ic_student.stuID = 17011924 where ic_class.studentID is Not NULL)
        String sql = "select ic_course.courseID, ic_course.courseName, ic_course.courseDepartmentID from ic_course where ic_course.courseID = any (select ic_class.courseID from ic_student left join ic_class on ic_student.stuID = ic_class.studentID and ic_student.stuID = "+studentID+" where ic_class.studentID is Not NULL)";
        try{
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
            
            ps = con.prepareStatement(sql);
            
            System.out.println(ps);
            
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            rs.last();
            int row = rs.getRow();
            rs.beforeFirst();
            Course[] courseList = new Course[row];
            int i = 0;
            while(rs.next()){
                courseList[i] = new Course();
                courseList[i].setCourseID(rs.getInt(1));
                courseList[i].setName(rs.getString(2));
                courseList[i].setDepartmentID(rs.getInt(3));
                i++;
            }

            ps.close();
            con.close();
            return courseList;
        }catch(Exception e){
            System.err.println("studentData.getStudentList ERROR: "+ e);
        }
        return null; 
    }
}
