/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnflsicUI;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author shen
 */
public class mainForm extends javax.swing.JFrame {

    /**
     * Creates new form mainForm
     */
    public mainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabelWelcome = new javax.swing.JLabel();
        jLabelDateTime = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuSt = new javax.swing.JMenu();
        jMenuItemAdd = new javax.swing.JMenuItem();
        jMenuItemStuManage = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemAddDep = new javax.swing.JMenuItem();
        jMenuItemManDep = new javax.swing.JMenuItem();
        jMenuCourse = new javax.swing.JMenu();
        jMenuItemAddCourse = new javax.swing.JMenuItem();
        jMenuItemCourseManage = new javax.swing.JMenuItem();
        jMenuTeacher = new javax.swing.JMenu();
        jMenuItemAddTeacher = new javax.swing.JMenuItem();
        jMenuItemManageTeacher = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        jLabelWelcome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelWelcome.setText("Welcome ");

        jLabelDateTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelDateTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelDateTime.setText("DateTime");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 667, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jLabelDateTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDateTime)
                .addContainerGap(381, Short.MAX_VALUE))
        );

        jMenuSt.setText("Student");

        jMenuItemAdd.setText("Add");
        jMenuItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddActionPerformed(evt);
            }
        });
        jMenuSt.add(jMenuItemAdd);

        jMenuItemStuManage.setText("Manage");
        jMenuItemStuManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStuManageActionPerformed(evt);
            }
        });
        jMenuSt.add(jMenuItemStuManage);

        jMenuBar1.add(jMenuSt);

        jMenu4.setText("Department");

        jMenuItemAddDep.setText("Add Department");
        jMenuItemAddDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddDepActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemAddDep);

        jMenuItemManDep.setText("Manage Department");
        jMenuItemManDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemManDepActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemManDep);

        jMenuBar1.add(jMenu4);

        jMenuCourse.setText("Course");

        jMenuItemAddCourse.setText("Add Course");
        jMenuItemAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddCourseActionPerformed(evt);
            }
        });
        jMenuCourse.add(jMenuItemAddCourse);

        jMenuItemCourseManage.setText("Course Manage");
        jMenuItemCourseManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCourseManageActionPerformed(evt);
            }
        });
        jMenuCourse.add(jMenuItemCourseManage);

        jMenuBar1.add(jMenuCourse);

        jMenuTeacher.setText("Teacher");

        jMenuItemAddTeacher.setText("Add Teacher");
        jMenuItemAddTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddTeacherActionPerformed(evt);
            }
        });
        jMenuTeacher.add(jMenuItemAddTeacher);

        jMenuItemManageTeacher.setText("Manage Teacher");
        jMenuItemManageTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemManageTeacherActionPerformed(evt);
            }
        });
        jMenuTeacher.add(jMenuItemManageTeacher);

        jMenuBar1.add(jMenuTeacher);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddActionPerformed
            AddStudentForm stf = new AddStudentForm();
            stf.setVisible(true);
            stf.pack();
            stf.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItemAddActionPerformed

    private void jMenuItemStuManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStuManageActionPerformed
            ManageStudentForm stM = new ManageStudentForm();
            stM.setVisible(true);
            stM.pack();
            stM.setLocationRelativeTo(null);
            stM.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemStuManageActionPerformed

    private void jMenuItemAddDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddDepActionPerformed
            AddDepartmentForm depF = new AddDepartmentForm();
            depF.setVisible(true);
            depF.pack();
            depF.setLocationRelativeTo(null);
            depF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemAddDepActionPerformed

    private void jMenuItemManDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemManDepActionPerformed
            ManageDepForm mdepF = new ManageDepForm();
            mdepF.setVisible(true);
            mdepF.pack();
            mdepF.setLocationRelativeTo(null);
            mdepF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemManDepActionPerformed

    private void jMenuItemAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddCourseActionPerformed
            AddCourseForm ACF = new AddCourseForm();
            ACF.setVisible(true);
            ACF.pack();
            ACF.setLocationRelativeTo(null);
            ACF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemAddCourseActionPerformed

    private void jMenuItemCourseManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCourseManageActionPerformed
            ManageCourseForm MCF = new ManageCourseForm();
            MCF.setVisible(true);
            MCF.pack();
            MCF.setLocationRelativeTo(null);
            MCF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemCourseManageActionPerformed

    private void jMenuItemAddTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddTeacherActionPerformed
            AddTeacherForm ATF = new AddTeacherForm();
            ATF.setVisible(true);
            ATF.pack();
            ATF.setLocationRelativeTo(null);
            ATF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemAddTeacherActionPerformed

    private void jMenuItemManageTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemManageTeacherActionPerformed
            ManageTeacherForm MTF = new ManageTeacherForm();
            MTF.setVisible(true);
            MTF.pack();
            MTF.setLocationRelativeTo(null);
            MTF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemManageTeacherActionPerformed

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
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabelDateTime;
    public javax.swing.JLabel jLabelWelcome;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuCourse;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemAdd;
    private javax.swing.JMenuItem jMenuItemAddCourse;
    private javax.swing.JMenuItem jMenuItemAddDep;
    private javax.swing.JMenuItem jMenuItemAddTeacher;
    private javax.swing.JMenuItem jMenuItemCourseManage;
    private javax.swing.JMenuItem jMenuItemManDep;
    private javax.swing.JMenuItem jMenuItemManageTeacher;
    private javax.swing.JMenuItem jMenuItemStuManage;
    private javax.swing.JMenu jMenuSt;
    private javax.swing.JMenu jMenuTeacher;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
