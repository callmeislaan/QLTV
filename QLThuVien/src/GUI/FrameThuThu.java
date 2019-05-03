/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BanDocBLL;
import BLL.TaiLieuBLL;
import BLL.TaiLieuMuonBLL;
import BLL.ThuThuBLL;
import Class.BanDoc;
import Class.TaiLieu;
import Class.TaiLieuMuon;
import Class.ThuThu;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author langt
 */
public class FrameThuThu extends javax.swing.JFrame {

    /**
     * Creates new form FrameThuThu
     */    BanDocBLL banDocBLL = new BanDocBLL();
    TaiLieuBLL taiLieuBLL = new TaiLieuBLL();
    ThuThuBLL thuThuBLL = new ThuThuBLL();
    TaiLieuMuonBLL taiLieuMuonBLL = new TaiLieuMuonBLL();
    DefaultTableModel banDocModel;
    DefaultTableModel taiLieuModel;
    DefaultTableModel thuThuModel;
    DefaultTableModel taiLieuMuonModel;
    BanDoc banDoc = new BanDoc();
    ThuThu thuThu = new ThuThu();
    TaiLieu taiLieu = new TaiLieu();
    TaiLieuMuon taiLieuMuon = new TaiLieuMuon();
    int rowBanDoc = -1, rowThuThu = -1, rowTaiLieu = -1, rowTaiLieuMuon = -1;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public FrameThuThu() {
        initComponents();
          setLocationRelativeTo(this);
        banDocModel = (DefaultTableModel) tblBanDoc.getModel();
        taiLieuModel = (DefaultTableModel) tblTaiLieu.getModel();
    //    thuThuModel = (DefaultTableModel) tblThuThu.getModel();
        taiLieuMuonModel = (DefaultTableModel) tblTaiLieuMuon.getModel();
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelQLTaiLieuMuon = new javax.swing.JPanel();
        txtTimKiemTaiLieuMuon = new javax.swing.JTextField();
        btnTimKiemTaiLieuMuon = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTaiLieuMuon = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        btnXemTatCaTaiLieuMuon = new javax.swing.JButton();
        PanelQLTaiLieu = new javax.swing.JPanel();
        txtTimKiemTaiLieu = new javax.swing.JTextField();
        btnTimKiemTaiLieu = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTaiLieu = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        btnXemTatCaTaiLieu = new javax.swing.JButton();
        PannelQLBanDoc = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBanDoc = new javax.swing.JTable();
        btnXemTatCaBanDoc = new javax.swing.JButton();
        txtTimKiemBanDoc = new javax.swing.JTextField();
        btnTimKiemBanDoc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTimKiemTaiLieuMuon.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnTimKiemTaiLieuMuon.setText("Tìm kiếm");
        btnTimKiemTaiLieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemTaiLieuMuonActionPerformed(evt);
            }
        });

        tblTaiLieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã mượn", "Mã bạn đọc", "Mã tài liệu", "Mã thủ thư", "Số lượng", "Ngày mượn", "Ngày trả"
            }
        ));
        tblTaiLieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiLieuMuonMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblTaiLieuMuon);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Quản lý Tài liệu mượn");

        btnXemTatCaTaiLieuMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-select-all-48.png"))); // NOI18N
        btnXemTatCaTaiLieuMuon.setText("Xem tất cả");
        btnXemTatCaTaiLieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemTatCaTaiLieuMuonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelQLTaiLieuMuonLayout = new javax.swing.GroupLayout(PanelQLTaiLieuMuon);
        PanelQLTaiLieuMuon.setLayout(PanelQLTaiLieuMuonLayout);
        PanelQLTaiLieuMuonLayout.setHorizontalGroup(
            PanelQLTaiLieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelQLTaiLieuMuonLayout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(jLabel32)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelQLTaiLieuMuonLayout.createSequentialGroup()
                .addGroup(PanelQLTaiLieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelQLTaiLieuMuonLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtTimKiemTaiLieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiemTaiLieuMuon))
                    .addGroup(PanelQLTaiLieuMuonLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnXemTatCaTaiLieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelQLTaiLieuMuonLayout.setVerticalGroup(
            PanelQLTaiLieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelQLTaiLieuMuonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelQLTaiLieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelQLTaiLieuMuonLayout.createSequentialGroup()
                        .addGroup(PanelQLTaiLieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemTaiLieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiemTaiLieuMuon))
                        .addGap(39, 39, 39)
                        .addComponent(btnXemTatCaTaiLieuMuon)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý tài liệu mượn", PanelQLTaiLieuMuon);

        txtTimKiemTaiLieu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnTimKiemTaiLieu.setText("Tìm kiếm");
        btnTimKiemTaiLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemTaiLieuActionPerformed(evt);
            }
        });

        tblTaiLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tài liệu", "Tên tài liệu", "Số lượng", "Nhà xuất bản", "Giá"
            }
        ));
        tblTaiLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiLieuMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTaiLieu);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Quản lý Tài liệu");

        btnXemTatCaTaiLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-select-all-48.png"))); // NOI18N
        btnXemTatCaTaiLieu.setText("Xem tất cả");
        btnXemTatCaTaiLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemTatCaTaiLieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelQLTaiLieuLayout = new javax.swing.GroupLayout(PanelQLTaiLieu);
        PanelQLTaiLieu.setLayout(PanelQLTaiLieuLayout);
        PanelQLTaiLieuLayout.setHorizontalGroup(
            PanelQLTaiLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelQLTaiLieuLayout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(jLabel26)
                .addGap(0, 524, Short.MAX_VALUE))
            .addGroup(PanelQLTaiLieuLayout.createSequentialGroup()
                .addGroup(PanelQLTaiLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelQLTaiLieuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTimKiemTaiLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiemTaiLieu))
                    .addGroup(PanelQLTaiLieuLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnXemTatCaTaiLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))
        );
        PanelQLTaiLieuLayout.setVerticalGroup(
            PanelQLTaiLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelQLTaiLieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelQLTaiLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelQLTaiLieuLayout.createSequentialGroup()
                        .addGroup(PanelQLTaiLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemTaiLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiemTaiLieu))
                        .addGap(45, 45, 45)
                        .addComponent(btnXemTatCaTaiLieu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý tài liệu", PanelQLTaiLieu);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Quản lý bạn đọc");

        tblBanDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã bạn đọc", "Tên bạn đọc", "Ngày sinh", "Địa chỉ", "Lớp"
            }
        ));
        tblBanDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBanDocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBanDoc);

        btnXemTatCaBanDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-select-all-48.png"))); // NOI18N
        btnXemTatCaBanDoc.setText("Xem tất cả");
        btnXemTatCaBanDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemTatCaBanDocActionPerformed(evt);
            }
        });

        txtTimKiemBanDoc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnTimKiemBanDoc.setText("Tìm kiếm");
        btnTimKiemBanDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemBanDocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PannelQLBanDocLayout = new javax.swing.GroupLayout(PannelQLBanDoc);
        PannelQLBanDoc.setLayout(PannelQLBanDocLayout);
        PannelQLBanDocLayout.setHorizontalGroup(
            PannelQLBanDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PannelQLBanDocLayout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PannelQLBanDocLayout.createSequentialGroup()
                .addGroup(PannelQLBanDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PannelQLBanDocLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtTimKiemBanDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiemBanDoc))
                    .addGroup(PannelQLBanDocLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnXemTatCaBanDoc)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))
        );
        PannelQLBanDocLayout.setVerticalGroup(
            PannelQLBanDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PannelQLBanDocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PannelQLBanDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PannelQLBanDocLayout.createSequentialGroup()
                        .addGroup(PannelQLBanDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemBanDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiemBanDoc))
                        .addGap(33, 33, 33)
                        .addComponent(btnXemTatCaBanDoc)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý bạn đọc", PannelQLBanDoc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemTaiLieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemTaiLieuMuonActionPerformed
        // TODO add your handling code here:
        taiLieuMuonModel.setRowCount(0);
        taiLieuMuonModel = taiLieuMuonBLL.timKiemTaiLieuMuon(tblTaiLieuMuon, txtTimKiemTaiLieuMuon.getText().trim());
        if (taiLieuMuonModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Không có tài liệu mượn nào");
        }
    }//GEN-LAST:event_btnTimKiemTaiLieuMuonActionPerformed

    private void tblTaiLieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiLieuMuonMouseClicked
        // TODO add your handling code here:
        rowTaiLieuMuon = tblTaiLieuMuon.getSelectedRow();
      
    }//GEN-LAST:event_tblTaiLieuMuonMouseClicked

    private void btnXemTatCaTaiLieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemTatCaTaiLieuMuonActionPerformed
        // TODO add your handling code here:
        taiLieuMuonModel.setRowCount(0);
        taiLieuMuonModel = taiLieuMuonBLL.xemTatCaTaiLieuMuon(tblTaiLieuMuon);
        if (taiLieuMuonModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Không có tài liệu mượn nào");
        }
    }//GEN-LAST:event_btnXemTatCaTaiLieuMuonActionPerformed

    private void tblTaiLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiLieuMouseClicked
        // TODO add your handling code here:
        rowTaiLieu = tblTaiLieu.getSelectedRow();
       
    }//GEN-LAST:event_tblTaiLieuMouseClicked

    private void btnXemTatCaTaiLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemTatCaTaiLieuActionPerformed
        // TODO add your handling code here:
        taiLieuModel.setRowCount(0);
        taiLieuModel = taiLieuBLL.xemTatCaTaiLieu(tblTaiLieu);
        if (taiLieuModel.getRowCount() < 0) {
            JOptionPane.showMessageDialog(null, "Không có tài liệu nào");
        }
    }//GEN-LAST:event_btnXemTatCaTaiLieuActionPerformed

    private void tblBanDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBanDocMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tblBanDocMouseClicked

    private void btnXemTatCaBanDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemTatCaBanDocActionPerformed
        // TODO add your handling code here:
        banDocModel.setRowCount(0);
        banDocModel = banDocBLL.xemTatCaBanDoc(tblBanDoc);
        if (banDocModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Không có bạn đọc nào");
        }
    }//GEN-LAST:event_btnXemTatCaBanDocActionPerformed

    private void btnTimKiemBanDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemBanDocActionPerformed
        // TODO add your handling code here:
        banDocModel.setRowCount(0);
        taiLieuMuonModel = taiLieuMuonBLL.timKiemTaiLieuMuon(tblTaiLieuMuon, txtTimKiemTaiLieuMuon.getText().trim());
        if (taiLieuMuonModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Không có tài liệu mượn nào");
        }
    }//GEN-LAST:event_btnTimKiemBanDocActionPerformed

    private void btnTimKiemTaiLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemTaiLieuActionPerformed
        // TODO add your handling code here:
             taiLieuModel.setRowCount(0);
        taiLieuModel=taiLieuBLL.timKiemTaiLieu(tblTaiLieu,txtTimKiemTaiLieu.getText().trim());  
        if (taiLieuModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Không có tài liệu mượn nào");
        }
    }//GEN-LAST:event_btnTimKiemTaiLieuActionPerformed

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
            java.util.logging.Logger.getLogger(FrameThuThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameThuThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameThuThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameThuThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameThuThu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelQLTaiLieu;
    private javax.swing.JPanel PanelQLTaiLieuMuon;
    private javax.swing.JPanel PannelQLBanDoc;
    private javax.swing.JButton btnTimKiemBanDoc;
    private javax.swing.JButton btnTimKiemTaiLieu;
    private javax.swing.JButton btnTimKiemTaiLieuMuon;
    private javax.swing.JButton btnXemTatCaBanDoc;
    private javax.swing.JButton btnXemTatCaTaiLieu;
    private javax.swing.JButton btnXemTatCaTaiLieuMuon;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBanDoc;
    private javax.swing.JTable tblTaiLieu;
    private javax.swing.JTable tblTaiLieuMuon;
    private javax.swing.JTextField txtTimKiemBanDoc;
    private javax.swing.JTextField txtTimKiemTaiLieu;
    private javax.swing.JTextField txtTimKiemTaiLieuMuon;
    // End of variables declaration//GEN-END:variables
}
