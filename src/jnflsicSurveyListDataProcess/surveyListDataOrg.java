
package jnflsicSurveyListDataProcess;

public class surveyListDataOrg {
    private int teacherID;
    private String teacherName;
    private String courseName;
    private String courseArea;
    private int grade;

    public surveyListDataOrg() {
    }

    public surveyListDataOrg(int teacherID, String teacherName, String courseName, String courseArea, int grade) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.courseName = courseName;
        this.courseArea = courseArea;
        this.grade = grade;
    }
    
    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseArea() {
        return courseArea;
    }

    public void setCourseArea(String courseArea) {
        this.courseArea = courseArea;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
}
