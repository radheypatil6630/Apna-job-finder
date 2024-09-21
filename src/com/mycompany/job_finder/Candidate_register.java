/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.job_finder;


import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author radhe
 */
public class Candidate_register extends javax.swing.JFrame {

            String candidate_id="",can_username,can_name,can_password,can_mob_no;
    /**
     * Creates new form Candidate_register
     */
    public Candidate_register() {
        initComponents();
        
        
           setSize(1540,1000);
          setLayout(null);
          label1.setBounds(470, 150,600, 70);
          jTextField1.setBounds(520, 250,500, 50);
          jTextField2.setBounds(520, 320,500, 50);
          jTextField3.setBounds(520, 390,500, 50);
          jPasswordField1.setBounds(520, 460,500, 50);
         
          jButton2.setBounds(650, 550,200, 50);

            label2.setBounds(1100,20,300,40);
           jButton1.setBounds(1450, 20,70, 40);//login
           
           setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public  String candidate_id_generator(String username,String candidate_name){
       long timestamp = System.currentTimeMillis();

    // Extract the first 3 characters of the username and candidate name
    String usernamePart = username.substring(0, Math.min(3, username.length()));
    String candidateNamePart = candidate_name.substring(0, Math.min(3, candidate_name.length()));

    // Combine them to form the unique candidate ID
    String candidate_id = usernamePart + candidateNamePart + timestamp;

    return candidate_id;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        label2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setFont(new java.awt.Font("Constantia", 3, 36)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 51, 51));
        label1.setText("Candidate Registration");
        jPanel2.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 430, 40));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setText("Candidate Name");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 280, 40));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setText("username");
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 280, 40));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setText("Moblie No");
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 280, 40));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 280, 40));

        jButton2.setBackground(new java.awt.Color(102, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("Sign Up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 140, 50));

        label2.setBackground(new java.awt.Color(153, 255, 255));
        label2.setForeground(new java.awt.Color(255, 51, 51));
        label2.setText("If you already logged in , Click here !");
        jPanel2.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 220, 20));

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 403, 70, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 340, 420, 450));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/job_finder/register.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1000));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Candidate_Login can_login=new Candidate_Login();
      can_login.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     //register
      String url = "jdbc:mysql://localhost:3306/jobfinder";
         String db_user = "root";
         String db_password = "root";
         try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection(url,db_user,db_password);
          
  
           can_name=jTextField1.getText();
           can_username=jTextField2.getText();
           can_mob_no=jTextField3.getText();
          
          char[] password=jPasswordField1.getPassword();
           can_password=new String(password);
          
           //class object
            Candidate_register obj = new Candidate_register();

    // Generate candidate ID
            candidate_id = obj.candidate_id_generator(can_username, can_name);
          
          
          //insert data
          String insert_query="insert into candidate_registration(candidate_name,username,mobile_no,password,candidate_id)  VALUES (?, ?, ?, ?, ?)";
     
          PreparedStatement pre=con.prepareStatement(insert_query);
          
           // Set the parameters for the query
            pre.setString(1, can_name);
            pre.setString(2, can_username);
            pre.setString(3, can_mob_no);
            pre.setString(4, can_password);
            pre.setString(5, candidate_id);
            
            
        
          
          int result=JOptionPane.showConfirmDialog(this,"Registration done");
          if(result==JOptionPane.YES_OPTION){
               pre.executeUpdate();
               Candidate_Login search=new Candidate_Login();
               search.setVisible(true);
          }
          
             System.out.println("insert data");

         }catch(ClassNotFoundException e1)
         {
             System.err.println(e1);
         }
         catch(SQLException e2){
             System.err.println(e2);
         }
   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        
         */
        
//       
        try {
           
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Candidate_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Candidate_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Candidate_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Candidate_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Candidate_register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private java.awt.Label label1;
    private javax.swing.JLabel label2;
    // End of variables declaration//GEN-END:variables
}
