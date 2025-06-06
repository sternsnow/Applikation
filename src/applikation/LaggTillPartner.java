/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package applikation;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author karlb
 */
public class LaggTillPartner extends javax.swing.JFrame {

    private InfDB idb;
    private String inloggadAnvandare;
    private Partner partner;
    private Validering validering;
    /**
     * Creates new form LaggTillPartner
     */
    public LaggTillPartner(InfDB idb, String inloggadAnvandare) {
        initComponents();
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        this.partner = new Partner(idb);
        this.validering = new Validering(idb);
        rensaAllaFalt();
    }

    
    public void rensaAllaFalt(){
    
    txtNamn.setText("");
    txtKontaktperson.setText("");
    txtKontaktEpost.setText("");
    txtTelefon.setText("");
    txtAdress.setText("");
    txtStad.setText("");
    txtBranch.setText("");
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtKontaktperson = new javax.swing.JTextField();
        txtKontaktEpost = new javax.swing.JTextField();
        lblNamn = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        lblKontaktperson = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        lblTelefon = new javax.swing.JLabel();
        txtBranch = new javax.swing.JTextField();
        lblKontaktEpost = new javax.swing.JLabel();
        btnLaggTillPartner = new javax.swing.JButton();
        lblAdress = new javax.swing.JLabel();
        btnTillbakaTillMeny = new javax.swing.JButton();
        lblBranch = new javax.swing.JLabel();
        BtnTillbakaTillForegaende = new javax.swing.JButton();
        lblStad = new javax.swing.JLabel();
        txtStad = new javax.swing.JTextField();
        txtNamn = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNamn.setText("Namn");

        lblKontaktperson.setText("Kontaktperson");

        lblTelefon.setText("Telefon");

        txtBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBranchActionPerformed(evt);
            }
        });

        lblKontaktEpost.setText("KontaktEpost");

        btnLaggTillPartner.setText("Lägg till");
        btnLaggTillPartner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillPartnerActionPerformed(evt);
            }
        });

        lblAdress.setText("Adress");

        btnTillbakaTillMeny.setText("Tillbaka till menyn");
        btnTillbakaTillMeny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaTillMenyActionPerformed(evt);
            }
        });

        lblBranch.setText("Branch");

        BtnTillbakaTillForegaende.setText("Tillbaka till föregående sida");
        BtnTillbakaTillForegaende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTillbakaTillForegaendeActionPerformed(evt);
            }
        });

        lblStad.setText("Stad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKontaktperson, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKontaktEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTelefon)
                                .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtBranch, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtStad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNamn, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtKontaktperson, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtKontaktEpost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(BtnTillbakaTillForegaende)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTillbakaTillMeny)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLaggTillPartner)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNamn)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKontaktperson)
                    .addComponent(txtKontaktperson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKontaktEpost)
                    .addComponent(txtKontaktEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefon)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBranch)
                    .addComponent(txtBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStad)
                    .addComponent(txtStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTillbakaTillMeny)
                    .addComponent(BtnTillbakaTillForegaende)
                    .addComponent(btnLaggTillPartner))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBranchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBranchActionPerformed

    private void btnLaggTillPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillPartnerActionPerformed
        Stad stad = new Stad(idb);
        
        String namn = txtNamn.getText();
        String kontaktperson = txtKontaktperson.getText();
        String kontaktEpost = txtKontaktEpost.getText();
        String telefon = txtTelefon.getText();
        String adress = txtAdress.getText();
        String stadNamn = txtStad.getText();
        String branch = txtBranch.getText();
        
        try{
            
        // Skapa nytt pid
        String maxPidSql = "SELECT MAX(pid) FROM partner";
        String maxPidStr = idb.fetchSingle(maxPidSql);
        int nyttPid = 1;

	if (maxPidStr != null) {
    	nyttPid = Integer.parseInt(maxPidStr) + 1;   // nyttPid får MAX pid + 1
	}

        String felmeddelanden = "";

       
            if(validering.arTextFaltTomt(namn) || !partner.kontrolleraNamn (namn)) {
                felmeddelanden += "- Namn måste innehålla giltiga tecken och får inte vara tomt.\n";
            }

        
            if(validering.arTextFaltTomt(kontaktperson) || !partner.kontrolleraNamn(kontaktperson)) {
                felmeddelanden += "- Kontaktperson måste innehålla giltiga namn eller vara tomt.\n";;
            }
        

       
            if(validering.arTextFaltTomt(kontaktEpost) || !partner.kontrolleraEpost(kontaktEpost)) {
                felmeddelanden += "- Ogiltig e-postadress eller tomt fält \n";
            }
        

        
            if(validering.arTextFaltTomt(telefon)  || !partner.kontrolleraTelefon(telefon)) {
                felmeddelanden += "- Ogiltigt telefonnummer eller tomt fält. \n";
            }
        

        
            if(validering.arTextFaltTomt(adress) || !partner.kontrolleraAdress(adress)) {
                felmeddelanden += "- Adress måste innehålla giltiga tecken och får inte vara tom. \n";
            }
        

        
            if(validering.arTextFaltTomt(stadNamn)|| !partner.kontrolleraStad(stadNamn)) {
                felmeddelanden += "- Stad måste innehålla giltiga tecken eller får inte vara tom. \n";
            }
        

        
            if(validering.arTextFaltTomt(branch) || !partner.kontrolleraBranch (branch)) {
                felmeddelanden += "- Branch måste innehålla giltiga tecken eller får inte vara tom. \n";
            }
        

        if (!felmeddelanden.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Följande fel måste rättas till:\n" + felmeddelanden);
           
            }
        
        else{

        //Hämta sid för angiven stad
        String sid = stad.getSid(stadNamn);
        
        //Om inga fel
        String insertFraga = "INSERT INTO partner (pid, namn, kontaktperson, kontaktepost, telefon, "
                + "adress, branch, stad) "
                + "VALUES ('" + nyttPid + "', '" + namn + "', '" + kontaktperson + "', '"
                + kontaktEpost + "', '" + telefon + "', '" + adress + "', '" + branch + "', '"
                + sid + "')";

        idb.insert(insertFraga);
       

        JOptionPane.showMessageDialog(null, namn + " har lagts till.");
        rensaAllaFalt();
        }
        }
        
        catch (InfException e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Fel vid inmatning av uppgifter: " + e.getMessage());
    }

    }//GEN-LAST:event_btnLaggTillPartnerActionPerformed

    private void btnTillbakaTillMenyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaTillMenyActionPerformed
        this.dispose();
        new Meny(idb, inloggadAnvandare).setVisible(true);
    }//GEN-LAST:event_btnTillbakaTillMenyActionPerformed

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
            java.util.logging.Logger.getLogger(LaggTillPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaggTillPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaggTillPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaggTillPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new LaggTillPartner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnTillbakaTillForegaende;
    private javax.swing.JButton btnLaggTillPartner;
    private javax.swing.JButton btnTillbakaTillMeny;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblBranch;
    private javax.swing.JLabel lblKontaktEpost;
    private javax.swing.JLabel lblKontaktperson;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblStad;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtBranch;
    private javax.swing.JTextField txtKontaktEpost;
    private javax.swing.JTextField txtKontaktperson;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtStad;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
