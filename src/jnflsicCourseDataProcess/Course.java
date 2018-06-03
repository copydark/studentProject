
package jnflsicCourseDataProcess;

import jnflsicCourseDatabase.CourseData;
//lrfjls
public class Course {
    private int courseID;
    private String courseName;   
    private String preReq;
    private String description;  
    private boolean active;
    private int credit;
    private String area;
    private String department;
    private int departmentID;
    private int teacherID;
    private String teacherName;
    private int maxStudent;
    
    public String getTeacherName() {
        System.out.println("teacherName:"+teacherName);
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        if(teacherID <=0){
            teacherID = CourseData.getTeaIDByName(teacherName);
        }
    }
    
    public Course(){
        
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }
    
    public Course(String Name, String pReq, String des, boolean act, int c, String a, String depart, String tea, int maxStu){
        courseName = Name;
        preReq = pReq;
        description = des;
        active = act;
        credit = c;
        area = a;
        department = depart;
        departmentID = CourseData.getDepartID(depart);
        teacherID = CourseData.getTeaIDByName(tea);
        maxStudent = maxStu;
        System.out.println(maxStudent);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
        if(teacherID == -1){
            teacherName = "N/A";
            return;
        }
        if(teacherName==null || teacherName.equals("")){
            teacherName = CourseData.getTeacherName(teacherID);
        }
        System.out.println("teacherName"+teacherName);
    }
    
    public int getCourseID(){
        return courseID;
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
    
    public void setCourseID(int id){
        courseID = id;
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
        System.out.println("departmentID:  "+d);
        if(department==null||department.equals("")){
            department = CourseData.getDepartName(d);
            
        }
        departmentID = d;
    }
    
    public void setDepartmentName(String dep){
        if(departmentID >= 0){
            departmentID = CourseData.getDepartID(dep);
        }
        department = dep;
    }
    
    public static boolean operateData(char oper, Course c){
        if(oper == 'i'){
            return CourseData.insertData(c);
        }else if(oper == 'u'){
            return CourseData.updateData(c);
        }else{
            return CourseData.delateData(c);
        }
    }
}
