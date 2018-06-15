/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnflsicSurveyListDataProcess;

import javax.swing.table.DefaultTableModel;
import jnflsicSurveyListDatabase.surveyReportDataManage;

/**
 *
 * @author shen
 */
public class surveyReportListTable {
    public static void fillSurveyListJTable(DefaultTableModel model, String department, String area, int grade, int questionCount, int col,  int curPage, int numRecordPrePage) {
        //                                                                 dtm2, department, area, grade, QuestionsCount, 5+QuestionsCount, 0, 10
        surveyReportDataOrg s[] = surveyReportDataManage.getsurevyReportListData(department, area, grade, questionCount, curPage, numRecordPrePage);
        //System.out.println("s0:"+s[0].getID());
        System.out.println("fill: "+model);
        System.out.println(col);
        if(s==null||s.length==0){
            return;
        }
        Object[] row = null;
        //System.out.println(s.length);
        for(int i = 0; i < s.length; i++){
            row = new Object[col];    
            //for(int j = 0; j < col; j++){

        
            row[0] = s[i].getTeacherID();
            //System.out.println("lalalalala"+row[0]);
            row[1] = s[i].getTeaccherName();
            row[2] = s[i].getCourseName();
//            row[3] = s[i].getArea();
            row[3] = s[i].getGrade();
            row[4] = s[i].getNumOfStudent();
            int[]scoreGroup = s[i].getQuestionscore();
            for(int j = 0; j<scoreGroup.length; j++){
                row[j+5]= scoreGroup[j];
            }   
            model.addRow(row);
        }
        model.fireTableStructureChanged();
    }
}
