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
import java.sql.ResultSet;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author mieum
 */
public class QLSach extends javax.swing.JFrame {

    DefaultTableModel tbn = new DefaultTableModel();
    DefaultTableModel tbnls = new DefaultTableModel();
    DefaultTableModel tbntk = new DefaultTableModel();

    public QLSach() {
        initComponents();
        getTbSach();
        getTbLoaiSach();
        getCbbLoaiSach();
        getCbbNXB();

    }

    public void getTbLoaiSach() {
        try {
            int numberls;
            Vector rowls, columnls;
            rowls = new Vector();
            columnls = new Vector();
            String url = "jdbc:sqlserver://OANHNGUYEN:1433;databaseName=QLTV;user=sa;password=123";
            Connection conn = DriverManager.getConnection(url);
            String sql = "select * from LoaiSach";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData metadata = rs.getMetaData();
            numberls = metadata.getColumnCount();// trả về số cột

            for (int i = 1; i <= numberls; i++) {
                columnls.add(metadata.getColumnName(i));//lấy ra tiêu đề các cột
            }
            tbnls.setColumnIdentifiers(columnls);
            while (rs.next()) {
                rowls = new Vector();
                for (int i = 1; i <= numberls; i++) {
                    rowls.addElement(rs.getString(i));
                }
                tbnls.addRow(rowls);
                tbloaisach.setModel(tbnls);
            }

            tbloaisach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (tbloaisach.getSelectedRow() >= 0) {
                        txtid.setText(tbloaisach.getValueAt(tbloaisach.getSelectedRow(), 0) + "");
                        txttenloai.setText(tbloaisach.getValueAt(tbloaisach.getSelectedRow(), 1) + "");
                        txtkieusach.setText(tbloaisach.getValueAt(tbloaisach.getSelectedRow(), 2) + "");
                    }
                }
            });
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getTbSach() {
        try {
            int number;
            Vector row, column;
            row = new Vector();
            column = new Vector();
            String url = "jdbc:sqlserver://OANHNGUYEN:1433;databaseName=QLTV;user=sa;password=123";
            Connection conn = DriverManager.getConnection(url);
            String sql = "  select ID_Sach,TenSach,TenLoaiSach,TenNXB,Sach.SoLuong \n"
                    + "  from Sach,LoaiSach,NXB\n"
                    + "  where Sach.ID_LoaiSach=LoaiSach.ID_LoaiSach and Sach.ID_NXB=NXB.ID_NXB";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount();// trả về số cột

            for (int i = 1; i <= number; i++) {
                column.add(metadata.getColumnName(i));//lấy ra tiêu đề các cột
            }
            tbn.setColumnIdentifiers(column);
            while (rs.next()) {
                row = new Vector();
                for (int i = 1; i <= number; i++) {
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                tbsach.setModel(tbn);
            }

            tbsach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (tbsach.getSelectedRow() >= 0) {
                        txtidsach.setText(tbsach.getValueAt(tbsach.getSelectedRow(), 0) + "");
                        txttensach.setText(tbsach.getValueAt(tbsach.getSelectedRow(), 1) + "");
                        cbbloaisach.setSelectedItem(tbsach.getModel().getValueAt(tbsach.getSelectedRow(), 2) + "");
                        cbbnxb.setSelectedItem(tbsach.getModel().getValueAt(tbsach.getSelectedRow(), 3) + "");
                        txtsoluong.setText(tbsach.getValueAt(tbsach.getSelectedRow(), 4) + "");
                    }
                }
            });
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getCbbLoaiSach() {
        try {
            String url = "jdbc:sqlserver://OANHNGUYEN:1433;databaseName=QLTV;user=sa;password=123";
            Connection conn = DriverManager.getConnection(url);
            String sql = "select TenLoaiSach from LoaiSach";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cbbloaisach.addItem(rs.getString("TenLoaiSach"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getCbbNXB() {
        try {
            String url = "jdbc:sqlserver://OANHNGUYEN:1433;databaseName=QLTV;user=sa;password=123";
            Connection conn = DriverManager.getConnection(url);
            String sql = "select TenNXB from NXB";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cbbnxb.addItem(rs.getString("TenNXB"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        btnthem1 = new javax.swing.JButton();
        btnsua1 = new javax.swing.JButton();
        btnxoa1 = new javax.swing.JButton();
        btnthoat1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cbbloaisach = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtidsach = new javax.swing.JTextField();
        txttensach = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbbnxb = new javax.swing.JComboBox<>();
        txtsoluong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbsach = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnthoat = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbloaisach = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttenloai = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtkieusach = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbtimkiem = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        rbtensach = new javax.swing.JRadioButton();
        rbloaisach = new javax.swing.JRadioButton();
        rbnxb = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N

        btnthem1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnthem1.setText("Thêm");
        btnthem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthem1ActionPerformed(evt);
            }
        });

        btnsua1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnsua1.setText("Sửa");
        btnsua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsua1ActionPerformed(evt);
            }
        });

        btnxoa1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnxoa1.setText("Xóa");
        btnxoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoa1ActionPerformed(evt);
            }
        });

        btnthoat1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnthoat1.setText("Thoát");
        btnthoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoat1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Loại Sách:");

        cbbloaisach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("ID_Sach:");

        txtidsach.setEditable(false);
        txtidsach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtidsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidsachActionPerformed(evt);
            }
        });

        txttensach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Tên Sách:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Nhà Xuất Bản:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Số Lượng:");

        cbbnxb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtsoluong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbloaisach, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttensach, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtidsach, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbnxb, 0, 144, Short.MAX_VALUE)
                    .addComponent(txtsoluong))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidsach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(cbbnxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttensach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbloaisach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(33, 33, 33))))
        );

        tbsach.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbsach.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbsach);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnthem1)
                        .addGap(18, 18, 18)
                        .addComponent(btnsua1)
                        .addGap(18, 18, 18)
                        .addComponent(btnxoa1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnthoat1)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthoat1)
                    .addComponent(btnxoa1)
                    .addComponent(btnsua1)
                    .addComponent(btnthem1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý sách", jPanel3);

        btnthem.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnthoat.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnthoat.setText("Thoát");
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        tbloaisach.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbloaisach);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin loại sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("ID_LoaiSach:");

        txtid.setEditable(false);
        txtid.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Tên loại sách:");

        txttenloai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Kiểu sách:");

        txtkieusach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttenloai, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(txtkieusach)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttenloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtkieusach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnthem)
                        .addGap(31, 31, 31)
                        .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnthoat)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua)
                    .addComponent(btnxoa)
                    .addComponent(btnthoat))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý loại sách", jPanel2);

        tbtimkiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID_Sach", "TenSach", "LoaiSach", "NXB", "SoLuong"
            }
        ));
        jScrollPane2.setViewportView(tbtimkiem);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Thông tin cần tìm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Thông tin:");

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
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btntimkiem)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(btntimkiem)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm theo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        rbtensach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbtensach.setText("Tên sách");

        rbloaisach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbloaisach.setText("Loại sách");

        rbnxb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbnxb.setText("Nhà xuất bản");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tìm kiếm sách", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        // TODO add your handling code here:
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnthoatActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        try {
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://OANHNGUYEN:1433;databaseName=QLTV;user=sa;password=123";
            Connection conn = DriverManager.getConnection(url);
            String sql = "insert into LoaiSach(TenLoaiSach,KieuSach)values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, txttenloai.getText());
            ps.setString(2, txtkieusach.getText());
            ps.executeUpdate();

            tbnls.setRowCount(0);
            getTbLoaiSach();
            cbbloaisach.removeAllItems();
            getCbbLoaiSach();

            ps.close();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://OANHNGUYEN:1433;databaseName=QLTV;user=sa;password=123";
            Connection conn = DriverManager.getConnection(url);
            String sql = "update LoaiSach set TenLoaiSach=?,KieuSach=? where ID_LoaiSach=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txttenloai.getText());
            ps.setString(2, txtkieusach.getText());
            ps.setString(3, txtid.getText());
            ps.executeUpdate();

            tbnls.setRowCount(0);
            getTbLoaiSach();
            cbbloaisach.removeAllItems();
            getCbbLoaiSach();

            ps.close();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://OANHNGUYEN:1433;databaseName=QLTV;user=sa;password=123";
            Connection conn = DriverManager.getConnection(url);
            String sql = "delete LoaiSach where ID_LoaiSach=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtid.getText());
            ps.executeUpdate();

            tbnls.setRowCount(0);
            getTbLoaiSach();
            cbbloaisach.removeAllItems();
            getCbbLoaiSach();

            ps.close();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnthem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthem1ActionPerformed

        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://OANHNGUYEN:1433;databaseName=QLTV;user=sa;password=123";
            Connection conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery("select ID_LoaiSach from LoaiSach where TenLoaiSach like N'"
                    + cbbloaisach.getSelectedItem().toString() + "'");

            int id_ls = 0;
            while (rs1.next()) {
                id_ls = Integer.parseInt(rs1.getString(1));
                //System.out.println(Integer.parseInt(rs1.getString(1)));
            }
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery("select ID_NXB from NXB where TenNXB like N'"
                    + cbbnxb.getSelectedItem().toString() + "'");
            int id_ls2 = 0;
            while (rs2.next()) {
                id_ls2 = Integer.parseInt(rs2.getString(1));
                //System.out.println(Integer.parseInt(rs2.getString(1)));
            }
            String sql = "insert into Sach(TenSach,ID_LoaiSach,ID_NXB,SoLuong)values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, txttensach.getText());
            ps.setInt(2, id_ls);
            ps.setInt(3, id_ls2);
            ps.setString(4, txtsoluong.getText());

            ps.executeUpdate();

            tbn.setRowCount(0);
            getTbSach();

            ps.close();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "dang nhap that bai");
        } catch (SQLException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "dang nhap that bai");
        }


    }//GEN-LAST:event_btnthem1ActionPerformed

    private void btnsua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsua1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://OANHNGUYEN:1433;databaseName=QLTV;user=sa;password=123";
            Connection conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery("select ID_LoaiSach from LoaiSach where TenLoaiSach like N'"
                    + cbbloaisach.getSelectedItem().toString() + "'");

            int id_ls = 0;
            while (rs1.next()) {
                id_ls = Integer.parseInt(rs1.getString(1));
                //System.out.println(Integer.parseInt(rs1.getString(1)));
            }
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery("select ID_NXB from NXB where TenNXB like N'"
                    + cbbnxb.getSelectedItem().toString() + "'");
            int id_ls2 = 0;
            while (rs2.next()) {
                id_ls2 = Integer.parseInt(rs2.getString(1));
                //System.out.println(Integer.parseInt(rs2.getString(1)));
            }

            String sql = "update Sach set TenSach=?,ID_LoaiSach=?,ID_NXB=?,SoLuong=? where ID_Sach=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, txttensach.getText());
            ps.setInt(2, id_ls);
            ps.setInt(3, id_ls2);
            ps.setString(4, txtsoluong.getText());
            ps.setString(5, txtidsach.getText());

            ps.executeUpdate();

            tbn.setRowCount(0);
            getTbSach();

            ps.close();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsua1ActionPerformed

    private void btnxoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoa1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://OANHNGUYEN:1433;databaseName=QLTV;user=sa;password=123";
            Connection conn = DriverManager.getConnection(url);
            String sql = "delete Sach where ID_Sach=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, txtidsach.getText());
            ps.executeUpdate();

            tbn.setRowCount(0);
            getTbSach();

            ps.close();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnxoa1ActionPerformed

    private void btnthoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoat1ActionPerformed
        // TODO add your handling code here:
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnthoat1ActionPerformed

    private void txtidsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidsachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidsachActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        // TODO add your handling code here:
        try {

            int numberls;
            Vector rowls, columnls;
            rowls = new Vector();
            columnls = new Vector();
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://OANHNGUYEN:1433;databaseName=QLTV;user=sa;password=123";
            Connection conn = DriverManager.getConnection(url);
            if (rbtensach.isSelected()) {
                String sql = "  select ID_Sach,TenSach,TenLoaiSach,TenNXB,Sach.SoLuong \n"
                        + "  from Sach,LoaiSach,NXB\n"
                        + "  where Sach.ID_LoaiSach=LoaiSach.ID_LoaiSach and Sach.ID_NXB=NXB.ID_NXB and TenSach like N'" 
                        + txttimkiem.getText() + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                ResultSetMetaData metadata = rs.getMetaData();
                numberls = metadata.getColumnCount();// trả về số cột

                for (int i = 1; i <= numberls; i++) {
                    columnls.add(metadata.getColumnName(i));//lấy ra tiêu đề các cột
                }
                tbntk.setColumnIdentifiers(columnls);
                while (rs.next()) {
                    rowls = new Vector();
                    for (int i = 1; i <= numberls; i++) {
                        rowls.addElement(rs.getString(i));
                    }
                    tbntk.addRow(rowls);
                    tbtimkiem.setModel(tbntk);
                }
            } else if (rbnxb.isSelected()) {
                String sql = "  select ID_Sach,TenSach,TenLoaiSach,TenNXB,Sach.SoLuong \n"
                        + "  from Sach,LoaiSach,NXB\n"
                        + "  where Sach.ID_LoaiSach=LoaiSach.ID_LoaiSach and Sach.ID_NXB=NXB.ID_NXB and TenNXB like N'" 
                        + txttimkiem.getText() + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                ResultSetMetaData metadata = rs.getMetaData();
                numberls = metadata.getColumnCount();// trả về số cột

                for (int i = 1; i <= numberls; i++) {
                    columnls.add(metadata.getColumnName(i));//lấy ra tiêu đề các cột
                }
                tbntk.setColumnIdentifiers(columnls);
                while (rs.next()) {
                    rowls = new Vector();
                    for (int i = 1; i <= numberls; i++) {
                        rowls.addElement(rs.getString(i));
                    }
                    tbntk.addRow(rowls);
                    tbtimkiem.setModel(tbntk);
                }
            } else if (rbloaisach.isSelected()) {
                String sql = "  select ID_Sach,TenSach,TenLoaiSach,TenNXB,Sach.SoLuong \n"
                        + "  from Sach,LoaiSach,NXB\n"
                        + "  where Sach.ID_LoaiSach=LoaiSach.ID_LoaiSach and Sach.ID_NXB=NXB.ID_NXB and TenLoaiSach like N'" 
                        + txttimkiem.getText() + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                ResultSetMetaData metadata = rs.getMetaData();
                numberls = metadata.getColumnCount();// trả về số cột

                for (int i = 1; i <= numberls; i++) {
                    columnls.add(metadata.getColumnName(i));//lấy ra tiêu đề các cột
                }
                tbntk.setColumnIdentifiers(columnls);
                while (rs.next()) {
                    rowls = new Vector();
                    for (int i = 1; i <= numberls; i++) {
                        rowls.addElement(rs.getString(i));
                    }
                    tbntk.addRow(rowls);
                    tbtimkiem.setModel(tbntk);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLSach.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btntimkiemActionPerformed

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
            java.util.logging.Logger.getLogger(QLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnsua1;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthem1;
    private javax.swing.JButton btnthoat;
    private javax.swing.JButton btnthoat1;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton btnxoa1;
    private javax.swing.JComboBox<String> cbbloaisach;
    private javax.swing.JComboBox<String> cbbnxb;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbloaisach;
    private javax.swing.JRadioButton rbnxb;
    private javax.swing.JRadioButton rbtensach;
    private javax.swing.JTable tbloaisach;
    private javax.swing.JTable tbsach;
    private javax.swing.JTable tbtimkiem;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidsach;
    private javax.swing.JTextField txtkieusach;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttenloai;
    private javax.swing.JTextField txttensach;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables

}
