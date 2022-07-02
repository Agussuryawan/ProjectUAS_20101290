package promhs;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
/**
 *
 * @author I Ketut Agus Suryawan 20101290
 */
public class frmmhs extends javax.swing.JInternalFrame {
    private DefaultTableModel model;
    static ResultSet rs;
    static Statement stmt;
    dbKoneksi cnn = new dbKoneksi();
    loadIMG img = new loadIMG();
    
    /**
     * Creates new form frmmhs
     */
    public frmmhs() {
        initComponents();
        this.initTable();
        this.getdata();
        this.cmdBatal.setVisible(false);
        
    }
    private void initTable(){
        model = new DefaultTableModel();
        dt_mhs.setModel(model);
        model.addColumn("NAMA");
        model.addColumn("NIM");
        model.addColumn("JENIS KELAMIN");
        model.addColumn("JURUSAN");
        model.addColumn("TGL LAHIR");
    }
    private void tampildata(String sql){
        try{
            Statement stmt = cnn.koneksi().createStatement();
            this.rs = stmt.executeQuery(sql);
        }catch(Exception e){
            System.out.println("kendala pada query");
        }
    }
    private void getdata(){
        String sql = "Select Nama, NIM, Jns_Kelamin, Jurusan, TGL_Lahir FROM dt_mhs;";
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
    try{
        this.tampildata(sql);
        while(this.rs.next()){
            Object[] obj = new Object[5];
            obj[0]= this.rs.getString("Nama");
            obj[1]= this.rs.getString("NIM");
            String txJK = this.rs.getString("Jns_Kelamin");
            if(txJK.equals("L")){
                obj[2]="Laki-Laki";
            }else{
                obj[2]="Perempuan";
            }
            obj[3]= this.rs.getString("Jurusan");
            obj[4]= this.rs.getString("TGL_Lahir");
        model.addRow(obj);
        }
    }catch(Exception e){
    }
    }
    private boolean UpdateData(String SQL){
        boolean hsl = false;
        try{
            Statement stmt= cnn.koneksi().createStatement();
            stmt.executeUpdate(SQL);
            hsl = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi masalah pada intruksi SQL");
        }
        return hsl;
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cmdBaru = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dt_mhs = new javax.swing.JTable();
        lbCRUD = new javax.swing.JLabel();
        imgphoto = new javax.swing.JLabel();
        txNAMA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txNIM = new javax.swing.JTextField();
        jlabel = new javax.swing.JLabel();
        txTGL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txJKL = new javax.swing.JRadioButton();
        txJKP = new javax.swing.JRadioButton();
        txJUR = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmdStroe = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        cmdBatal = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("List Data Mahasiswa");

        cmdBaru.setText("Data Baru");
        cmdBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBaruActionPerformed(evt);
            }
        });

        dt_mhs.setModel(new javax.swing.table.DefaultTableModel(
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
        dt_mhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dt_mhsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dt_mhs);

        lbCRUD.setText("Detail");

        jLabel2.setText("Nama");

        jLabel3.setText("NIM");

        jlabel.setText("Tgl Lahir");

        jLabel4.setText("Jenis Kelamin");

        buttonGroup1.add(txJKL);
        txJKL.setText("Laki-Laki");

        buttonGroup1.add(txJKP);
        txJKP.setText("Perempuan");

        txJUR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jurusan", "MDI", "DGM", "KAB" }));

        jLabel5.setText("Jurusan");

        cmdStroe.setText("Simpan");
        cmdStroe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdStroeActionPerformed(evt);
            }
        });

        cmdUpdate.setText("Update");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        cmdDelete.setText("Hapus");
        cmdDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdDeleteMouseClicked(evt);
            }
        });
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        cmdBatal.setText("Batal");
        cmdBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBatalActionPerformed(evt);
            }
        });

        cmdClose.setText("Tutup Form");
        cmdClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmdBaru, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(imgphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2)
                                            .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(txNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jlabel)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                    .addComponent(txTGL))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(txJUR, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txJKL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txJKP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdStroe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdClose)
                        .addGap(11, 11, 11))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdBaru)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCRUD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txJKL)
                                    .addComponent(txJKP)))
                            .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jlabel)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txJUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdStroe)
                    .addComponent(cmdUpdate)
                    .addComponent(cmdDelete)
                    .addComponent(cmdBatal)
                    .addComponent(cmdClose))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBaruActionPerformed
      this.cmdBaru.setEnabled(false);
      this.cmdUpdate.setEnabled(false);
      this.cmdDelete.setEnabled(false);
      this.cmdStroe.setEnabled(true);
      this.cmdBatal.setVisible(true);
      
      this.txNAMA.setText("");
      this.txNIM.setText("");
      this.txJUR.setSelectedIndex(0);
      this.txTGL.setText("");
      
      this.lbCRUD.setText("Tambah data mhs");
    }//GEN-LAST:event_cmdBaruActionPerformed

    private void dt_mhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dt_mhsMouseClicked
        String urlGambarNull = "src/img/gambar.jpg";
        this.txNAMA.setText(model.getValueAt(dt_mhs.getSelectedRow(),0).toString());
        this.txNIM.setText(model.getValueAt(dt_mhs.getSelectedRow(),1).toString());
        String txJK = model.getValueAt(dt_mhs.getSelectedRow(),2).toString();
        if(txJK.equals("Perempuan")){
            this.txJKP.setSelected(true);
        }else{
            this.txJKP.setSelected(true);
        }
        this.txJUR.setSelectedItem(model.getValueAt(dt_mhs.getSelectedRow(),3).toString());
        this.txTGL.setText(model.getValueAt(dt_mhs.getSelectedRow(),4).toString());
        String urlGambar = "src/img/"+this.txNIM.getText()+".jpg";
        BufferedImage loadImg = img.loadImage(urlGambar);
        if(loadImg == null){
            loadImg = img.loadImage(urlGambarNull);
        }
        ImageIcon imageIcon = new ImageIcon (loadImg);
        this.imgphoto.setIcon(imageIcon);
        
        this.lbCRUD.setText("Edit Data"+this.txNIM.getText());
        this.cmdStroe.setEnabled(false);
        this.cmdUpdate.setEnabled(true);
        this.cmdDelete.setEnabled(true);
    }//GEN-LAST:event_dt_mhsMouseClicked
    
    private void cmdCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_cmdCloseMouseClicked

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        String NAMA = this.txNAMA.getText();
        String NIM = this.txNIM.getText();
        String JNS_KL = "L";
        if(this.txJKP.isSelected()){
            JNS_KL="P";
        }
        String JURUSAN = this.txJUR.getSelectedItem().toString();
        String TGL = this.txTGL.getText();
        String SQLUpdate = "UPDATE dt_mhs SET Nama='"+NAMA+"', Jns_Kelamin='"+JNS_KL+"',Jurusan='"+JURUSAN+"',TGL_Lahir='"+TGL+"' WHERE NIM='"+NIM+"';";
        if(this.UpdateData(SQLUpdate)){
            this.getdata();
            JOptionPane.showMessageDialog(null, "Data Terupdate");
        }
    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        String Nama=this.txNAMA.getText();
        String NIM = this.txNIM.getText();
        int opsi = JOptionPane.showConfirmDialog(null,"yakin Akan Menghapus "+Nama+"("+NIM+")?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(opsi == JOptionPane.YES_OPTION){
            String SQLDelete="DELETE FROM dt_mhs WHERE NIM='"+NIM+"';";
            if(this.UpdateData(SQLDelete)){
                this.getdata();
                JOptionPane.showMessageDialog(null, "Data Terhapus");
            }
        }
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void cmdBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBatalActionPerformed
        this.cmdClose.setEnabled(true);
        this.cmdBaru.setEnabled(true);
        this.cmdStroe.setEnabled(false);
        this.cmdBatal.setVisible(false);
    }//GEN-LAST:event_cmdBatalActionPerformed

    private void cmdStroeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdStroeActionPerformed
       String NAMA = this.txNAMA.getText();
       String NIM = this.txNIM.getText();
       String JNS_KL = "L";
       if(this.txJKP.isSelected()){
           JNS_KL="p";
       }
       String JURUSAN = this.txJUR.getSelectedItem().toString();
       String TGL=this.txTGL.getText();
       String SQLInsert = "INSERT INTO dt_mhs (Nama,NIM,Jns_Kelamin,Jurusan,TGL_Lahir) VALUES('"+NAMA+"','"+NIM+"','"+JNS_KL+"','"+JURUSAN+"','"+TGL+"');";
       if(this.UpdateData(SQLInsert)){
           this.getdata();
           JOptionPane.showMessageDialog(null, "Data Telah Di Tambahkan ");
       } 
       this.cmdStroe.setEnabled(false);
       this.cmdBatal.setVisible(false);
       this.cmdClose.setEnabled(true);
       this.cmdBaru.setEnabled(true);
       
    }//GEN-LAST:event_cmdStroeActionPerformed

    private void cmdDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdDeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdDeleteMouseClicked

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
            java.util.logging.Logger.getLogger(frmmhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmmhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmmhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmmhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmmhs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cmdBaru;
    private javax.swing.JButton cmdBatal;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdStroe;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JTable dt_mhs;
    private javax.swing.JLabel imgphoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel;
    private javax.swing.JLabel lbCRUD;
    private javax.swing.JRadioButton txJKL;
    private javax.swing.JRadioButton txJKP;
    private javax.swing.JComboBox<String> txJUR;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JTextField txNIM;
    private javax.swing.JTextField txTGL;
    // End of variables declaration//GEN-END:variables

    
}