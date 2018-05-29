
package jnflsicTeacherDataProcess;

import java.util.Calendar;
import jnflsicTeacherDatabase.teacherData;


public class Teacher {
    private String fristName;
    private String middleName;
    private String lastName;
    private String userName;
    private char[] password;
    private char sex;
    private String position;
    private boolean valid;
    private boolean hasCertificate;
    private Calendar birthday;
    private String phone;
    private String graduateSchool;
    private String degree;
    private String major;
    private String department;
    private int departmentID;
    private int teaID;
    
    public Teacher(){
        
    }
    
    public Teacher(String fN, String MN, String LN, String UName, char[] pass, char s, String pos,
            boolean v, boolean has, Calendar date, String ph, String gSchool, String deg, String maj, String depart){
        fristName = fN;
        middleName = MN;
        lastName = LN;
        userName = UName;
        password = pass;
        sex = s;
        position = pos;
        valid = v;
        hasCertificate = has;
        birthday = date;
        phone = ph;
        graduateSchool = gSchool;
        degree = deg;
        major = maj;
        department = depart;
    }

    public int getTeaID() {
        return teaID;
    }

    public void setTeaID(int teaID) {
        this.teaID = teaID;
    }

    public String getDepartment() {
        return department;
    }

//    public void setDepartment(String department) {
//        this.department = department;
//    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isHasCertificate() {
        return hasCertificate;
    }

    public void setHasCertificate(boolean hasCertificate) {
        this.hasCertificate = hasCertificate;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    public static boolean operateData(char oper, Teacher t){
        if(oper == 'i'){
            return teacherData.insertData(t);
        }else if(oper == 'u'){
            return teacherData.updateData(t);
        }else{
            return teacherData.delateData(t);
        }
    }
    
    public void setDepartmentID(int d){
        //System.out.println(department);
        if(department==null||department.equals("")){
            department = teacherData.getDepartName(d);
            
        }
        departmentID = d;
    }
    
    public void setDepartmentName(String dep){
        if(departmentID <= 0){
            departmentID = teacherData.getDepartmentID(dep);
        }
        department = dep;
    }
}
