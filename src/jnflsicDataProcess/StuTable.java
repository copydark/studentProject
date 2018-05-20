
package jnflsicDataProcess;

import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import jnflsicDatabase.studentManage;


public class StuTable {
    
    public StuTable(){
        
    }
    
    public static void fillStudentJtable(DefaultTableModel model, String keyword, int year, int col, int numOfRecordPrePage, int curPage){
        Student s[] = studentManage.getStudent(keyword, year, numOfRecordPrePage, curPage);
        //System.out.println("s0:"+s[0].getID());
        System.out.println("fill: "+model);
        if(s==null||s.length==0){
            return;
        }
        //table.clearSelection();
        //DefaultTableModel model = (DefaultTableModel)table.getModel();
        Object[] row = null;
        //System.out.println(s.length);
        for(int i = 0; i < s.length; i++){
            row = new Object[col];    
            //for(int j = 0; j < col; j++){
            row[0] = s[i].getID();
            //System.out.println("lalalalala"+row[0]);
            row[1] = s[i].getFName();
            row[2] = s[i].getMName();
            row[3] = s[i].getLName();
            row[4] = s[i].getSex();
            row[5] = s[i].getGrade();
            System.out.println("grade"+s[i].getGrade());
            //Calendar c = s[i].getBirthday();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
            row[6] = format.format(s[i].getBirthday().getTime());
            //s[i].getBirthday().get
            row[7] = s[i].getYear();
            row[8] = s[i].getPhone();
            row[9] = s[i].getAdd();
                
            //}
            model.addRow(row);
        }
        model.fireTableStructureChanged();
    }
    
    public static int totalPages(){
        return studentManage.getTotalPages();
    }
}
