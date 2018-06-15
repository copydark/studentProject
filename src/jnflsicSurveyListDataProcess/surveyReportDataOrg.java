
package jnflsicSurveyListDataProcess;

public class surveyReportDataOrg {
    //String department, String area, int grade, int col, int questionCount
    private int teacherID;
    private String teaccherName;
    private String courseName;
    private int numOfStudent;
    private int questionscore[];
    private String area;
    private int grade;
    private int questionCount;

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeaccherName() {
        return teaccherName;
    }

    public void setTeaccherName(String teaccherName) {
        this.teaccherName = teaccherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumOfStudent() {
        return numOfStudent;
    }

    public void setNumOfStudent(int numOfStudent) {
        this.numOfStudent = numOfStudent;
    }

    public int[] getQuestionscore() {
        return questionscore;
    }

    public void setQuestionscore(int[] questionscore) {
        this.questionscore = questionscore;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
    
}
