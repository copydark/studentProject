/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnflsicUI;

import freemarker.template.TemplateException;
import java.awt.Color;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jnflsicClassDataProcess.ClassTable;
import jnflsicClassDatabase.ClassData;
import jnflsicCourseDataProcess.Course;
import jnflsicCourseDatabase.CourseData;
import jnflsicDataProcess.Pages;
import jnflsicDataProcess.Student;
import jnflsicDatabase.studentData;
import jnflsicDatabase.studentManage;
import jnflsicSurveyListDataProcess.SurveyListTable;
import jnflsicSurveyListDataProcess.surveyListDataOrg;
import jnflsicSurveyListDataProcess.surveyOutput;
import jnflsicSurveyListDatabase.surveyListDataManage;

/**
 *
 * @author shen
 */
public class ManageSurveryList extends javax.swing.JFrame {

    /**
     * Creates new form ManageClassForm
     */
    public ManageSurveryList() {
        initComponents();
        setDepartmentList();
        jTable1.setRowHeight(40);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.GRAY);
        jTable1.setSelectionBackground(Color.black);
    }
    //select ic_student.stuID, ic_student.first_name, ic_student.middle_name, ic_student.last_name, ic_student.grade, ic_class.studentID from ic_student left join ic_class on ic_student.stuID = ic_class.studentID and ic_class.courseID=102 where ic_class.studentID is NULL
    private void setDepartmentList(){
        String[] departmentList = CourseData.getDepartmentList();
        for(int i = 0; i<departmentList.length; i++){
            jComboBoxDepartment.addItem(departmentList[i]);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxDepartment = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxArea = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxGrade = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonTablePre = new javax.swing.JButton();
        jButtonTableNext = new javax.swing.JButton();
        jLabelTablePage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelTotalP = new javax.swing.JLabel();
        jButtonGenerate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Management Teacher Servery List Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));

        jComboBoxDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL" }));

        jLabel4.setText("Course Department:");

        jLabel5.setText("Course Area:");

        jComboBoxArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "Advanced Placement (AP)", "Advanced Level (AL)", "Advanced Subsidiary Level (AS)", "National Course", "Second Language", "Others" }));

        jLabel8.setText("Grade:");

        jComboBoxGrade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "10", "11", "12" }));

        jButton1.setText("List Survey Teacher");
        jButton1.setActionCommand("List Survey Teacher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDepartment, 0, 128, Short.MAX_VALUE)
                            .addComponent(jComboBoxArea, 0, 1, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(75, 75, 75)
                        .addComponent(jComboBoxGrade, 0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TeacherID", "Teacher Name", "Course Name", "Course Area", "Grade", "Approve"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jButtonTablePre.setText("Pre");
        jButtonTablePre.setEnabled(false);
        jButtonTablePre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTablePreActionPerformed(evt);
            }
        });

        jButtonTableNext.setText("Next");
        jButtonTableNext.setEnabled(false);
        jButtonTableNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTableNextActionPerformed(evt);
            }
        });

        jLabelTablePage.setText("1");

        jLabel6.setText("Page");

        jLabelTotalP.setText("/1");

        jButtonGenerate.setText("Generate");
        jButtonGenerate.setEnabled(false);
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonTablePre, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTablePage, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotalP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonTableNext)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonGenerate)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTablePre)
                    .addComponent(jButtonTableNext)
                    .addComponent(jLabelTablePage)
                    .addComponent(jLabel6)
                    .addComponent(jLabelTotalP)
                    .addComponent(jButtonGenerate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonTablePreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTablePreActionPerformed
        resetTable(-1);
    }//GEN-LAST:event_jButtonTablePreActionPerformed

    private void jButtonTableNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTableNextActionPerformed
        resetTable(1);
    }//GEN-LAST:event_jButtonTableNextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel dtm2 = (DefaultTableModel)jTable1.getModel();
        dtm2.setDataVector(null, new String [] {
                "TeacherID", "Teacher Name", "Course Name", "Course Area", "Grade", "Approve"
            });
        String department = jComboBoxDepartment.getSelectedItem().toString();
        String area = jComboBoxArea.getSelectedItem().toString();
        int grade = jComboBoxGrade.getSelectedIndex();
        if(grade!=0){
            grade = grade +9;
        }
        int col = dtm2.getColumnCount();
        SurveyListTable.fillSurveyListJTable(dtm2, department, area, grade, col, 0, 10);
        int totalP = surveyListDataManage.getTotalPage();
        jLabelTotalP.setText("/"+totalP);
        jLabelTablePage.setText("1");
        
        if(dtm2.getRowCount()>0){
            jButtonTablePre.setEnabled(true);
            jButtonTableNext.setEnabled(true);
            jButtonGenerate.setEnabled(true);
        }else{
            jButtonTablePre.setEnabled(false);
            jButtonTableNext.setEnabled(false);
            jButtonGenerate.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed

        DefaultTableModel dtm2 = (DefaultTableModel)jTable1.getModel();
        int row = dtm2.getRowCount();
        int count = 0;
        for(int i = 0; i<row; i++){
            if(Boolean.parseBoolean(dtm2.getValueAt(i, 5).toString())){
                count++;
            }
        }
        surveyListDataOrg s[] = new surveyListDataOrg [count];
        int j = 0;
        for(int i = 0; i<row; i++){
            if(Boolean.parseBoolean(dtm2.getValueAt(i, 5).toString())){
               s[j]= new surveyListDataOrg();
               s[j].setTeacherID(Integer.parseInt(dtm2.getValueAt(i, 0).toString()));
               s[j].setTeacherName(dtm2.getValueAt(i, 1).toString());
               s[j].setCourseName(dtm2.getValueAt(i, 2).toString());
               s[j].setCourseArea(dtm2.getValueAt(i, 3).toString());
               s[j].setGrade(Integer.parseInt(dtm2.getValueAt(i, 4).toString()));
               j++;
            }
        }
        try {
            surveyOutput.generateHtml(s);
            JOptionPane.showMessageDialog(null, "Generate a group of files");
        } catch (TemplateException ex) {
            Logger.getLogger(ManageSurveryList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageSurveryList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonGenerateActionPerformed
    
    private void resetTable(int state){
        DefaultTableModel dtm2 = (DefaultTableModel)jTable1.getModel();
        dtm2.setDataVector(null, new String [] {
                "TeacherID", "Teacher Name", "Course Name", "Course Area", "Grade", "Approve"
            });
        System.out.println(jLabelTablePage.getText());
        int curPage = Integer.parseInt(jLabelTablePage.getText())+state;
        if(curPage<=0){
            curPage = 1;
        }else if(surveyListDataManage.getP()!=null && curPage>surveyListDataManage.getTotalPage()){
            curPage = surveyListDataManage.getTotalPage();

        }
        jLabelTablePage.setText(curPage+"");
        System.out.println(curPage);
        int numCol = jTable1.getColumnCount();
        String department = jComboBoxDepartment.getSelectedItem().toString();
        String area = jComboBoxArea.getSelectedItem().toString();
        int grade = jComboBoxGrade.getSelectedIndex();
        if(grade!=0){
            grade = grade +9;
        }
        SurveyListTable.fillSurveyListJTable(dtm2, department, area, grade, numCol, curPage-1, 10);
        if(dtm2.getRowCount()>0){
            jButtonTablePre.setEnabled(true);
            jButtonTableNext.setEnabled(true);
            jButtonGenerate.setEnabled(true);
        }else{
            jButtonTablePre.setEnabled(false);
            jButtonTableNext.setEnabled(false);
            jButtonGenerate.setEnabled(false);
        }
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageSurveryList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageSurveryList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageSurveryList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageSurveryList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageSurveryList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonTableNext;
    private javax.swing.JButton jButtonTablePre;
    private javax.swing.JComboBox jComboBoxArea;
    private javax.swing.JComboBox jComboBoxDepartment;
    private javax.swing.JComboBox jComboBoxGrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabelTablePage;
    private javax.swing.JLabel jLabelTotalP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
