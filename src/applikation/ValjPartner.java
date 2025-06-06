/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package applikation;

import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author karlb
 */
public class ValjPartner extends javax.swing.JFrame {

    private InfDB idb;
    private String inloggadAnvandare;
    private Partner partner;
    private String valdPartner;
    private String pid;
    /**
     * Creates new form PartnerMeny
     */
    public ValjPartner(InfDB idb, String inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
    
        partner = new Partner(idb);  // skapa objektet som används i fyllCombobox()
        fyllCombobox();
    }
    
    public void fyllCombobox()
    {
        try{
        cbxPartner.removeAllItems();
        ArrayList<String> partners = partner.hamtaAllaNamn();
        for(String namn: partners)
        {
            cbxPartner.addItem(namn);
        }
        }   
        catch(Exception ex){
        System.out.println(ex.getMessage());    
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

        lblPartner = new javax.swing.JLabel();
        cbxPartner = new javax.swing.JComboBox<>();
        btnValj = new javax.swing.JButton();
        btnTillbakaTillMeny = new javax.swing.JButton();
        BtnTillbakaTillForegaende = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPartner.setText("Partner:");

        cbxPartner.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnValj.setText("Välj");
        btnValj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValjActionPerformed(evt);
            }
        });

        btnTillbakaTillMeny.setText("Tillbaka till menyn");
        btnTillbakaTillMeny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaTillMenyActionPerformed(evt);
            }
        });

        BtnTillbakaTillForegaende.setText("Tillbaka till föregående sida");
        BtnTillbakaTillForegaende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTillbakaTillForegaendeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnTillbakaTillForegaende)
                        .addGap(18, 18, 18)
                        .addComponent(btnTillbakaTillMeny))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPartner, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cbxPartner, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnValj))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblPartner)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnValj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTillbakaTillMeny)
                    .addComponent(BtnTillbakaTillForegaende))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaTillMenyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaTillMenyActionPerformed
        this.dispose();
        new Meny(idb, inloggadAnvandare).setVisible(true);
    }//GEN-LAST:event_btnTillbakaTillMenyActionPerformed

    private void btnValjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValjActionPerformed
        try{
        String valdStrang = cbxPartner.getSelectedItem().toString();
        this.valdPartner = valdStrang;
        String sqlFraga = "SELECT pid from partner WHERE namn = '" + valdPartner + "'";
        String hamtatPid = idb.fetchSingle(sqlFraga);
        this.pid = hamtatPid;
        this.setVisible(false);
        new PartnerUppgifter(idb, inloggadAnvandare, valdPartner, pid).setVisible(true);
        }
        catch(InfException ex){
        System.out.println(ex.getMessage());    
        }  
    }//GEN-LAST:event_btnValjActionPerformed

    private void BtnTillbakaTillForegaendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTillbakaTillForegaendeActionPerformed
        this.dispose();
        new PartnerMeny(idb, inloggadAnvandare).setVisible(true);
    }//GEN-LAST:event_BtnTillbakaTillForegaendeActionPerformed

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
            java.util.logging.Logger.getLogger(ValjPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValjPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValjPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValjPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ValjPartner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnTillbakaTillForegaende;
    private javax.swing.JButton btnTillbakaTillMeny;
    private javax.swing.JButton btnValj;
    private javax.swing.JComboBox<String> cbxPartner;
    private javax.swing.JLabel lblPartner;
    // End of variables declaration//GEN-END:variables
}
