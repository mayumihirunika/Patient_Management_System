/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.TextAlignment;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.Document;


/**
 *
 * @author Mayumi Hirunika
 */
public class NCheckPatientForm extends javax.swing.JFrame {

    /**
     * Creates new form NCheckPatientForm
     */
    public NCheckPatientForm() {
        initComponents();
        Connect();
        patient_table();
    }

    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect()
    {
        
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_management_system","root","");
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NurseDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }catch (SQLException ex) {
                Logger.getLogger(NurseDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }       
    
    }    
    
     public void patient_table(){
        try {
            pst=con.prepareStatement("Select*from patient");
            rs=pst.executeQuery();
        
            ResultSetMetaData RSD= rs.getMetaData();
            int R;
            
            R=RSD.getColumnCount();
            
            DefaultTableModel df=(DefaultTableModel)tblNPatient.getModel();
            df.setRowCount(0);
            
            
            while(rs.next())
            {
                Vector v1=new Vector();
                
                for(int i=1; i<=R; i++){
                
                
                v1.add(rs.getString("Patient_No"));
                v1.add(rs.getString("Name"));
                v1.add(rs.getString("Age"));
                v1.add(rs.getString("Gender"));
                v1.add(rs.getString("Blood_Group"));
                v1.add(rs.getString("Mobile_Number"));
                v1.add(rs.getString("Address"));
                v1.add(rs.getString("Admit_Date"));
                v1.add(rs.getString("Diagnosis"));
                v1.add(rs.getString("Ward"));
                v1.add(rs.getString("Room_No"));
                
                
                }
                
                df.addRow(v1);
            }
           

        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        btnNSearch = new javax.swing.JButton();
        txtNSearch = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblNPatient = new javax.swing.JTable();
        btnNBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblCheckPatient = new javax.swing.JLabel();
        btnViewPatient = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Check Patient");
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        btnNSearch.setBackground(new java.awt.Color(0, 102, 102));
        btnNSearch.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnNSearch.setText("Search");
        btnNSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2));
        btnNSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNSearchActionPerformed(evt);
            }
        });

        txtNSearch.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtNSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));
        txtNSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNSearchActionPerformed(evt);
            }
        });

        tblNPatient.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblNPatient.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        tblNPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Patient No", "Name", "Age", "Gender", "Blood Group", "Mobile Number", "Address", "Admit Date", "Diagnosis", "ward", "Room No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblNPatient);

        btnNBack.setBackground(new java.awt.Color(153, 153, 153));
        btnNBack.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnNBack.setText("Back");
        btnNBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2));
        btnNBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnNSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNBack, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblCheckPatient.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lblCheckPatient.setText("Check Patient");

        btnViewPatient.setBackground(new java.awt.Color(0, 102, 102));
        btnViewPatient.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnViewPatient.setText("View Patient");
        btnViewPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2));
        btnViewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPatientActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(0, 102, 102));
        btnPrint.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnPrint.setText("Print");
        btnPrint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\2nd_Sem_JavaProject (2)\\Patient_Management_System_01\\src\\Img\\Check Patient.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCheckPatient)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(lblCheckPatient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnViewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNSearchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel ob = (DefaultTableModel)tblNPatient.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tblNPatient.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtNSearch.getText()));
    }//GEN-LAST:event_btnNSearchActionPerformed

    private void txtNSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNSearchActionPerformed

    private void btnNBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNBackActionPerformed
        // TODO add your handling code here:
        NurseDashboard nursedashboard= new NurseDashboard ();
        nursedashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNBackActionPerformed

    private void btnViewPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPatientActionPerformed
        // TODO add your handling code here:
        patient_table();

    }//GEN-LAST:event_btnViewPatientActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        String path = "";
          JFileChooser j = new JFileChooser();
          j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
          int x = j.showSaveDialog(this);
          if(x == JFileChooser.APPROVE_OPTION)
          {
              path = j.getSelectedFile().getPath();
          }
          com.lowagie.text.Document doc = new com.lowagie.text.Document();
          try{
              PdfWriter.getInstance(doc, new FileOutputStream(path +"Patient.pdf"));
              doc.open();
              PdfPTable tbl = new PdfPTable(5);
              tbl.addCell("Patient_ID");
              tbl.addCell("Name");
              tbl.addCell("Age");
              tbl.addCell("Gender");
              tbl.addCell("Blood_Group");
              tbl.addCell("Mobile_Number");
              tbl.addCell("Address");
              tbl.addCell("Admit_Date");
              tbl.addCell("Diagnosis");
              tbl.addCell("Ward");
              tbl.addCell("Room_No");
              for(int i=0; i< tblNPatient.getRowCount(); i++){
                  String AN = tblNPatient.getValueAt(i, 1).toString();
                  String BN = tblNPatient.getValueAt(i, 2).toString();
                  String CN = tblNPatient.getValueAt(i, 3).toString();
                  String DN = tblNPatient.getValueAt(i, 4).toString();
                  String EN = tblNPatient.getValueAt(i, 5).toString();
                  String FN = tblNPatient.getValueAt(i, 6).toString();
                  String GN = tblNPatient.getValueAt(i, 7).toString();
                  String HN = tblNPatient.getValueAt(i, 8).toString();
                  String IN = tblNPatient.getValueAt(i, 9).toString();
                  String JN = tblNPatient.getValueAt(i, 10).toString();
                  
                  tbl.addCell(AN);
                  tbl.addCell(BN);
                  tbl.addCell(CN);
                  tbl.addCell(DN);
                  tbl.addCell(EN);
                  tbl.addCell(FN);
                  tbl.addCell(GN);
                  tbl.addCell(HN);
                  tbl.addCell(IN);
                  tbl.addCell(JN);
                  
              }
              doc.add(tbl);
              JOptionPane.showMessageDialog(null, "PDF Generated");
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Some thing went wrong");
          }
          doc.close();                                       
        
               

    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(NCheckPatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NCheckPatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NCheckPatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NCheckPatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NCheckPatientForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNBack;
    private javax.swing.JButton btnNSearch;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnViewPatient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCheckPatient;
    private javax.swing.JTable tblNPatient;
    private javax.swing.JTextField txtNSearch;
    // End of variables declaration//GEN-END:variables
}
