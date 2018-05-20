/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnflsicUI;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jnflsicDataProcess.StuTable;
import jnflsicDataProcess.Student;
import jnflsicDepDataProcess.DepTable;
import jnflsicDepDataProcess.Department;

/**
 *
 * @author shen
 */
public class ManageDepForm extends javax.swing.JFrame {
    //StuTable fillT = new StuTable();
    public ManageDepForm() {
        initComponents();
        int numCol = jTable1.getColumnCount();
        DepTable.fillDepJtable((DefaultTableModel)jTable1.getModel(), "", "", numCol, tableNumOfRecords, tablePages);
        //fillT.fillStuJTable(jTable1,valueToSearch, year);
        jLabelTotalNumPag.setText("/"+DepTable.totalPages());
        model = (DefaultTableModel)jTable1.getModel();
        jTable1.setRowHeight(40);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.GRAY);
        jTable1.setSelectionBackground(Color.black);
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
        jLabelFirstName = new javax.swing.JLabel();
        jLabelLastName1 = new javax.swing.JLabel();
        jLabelPhone = new javax.swing.JLabel();
        jLabelAddress = new javax.swing.JLabel();
        jTextFieldDepName = new javax.swing.JTextField();
        jTextFieldLeaderName = new javax.swing.JTextField();
        jTextFieldPhone = new javax.swing.JTextField();
        jScrollPanelAddress = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jButtonManageDep = new javax.swing.JButton();
        jButtonDepAdd = new javax.swing.JButton();
        jLabelStuID = new javax.swing.JLabel();
        jTextFieldDepID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonDepRemove = new javax.swing.JButton();
        jTextFieldKeyword = new javax.swing.JTextField();
        jLabelDepID = new javax.swing.JLabel();
        jTextFieldLeader = new javax.swing.JTextField();
        jLabelStuID2 = new javax.swing.JLabel();
        jLabelLeader = new javax.swing.JLabel();
        jButtonDepSearch = new javax.swing.JButton();
        jButtonManageFrist = new javax.swing.JButton();
        jButtonManagePre = new javax.swing.JButton();
        jTextFieldPage = new javax.swing.JTextField();
        jLabelTotalNumPag = new javax.swing.JLabel();
        jLabelTotalNumPag1 = new javax.swing.JLabel();
        jTextFieldRecord = new javax.swing.JTextField();
        jLabelmRe = new javax.swing.JLabel();
        jButtonManageNext = new javax.swing.JButton();
        jButtonManageLast = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Department");

        jLabelFirstName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelFirstName.setText("Department Name:");

        jLabelLastName1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelLastName1.setText("Leader Name:");

        jLabelPhone.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelPhone.setText("Phone:");

        jLabelAddress.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelAddress.setText("Description:");

        jTextFieldDepName.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N

