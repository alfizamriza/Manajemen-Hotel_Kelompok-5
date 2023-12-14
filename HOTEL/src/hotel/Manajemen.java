/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import javax.swing.*;
import controller.Koneksi;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Asus
 */
public class Manajemen extends javax.swing.JFrame {

    Connection conn = Koneksi.getKoneksi();
    ResultSet rs = null;
    PreparedStatement pst = null;

    public ResultSet cekKamar() {
        String sql = "SELECT * FROM customer WHERE status=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, "Sudah");
            return pst.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

public void ViewData() {
        try {
            ResultSet resultSet = cekKamar();
            DefaultTableModel model = (DefaultTableModel) tKosong.getModel(); // Ambil model yang sudah ada

            // Kosongkan model yang ada sebelumnya
            model.setRowCount(0);

            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getString("nama"),
                    resultSet.getString("nik"),
                    resultSet.getString("no_kamar"),
                    resultSet.getString("tanggal"),
                    resultSet.getString("harga")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Creates new form CheckIn
     */
    public Manajemen() {
        initComponents();
//      tanggal.setIndex(cbTipeKamar.getSelectedIndex());
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
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tKosong = new javax.swing.JTable();
        bCari = new javax.swing.JButton();
        txPendapatan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txPengunjung = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1020, 558));
        setMinimumSize(new java.awt.Dimension(1020, 558));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1020, 550));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (2).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Catamaran Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANAJEMEN");

        tKosong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tKosong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama", "NIK", "No Kamar", "Tanggal", "Harga"
            }
        ));

        tKosong.setFocusable(false);
        tKosong.setSelectionBackground(new java.awt.Color(0, 51, 255));
        tKosong.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tKosong.setShowHorizontalLines(true);
        tKosong.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tKosong);
