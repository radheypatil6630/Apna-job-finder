/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.job_finder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author radhe
 */


public class Job_status extends javax.swing.JFrame {

       
       JPanel panel_new_1;
  
   private List<JPanel> jobPanels = new ArrayList<>();      
     private List<Object[]> data = new ArrayList<>();
    DefaultTableModel model;

   
    public Job_status() {
       model = new DefaultTableModel(new Object[][] {}, new String[] {
            "Candidate Name", "Job Name", "Mobile No", "Select status", "Status"
        }) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        initComponents();
         jTable1.setModel(model);
         loadJobData();
         setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
         // Add TableModelListener to update status based on checkbox selection
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() == 3) { // Check if the change is in the checkbox column
                    int row = e.getFirstRow();
                    boolean isSelected = (boolean) model.getValueAt(row, 3);
                    String newStatus = isSelected ? "Accept" : "Reject";
                    model.setValueAt(newStatus, row, 4);
                    
                     // Update the database with the new status
                updateDatabaseStatus(row, newStatus);
                }
            }
        });
     
    }
private void updateDatabaseStatus(int row, String newStatus) {
    String url = "jdbc:mysql://localhost:3306/jobfinder?serverTimezone=UTC";
    String db_username = "root";
    String db_password = "root";

    try (Connection conn = DriverManager.getConnection(url, db_username, db_password)) {
        String sql = "UPDATE applied_jobs SET status = ? WHERE candidate_name = ? AND job_name = ? AND mobile_no = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newStatus);
        pstmt.setString(2, (String) model.getValueAt(row, 0)); // Candidate Name
        pstmt.setString(3, (String) model.getValueAt(row, 1)); // Job Name
        pstmt.setString(4, (String) model.getValueAt(row, 2)); // Mobile No
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(410, 271));

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 51, 51));
        jTable1.setModel(model);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(40);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1510, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void loadJobData() {
    String url = "jdbc:mysql://localhost:3306/jobfinder?serverTimezone=UTC";
    String db_username = "root";
    String db_password = "root";

    try (Connection conn = DriverManager.getConnection(url, db_username, db_password)) {
//        System.out.println("Connection established");

        String sql = "SELECT * FROM applied_jobs";
        System.out.println("Executing SQL query: " + sql);
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        // Print ResultSet metadata
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();


        boolean hasData = false;
        data.clear(); // Clear the data list before adding new data

        while (rs.next()) {
            hasData = true;
            Object[] row = new Object[5];
            row[0] = rs.getString("candidate_name");
            row[1] = rs.getString("job_name");
            row[2] = rs.getString("mobile_no");
            row[3] = "Accept".equals(rs.getString("status")); // Set checkbox state based on status
            row[4] = rs.getString("status");
           // row[4] = b1.add(accept);
            data.add(row);
        }

        if (!hasData) {
            System.out.println("No data found in applied_jobs table");
        }

        // Convert data list to 2D array
        Object[][] dataArray = data.toArray(new Object[data.size()][]);

        // Set the model of the JTable
        model.setDataVector(dataArray, new String[] {
          "Candidate Name", "Job Name", "Mobile No", "Select status", "Status"
            });
//        JButton newbtn=new JButton("accept");
        

    } catch (SQLException e) {
        e.printStackTrace();
    }
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
            java.util.logging.Logger.getLogger(Job_status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Job_status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Job_status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Job_status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Job_status().setVisible(true);
            }
        });
    }
    
   
    private javax.swing.JCheckBox Select_status;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}