        jTextFieldLeaderName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTextFieldPhone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPhoneKeyTyped(evt);
            }
        });

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jScrollPanelAddress.setViewportView(jTextAreaDescription);

        jButtonManageDep.setText("Update");
        jButtonManageDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageDepActionPerformed(evt);
            }
        });

        jButtonDepAdd.setText("Add");
        jButtonDepAdd.setToolTipText("");
        jButtonDepAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDepAddActionPerformed(evt);
            }
        });

        jLabelStuID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelStuID.setText("Search");

        jTextFieldDepID.setEditable(false);
        jTextFieldDepID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DepartmentID", "Department Name", "Leader Name", "Phone", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonDepRemove.setText("Remove");
        jButtonDepRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDepRemoveActionPerformed(evt);
            }
        });

        jTextFieldKeyword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabelDepID.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelDepID.setText("DepartmentID:");

        jTextFieldLeader.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabelStuID2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelStuID2.setText("Keyword:");

        jLabelLeader.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelLeader.setText("Leader Name: ");

        jButtonDepSearch.setText("Search");
        jButtonDepSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDepSearchActionPerformed(evt);
            }
        });

        jButtonManageFrist.setText("First");
        jButtonManageFrist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageFristActionPerformed(evt);
            }
        });

        jButtonManagePre.setText("Previous");
        jButtonManagePre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManagePreActionPerformed(evt);
            }
        });

        jTextFieldPage.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextFieldPage.setText("1");

        jLabelTotalNumPag.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTotalNumPag.setText("/num");

        jLabelTotalNumPag1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTotalNumPag1.setText("Pages");

        jTextFieldRecord.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTextFieldRecord.setText("10");

        jLabelmRe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelmRe.setText("Records/per page");

        jButtonManageNext.setText("Next");
        jButtonManageNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageNextActionPerformed(evt);
            }
        });

        jButtonManageLast.setText("Last");
        jButtonManageLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabelDepID))
                            .addComponent(jLabelFirstName, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDepName, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(jTextFieldDepID)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabelPhone)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPhone))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabelLastName1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldLeaderName, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelAddress)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonDepAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonManageDep, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButtonDepRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPanelAddress)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStuID)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelStuID2)
                                        .addGap(31, 31, 31)
                                        .addComponent(jTextFieldKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabelLeader)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldLeader, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonDepSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(230, 230, 230))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButtonManageFrist, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButtonManagePre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldPage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTotalNumPag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotalNumPag1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelmRe)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonManageNext, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonManageLast, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonDepSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelStuID)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldLeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelLeader))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelStuID2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDepID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDepID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDepName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFirstName))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLeaderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLastName1))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPhone)
                            .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPanelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAddress))
                        .addGap(61, 61, 61))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonManageNext, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonManageLast, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTotalNumPag)
                        .addComponent(jLabelTotalNumPag1)
                        .addComponent(jTextFieldRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelmRe))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonManageFrist, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonManagePre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonDepAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonManageDep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonDepRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

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
    
    private static void clear(){
        jTextFieldDepID.setText("");
        jTextFieldDepName.setText("");
        jTextFieldLeaderName.setText("");
        jTextFieldPhone.setText("");
        jTextAreaDescription.setText("");
    }
    
    private void jButtonDepAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDepAddActionPerformed
            AddDepartmentForm depF = new AddDepartmentForm();
            depF.setVisible(true);
            depF.pack();
            depF.setLocationRelativeTo(null);
            depF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButtonDepAddActionPerformed

    private void jTextFieldPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPhoneKeyTyped
        //allow only numbers
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldPhoneKeyTyped
    
    private boolean verify(){
        if(jTextFieldDepName.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter Department Name");
            jTextFieldDepName.requestFocus();
            return false;
        }
 
        return true;
    }
    
    private void jButtonManageDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageDepActionPerformed
        String depName = jTextFieldDepName.getText();
        String LeadName = jTextFieldLeaderName.getText();
        String Phone = jTextFieldPhone.getText();
        String des = jTextAreaDescription.getText();
        if(!verify()){
            return;
        }
        //    public Department(String depName, String phone, String leader, String description){
        Department de = new Department(depName, Phone, LeadName, des);
        de.setID(Integer.parseInt(jTextFieldDepID.getText()));
        
        if(Department.operateData('u', de)){
            resetTable();
            clear();
        }
    }//GEN-LAST:event_jButtonManageDepActionPerformed

    private void jButtonDepRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDepRemoveActionPerformed
        if(jTextFieldDepID.getText().equals("")){
            return;
        }
        int id = Integer.parseInt(jTextFieldDepID.getText());
        Department d = new Department();
        d.setID(id);
        if(Department.operateData('d', d)){
            resetTable();
            clear();
        }
    }//GEN-LAST:event_jButtonDepRemoveActionPerformed
    
    public static void resetTable(){
        clear();
        tablePages = Integer.parseInt(jTextFieldPage.getText());
        tableNumOfRecords = Integer.parseInt(jTextFieldRecord.getText());
        DefaultTableModel dtm2 = (DefaultTableModel)jTable1.getModel();
        dtm2.setDataVector(null, new String [] {
                "DepartmentID", "Department Name", "Leader Name", "Phone", "Description"
            });
        String key = jTextFieldKeyword.getText();
        String leaderName = jTextFieldLeader.getText();

        DepTable.fillDepJtable(dtm2, key, leaderName, jTable1.getColumnCount(), tableNumOfRecords, tablePages);
        jLabelTotalNumPag.setText("/"+DepTable.totalPages());
    }
    
    private void jButtonDepSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDepSearchActionPerformed
        jTextFieldPage.setText("1");
        resetTable();
    }//GEN-LAST:event_jButtonDepSearchActionPerformed

    private void jButtonManageFristActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageFristActionPerformed
        //tablePages = 1;
        jTextFieldPage.setText("1");
        tableNumOfRecords = Integer.parseInt(jTextFieldRecord.getText());
        resetTable();
    }//GEN-LAST:event_jButtonManageFristActionPerformed

    private void jButtonManagePreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManagePreActionPerformed
        int n = Integer.parseInt(jTextFieldPage.getText())-1;
        if(n==0){
            n = 1;
        }
        jTextFieldPage.setText(n+"");
        tableNumOfRecords = Integer.parseInt(jTextFieldRecord.getText());
        //jTextFieldPage.setText(tablePages+"");
        resetTable();
    }//GEN-LAST:event_jButtonManagePreActionPerformed

    private void jButtonManageNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageNextActionPerformed
        int n = Integer.parseInt(jTextFieldPage.getText())+1;
        if(n>Integer.parseInt(jLabelTotalNumPag.getText().substring(1, 2))){
            n = Integer.parseInt(jLabelTotalNumPag.getText().substring(1, 2));
        }
        jTextFieldPage.setText(n+"");
        tableNumOfRecords = Integer.parseInt(jTextFieldRecord.getText());
        //jTextFieldPage.setText(tablePages+"");
        resetTable();
    }//GEN-LAST:event_jButtonManageNextActionPerformed

    private void jButtonManageLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageLastActionPerformed
        //tablePages = Integer.parseInt(jLabelTotalNumPag.getText().substring(1,2));
                //tablePages = 1;
        jTextFieldPage.setText(jLabelTotalNumPag.getText().substring(1,2));
        tableNumOfRecords = Integer.parseInt(jTextFieldRecord.getText());
        //jTextFieldPage.setText(tablePages+"");
        resetTable();
    }//GEN-LAST:event_jButtonManageLastActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        rowIndex = jTable1.getSelectedRow();
        jTextFieldDepID.setText(model.getValueAt(rowIndex, 0).toString());
        jTextFieldDepName.setText(model.getValueAt(rowIndex, 1).toString());
        jTextFieldLeaderName.setText(model.getValueAt(rowIndex, 2).toString());
        jTextFieldPhone.setText(model.getValueAt(rowIndex, 3).toString());
        jTextAreaDescription.setText(model.getValueAt(rowIndex, 4).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_UP || evt.getKeyCode()==KeyEvent.VK_DOWN){
            rowIndex = jTable1.getSelectedRow();
           // model = (DefaultTableModel)jTable1.getModel();
            jTextFieldDepID.setText(model.getValueAt(rowIndex, 0).toString());
            jTextFieldDepName.setText(model.getValueAt(rowIndex, 1).toString());
            jTextFieldLeaderName.setText(model.getValueAt(rowIndex, 2).toString());
            jTextFieldPhone.setText(model.getValueAt(rowIndex, 3).toString());
            jTextAreaDescription.setText(model.getValueAt(rowIndex, 4).toString());
        }
    }//GEN-LAST:event_jTable1KeyReleased

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
            java.util.logging.Logger.getLogger(ManageDepForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageDepForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageDepForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageDepForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManageDepForm st = new ManageDepForm();
                st.middleScreen();
                st.setVisible(true);
            }
        });
    }
    
    private void middleScreen(){
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setLocation( (int) (width - this.getWidth()) / 2,(int) (height - this.getHeight()) / 2);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDepAdd;
    private javax.swing.JButton jButtonDepRemove;
    private javax.swing.JButton jButtonDepSearch;
    private javax.swing.JButton jButtonManageDep;
    private javax.swing.JButton jButtonManageFrist;
    private javax.swing.JButton jButtonManageLast;
    private javax.swing.JButton jButtonManageNext;
    private javax.swing.JButton jButtonManagePre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelDepID;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelLastName1;
    private javax.swing.JLabel jLabelLeader;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelStuID;
    private javax.swing.JLabel jLabelStuID2;
    private static javax.swing.JLabel jLabelTotalNumPag;
    private javax.swing.JLabel jLabelTotalNumPag1;
    private javax.swing.JLabel jLabelmRe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPanelAddress;
    public static javax.swing.JTable jTable1;
    private static javax.swing.JTextArea jTextAreaDescription;
    private static javax.swing.JTextField jTextFieldDepID;
    private static javax.swing.JTextField jTextFieldDepName;
    private static javax.swing.JTextField jTextFieldKeyword;
    private static javax.swing.JTextField jTextFieldLeader;
    private static javax.swing.JTextField jTextFieldLeaderName;
    private static javax.swing.JTextField jTextFieldPage;
    private static javax.swing.JTextField jTextFieldPhone;
    public static javax.swing.JTextField jTextFieldRecord;
    // End of variables declaration//GEN-END:variables
    private static int tablePages = 1;
    private static int tableNumOfRecords = 10;
    private static int rowIndex = 0;
    private static DefaultTableModel model = null;
}
