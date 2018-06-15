/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnflsicSurveyListDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jnflsicDatabase.connectDatabase;
import jnflsicSurveyListDataProcess.surveyReportDataOrg;

/**
 *
 * @author shen
 */
public class surveyReportDataManage {
//    private static Pages p;
    public static surveyReportDataOrg[] getsurevyReportListData(String department, String area, int grade, int questionCount, int curPage, int numRecordPrePage) {
        //p = new Pages(curPage-1, numRecordPrePage);
        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "Select teacherID, teacherName, courseName, grade, sum(`count`), sum(score1), sum(score2), sum(score3), sum(score4), sum(score5), sum(score6), sum(score6), sum(score7), sum(score8), sum(score9), sum(score10), sum(score11), sum(score12), sum(score13), sum(score14), sum(score15) from ic_survey_teacher";
            String where = "";
            if(grade!=0){
                grade += 9;
                where = " where grade = "+grade;    
            }   
            String group = " group by teacherID, courseName, grade";
            sql += where+group;
//            if(!department.equals("ALL")){
//                int depID = CourseData.getDepartID(department);
//                where += " and ic_course.courseDepartmentID = "+depID;
//                if(!area.equals("ALL")){
//                    where += " and ic_course.courseArea = '" + area+"'";
//                }
//            //String countSQL = "Select count(stuID) FROM jnflsic_sch_info.ic_student";
//            }else{
//                if(!area.equals("ALL")){
//                    where += " and ic_course.courseArea = '" + area+"'";
//                }
//            }
//            where += sqlLast;
//            if(grade!=0){
//                where += whereGrade + grade;
//            }
            
//            setTotalPage(where);
//            String limit = " limit " + p.getFirstNumOfRecords() +","+p.getNumRecordsPrePages();

            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
//            System.out.println(sql);
//            sql+=where+limit;
            
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            rs.last();
            
            int size = rs.getRow();
            if(size == 0){
                return null;
            }
            rs.beforeFirst();

           surveyReportDataOrg []s = new surveyReportDataOrg[size];
           
           int i = 0;
           //teacherID, teacherName, courseName, grade, `count`, score
            while(rs.next()){
                if(rs.getInt(5)==0){
                    continue;
                }
                s[i] = new surveyReportDataOrg();
                s[i].setTeacherID(rs.getInt(1));
                s[i].setTeaccherName(rs.getString(2));
                s[i].setCourseName(rs.getString(3));
                s[i].setGrade(rs.getInt(4));
                s[i].setNumOfStudent(rs.getInt(5));
                String scores = rs.getString(6);
                int scoreInt[] = new int[15];
                for(int j = 0; j<scoreInt.length; j++){
                    scoreInt[j] = rs.getInt(j+7);
                }
                s[i].setQuestionscore(scoreInt);
                i++;
            }
            
            ps.close();
            con.close();
            return s;
        } catch (Exception e) {
            System.err.println("surverReportDataManage.surveyReportDataManage"+e);
        }
        return null;
        
    }
    
    
    public static int getQuestionNum() {
        String sql = "select score from ic_survey_teacher limit 0, 1";
        try {
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
//            System.out.println(sql);
            
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            String bi1 = "";
            if(rs.next()){
                bi1 = rs.getString(1);
            }               
            ps.close();
            con.close();
            return bi1.length();
        } catch (Exception e) {
            System.err.println(e);
        }
        return -1;
    }
    
}
