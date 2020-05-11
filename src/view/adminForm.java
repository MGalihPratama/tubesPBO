/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;


/**
 *
 * @author a c e r+
 */
public class adminForm extends javax.swing.JFrame {
    
    private void kosongkan_form(){
        txtId.setEditable(true);
        txtId.setText(null);
        txtNama.setText(null);
        cdJabatan.setSelectedItem(this);  
    } 
    
    private void cariDataTransaksi(){
        try {
            String search = txtcari.getText();
            String sql="Select * from transaksi where id_pembeli like '%"+search+"%'";
            PreparedStatement ps=null;
            Object [] row={"Nomor Transaksi", "Id Pembeli", "Id Roti", "Tanggal Transaksi", "Jumlah Beli"};
            DefaultTableModel dtm=new DefaultTableModel(null,row);
                tabelTransaksi.setModel(dtm);
                jScrollPane4.setEnabled(true);
                jScrollPane4.setBorder(null);
                jScrollPane4.setViewportView(tabelTransaksi);
            java.sql.ResultSet rs=null;
            ps=Konfig.configDB().prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                    String no_transaksi=rs.getString(1);
                    String id_pembeli=rs.getString(2);
                    String id_roti=rs.getString(3);
                    String tgl_transaksi=rs.getString(4);
                    String jumlah_beli=rs.getString(5);
                    
                    String [] baris={no_transaksi,id_pembeli,id_roti,tgl_transaksi,jumlah_beli};
                    dtm.addRow(baris);
                }
        }
        catch (SQLException e){}
    }
    
    private void tampilkan_data_transaksi(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No Transaksi");
        model.addColumn("Id Pemebeli");
        model.addColumn("Id Roti");
        model.addColumn("Tgl Transaksi");
        model.addColumn("Jumlah Beli");
        
        try{
            String sql = "SELECT * FROM transaksi";
            PreparedStatement ps=null;
            Object [] row={"Nomor Transaksi", "Id Pembeli", "Id Roti", "Tanggal Transaksi", "Jumlah Beli"};
            DefaultTableModel dtm=new DefaultTableModel(null,row);
                tabelTransaksi.setModel(dtm);
                jScrollPane4.setEnabled(true);
                jScrollPane4.setBorder(null);
                jScrollPane4.setViewportView(tabelTransaksi);
            java.sql.ResultSet rs=null;
            ps=Konfig.configDB().prepareStatement(sql);
            rs=ps.executeQuery();
                while (rs.next()){
                    String no_transaksi=rs.getString(1);
                    String id_pembeli=rs.getString(2);
                    String id_roti=rs.getString(3);
                    String tgl_transaksi=rs.getString(4);
                    String jumlah_beli=rs.getString(5);
                    
                    String [] baris={no_transaksi,id_pembeli,id_roti,tgl_transaksi,jumlah_beli};
                    dtm.addRow(baris);
                }
            
        }catch(SQLException e){}
    }
    
    private void tampilkan_data_produk(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Harga");
        model.addColumn("Stok");
        model.addColumn("Id Pegawai");
        
        try{
            int no=1;
            String sql = "SELECT * FROM produk";
            java.sql.Connection conn = (Connection) Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[] {res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)});
            }
            tabelProduk.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage()); 
        }
    }
    private void tampilkan_data_pembeli(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Kontak");
        model.addColumn("Alamat");
        
        try{
            int no=1;
            String sql = "SELECT * FROM pembeli";
            java.sql.Connection conn = (Connection) Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[] {res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
            }
            tabelPembeli.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());  
        }
    } 
    
    private void tampilkan_data_pegawai(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Jabatan");
        
        try{
           
            String sql = "SELECT * FROM pegawai";
            java.sql.Connection conn = (Connection) Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[] {res.getString(1),res.getString(2),res.getString(3)});
            }
            tabelPegawai.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage()); 
        }
    }
  
    /**
     * Creates new form mainFrame
     */
    public adminForm() {
        initComponents();
        tampilkan_data_pegawai();
        tampilkan_data_produk();
        tampilkan_data_transaksi();
        tampilkan_data_pembeli();
        kosongkan_form();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        produkButton = new javax.swing.JButton();
        pegawaiButton = new javax.swing.JButton();
        pembeliButton = new javax.swing.JButton();
        transaksiButton = new javax.swing.JButton();
        tentangButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        produkPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelProduk = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtTambah = new javax.swing.JTextField();
        txtIdRoti = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNamaRoti = new javax.swing.JTextField();
        tambah1 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        txtStokRoti = new javax.swing.JTextField();
        txtHargaRoti = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtpeg1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pegawaiPanel = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        cdJabatan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPegawai = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pembeliPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelPembeli = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        transaksiPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();

        setTitle("TOKO ROTI");
        setBackground(new java.awt.Color(229, 142, 38));

        bodyPanel.setBackground(new java.awt.Color(220, 202, 226));

        menuPanel.setBackground(new java.awt.Color(229, 142, 38));

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Gambar/home.png"))); // NOI18N
        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        produkButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Gambar/menu.png"))); // NOI18N
        produkButton.setText("Product");
        produkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produkButtonActionPerformed(evt);
            }
        });

        pegawaiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Gambar/pegawai.png"))); // NOI18N
        pegawaiButton.setText("Employee");
        pegawaiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegawaiButtonActionPerformed(evt);
            }
        });

        pembeliButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Gambar/customer.png"))); // NOI18N
        pembeliButton.setText("Customer");
        pembeliButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pembeliButtonActionPerformed(evt);
            }
        });

        transaksiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Gambar/transaksi.png"))); // NOI18N
        transaksiButton.setText("Transaction");
        transaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiButtonActionPerformed(evt);
            }
        });

        tentangButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Gambar/about us.png"))); // NOI18N
        tentangButton.setText("About");
        tentangButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tentangButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(produkButton)
                .addGap(18, 18, 18)
                .addComponent(pegawaiButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pembeliButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transaksiButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tentangButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeButton)
                    .addComponent(pegawaiButton)
                    .addComponent(pembeliButton)
                    .addComponent(transaksiButton)
                    .addComponent(tentangButton)
                    .addComponent(produkButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(220, 202, 226));
        mainPanel.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(46, 204, 113));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\a c e r\\Downloads\\miti-qYreP9QOdrk-unsplash.png")); // NOI18N

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(homePanel, "card2");

        produkPanel1.setBackground(new java.awt.Color(162, 155, 254));

        tabelProduk.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelProdukMouseClicked(evt);
            }
        });
        tabelProduk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelProdukKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(tabelProduk);

        jLabel7.setText("Tambah Jumlah");

        txtIdRoti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdRotiActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("ID Roti");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Nama");

        txtNamaRoti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaRotiActionPerformed(evt);
            }
        });

        tambah1.setText("Tambah");
        tambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah1ActionPerformed(evt);
            }
        });

        jButton8.setText("Save");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Edit");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        txtHargaRoti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaRotiActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Harga");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Stok");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Id Pegawai");

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 51, 51));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5.setText("DATA PRODUK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout produkPanel1Layout = new javax.swing.GroupLayout(produkPanel1);
        produkPanel1.setLayout(produkPanel1Layout);
        produkPanel1Layout.setHorizontalGroup(
            produkPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE)
            .addGroup(produkPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(produkPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(54, 54, 54)
                .addGroup(produkPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(produkPanel1Layout.createSequentialGroup()
                        .addComponent(txtpeg1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(produkPanel1Layout.createSequentialGroup()
                        .addGroup(produkPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(produkPanel1Layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHargaRoti, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStokRoti, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdRoti, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaRoti, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(tambah1)
                        .addGap(29, 29, 29))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        produkPanel1Layout.setVerticalGroup(
            produkPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, produkPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(produkPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(txtIdRoti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(produkPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaRoti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(produkPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHargaRoti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(produkPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStokRoti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(produkPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpeg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(produkPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(txtTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tambah1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        mainPanel.add(produkPanel1, "card3");

        pegawaiPanel.setBackground(new java.awt.Color(186, 220, 88));
        pegawaiPanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pegawaiPanelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cencel ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        cdJabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casier", "Satpam", "Pramuniaga", "Koki", " ", " " }));
        cdJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdJabatanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Jabatan");

        tabelPegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPegawaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelPegawai);

        jPanel3.setBackground(new java.awt.Color(255, 0, 51));
        jPanel3.setForeground(new java.awt.Color(255, 0, 51));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel8.setText("DATA PEGAWAI");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pegawaiPanelLayout = new javax.swing.GroupLayout(pegawaiPanel);
        pegawaiPanel.setLayout(pegawaiPanelLayout);
        pegawaiPanelLayout.setHorizontalGroup(
            pegawaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pegawaiPanelLayout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
            .addGroup(pegawaiPanelLayout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addGroup(pegawaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(67, 67, 67)
                .addGroup(pegawaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pegawaiPanelLayout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pegawaiPanelLayout.createSequentialGroup()
                        .addGroup(pegawaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cdJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pegawaiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pegawaiPanelLayout.setVerticalGroup(
            pegawaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pegawaiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(pegawaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(pegawaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addGroup(pegawaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cdJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(39, 39, 39)
                .addGroup(pegawaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.add(pegawaiPanel, "card4");

        pembeliPanel.setBackground(new java.awt.Color(248, 239, 186));

        tabelPembeli.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabelPembeli);

        jPanel4.setBackground(new java.awt.Color(255, 204, 0));
        jPanel4.setForeground(new java.awt.Color(255, 204, 0));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel9.setText("DATA PEMBELI");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(426, 426, 426)
                .addComponent(jLabel9)
                .addContainerGap(466, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pembeliPanelLayout = new javax.swing.GroupLayout(pembeliPanel);
        pembeliPanel.setLayout(pembeliPanelLayout);
        pembeliPanelLayout.setHorizontalGroup(
            pembeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pembeliPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pembeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        pembeliPanelLayout.setVerticalGroup(
            pembeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pembeliPanelLayout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(pembeliPanel, "card6");

        transaksiPanel.setBackground(new java.awt.Color(75, 207, 250));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setText("DATA TRANSAKSI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tabelTransaksi);

        javax.swing.GroupLayout transaksiPanelLayout = new javax.swing.GroupLayout(transaksiPanel);
        transaksiPanel.setLayout(transaksiPanelLayout);
        transaksiPanelLayout.setHorizontalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addGroup(transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(transaksiPanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(transaksiPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        transaksiPanelLayout.setVerticalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        mainPanel.add(transaksiPanel, "card5");

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void transaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiButtonActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(transaksiPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_transaksiButtonActionPerformed

    private void pegawaiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegawaiButtonActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(pegawaiPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_pegawaiButtonActionPerformed

    private void pembeliButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pembeliButtonActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(pembeliPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_pembeliButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(homePanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void produkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produkButtonActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(produkPanel1);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_produkButtonActionPerformed

    private void tentangButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tentangButtonActionPerformed
        // TODO add your handling code here:
        tentangView klik = new tentangView();
        klik.setVisible(true);
    }//GEN-LAST:event_tentangButtonActionPerformed

    private void cdJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdJabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cdJabatanActionPerformed

    private void pegawaiPanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pegawaiPanelAncestorAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pegawaiPanelAncestorAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        kosongkan_form();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "INSERT INTO pegawai VALUES('"+txtId.getText()+"','"+txtNama.getText()+"','"+cdJabatan.getSelectedItem()+"')";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Data saved successfully");
            tampilkan_data_pegawai();
            kosongkan_form();
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabelPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPegawaiMouseClicked
        // TODO add your handling code here:
        int baris = tabelPegawai.rowAtPoint(evt.getPoint());
        String ID = tabelPegawai.getValueAt(baris, 0).toString();
        txtId.setText(ID);
        String nama = tabelPegawai.getValueAt(baris, 1).toString();
        txtNama.setText(nama);
        String jab = tabelPegawai.getValueAt(baris, 2).toString();
        cdJabatan.setSelectedItem(jab);
        
    }//GEN-LAST:event_tabelPegawaiMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "UPDATE pegawai SET nama_pegawai='"+txtNama.getText()+"',jabatan='"+cdJabatan.getSelectedItem()+"' WHERE id_pegawai='"+txtId.getText()+"'";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Edit data successfully");
            
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data_pegawai();
        kosongkan_form();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE FROM pegawai WHERE id_pegawai='"+txtId.getText()+"'";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
        JOptionPane.showMessageDialog(null, "Delete data successfully");
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data_pegawai();
        kosongkan_form();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        kosongkan_form();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        cariDataTransaksi();
    }//GEN-LAST:event_txtcariKeyPressed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void tabelProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelProdukMouseClicked
        // TODO add your handling code here:
        int baris = tabelProduk.rowAtPoint(evt.getPoint());
        String ID = tabelProduk.getValueAt(baris, 0).toString();
        txtIdRoti.setText(ID);
        String nama = tabelProduk.getValueAt(baris, 1).toString();
        txtNamaRoti.setText(nama);
        String harga = tabelProduk.getValueAt(baris, 2).toString();
        txtHargaRoti.setText(harga);
        String stok = tabelProduk.getValueAt(baris, 3).toString();
        txtStokRoti.setText(stok);
        String peg = tabelProduk.getValueAt(baris, 4).toString();
        txtpeg1.setText(peg);
        
    }//GEN-LAST:event_tabelProdukMouseClicked

    private void tabelProdukKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelProdukKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelProdukKeyPressed

    private void txtIdRotiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdRotiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdRotiActionPerformed

    private void txtNamaRotiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaRotiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaRotiActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try{
            String sql = "INSERT INTO produk VALUES('"+txtIdRoti.getText()+"','"+txtNamaRoti.getText()+"','"+txtHargaRoti.getText()+"','"+txtStokRoti.getText()+"','"+txtpeg1.getText()+"')";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Data saved successfully");
            tampilkan_data_produk();
            kosongkan_form();
        }catch (HeadlessException | SQLException e){               
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try{
            String sql = "UPDATE produk SET id_roti='"+txtIdRoti.getText()+"',nama_roti='"+txtNamaRoti.getText()+"',harga='"+txtHargaRoti.getText()+"',stok='"+txtStokRoti.getText()+"',id_pegawai='"+txtpeg1.getText()+"' WHERE id_roti='"+txtIdRoti.getText()+"'";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Edit data successfully");
            
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data_produk();
        kosongkan_form();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txtHargaRotiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaRotiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaRotiActionPerformed

    private void tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah1ActionPerformed
        try{
            PreparedStatement ps = null;
            Integer stok, tambah, total;
                 stok=Integer.parseInt(txtStokRoti.getText());
                 tambah=Integer.parseInt(txtTambah.getText());
                 total=stok+tambah;
                 String sqlA = "update produk set stok='"+ total +"' where id_roti='"+txtIdRoti.getText()+"'";
                 ps=Konfig.configDB().prepareStatement(sqlA);
                 ps.executeUpdate(sqlA);
            
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data_produk();
        kosongkan_form();
    }//GEN-LAST:event_tambah1ActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariActionPerformed

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
            java.util.logging.Logger.getLogger(adminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JComboBox<String> cdJabatan;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel homePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton pegawaiButton;
    private javax.swing.JPanel pegawaiPanel;
    private javax.swing.JButton pembeliButton;
    private javax.swing.JPanel pembeliPanel;
    private javax.swing.JButton produkButton;
    private javax.swing.JPanel produkPanel1;
    private javax.swing.JTable tabelPegawai;
    private javax.swing.JTable tabelPembeli;
    private javax.swing.JTable tabelProduk;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JButton tambah1;
    private javax.swing.JButton tentangButton;
    private javax.swing.JButton transaksiButton;
    private javax.swing.JPanel transaksiPanel;
    private javax.swing.JTextField txtHargaRoti;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdRoti;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamaRoti;
    private javax.swing.JTextField txtStokRoti;
    private javax.swing.JTextField txtTambah;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtpeg1;
    // End of variables declaration//GEN-END:variables
}
