/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.job_finder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author radhe
 */
public class Job_apply extends javax.swing.JFrame {

    String candidate_nametxt, candidate_idtxt, mobile_notxt,jobNametxt, jobSalarytxt, recruiter_nametxt, recruiter_idtxt;
    String statustxt="pending";
     private String resumeName;
  
     
      public void  passData(String candidate_name,String candidate_id,String mobile_no,String jobName,String jobSalary,String recruiter_name,String recruiter_id){
      this.candidate_idtxt=candidate_id;
      this.jobSalarytxt=jobSalary;

      this.recruiter_idtxt=recruiter_id;
      this.candidate_nametxt=candidate_name;
      this.jobNametxt=jobName;
      this.recruiter_nametxt=recruiter_name;
      this.mobile_notxt=mobile_no;

        
       //assign values
         candidate_nametextfield.setText(candidate_name);
         job_name.setText(jobName);
         Recruiter_name.setText(recruiter_name);
         Mobile_name.setText(mobile_no);
        
   System.out.println("job apply page \n name="+candidate_name+"\n mob="+mobile_no+" candidate id="+candidate_id+"\n jobname="+jobName+"\n job salary="+jobSalary+"\n job status="+statustxt+"\nrecruiter name="+recruiter_name+"\nrecruiter id="+recruiter_id);
        
    }
    public Job_apply() {
        initComponents();
         setSize(800,1000);
    //  System.out.println(" \n \n job apply page \n name="+candidate_nametxt+"\n candidate id="+candidate_idtxt+"\n jobname="+jobNametxt+"\n job salary="+jobSalarytxt+"\n job status="+statustxt+"\nrecruiter name="+recruiter_nametxt+"\nrecruiter id="+recruiter_idtxt);
         getContentPane(). setLayout(null);
          setBackground(new Color(255, 100, 200));
         jLabel1.setBounds(100,50,500,80);
         candidate_name.setBounds(40, 150, 200, 50);
         candidate_nametextfield.setBounds(300, 150, 370, 50);
         job_name_field.setBounds(40, 230, 200, 50);
         job_name.setBounds(300, 230, 370, 50);
         company_name.setBounds(40, 310, 200, 50);
         Recruiter_name.setBounds(300, 310, 370, 50);
         mob_no_field.setBounds(40, 390, 200, 50);
         Mobile_name.setBounds(300, 390, 370, 50);
         resume_field.setBounds(40, 470, 200, 50);
    
         jButton1.setBounds(200, 580, 130, 70);
         
         upload_resume.setBounds(300, 470, 370, 50);
         jButton2.setBounds(570, 530, 70, 30);     
//              
//          upload_resume.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//              JFileChooser fileChooser = new JFileChooser();
//                fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
//                int returnValue = fileChooser.showOpenDialog(null);
//                if (returnValue == JFileChooser.APPROVE_OPTION) {
//                    File selectedFile = fileChooser.getSelectedFile();
//                    resumeName = selectedFile.getName(); // Set the resume name
//                    upload_resume.setText(selectedFile.getAbsolutePath());
//                }
//            }
//        });
         
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         upload_resume.setEditable(false);
         
         //disble component
         job_name.setEditable(false);
         candidate_nametextfield.setEditable(false);
         Recruiter_name.setEditable(false);
         Mobile_name.setEditable(false);
        // upload_resume.setEditable(false);
       
    // System.out.println("job apply page \n name="+candidate_name+"\n mob="+mobile_no+" candidate id="+candidate_id+"\n jobname="+jobName+"\n job salary="+jobSalary+"\n job status="+statustxt+"\nrecruiter name="+recruiter_name+"\nrecruiter id="+recruiter_id);
   }

//    private void loadCompanyData() {
//    String url = "jdbc:mysql://localhost:3306/jobfinder?serverTimezone=UTC";
//    String db_username = "root";
//    String db_password = "root";
//
//    try (Connection conn = DriverManager.getConnection(url, db_username, db_password)) {
////        System.out.println("Connection established");
//
//        String sql = "SELECT * FROM company_registration";
//        System.out.println("Executing SQL query: " + sql);
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        ResultSet rs = pstmt.executeQuery();
//
////        // Print ResultSet metadata
////        ResultSetMetaData rsmd = rs.getMetaData();
////        int columnsNumber = rsmd.getColumnCount();
//
//
//        boolean hasData = false;
////        data.clear(); // Clear the data list before adding new data
//
//        while (rs.next()) {
//            recruiter_name=rs.getString("recruiter_name");
//            recruiter_id=rs.getString("recruiter_id");
//            
////             System.out.println(" job_search ------  \n recruite name ="+recruiter_name+"\n recruiter id="+recruiter_id);
//        }
//        
//          System.out.println(" job_search ------  \n recruite name ="+recruiter_name+"\n recruiter id="+recruiter_id);
//
//        
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
    
