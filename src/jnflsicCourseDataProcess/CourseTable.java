
package jnflsicCourseDataProcess;

import javax.swing.table.DefaultTableModel;



public class CourseTable {
    
    public CourseTable(){
        
    }
    
    public static void fillCourseJtable(DefaultTableModel model, String keyword, int departmentID, String area, int col, int numOfRecordPrePage, int curPage){
        Course c[] = CourseManage.getCourse(keyword, departmentID, area, numOfRecordPrePage, curPage);
        //System.out.println("s0:"+s[0].getID());
        System.out.println("fill: "+model);
        if(c==null||c.length==0){
            return;
        }
        //table.clearSelection();
        //DefaultTableModel model = (DefaultTableModel)table.getModel();
        Object[] row = null;
        //System.out.println(s.length);
        for(int i = 0; i < c.length; i++){
            row = new Object[col];    
            //for(int j = 0; j < col; j++){
            row[0] = c[i].getCourseID();
            //System.out.println("lalalalala"+row[0]);
            row[1] = c[i].getCourseName();
            //String active = c[i].getActive()?"Open":"Close";
            row[2] = c[i].getActive()?"Open":"Close";
            
            row[3] = c[i].getCredit();
            row[4] = c[i].getArea();
            row[5] = c[i].getDepartmentName();
            row[6] = c[i].getPReq();
            row[7] = c[i].getDescription();
            System.out.println(c[i].getDescription());
                
            //}
            model.addRow(row);
        }
        model.fireTableStructureChanged();
    }
    
    public static int totalPages(){
        return CourseManage.getTotalPages();
    }
}
