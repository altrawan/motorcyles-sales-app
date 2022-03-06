/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sch.smkn1kawali.penjualanmotor.views.mains;

import id.sch.smkn1kawali.penjualanmotor.controllers.ControllerUser;
import id.sch.smkn1kawali.penjualanmotor.interfaces.InterfaceUser;
import id.sch.smkn1kawali.penjualanmotor.models.Karyawan;
import id.sch.smkn1kawali.penjualanmotor.models.User;
import id.sch.smkn1kawali.penjualanmotor.utilitys.Cryptography;
import id.sch.smkn1kawali.penjualanmotor.utilitys.Messages;
import id.sch.smkn1kawali.penjualanmotor.utilitys.Validations;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author Acer One
 */
public class FrmMasterUser extends javax.swing.JFrame {
    InterfaceUser i;
    public String aksi, kode, nama, username, email, role, status;
    
    /**
     * Creates new form FrmMasterUser
     */
    public FrmMasterUser() {
        initComponents();
        i = new ControllerUser();
        tKode.setEnabled(false);
    }
    
    //coding untuk membuat nomor kode user otomatis bertambah 1,
    //jika tombol TAMBAH di tekan
    private void buatnomor() {
        try {
            User u = new User();
            i.createId(u);
            tKode.setText(u.getKode());
        } catch (SQLException ex) {
            Messages.setErrorMessage("Ada kesalahan dalam SQL statement..!");
        }
    }
    
    private void bersih() {
        buatnomor();
        tNama.setText("");
        tUsername.setText("");
        buttonGroup1.clearSelection();
        tEmail.setText("");
        buttonGroup2.clearSelection();
    }
    
    private void setEditOff() {
        tNama.setEnabled(false);
        tUsername.setEnabled(false);
        rbAdmin.setEnabled(false);
        rbGuest.setEnabled(false);
        tEmail.setEnabled(false);
        rbAktif.setEnabled(false);
        rbTidakAktif.setEnabled(false);
    }
    
    private void edit() {
        tKode.setText(kode);
        tNama.setText(nama);
        tUsername.setText(username);
        tEmail.setText(email);
        if (role.equals("ADMIN")) {
            rbAdmin.setSelected(true);
        } else {
            rbGuest.setSelected(true);
        }
        if (status.equals("AKTIF")) {
            rbAktif.setSelected(true);
        } else {
            rbTidakAktif.setSelected(true);
        }
    }
    
    private void validasi() {
        switch (aksi) {
            case "INSERT":
                bersih();
                jLabel1.setText("Tambah Data");
                break;
            case "UPDATE":
                edit();
                jLabel1.setText("Edit Data");
                break;
            default:
                edit();
                setEditOff();
                jLabel1.setText("View Data");
                btnSimpan.setVisible(false);
                break;
        }
    }
    
    protected String RandomPass(int length) {
        final String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (sb.length() < length) {
            int index = (int) (random.nextFloat() * chars.length());
            sb.append(chars.charAt(index));
        }
        String str = sb.toString();
        return str;
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tUsername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rbAktif = new javax.swing.JRadioButton();
        rbTidakAktif = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        tEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbAdmin = new javax.swing.JRadioButton();
        rbGuest = new javax.swing.JRadioButton();
        btnSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(42, 39, 41));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tambah Data");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Kode User");

        tKode.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nama");

        tNama.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tNamaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Username");

        tUsername.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Status");

        rbAktif.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rbAktif);
        rbAktif.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbAktif.setText("AKTIF");

        rbTidakAktif.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rbTidakAktif);
        rbTidakAktif.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbTidakAktif.setText("TIDAK AKTIF");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Role");

        tEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Email");

        rbAdmin.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbAdmin);
        rbAdmin.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbAdmin.setText("ADMIN");

        rbGuest.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbGuest);
        rbGuest.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbGuest.setText("GUEST");

        btnSimpan.setBackground(new java.awt.Color(42, 39, 41));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.setBorder(null);
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(82, 82, 82)
                        .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(109, 109, 109)
                        .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(119, 119, 119)
                        .addComponent(rbAdmin)
                        .addGap(0, 0, 0)
                        .addComponent(rbGuest))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(107, 107, 107)
                        .addComponent(rbAktif)
                        .addGap(2, 2, 2)
                        .addComponent(rbTidakAktif))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel9))
                            .addGap(83, 83, 83)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbAdmin)
                        .addComponent(jLabel8))
                    .addComponent(rbGuest))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5))
                    .addComponent(rbAktif)
                    .addComponent(rbTidakAktif))
                .addGap(29, 29, 29)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       validasi();
    }//GEN-LAST:event_formWindowOpened

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if (tKode.getText().isEmpty() || tNama.getText().isEmpty() || tUsername.getText().isEmpty() 
                || rbAdmin.isSelected() == false &&  rbGuest.isSelected() == false 
                || rbAktif.isSelected() == false && rbTidakAktif.isSelected() == false) {
            Messages.setErrorMessage("Lengkapi data terlebih dahulu..!");
        } else if (tNama.getText().length() < 3 || tUsername.getText().length() > 50) {
            Messages.setErrorMessage("Nama berisi 3-50 digit..!");
        } else if (Validations.isValidUsername(tUsername.getText()) == false) {
            Messages.setErrorMessage("Username harus berisi huruf kapital, kecil dan angka");
        } else if (Validations.isValidEmail(tEmail.getText()) == false) {
            Messages.setErrorMessage("Alamat email tidak valid");
        } else {
            String pass = RandomPass(8);
            String jenis, status;
            if (rbAdmin.isSelected()) {
                jenis = "ADMIN";
            } else {
                jenis = "GUEST";
            }
            if (rbAktif.isSelected()) {
                status = "AKTIF";
            } else {
                status = "TIDAK AKTIF";
            }
            try {
                User u = new User();
                u.setKode(tKode.getText());
                u.setName(tNama.getText());
                u.setUsername(tUsername.getText());
                u.setEmail(tEmail.getText());
                u.setPassword(Cryptography.generateStorngPasswordHash(pass));
                u.setRole(jenis);
                u.setStatus(status);
                if ("INSERT".equals(aksi)) {
                    //Menambah record baru ke database
                    i.insert(u);
                    Messages.setInfomationMessage("Data telah berhasil disimpan");
                    Messages.setInputMessage("Password :", pass);
                    bersih();
                } else {
                    //Mengubah record yang sudah ada di database
                    i.update(u);
                    Messages.setInfomationMessage("Data telah berhasil diperbaharui");
                    dispose();
                }
            } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
                Messages.setErrorMessage("Ada kesalahan dalam SQL statement..!" + ex.toString());
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tNamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNamaKeyTyped
        // TODO add your handling code here:
        if (!Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar()== KeyEvent.VK_SPACE)) { //validasi space
            evt.consume();
        }
    }//GEN-LAST:event_tNamaKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        switch(aksi) {
            case "VIEW":
                new FrmRiwayatUser().show();
                this.dispose();
                break;
            default:
                this.dispose();
                break;
        }
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(FrmMasterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMasterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMasterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMasterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMasterUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rbAdmin;
    private javax.swing.JRadioButton rbAktif;
    private javax.swing.JRadioButton rbGuest;
    private javax.swing.JRadioButton rbTidakAktif;
    private javax.swing.JTextField tEmail;
    private javax.swing.JTextField tKode;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tUsername;
    // End of variables declaration//GEN-END:variables
}
