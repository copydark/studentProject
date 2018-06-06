/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnflsicClassDataProcess;


import javax.swing.table.DefaultTableModel;
import jnflsicClassDatabase.ClassData;
import jnflsicCourseDataProcess.Course;
import jnflsicDataProcess.Pages;
import jnflsicDataProcess.Student;
import jnflsicDatabase.studentData;



public class ClassTable {

    public static void fillClassCourseJtable(DefaultTableModel model, String studentInfo, int col) {
        Course c[] = ClassData.getCourseList(studentInfo);
        //System.out.println("fill: "+model);
        //p = new Pages(curPage, numOfRecordPrePage);
        if(c==null||c.length==0){
            return;
        }
        Object[] row = null;
        for(int i = 0; i < c.length; i++){
            row = new Object[col];    
            row[0] = c[i].getCourseID();
            row[1] = c[i].getCourseName();
            row[2] = c[i].getDepartmentName();
            //System.out.println(c[i].getID());
            model.addRow(row);
        }
        model.fireTableStructureChanged();
    }
    
    public ClassTable(){
        
    }
    
    public static void fillClassJtable(DefaultTableModel model, String courseInfo, int col, int curPage, int numOfRecordPrePage){
        Student c[] = ClassData.getStudentList(courseInfo, curPage, numOfRecordPrePage);
        System.out.println("fill: "+model);
        //p = new Pages(curPage, numOfRecordPrePage);
        if(c==null||c.length==0){
            return;
        }
        Object[] row = null;
        for(int i = 0; i < c.length; i++){
            row = new Object[col];    
            row[0] = c[i].getID();
            row[1] = c[i].getFName()+" "+c[i].getMName()+" "+c[i].getLName();
            row[2] = c[i].getGrade();
            System.out.println(c[i].getID());
            model.addRow(row);
        }
        model.fireTableStructureChanged();
    }
    
    public static int totalPages(){
        return ClassData.getTotalPages();
    }
}

