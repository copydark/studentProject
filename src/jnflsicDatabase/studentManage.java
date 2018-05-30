package jnflsicDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jnflsicDataProcess.Pages;
import jnflsicDataProcess.Student;

public class studentManage {

    private static Pages p;

    public static Student[] getStudent(String keyword, int year, int numOfRecordPrePage, int curPage) {
        p = new Pages(curPage, numOfRecordPrePage);

        try {
            //String firstName, String middleName, String lastName, char sex, int grade, Calendar birthday, int year, String phoneNum, String add
            String sql = "Select stuID, first_name, middle_name, last_name, sex, birthdate, grade, enrollYear, phone, address FROM jnflsic_sch_info.ic_student";

            String where = "";
            if (!keyword.equals("")) {
                where = " where (first_name like '%" + keyword + "%' or middle_name like '%" + keyword + "%' or last_name like '%" + keyword + "%')";
                if (year != 0) {
                    String year1 = String.valueOf(year);
                    if (year1.length() != 4) {
                        where += " and Grade= " + year;
                    } else {
                        where += " and enrollYear= " + year;
                    }
                }
                //String countSQL = "Select count(stuID) FROM jnflsic_sch_info.ic_student";
            } else {
                if (year != 0) {
                    String year1 = String.valueOf(year);
                    if (year1.length() != 4) {
                        where += " where Grade= " + year;
                    } else {
                        where = " where enrollYear= " + year;
                    }
                }
            }
            setTotalPage(where);
            String limit = " limit " + p.getFirstNumOfRecords() + "," + p.getNumRecordsPrePages();

            //sql+=where;
            //p.setTotalPages(year);
            Connection con = connectDatabase.getConnection();
            PreparedStatement ps;
//            System.out.println(sql);
            sql += where + limit;
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            rs.last();

            int size = rs.getRow();
            if (size == 0) {
                return null;
            }
            rs.beforeFirst();

            int numOfRows = numOfRecordPrePage;
            if (size < numOfRecordPrePage) {
                numOfRows = size;
            }

            Student[] s = new Student[numOfRows];
            int i = 0;
            while (rs.next()) {
                s[i] = new Student();
                s[i].setID(rs.getInt(1));
                s[i].setFName(rs.getString(2));
                s[i].setMName(rs.getString(3));
                s[i].setLName(rs.getString(4));
                s[i].setSex(rs.getString(5).charAt(0));
                Calendar c = Calendar.getInstance();
                c.setTime(rs.getDate(6));
                s[i].setDate(c);
                s[i].setGrade(rs.getInt(7));
                s[i].setYear(rs.getInt(8));
                s[i].setPhone(rs.getString(9));
                s[i].setAdd(rs.getString(10));

                i++;
            }
            ps.close();
            con.close();
            return s;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    private static void setTotalPage(String where) {
        String countSQL = "Select count(stuID) FROM jnflsic_sch_info.ic_student";
        try {
            int row = connectDatabase.numberOfRow(countSQL + where);
            p.setTotalPages(row);
        } catch (Exception ex) {
            Logger.getLogger(studentManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getTotalPages() {
        return p.getTotalPages();
    }
}
