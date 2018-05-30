
package jnflsicTeacherDataProcess;

import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import jnflsicTeacherDatabase.teacherData;
import jnflsicTeacherDatabase.teacherManage;


public class TeaTable {
    
    public TeaTable(){
        
    }
//    (dtm2, key, pos, degree, depart, v, has, jTable1.getColumnCount(), tableNumOfRecords, tablePages);
    public static void fillTeaJtable(DefaultTableModel model, String keyword, String pos, String deg, String dep, String v, String has, int col, int numOfRecordPrePage, int curPage){
        int departID = teacherData.getDepartmentID(dep);
        Teacher t[] = teacherManage.getTeacher(keyword, pos, deg, departID, v, has, numOfRecordPrePage, curPage);
        //System.out.println("s0:"+s[0].getID());
        System.out.println("fill: "+model);
        if(t==null||t.length==0){
            return;
        }
        //table.clearSelection();
        //DefaultTableModel model = (DefaultTableModel)table.getModel();
        Object[] row = null;
        //System.out.println(s.length);
        for(int i = 0; i < t.length; i++){
            row = new Object[col];    
            //for(int j = 0; j < col; j++){
            row[0] = t[i].getTeaID();
            //System.out.println("lalalalala"+row[0]);
            row[1] = t[i].getFristName();
            row[2] = t[i].getMiddleName();
            row[3] = t[i].getLastName();
            row[4] = t[i].getSex();
            row[5] = t[i].getPosition();
            //System.out.println("grade"+s[i].getGrade());
            //Calendar c = s[i].getBirthday();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
            row[6] = format.format(t[i].getBirthday().getTime());
            //s[i].getBirthday().get
            row[7] = t[i].getDepartment();
            row[8] = t[i].getPhone();
            row[9]="Inactived";
            if(t[i].isValid()){
                row[9]="Working";
            }
            
            row[10] = "Has Certificate";
            if(!t[i].isHasCertificate()){
                row[10] = "Do not have Certificate";
            }
            
            row[11] = t[i].getGraduateSchool();
            row[12] = t[i].getDegree();
            row[13] = t[i].getMajor();
            row[14] = t[i].getUserName();
            row[15] = t[i].getPassword();
            
            //}
            model.addRow(row);
        }
        model.fireTableStructureChanged();
    }
    
    public static int totalPages(){
        return teacherManage.getTotalPages();
    }
}
