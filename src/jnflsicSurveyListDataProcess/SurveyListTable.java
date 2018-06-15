
package jnflsicSurveyListDataProcess;

import javax.swing.table.DefaultTableModel;
import jnflsicSurveyListDatabase.surveyListDataManage;


public class SurveyListTable {

    public static void fillSurveyListJTable(DefaultTableModel model, String department, String area, int grade, int col, int curPage, int numRecordPrePage) {
        surveyListDataOrg s[] = surveyListDataManage.getsurevyListData(department, area, grade, curPage, numRecordPrePage);
        //System.out.println("s0:"+s[0].getID());
        System.out.println("fill: "+model);
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
            row[1] = s[i].getTeacherName();
            row[2] = s[i].getCourseName();
            row[3] = s[i].getCourseArea();
            row[4] = s[i].getGrade();
            row[5] = true;
                
            model.addRow(row);
        }
        model.fireTableStructureChanged();
    }
    
    
}
