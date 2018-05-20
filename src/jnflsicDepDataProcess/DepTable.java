
package jnflsicDepDataProcess;

import jnflsicDataProcess.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import jnflsicDatabase.studentManage;
import jnflsicDepDatabase.departmentManage;


public class DepTable {
    
    public DepTable(){
        
    }
    
    public static void fillDepJtable(DefaultTableModel model, String keyword, String leader, int col, int numOfRecordPrePage, int curPage){
        Department d[] = departmentManage.getDepartment(keyword, leader, numOfRecordPrePage, curPage);
        //System.out.println("s0:"+s[0].getID());
        System.out.println("fill: "+model);
        if(d==null||d.length==0){
            return;
        }
        Object[] row = null;
        //System.out.println(s.length);
        for(int i = 0; i < d.length; i++){
            row = new Object[col];    
            //for(int j = 0; j < col; j++){
            row[0] = d[i].getID();
            //System.out.println("lalalalala"+row[0]);
            row[1] = d[i].getName();
            row[2] = d[i].getLeader();
            row[3] = d[i].getPhone();
            row[4] = d[i].getDes();
                
            model.addRow(row);
        }
        model.fireTableStructureChanged();
    }
    
    public static int totalPages(){
        return departmentManage.getTotalPages();
    }
}
