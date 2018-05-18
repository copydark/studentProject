
package jnflsicDataProcess;

import java.util.Calendar;
import jnflsicDatabase.studentData;

public class Student {
    private int StuID;
    private String fName;
    private String mName;
    private String lName;
    private char sex;
    private int grade;
    private Calendar birthday;
    private int year;
    private String phoneNum;
    private String add;
    
    public Student(){
        
    }
    
    public Student(String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add){
        this.fName = firstName;
        this.mName = middleName;
        this.lName = lastName;
        this.sex = sex;
        this.grade = grade;
        this.birthday = birthday;
        this.year = year;
        this.phoneNum = phoneNum;
        this.add = add;
    }
    
    public void setID(int id){
        this.StuID = id;
    }
    
    public void setFName(String n){
        this.fName = n;
    }
    
    public void setMName(String n){
        this.mName = n;
    }
    
    public void setLName(String n){
        this.lName = n;
    }
    
    public void setSex(char s){
        this.sex = s;
    }
    
    public void setGrade(int g){
        this.grade = g;
    }
    
    public void setDate(Calendar d){
        this.birthday = d;
    }
    
    public void setAdd(String a){
        this.add = a;
    }
    
    public void setPhone(String p){
        this.phoneNum = p;
    }
    
    public void setYear(int y){
        this.year = y;
    }
    
    public int getID(){
        return this.StuID;
    }
    
    public String getFName(){
        return this.fName;
    }
    
    public String getMName(){
        return this.mName;
    }
    
    public String getLName(){
        return this.lName;
    }
    
    public char getSex(){
        return this.sex;
    }
    
    public int getGrade(){
        return this.grade;
    }
    
    public Calendar getBirthday(){
        return this.birthday;
    }
    
    public String getPhone(){
        return this.phoneNum;
    }
    
    public String getAdd(){
        return this.add;
    }
    
    public int getYear(){
        return this.year;
    }
    
    public static boolean operateData(char oper, Student s){
        if(oper == 'i'){
            return studentData.insertData(s);
        }else if(oper == 'u'){
            return studentData.updateData(s);
        }else{
            return studentData.delateData(s);
        }
    }
}
