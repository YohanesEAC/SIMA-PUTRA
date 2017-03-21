/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author YEAC
 */
public class frm_barang extends javax.swing.JFrame {
     //deklarasi variable
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;

    /**
     
     */
    public frm_barang() {
        initComponents();
        ImageIcon ico = new ImageIcon("src/images/usuarios.png");
        setIconImage(ico.getImage());
                Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = new Dimension ( 860, 430 );
        
        tglskrg();
        
        this.setBounds ( ss.width / 2 - frameSize.width / 2, 
                  ss.height / 2 - frameSize.height / 2,
                  frameSize.width, frameSize.height );
       
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);   
        btn_simpan.setEnabled(false);
        txt_nama_barang.setEnabled(false);
        txt_jumlah_barang.setEnabled(false);
        txt_harga_satuan.setEnabled(false);
        txt_kode_barang.setEnabled(false);
        cbx_jenis.setEnabled(false);
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tabel_barang.setModel(tableModel);
        settableload();
    }
    
int row = 0;
public void tampil_field()
{
    row = tabel_barang.getSelectedRow();
    txt_kode_barang.setText(tableModel.getValueAt(row, 0).toString());
    txt_nama_barang.setText(tableModel.getValueAt(row, 1).toString());
    cbx_jenis.setSelectedItem(tableModel.getValueAt(row, 2).toString());
    txt_jumlah_barang.setText(tableModel.getValueAt(row, 3).toString());
    txt_harga_satuan.setText(tableModel.getValueAt(row, 4).toString());
    txt_tanggal_barang_masuk.setText(tableModel.getValueAt(row, 5).toString());
    btn_simpan.setEnabled(false);
    btn_ubah.setEnabled(true);
    btn_hapus.setEnabled(true);  
}
public void membersihkan_teks(){
    txt_nama_barang.setEnabled(false);
    txt_jumlah_barang.setEnabled(false);
    txt_harga_satuan.setEnabled(false);
    cbx_jenis.setEnabled(false);
    btn_simpan.setEnabled(false);
    txt_kode_barang.setText("");
    txt_nama_barang.setText("");
    cbx_jenis.setSelectedItem("");
    txt_jumlah_barang.setText("");
    txt_harga_satuan.setText("");

}
public void membersihkan_tabel(){
    while(tableModel.getRowCount()>0){
        for(int i=0;i<tableModel.getRowCount();i++){
            tableModel.removeRow(i);
        }
    }
}
public void carikodebarang() {
    try {
        Class.forName(driver);
        Object row[] = {"Kode Barang",
                            "Nama Barang",
                            "Jenis Barang",
                            "Jumlah Barang",
                            "Harga Satuan",
                            "Tanggal Barang Masuk"};
        tableModel = new DefaultTableModel(null,row);
        tabel_barang.setModel(tableModel); 
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String sql = "select * from tabel_barang where kode_barang" + " like '%" + cari.getText() + "%'";
        ResultSet res = stt.executeQuery(sql);
        while (res.next()) {
            String a = res.getString(1);
            String b = res.getString(2);
            String c = res.getString(3);   
            String d = res.getString(4);
            String e = res.getString(5);
            String f = res.getString(6);
            String[] data = {a,b,c,d,e,f};
        tableModel.addRow(data);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void carinamabarang() {
    try {
        Class.forName(driver);
        Object row[] = {"Kode Barang",
                            "Nama Barang",
                            "Jenis Barang",
                            "Jumlah Barang",
                            "Harga Satuan",
                            "Tanggal Barang Masuk"};
        tableModel = new DefaultTableModel(null,row);
        tabel_barang.setModel(tableModel); 
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String sql = "select * from tabel_barang where nama_barang" + " like '%" + cari.getText() + "%'";
        ResultSet res = stt.executeQuery(sql);
        while (res.next()) {
            String a = res.getString(1);
            String b = res.getString(2);
            String c = res.getString(3);   
            String d = res.getString(4);
            String e = res.getString(5);
            String f = res.getString(6);
            String[] data = {a,b,c,d,e,f};
        tableModel.addRow(data);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
}


public void carijenisbarang() {
    try {
        Class.forName(driver);
        Object row[] = {"Kode Barang",
                            "Nama Barang",
                            "Jenis Barang",
                            "Jumlah Barang",
                            "Harga Satuan",
                            "Tanggal Barang Masuk"};
        tableModel = new DefaultTableModel(null,row);
        tabel_barang.setModel(tableModel); 
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String sql = "select * from tabel_barang where jenis_barang" + " like '%" + cari.getText() + "%'";
        ResultSet res = stt.executeQuery(sql);
        while (res.next()) {
            String a = res.getString(1);
            String b = res.getString(2);
            String c = res.getString(3);   
            String d = res.getString(4);
            String e = res.getString(5);
            String f = res.getString(6);
            String[] data = {a,b,c,d,e,f};
        tableModel.addRow(data);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void tglskrg(){
        Date skrg= new Date();
        SimpleDateFormat format= new SimpleDateFormat("dd MMMM yyyy");
        SimpleDateFormat format2= new SimpleDateFormat("yyyy-MM-dd");
        String tgl = format2.format(skrg);
        txt_tanggal_barang_masuk.setText(format.format(skrg));
    }

private javax.swing.table.DefaultTableModel tableModel = getDefaultTabelModel();
private javax.swing.table.DefaultTableModel getDefaultTabelModel()
{
    //membuat judul header
    return new javax.swing.table.DefaultTableModel
            (
                new  Object[][] {},
                new String[]{"Kode Barang",
                            "Nama Barang",
                            "Jenis Barang",
                            "Jumlah Barang",
                            "Harga Satuan",
                            "Tanggal Barang Masuk"}
            )
    //disable perubahan pada grid
    {
        boolean[] canEdit = new boolean[]
        {
            false, false, false, false, false, false
        };
        
        public boolean isCellEdittable(int  rowIndex, int columnIndex)
        {
            return canEdit[columnIndex];
        }
    };
}
  
String data[] = new String[6];
private void settableload()
{
    String stat = "";
    try
    {
        Class.forName(driver);
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String SQL ="select * from tabel_barang";
        ResultSet res = stt.executeQuery(SQL);
        while (res.next()) 
        {
           Object[] data;
           data = new Object[6];
           data[0] = res.getString(1);
           data[1] = res.getString(2);
           data[2] = res.getString(3);
           data[3] = res.getString(4);
           data[4] = res.getString(5);
           data[5] = res.getString(6);
           tableModel.addRow(data);
        }

    }
    catch(Exception ex)
    {
        System.err.println(ex.getMessage());
        JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
    
public void tambah_barang() throws ClassNotFoundException, SQLException{
        try{            
           Class.forName(driver);
           Connection kon = DriverManager.getConnection(database,user,pass);
           Statement stt = kon.createStatement();
           
           String sql= "SELECT MAX(right(kode_barang,5)) AS kode_barang FROM tabel_barang";
           ResultSet res = stt.executeQuery(sql);
    
        while(res.next())
            {
                if(res.first() == false)
                {
        txt_kode_barang.setText("KB-000001");
       
}
                else
        {
                   res.last();
                   int auto_id = res.getInt(1) + 1;
                   String no = String.valueOf(auto_id);
                   int noLong = no.length();
                   //MENGATUR jumlah 0
                    for(int a=0;a<6-noLong;a++)
                    { 
                        no = "0" + no;
                    }
                   txt_kode_barang.setText("KB-" + no);
                
                 }        
            }
}    
catch (Exception e){
            JOptionPane.showMessageDialog(this, "ERROR: \n" + e.toString(),
                            "Kesalahan", JOptionPane.WARNING_MESSAGE);

        }
}
 private void tampil_tabel(){
       try {
           Class.forName(driver);
           Connection kon = DriverManager.getConnection(database,user,pass);
           Statement stt = kon.createStatement();
           String sql = "SELECT * FROM tabel_barang";
           ResultSet res = stt.executeQuery(sql);
           while(res.next()){
               Object[] o;
               o = new Object[6];
               o[0] = res.getString("kode_barang");
               o[1] = res.getString("nama_barang");
               o[2] = res.getString("jenis_barang");
               o[3] = res.getString("jumlah");
               o[4] = res.getString("harga_satuan");
               o[5] = res.getString("tanggal_barang_masuk");
               tableModel.addRow(o);
           }
       } catch (Exception e) {
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

        jPanel2 = new javax.swing.JPanel();
        txt_jumlah_barang = new javax.swing.JTextField();
        txt_harga_satuan = new javax.swing.JTextField();
        txt_kode_barang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
        btn_keluar = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_tanggal_barang_masuk = new javax.swing.JTextField();
        btn_batal = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_nama_barang = new javax.swing.JTextField();
        carii = new javax.swing.JComboBox();
        cari = new javax.swing.JTextField();
        go = new javax.swing.JButton();
        cbx_jenis = new javax.swing.JComboBox();
        pembuat1 = new Form.pembuat();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Barang");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_jumlah_barang.setToolTipText("Isi Menggunakan Angka !");
        txt_jumlah_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_jumlah_barangKeyTyped(evt);
            }
        });
        jPanel2.add(txt_jumlah_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 110, 36, -1));

        txt_harga_satuan.setToolTipText("Isi Menggunakan Angka !");
        txt_harga_satuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_harga_satuanKeyTyped(evt);
            }
        });
        jPanel2.add(txt_harga_satuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 141, 131, -1));

        txt_kode_barang.setEditable(false);
        jPanel2.add(txt_kode_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 11, 137, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kode Barang");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jenis Kayu");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 76, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jumlah Barang");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Harga Satuan");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 144, -1, -1));

        tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Jenis Barang", "Jumlah", "Harga Satuan"
            }
        ));
        tabel_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_barang);
        if (tabel_barang.getColumnModel().getColumnCount() > 0) {
            tabel_barang.getColumnModel().getColumn(0).setHeaderValue("Kode Barang");
            tabel_barang.getColumnModel().getColumn(1).setHeaderValue("Jenis Barang");
            tabel_barang.getColumnModel().getColumn(2).setHeaderValue("Jumlah");
            tabel_barang.getColumnModel().getColumn(3).setHeaderValue("Harga Satuan");
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 242, 855, 110));

        btn_keluar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/oneline_home-16 (1).png"))); // NOI18N
        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 357, 100, -1));

        btn_hapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin-16.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel2.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 357, 90, -1));

        btn_ubah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_editor_pen_pencil_write-16 - Copy.png"))); // NOI18N
        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 357, 90, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_cross_new_plus_create-16.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 11, -1, -1));

        btn_simpan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/multimedia-27-16.png"))); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel2.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 206, 110, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tanggal Barang Masuk");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 178, -1, -1));

        txt_tanggal_barang_masuk.setEditable(false);
        txt_tanggal_barang_masuk.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel2.add(txt_tanggal_barang_masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 175, 119, -1));

        btn_batal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alert.png"))); // NOI18N
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        jPanel2.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 357, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama Barang");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, -1, -1));

        txt_nama_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nama_barangKeyTyped(evt);
            }
        });
        jPanel2.add(txt_nama_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 42, 137, -1));

        carii.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cari Berdasarkan", "Kode Barang", "Nama Barang", "Jenis Barang" }));
        carii.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cariiMouseClicked(evt);
            }
        });
        carii.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariiActionPerformed(evt);
            }
        });
        jPanel2.add(carii, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 208, 140, -1));

        cari.setEnabled(false);
        jPanel2.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 208, 110, -1));

        go.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-ico.png"))); // NOI18N
        go.setText("Cari");
        go.setEnabled(false);
        go.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goMouseClicked(evt);
            }
        });
        go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goActionPerformed(evt);
            }
        });
        jPanel2.add(go, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 206, -1, -1));

        cbx_jenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "=SILAHKAN PILIH JENIS KAYU=", "Kayu Jati", "Kayu Borneo", "Kayu Alba" }));
        jPanel2.add(cbx_jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 73, -1, -1));

        javax.swing.GroupLayout pembuat1Layout = new javax.swing.GroupLayout(pembuat1);
        pembuat1.setLayout(pembuat1Layout);
        pembuat1Layout.setHorizontalGroup(
            pembuat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        pembuat1Layout.setVerticalGroup(
            pembuat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jPanel2.add(pembuat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, -1, -1));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            tambah_barang();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);   
        btn_simpan.setEnabled(true);
        txt_nama_barang.setEnabled(true);
        txt_jumlah_barang.setEnabled(true);
        txt_harga_satuan.setEnabled(true);
        txt_kode_barang.setEnabled(true);
        cbx_jenis.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        String data[]=new String[6];
         String input = txt_jumlah_barang.getText();
         if (input.matches("[0-9]*")) {
            System.out.println("OK");
            } else {
                    JOptionPane.showMessageDialog(null, "Jumlah Barang Hanya Diisi Oleh Angka [0-9]!");
                    }
        String input2 = txt_harga_satuan.getText();
        if (input2.matches("[0-9]*")) {
        System.out.println("OK");
        } else {
                JOptionPane.showMessageDialog(null, "Harga Satuan Hanya Diisi Oleh Angka [0-9]!");
                }
        int row = tabel_barang.getSelectedRow();
        try {
            Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Mohon pilih tabel terlebih dahulu","Pesan",JOptionPane.WARNING_MESSAGE);
            }
            else{
                String sql = "UPDATE tabel_barang SET nama_barang = '"+txt_nama_barang.getText()+"'"
                        + ", jenis_barang = '"+cbx_jenis.getSelectedItem()+"', jumlah = '"+txt_jumlah_barang.getText()+"', harga_satuan = '"+txt_harga_satuan.getText()+"', tanggal_barang_masuk = '"+txt_tanggal_barang_masuk.getText()+"' WHERE kode_barang = '"+txt_kode_barang.getText()+"'";
                stt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Berhasil Diubah!");
                membersihkan_teks();
                membersihkan_tabel();
                settableload();
            }
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
    
        // TODO add your handling code here:
            if(evt.getSource() == btn_keluar){
            int a;
            a = JOptionPane.showConfirmDialog(null, "ANDA YAKIN AKAN KELUAR?", "WARNING!", JOptionPane.YES_NO_OPTION);
            
            if(a == JOptionPane.YES_OPTION){
                this.setVisible(false);
            }
        }
        
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
         String data[]=new String[6];
         String input = txt_jumlah_barang.getText();
         if (input.matches("[0-9]*")) {
            System.out.println("OK");
            } else {
                    JOptionPane.showMessageDialog(null, "Jumlah Barang Hanya Diisi Oleh Angka [0-9]!");
                    }
        String input2 = txt_harga_satuan.getText();
        if (input2.matches("[0-9]*")) {
        System.out.println("OK");
        } else {
                JOptionPane.showMessageDialog(null, "Harga Satuan Hanya Diisi Oleh Angka [0-9]!");
                }
        if((txt_kode_barang.getText().isEmpty())|| (txt_nama_barang.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong, Silahkan Dilengkapi!");
        txt_kode_barang.requestFocus();
        }
        else
        {
            try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO tabel_barang(kode_barang,"+"nama_barang,"+"jenis_barang,"+"jumlah,"+"harga_satuan,"+"tanggal_barang_masuk)"+"VALUES"
                        +"('"+txt_kode_barang.getText()+"',"
                        +"'"+txt_nama_barang.getText()+"',"
                        +"'"+cbx_jenis.getSelectedItem()+"',"
                        +"'"+txt_jumlah_barang.getText()+"',"
                        +"'"+txt_harga_satuan.getText()+"',"
                        +"'"+txt_tanggal_barang_masuk.getText()+"')";
                stt.executeUpdate(SQL);
                data[0]=txt_kode_barang.getText();
                data[1]=txt_nama_barang.getText();
                data[2]=cbx_jenis.getSelectedItem().toString();
                data[3]=txt_jumlah_barang.getText();
                data[4]=txt_harga_satuan.getText();
                data[5]=txt_tanggal_barang_masuk.getText();
                tableModel.insertRow(0, data);
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_simpan.setEnabled(false);
                btn_ubah.setEnabled(false);
                btn_hapus.setEnabled(false);   
                btn_simpan.setEnabled(false);
                txt_nama_barang.setEnabled(false);
                txt_jumlah_barang.setEnabled(false);
                txt_harga_satuan.setEnabled(false);
                txt_kode_barang.setEnabled(false);
                cbx_jenis.setEnabled(false);
                membersihkan_teks();
                JOptionPane.showMessageDialog(null, "Berhasil Tersimpan!");

            }
            catch(Exception ex)
            {
                
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        membersihkan_tabel();
        settableload();
        membersihkan_teks();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        //Validasi Hapus Data
        if(evt.getSource() == btn_hapus){
        int a;
        a = JOptionPane.showConfirmDialog(null, "ANDA YAKIN DATA AKAN DIHAPUS ? ", "WARNING!", JOptionPane.YES_NO_OPTION);    
        if(a == JOptionPane.YES_OPTION){
        int row = tabel_barang.getSelectedRow();
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Mohon pilih tabel terlebih dahulu","Pesan",JOptionPane.WARNING_MESSAGE);
            }
            else{
                String sqlhapus = "DELETE FROM tabel_barang WHERE kode_barang = '"+txt_kode_barang.getText()+"'";
                stt.executeUpdate(sqlhapus);
                JOptionPane.showMessageDialog(null, "Berhasil Dihapus!");
                tableModel.removeRow(row);
                membersihkan_teks();
            }
        } catch (Exception e) {
        }
                    }
        }   
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tabel_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barangMouseClicked
        // TODO add your handling code here:
          if(evt.getClickCount()==1)
        {
            tampil_field();
        }
        btn_hapus.setEnabled(true);
        btn_ubah.setEnabled(true); 
        btn_keluar.setEnabled(true);
        btn_simpan.setEnabled(false);
        txt_nama_barang.setEnabled(true);
        txt_jumlah_barang.setEnabled(true);
        txt_harga_satuan.setEnabled(true);
        txt_kode_barang.setEnabled(false);
        cbx_jenis.setEnabled(true);
    }//GEN-LAST:event_tabel_barangMouseClicked

    private void cariiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cariiMouseClicked

    private void cariiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariiActionPerformed
        cari.setEnabled(true);
        go.setEnabled(true);

    }//GEN-LAST:event_cariiActionPerformed

    private void goMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goMouseClicked
        if(carii.getSelectedIndex() == 1){
            carikodebarang();
        }

        if (carii.getSelectedIndex()== 2) {
            carinamabarang();
        }
        if (carii.getSelectedIndex()== 3) {
            carijenisbarang();
        }

    }//GEN-LAST:event_goMouseClicked

    private void goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goActionPerformed

    private void txt_nama_barangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_barangKeyTyped
        // TODO add your handling code here:
    if ( txt_nama_barang.getText().length() == 10 ) {
        evt.consume();
        
    }
    }//GEN-LAST:event_txt_nama_barangKeyTyped

    private void txt_jumlah_barangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlah_barangKeyTyped
        // TODO add your handling code here:
            if ( txt_jumlah_barang.getText().length() == 3 ) {
        evt.consume();        
    }
    }//GEN-LAST:event_txt_jumlah_barangKeyTyped

    private void txt_harga_satuanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_harga_satuanKeyTyped
        // TODO add your handling code here:
        if ( txt_nama_barang.getText().length() == 8 ) {
        evt.consume();    
    }
    }//GEN-LAST:event_txt_harga_satuanKeyTyped

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
            java.util.logging.Logger.getLogger(frm_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox carii;
    private javax.swing.JComboBox cbx_jenis;
    private javax.swing.JButton go;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Form.pembuat pembuat1;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JTextField txt_harga_satuan;
    private javax.swing.JTextField txt_jumlah_barang;
    private javax.swing.JTextField txt_kode_barang;
    private javax.swing.JTextField txt_nama_barang;
    private javax.swing.JTextField txt_tanggal_barang_masuk;
    // End of variables declaration//GEN-END:variables
}
