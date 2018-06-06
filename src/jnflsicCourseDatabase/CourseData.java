package jnflsicCourseDatabase;

import jnflsicDatabase.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import jnflsicClassDatabase.ClassData;
import jnflsicCourseDataProcess.Course;
import jnflsicDataProcess.Pages;

public class CourseData {

    private static boolean checkHash(int hash) {
        try {
            String sql = "Select courseID from jnflsic_sch_info.ic_course where courseID = ?";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, hash);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);

            if (rs.next()) {
                ps.close();
                con.close();
                return true;
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private static int toHash(String Name) {
        int hashCode = -1;
        int offset = 0;
        do {
            hashCode = Math.abs((Name).hashCode()) + offset;
            offset++;
        } while (checkHash(hashCode));
        return hashCode;
    }

    public static boolean insertData(Course c) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "INSERT INTO jnflsic_sch_info.ic_course (courseID, courseName, courseDescription, courseActive, courseValue, coursePreReq, courseDepartmentID, courseArea, teacherID, max_Students) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;

            ps = con.prepareStatement(sql);

            String courseName = c.getCourseName();
            ps.setInt(1, toHash(courseName));
            ps.setString(2, courseName);
            ps.setString(3, c.getDescription());
            ps.setBoolean(4, c.getActive());
            ps.setString(5, c.getCredit() + "");
            ps.setString(6, c.getPReq());
            ps.setString(7, c.getDepartmentID() + "");
            ps.setString(8, c.getArea());
            ps.setInt(9, c.getTeacherID());
            ps.setInt(10, c.getMaxStudent());
            System.out.println(ps);
            int rs = ps.executeUpdate();
            if (rs > 0) {
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

    public static String[] getDepartmentList() {
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
            while (rs.next()) {
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

    public static String getDepartName(int dID) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "SELECT depName FROM ic_department where depID = '" + dID + "';";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;

            ps = con.prepareStatement(sql);

            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            if (rs.next()) {
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

    public static int getDepartID(String dName) {
        if (dName.equals("ALL")) {
            return 0;
        }
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "SELECT depID FROM ic_department where depName = '" + dName + "';";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;

            ps = con.prepareStatement(sql);

            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            if (rs.next()) {
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

    public static String[] teacherList(String dID) {
        String teaName[];
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "SELECT teaSurName, teaMidName, teaFirName FROM ic_teacher where depID = '" + dID + "';";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;

            ps = con.prepareStatement(sql);

            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            rs.last();
            int rowNum = rs.getRow();
            rs.beforeFirst();
            teaName = new String[rowNum];
            int i = 0;
            while (rs.next()) {
//                JOptionPane.showMessageDialog(null, "New Course Added");
                teaName[i] = rs.getString(3) + " " + rs.getString(2) + " " + rs.getString(1);
                i++;

            }
            ps.close();
            con.close();
            return teaName;

        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

//    public static int getTeaID(String tName){
//        try {
//            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
//            String name[] = dName.split(" ");
//            String sql = "SELECT teaID FROM ic_teacher where depName = '"+tName+"';";
//            Connection con = connectDatabase.getConnection();
//            PreparedStatement ps;
//            
//            ps = con.prepareStatement(sql);
//            
//            System.out.println(ps);
//            ResultSet rs = ps.executeQuery();
//            //int rs = ps.executeUpdate();
//            if(rs.next()) {
////                JOptionPane.showMessageDialog(null, "New Course Added");
//                int depID = rs.getInt(1);
//                ps.close();
//                con.close();
//                return depID;
//            }
//
//            ps.close();
//            con.close();
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//        return -1;
//    }
    public static boolean updateData(Course c) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "UPDATE jnflsic_sch_info.ic_course SET courseID = ?, courseName = ?, courseDescription = ?, courseActive = ?, courseValue = ?, coursePreReq = ?, courseDepartmentID = ?, courseArea = ?, teacherID = ? , max_Students = ? WHERE courseID = ?;";
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
            ps.setString(8, c.getArea());
            ps.setInt(9, c.getCourseID());
            ps.setInt(10, c.getTeacherID());
            ps.setInt(11, c.getMaxStudent());
            System.out.println(ps);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            if (rs > 0) {
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
            if (rs > 0) {
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

    public static String getTeacherName(int tID) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "SELECT teaFirName, teaMidName, teaSurName FROM ic_teacher where teaID = '" + tID + "';";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;

            ps = con.prepareStatement(sql);

            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            if (rs.next()) {
//                JOptionPane.showMessageDialog(null, "New Course Added");
                String teaName = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3);
                ps.close();
                con.close();
                return teaName;
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return "N/A";
    }

    public static int getTeaIDByName(String tName) {
        if (tName.equals("") || tName == null || tName.equals("N/A")) {
            return -1;
        }
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String name[] = tName.split(" ");
            //teaFirName, teaMiddle, teaSurName
            String sql = "SELECT teaID FROM ic_teacher where teaFirName = '" + name[0] + "' and teaMidName = '" + name[1] + "' and teaSurName = '" + name[2] + "';";
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;

            ps = con.prepareStatement(sql);

            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            if (rs.next()) {
//                JOptionPane.showMessageDialog(null, "New Course Added");
                int teaID = rs.getInt(1);
                ps.close();
                con.close();
                return teaID;
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return -1;
    }

    public static String[] getCourseList(int departmentID, String area) {
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            //String name[] = tName.split(" ");
            //teaFirName, teaMiddle, teaSurName
            String course[];
            String sql = "SELECT courseID, courseName,max_Students FROM ic_course where courseDepartmentID = '" + departmentID + "'";
            if (!area.equals("N/A")) {
                sql += " and courseArea = '" + area + "'";
            }
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;

            ps = con.prepareStatement(sql);

            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            rs.last();
            int row = rs.getRow();
            rs.beforeFirst();
            course = new String[row];

            int i = 0;

            while (rs.next()) {
//                JOptionPane.showMessageDialog(null, "New Course Added");
                int courseID = rs.getInt(1);

                int maxStu = rs.getInt(3);
                int available = maxStu - ClassData.getNumStuInClass(courseID);
                course[i] = "CourseID: " + courseID + " Course Name: " + rs.getString(2) + " Available: " + available;
                i++;
            }

            ps.close();
            con.close();
            return course;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    private static int[] getCourseIDList(String courseName) {
        String sql = "select courseID from ic_course where courseName like '%" + courseName + "%'";
        int[] courseID;
        try {
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;

            ps = con.prepareStatement(sql);

            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            rs.last();
            int row = rs.getRow();
            rs.beforeFirst();
            courseID = new int[row];

            int i = 0;

            while (rs.next()) {
//                JOptionPane.showMessageDialog(null, "New Course Added");
                courseID[i] = rs.getInt(1);
                i++;
            }

            ps.close();
            con.close();
            return courseID;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    
    public static int getTotalPages() {
        return p.getTotalPages();
    }
    
    public static Pages getP(){
        return p;
    }
    
    public static Course[] getCourseList(String courseName, int departmentID, int studentID, int start, int numberRecoredPrePage) {
        Course courseList[];
        int[] courseID = null;
        p = new Pages(start, numberRecoredPrePage);
        String sql = "select ic_course.courseID, ic_course.courseName, ic_course.courseDepartmentID, ic_class.courseID, ic_class.studentID from ic_course left join ic_class on ic_course.courseID = ic_class.courseID and ic_class.studentID ="+studentID;
        String where = "";
        if (!courseName.equals("")) {
            String courseStringID = "";
            //System.out.println("trueeeeeeeeeeeee");
            courseID = getCourseIDList(courseName);
            for (int i = 0; i < courseID.length; i++) {
                courseStringID += courseID[i] + ",";
            }
            courseStringID = courseStringID.substring(0, courseStringID.length() - 1);
            where += " where ic_class.courseID is NULL and find_in_set(ic_course.courseID, '"+courseStringID+"')";
        } else {
            where += " where ic_class.courseID is NULL";
        }
        if(departmentID!=0){
            where += " and ic_course.courseDepartmentID = "+departmentID;
        }
        
        String limit = " limit "+p.getFirstNumOfRecords()+", "+p.getNumRecordsPrePages();
        setTotalPage(where);
        sql+= where+limit;
        if(p.getTotalPages()==0){
            limit = " limit "+0+", "+p.getNumRecordsPrePages();
        }
        
        try {
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;

            ps = con.prepareStatement(sql);
            //ps.setString(1, courseStringID);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            //int rs = ps.executeUpdate();
            rs.last();
            int row = rs.getRow();
            rs.beforeFirst();
            courseList = new Course[row];

            int i = 0;

            while (rs.next()) {
//                JOptionPane.showMessageDialog(null, "New Course Added");
                //ic_course.courseID, ic_course.courseName, ic_course.courseDepartmentID,
                courseList[i] = new Course();
                courseList[i].setCourseID(rs.getInt(1));
                courseList[i].setName(rs.getString(2));
                courseList[i].setDepartmentID(rs.getInt(3));
                i++;
            }

            ps.close();
            con.close();
            return courseList;
        } catch (Exception e) {
            System.err.println("CourseData.getCourseList has error: "+e);
        }
        return null;

    }
    private static Pages p;

    private static int setTotalPage(String where) {
        String sql = "select count(ic_course.courseID), ic_class.courseID from ic_course left join ic_class on ic_course.courseID = ic_class.courseID";
        sql += where;
        try {
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;

            ps = con.prepareStatement(sql);
            //ps.setString(1, courseStringID);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            int i = 0;
            int numOfRecords=0;
            if (rs.next()) {
//                JOptionPane.showMessageDialog(null, "New Course Added");
                //ic_course.courseID, ic_course.courseName, ic_course.courseDepartmentID,
                numOfRecords = rs.getInt(1);
            }
            p.setTotalPages(numOfRecords);
            ps.close();
            con.close();
            return numOfRecords;
        } catch (Exception e) {
            System.err.println("CourseData.getCourseList has error: "+e);
        }
        return 0;
    }
}
