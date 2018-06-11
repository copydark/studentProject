
package jnflsicSurveyListDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import jnflsicCourseDatabase.CourseData;
import jnflsicDataProcess.Pages;
import jnflsicDatabase.connectDatabase;
import jnflsicDepDatabase.departmentManage;
import jnflsicSurveyListDataProcess.surveyListDataOrg;

public class surveyListDataManage {
    private static Pages p;
    public static surveyListDataOrg[] getsurevyListData(String department, String area, int grade, int curPage, int numRecordPrePage){
        p = new Pages(curPage, numRecordPrePage);
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "select m.teacherID, m.courseName, m.courseArea, ic_teacher.teaSurName, ic_teacher.teaMidName, ic_teacher.teaFirName from \n" +
                        "(select h.grade, ic_course.courseName, ic_course.courseDepartmentID, ic_course.courseArea, ic_course.teacherID from \n" +
                        "(SELECT ic_class.courseID, ic_student.grade FROM ic_class left join ic_student on ic_student.stuID = ic_class.studentID where ic_student.grade is not null group by ic_class.courseID) h \n" +
                        "left join ic_course on h.courseID = ic_course.courseID";
                  //  "where ic_course.courseDepartmentID = 99780 and ic_course.courseArea = \"Advanced\""
            String sqlLast  = ") m left join ic_teacher on m.teacherID = ic_teacher.teaID";
            String whereGrade = " where m.grade = ";        
            
            String where=" where (ic_course.teacherID != 0 and ic_course.teacherID != -1)";
            
            if(!department.equals("ALL")){
                int depID = CourseData.getDepartID(department);
                where += " and ic_course.courseDepartmentID = "+depID;
                if(!area.equals("ALL")){
                    where += " and ic_course.courseArea = '" + area+"'";
                }
            //String countSQL = "Select count(stuID) FROM jnflsic_sch_info.ic_student";
            }else{
                if(!area.equals("ALL")){
                    where += " and ic_course.courseArea = '" + area+"'";
                }
            }
            where += sqlLast;
            if(grade!=0){
                where += whereGrade + grade;
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

           surveyListDataOrg []s = new surveyListDataOrg[size];
           
           int i = 0;
           //m.teacherID, m.courseName, m.courseArea, ic_teacher.teaSurName, ic_teacher.teaMidName, ic_teacher.teaFirName
            while(rs.next()){
                s[i] = new surveyListDataOrg();
                s[i].setTeacherID(rs.getInt(1));
                s[i].setCourseName(rs.getString(2));
                s[i].setCourseArea(rs.getString(3));
                s[i].setGrade(grade);
                s[i].setTeacherName(rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
                i++;
            }               
            ps.close();
            con.close();
            return s;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    
    
    private static void setTotalPage(String where){
        String countSQL = "select count(m.teacherID) from \n" +
                        "(select h.grade, ic_course.courseName, ic_course.courseDepartmentID, ic_course.courseArea, ic_course.teacherID from \n" +
                        "(SELECT ic_class.courseID, ic_student.grade FROM ic_class left join ic_student on ic_student.stuID = ic_class.studentID where ic_student.grade is not null group by ic_class.courseID) h \n" +
                        "left join ic_course on h.courseID = ic_course.courseID";;
        try {
            int row = connectDatabase.numberOfRow(countSQL+where);
            p.setTotalPages(row);
        } catch (Exception ex) {
            Logger.getLogger(departmentManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int getTotalPage(){
        return p.getTotalPages();
    }
    
    public static Pages getP(){
        return p;
    }
}