   public void insertData(String candidate_name,String mobile_no,String jobName,String recruiter_name, String resumeName){
        String url = "jdbc:mysql://localhost:3306/jobfinder";
        String db_username = "root";
        String db_password = "root";

        try (Connection conn = DriverManager.getConnection(url, db_username, db_password)) {
            
            String sql = "INSERT INTO applied_jobs (candidate_name, candidate_id,job_name, mobile_no, job_salary,status,recruiter_name,recruiter_id, resume_name) VALUES (?,?, ?, ?, ?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, candidate_name);
            pstmt.setString(2, candidate_idtxt);
            pstmt.setString(3, mobile_no);
            pstmt.setString(4, recruiter_name);
            pstmt.setString(5, jobSalarytxt);
            pstmt.setString(6, statustxt);
            pstmt.setString(7, jobName);
            pstmt.setString(8, recruiter_idtxt);
            pstmt.setString(9, resumeName);
            System.out.println("username="+mobile_no+"recruiter id ="+recruiter_name+""+jobName);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Apply for job  successfully");
             Applied_jobs applyObj=new Applied_jobs();
            applyObj.setVisible(true);
//            job_upload.setVisible(false);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error applying job");
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

        jLabel1 = new javax.swing.JLabel();
        job_name_field = new javax.swing.JLabel();
        candidate_name = new javax.swing.JLabel();
        company_name = new javax.swing.JLabel();
        job_name = new javax.swing.JTextField();
        candidate_nametextfield = new javax.swing.JTextField();
        Recruiter_name = new javax.swing.JTextField();
        Mobile_name = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        resume_field = new javax.swing.JLabel();
        mob_no_field = new javax.swing.JLabel();
        upload_resume = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registration From");

        job_name_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        job_name_field.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        job_name_field.setText("Job Name");

        candidate_name.setBackground(new java.awt.Color(153, 153, 255));
        candidate_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        candidate_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        candidate_name.setText("Name");

        company_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        company_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        company_name.setText("Company Name");

        job_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        job_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        job_name.setText(jobNametxt);
        job_name.setToolTipText("Job Name");

        candidate_nametextfield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        candidate_nametextfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        candidate_nametextfield.setText(candidate_nametxt);
        candidate_nametextfield.setToolTipText("Candidate Name");
        candidate_nametextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                candidate_nametextfieldActionPerformed(evt);
            }
        });

        Recruiter_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Recruiter_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Recruiter_name.setText(recruiter_nametxt);
        Recruiter_name.setToolTipText("recruiter Name");
        Recruiter_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recruiter_nameActionPerformed(evt);
            }
        });

        Mobile_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Mobile_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mobile_name.setText(mobile_notxt);
        Mobile_name.setToolTipText("Mobile Name");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        resume_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resume_field.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resume_field.setText("Resume");
        resume_field.setToolTipText("");

        mob_no_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mob_no_field.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mob_no_field.setText("Mobile No");
        mob_no_field.setToolTipText("Mobile No");

        upload_resume.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        upload_resume.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        upload_resume.setText("Upload resume");
        upload_resume.setToolTipText("upload resume");
        upload_resume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_resumeActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(455, 455, 455)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(resume_field, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(317, 317, 317)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mob_no_field, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(job_name_field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(company_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(43, 43, 43))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(candidate_name, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(job_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Recruiter_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mobile_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(candidate_nametextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(upload_resume, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(35, 35, 35))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(427, 427, 427))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(candidate_name, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(candidate_nametextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(job_name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(job_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Recruiter_name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(company_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Mobile_name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(mob_no_field, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resume_field, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upload_resume, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(17, 17, 17)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(446, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Recruiter_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recruiter_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Recruiter_nameActionPerformed

    private void candidate_nametextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_candidate_nametextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_candidate_nametextfieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertData(candidate_nametextfield.getText(), job_name.getText(), Recruiter_name.getText(), Mobile_name.getText(),resumeName);
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void upload_resumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_resumeActionPerformed
  
    }//GEN-LAST:event_upload_resumeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            resumeName = selectedFile.getName(); // Set the resume name
            upload_resume.setText(selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_jButton2ActionPerformed
   
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
            java.util.logging.Logger.getLogger(Job_apply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Job_apply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Job_apply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Job_apply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Job_apply().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Mobile_name;
    private javax.swing.JTextField Recruiter_name;
    private javax.swing.JLabel candidate_name;
    private javax.swing.JTextField candidate_nametextfield;
    private javax.swing.JLabel company_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField job_name;
    private javax.swing.JLabel job_name_field;
    private javax.swing.JLabel mob_no_field;
    private javax.swing.JLabel resume_field;
    private javax.swing.JTextField upload_resume;
    // End of variables declaration//GEN-END:variables
}
