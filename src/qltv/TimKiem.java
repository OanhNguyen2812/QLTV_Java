/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author mieum
 */
public class TimKiem extends javax.swing.JFrame {

    DefaultTableModel tbn = new DefaultTableModel();
    DefaultTableModel tbnbd = new DefaultTableModel();

    public TimKiem() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        rbtensach = new javax.swing.JRadioButton();
        rbloaisach = new javax.swing.JRadioButton();
        rbnxb = new javax.swing.JRadioButton();
        rbbandoc = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtimkiem = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Thông tin cần tìm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        txttimkiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btntimkiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btntimkiem.setText("Tìm kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btntimkiem)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntimkiem))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm theo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        rbtensach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbtensach.setText("Tên sách");

        rbloaisach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbloaisach.setText("Loại sách");

        rbnxb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbnxb.setText("Nhà xuất bản");

        rbbandoc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbbandoc.setText("Tên bạn đọc");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbbandoc)
                    .addComponent(rbnxb)
                    .addComponent(rbloaisach)
                    .addComponent(rbtensach))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtensach)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbloaisach)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbnxb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbbandoc)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tbtimkiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbtimkiem);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        // TODO add your handling code here:
        try {
            tbn.setRowCount(0);
            int numberls;
            Vector rowls, columnls;
            rowls = new Vector();
            columnls = new Vector();
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://OANHNGUYEN:1433;databaseName=QLTV;user=sa;password=123";
            Connection conn = DriverManager.getConnection(url);
            if (rbtensach.isSelected()) {
                String sql = "select ID_Sach,TenSach,TenLoaiSach,TenNXB,Sach.SoLuong \n"
                        + "  from Sach,LoaiSach,NXB\n"
                        + "  where Sach.ID_LoaiSach=LoaiSach.ID_LoaiSach and Sach.ID_NXB=NXB.ID_NXB and ID_Sach like N'" + txttimkiem.getText() + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                ResultSetMetaData metadata = rs.getMetaData();
                numberls = metadata.getColumnCount();// trả về số cột

                for (int i = 1; i <= numberls; i++) {
                    columnls.add(metadata.getColumnName(i));//lấy ra tiêu đề các cột
                }
                tbn.setColumnIdentifiers(columnls);
                while (rs.next()) {
                    rowls = new Vector();
                    for (int i = 1; i <= numberls; i++) {
                        rowls.addElement(rs.getString(i));
                    }
                    tbn.addRow(rowls);

                    tbtimkiem.setModel(tbn);
                }
            } else if (rbnxb.isSelected()) {
                String sql = "select ID_Sach,TenSach,TenLoaiSach,TenNXB,Sach.SoLuong \n"
                        + "  from Sach,LoaiSach,NXB\n"
                        + "  where Sach.ID_LoaiSach=LoaiSach.ID_LoaiSach and Sach.ID_NXB=NXB.ID_NXB and TenNXB like N'" + txttimkiem.getText() + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                ResultSetMetaData metadata = rs.getMetaData();
                numberls = metadata.getColumnCount();// trả về số cột

                for (int i = 1; i <= numberls; i++) {
                    columnls.add(metadata.getColumnName(i));//lấy ra tiêu đề các cột
                }
                tbn.setColumnIdentifiers(columnls);
                while (rs.next()) {
                    rowls = new Vector();
                    for (int i = 1; i <= numberls; i++) {
                        rowls.addElement(rs.getString(i));
                    }
                    tbn.addRow(rowls);
                    tbtimkiem.setModel(tbn);
                }
            } else if (rbloaisach.isSelected()) {
                String sql = "select ID_Sach,TenSach,TenLoaiSach,TenNXB,Sach.SoLuong \n"
                        + "  from Sach,LoaiSach,NXB\n"
                        + "  where Sach.ID_LoaiSach=LoaiSach.ID_LoaiSach and Sach.ID_NXB=NXB.ID_NXB and TenLoaiSach like N'" + txttimkiem.getText() + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                ResultSetMetaData metadata = rs.getMetaData();
                numberls = metadata.getColumnCount();// trả về số cột

                for (int i = 1; i <= numberls; i++) {
                    columnls.add(metadata.getColumnName(i));//lấy ra tiêu đề các cột
                }
                tbn.setColumnIdentifiers(columnls);
                while (rs.next()) {
                    rowls = new Vector();
                    for (int i = 1; i <= numberls; i++) {
                        rowls.addElement(rs.getString(i));
                    }
                    tbn.addRow(rowls);
                    tbtimkiem.setModel(tbn);
                }
            } else if (rbbandoc.isSelected()) {
                String sql = "select * from BanDoc where TenBanDoc like N'" + txttimkiem.getText() + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                ResultSetMetaData metadata = rs.getMetaData();
                numberls = metadata.getColumnCount();// trả về số cột

                for (int i = 1; i <= numberls; i++) {
                    columnls.add(metadata.getColumnName(i));//lấy ra tiêu đề các cột
                }
                tbn.setColumnIdentifiers(columnls);
                while (rs.next()) {
                    rowls = new Vector();
                    for (int i = 1; i <= numberls; i++) {
                        rowls.addElement(rs.getString(i));
                    }
                    tbn.addRow(rowls);
                    tbtimkiem.setModel(tbn);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimKiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbbandoc;
    private javax.swing.JRadioButton rbloaisach;
    private javax.swing.JRadioButton rbnxb;
    private javax.swing.JRadioButton rbtensach;
    private javax.swing.JTable tbtimkiem;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
