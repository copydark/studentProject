
package jnflsicCourseDataProcess;

import jnflsicCourseDatabase.CourseData;

public class Course {
    private String courseName;   
    private String preReq;
    private String description;  
    private boolean active;
    private int credit;
    private String area;
    private String department;
    private int departmentID;
    
    public Course(){
        
    }
    
    public Course(String Name, String pReq, String des, boolean act, int c, String a, String depart){
        courseName = Name;
        preReq = pReq;
        description = des;
        active = act;
        credit = c;
        area = a;
        department = depart;
        departmentID = CourseData.getDepartID(depart);
    }
    
    public String getCourseName(){
        return courseName;
    }
    
    public String getPReq(){
        return preReq;
    }
    
    public String getDescription(){
        return description;
    }
    
    public boolean getActive(){
        return active;
    }
    
    public int getCredit(){
        return credit;
    }
    
    public String getArea(){
        return area;
    }
    
    public int getDepartmentID(){
        return departmentID;
    }
    
    public String getDepartmentName(){
        return department;
    }
    
    public void setName(String c){
        courseName = c;
    }
    
    public void setPreReq(String p){
        preReq = p;
    }
    
    public void setDescription(String d){
        description = d;
    }
    
    public void setActive(boolean a){
        active = a;
    }
    
    public void setcredit(int c){
        credit = c;
    }
    
    public void setArea(String a){
        area = a;
    }
    
    public void setDepartmentID(int d){
        departmentID = d;
    }
    
    public void setDepartmentName(String dep){
        department = dep;
    }
    
    public static boolean operateData(char oper, Course d){
        if(oper == 'i'){
            return CourseData.insertData(d);
        }else if(oper == 'u'){
            return CourseData.updateData(d);
        }else{
            return CourseData.delateData(d);
        }
    }
}
