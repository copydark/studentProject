/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnflsicUI;

import java.awt.Color;
import java.util.Date;
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

/**
 *
 * @author shen
 */
public class ManageClassForm extends javax.swing.JFrame {

    /**
     * Creates new form ManageClassForm
     */
    public ManageClassForm() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCourse = new javax.swing.JList();
        jButtonSearchCourse = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldStuName = new javax.swing.JTextField();
        jComboBoxGrade = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListStudent = new javax.swing.JList();
        jButtonPre = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonSearchStudent = new javax.swing.JButton();
        labelpages = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelSelectedCourse = new javax.swing.JLabel();
        jButtonTablePre = new javax.swing.JButton();
        jButtonTableNext = new javax.swing.JButton();
        jLabelClassTablePage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Class and Student Management Form");

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

        jComboBoxDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "N/A" }));

        jLabel4.setText("Course Department:");

        jLabel5.setText("Course Area:");

        jComboBoxArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "N/A", "Advanced Placement (AP)", "Advanced Level (AL)", "Advanced Subsidiary Level (AS)", "National Course", "Second Language", "Others" }));

        jListCourse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListCourse.setEnabled(false);
        jListCourse.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListCourseValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListCourse);

        jButtonSearchCourse.setText("Search Course");
        jButtonSearchCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDepartment, 0, 128, Short.MAX_VALUE)
                            .addComponent(jComboBoxArea, 0, 1, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSearchCourse)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSearchCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel3.setText("Student Name:");

        jComboBoxGrade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "10", "11", "12" }));

        jLabel2.setText("Grade:");

        jListStudent.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListStudent.setEnabled(false);
        jListStudent.setSelectionBackground(new java.awt.Color(255, 102, 153));
        jListStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListStudentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListStudent);

        jButtonPre.setText("Pre");
        jButtonPre.setEnabled(false);
        jButtonPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreActionPerformed(evt);
            }
        });

        jButtonNext.setText("Next");
        jButtonNext.setEnabled(false);
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonSearchStudent.setText("Search Student");
        jButtonSearchStudent.setEnabled(false);
        jButtonSearchStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchStudentActionPerformed(evt);
            }
        });

        labelpages.setText("1");

        jLabel7.setText("Page");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxGrade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldStuName)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButtonPre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelpages)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonNext)
                                .addGap(26, 26, 26))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSearchStudent)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStuName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSearchStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPre)
                    .addComponent(jButtonNext)
                    .addComponent(labelpages)
                    .addComponent(jLabel7)))
        );

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StudentID", "Student Name", "Grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jLabelSelectedCourse.setText("course");

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

        jLabelClassTablePage.setText("1");

        jLabel6.setText("Page");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSelectedCourse)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButtonTablePre, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabelClassTablePage)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonTableNext)
                .addGap(67, 67, 67))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSelectedCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTablePre)
                    .addComponent(jButtonTableNext)
                    .addComponent(jLabelClassTablePage)
                    .addComponent(jLabel6))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchCourseActionPerformed
        String department = jComboBoxDepartment.getSelectedItem().toString();
        if(department.equals("N/A")){
            JOptionPane.showMessageDialog(null, "Please Select a Department Name");
            jComboBoxDepartment.requestFocus();
            return;
        }
        Course c = new Course();
        c.setDepartmentName(department);
        String area = jComboBoxArea.getSelectedItem().toString();
        c.setArea(area);
        String courseName[] = CourseData.getCourseList(c.getDepartmentID(), c.getArea());
        if(courseName.length>0){
            jListCourse.setEnabled(true);
            jButtonSearchStudent.setEnabled(true);
            jListStudent.setEnabled(true);
            for(int i = 0; i<courseName.length; i++){
                jListCourse.setListData(courseName);
            }
        }else{
            jListCourse.setEnabled(false);
            jButtonSearchStudent.setEnabled(false);
            jListStudent.setEnabled(false);
            jButtonPre.setEnabled(false);
            jButtonNext.setEnabled(false);
            jTable1.setEnabled(false);
            jButtonTablePre.setEnabled(false);
            jButtonTableNext.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonSearchCourseActionPerformed

    private void jListCourseValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListCourseValueChanged
        if(jListCourse.getSelectedValue()==null){
            return;
        }
        String couresName = jListCourse.getSelectedValue().toString();
        jLabelSelectedCourse.setText(couresName);
        setStudent(0);
        resetTable(0);
    }//GEN-LAST:event_jListCourseValueChanged
    

    private void jButtonSearchStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchStudentActionPerformed
        setStudent(0);
    }//GEN-LAST:event_jButtonSearchStudentActionPerformed

    private void jButtonPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreActionPerformed
        setStudent(-1);
    }//GEN-LAST:event_jButtonPreActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        setStudent(1);
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jListStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListStudentMouseClicked
        if(evt.getClickCount()==2){
            System.out.println(jListStudent.getSelectedValue().toString());
            String courseInfo = jLabelSelectedCourse.getText();
            String studentInfo = jListStudent.getSelectedValue().toString();
            ClassData.AddRecored(studentInfo,courseInfo);
            //resetTable
            resetTable(0);
            setStudent(0);
        }
    }//GEN-LAST:event_jListStudentMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //System.out.println("course:"+jLabelSelectedCourse.getText());
        if(evt.getClickCount()==2){
//            System.out.println(jListStudent.getSelectedValue().toString());
            String courseInfo = jLabelSelectedCourse.getText();
            //System.out.println("course:"+courseInfo);
            int rowIndex = jTable1.getSelectedRow();
            int studentGrade = Integer.parseInt(jTable1.getValueAt(rowIndex, 2).toString());
            int studentID = Integer.parseInt(jTable1.getValueAt(rowIndex, 0).toString());
            ClassData.RemoveRecored(studentID,courseInfo);
            //resetTable
            resetTable(0);
            setStudent(0);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonTablePreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTablePreActionPerformed
        resetTable(-1);
    }//GEN-LAST:event_jButtonTablePreActionPerformed

    private void jButtonTableNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTableNextActionPerformed
        resetTable(1);
    }//GEN-LAST:event_jButtonTableNextActionPerformed
    
    private void resetTable(int state){
        DefaultTableModel dtm2 = (DefaultTableModel)jTable1.getModel();
        dtm2.setDataVector(null, new String [] {
                "StudentID", "Student Name", "Grade"
            });
        System.out.println(jLabelClassTablePage.getText());
        int curPage = Integer.parseInt(jLabelClassTablePage.getText())+state;
        if(curPage<=0){
            curPage = 1;
        }else if(ClassData.getP()!=null && curPage>ClassTable.totalPages()){
            curPage = ClassTable.totalPages();

        }
        jLabelClassTablePage.setText(curPage+"");
        System.out.println(curPage);
        int numCol = jTable1.getColumnCount();
        ClassTable.fillClassJtable(dtm2, jLabelSelectedCourse.getText(), numCol, curPage, 10);
        if(dtm2.getRowCount()>0){
            jButtonTablePre.setEnabled(true);
            jButtonTableNext.setEnabled(true);
        }else{
            jButtonTablePre.setEnabled(false);
            jButtonTableNext.setEnabled(false);
        }
    }
    
    
    private void setStudent(int state){
        int start = Integer.parseInt(labelpages.getText())+state;
        System.out.println("starttttttt:     "+start);
        if(start <= 0){
            start = 1;
        }else if(studentData.getP()!=null){
            //System.out.println("ManageClassForm.setStudent totalpage"+studentData.getTotalPages());
            //System.out.println(start>studentData.getTotalPages()&&start>=0);
            if(start>studentData.getTotalPages()){
                start = studentData.getTotalPages();
            }
        }
        
        labelpages.setText(start+"");
        jListStudent.removeAll();
        String name = jTextFieldStuName.getText();
        int grade = jComboBoxGrade.getSelectedIndex();
        String courseInfo = jLabelSelectedCourse.getText();
        if(courseInfo.equals("course")){
            return;
        }
        String stuData[] = studentData.getStudentList(name, grade, courseInfo, start, 20);
        System.out.println(stuData);
        if(stuData==null){
            jButtonPre.setEnabled(false);
            jButtonNext.setEnabled(false);
            jButtonTablePre.setEnabled(false);
            jButtonTableNext.setEnabled(false);
            return;
        }
        jListStudent.setEnabled(true);
        jButtonPre.setEnabled(true);
        jButtonNext.setEnabled(true);
        jListStudent.setListData(stuData);
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ManageClassForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageClassForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageClassForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageClassForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageClassForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPre;
    private javax.swing.JButton jButtonSearchCourse;
    private javax.swing.JButton jButtonSearchStudent;
    private javax.swing.JButton jButtonTableNext;
    private javax.swing.JButton jButtonTablePre;
    private javax.swing.JComboBox jComboBoxArea;
    private javax.swing.JComboBox jComboBoxDepartment;
    private javax.swing.JComboBox jComboBoxGrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabelClassTablePage;
    private javax.swing.JLabel jLabelSelectedCourse;
    private javax.swing.JList jListCourse;
    private javax.swing.JList jListStudent;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldStuName;
    private javax.swing.JLabel labelpages;
    // End of variables declaration//GEN-END:variables
}
