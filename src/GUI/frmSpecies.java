/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmSpecies.java
 *
 * Created on 08.feb.2014, 12:38:31
 */
package GUI;

import Classes.Species;
import Classes.Validation;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ralfne
 */
public class frmSpecies extends javax.swing.JFrame {
    private Species m_Species=null;
    
    /** Creates new form frmSpecies */
    public frmSpecies(Species s) {
        m_Species=s;
        initComponents();
        try{            
            init();
            displaySpecies();
        }catch(Exception ex){
            frmMain.getfrmMain().displayException(ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtTaxName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTaxID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbIsParasite = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbValidation = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReferences = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        btnDisplayHosts = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTaxPath = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTaxChildren = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCreatedDate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComment = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtGiNumberLimit = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Internal ID:");

        jLabel2.setText("Tax name:");

        jLabel3.setText("Tax ID");

        jLabel4.setText("Is parasite");

        cmbIsParasite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Unknown", "Free living", "Host-associated", "Symbiant", "Parasite" }));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Validation:");

        cmbValidation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("References:");

        txtReferences.setColumns(20);
        txtReferences.setRows(5);
        jScrollPane2.setViewportView(txtReferences);

        jButton3.setText("Display Gi Numbers");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnDisplayHosts.setText("Display hosts");
        btnDisplayHosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayHostsActionPerformed(evt);
            }
        });

        jLabel5.setText("Tax path:");

        txtTaxChildren.setColumns(20);
        txtTaxChildren.setRows(5);
        jScrollPane1.setViewportView(txtTaxChildren);

        jLabel8.setText("Tax children:");

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setText("Created:");

        txtCreatedDate.setText("dd-MM-yyyy HH:mm:ss");

        jLabel10.setText("Comment:");

        txtComment.setColumns(20);
        txtComment.setRows(5);
        jScrollPane3.setViewportView(txtComment);

        jButton4.setText("Display PMIDs...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setText("Limit retrieved gi numbers to:");

        txtGiNumberLimit.setText("10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDisplayHosts, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiNumberLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(19, 19, 19)
                        .addComponent(txtTaxPath, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cmbIsParasite, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbValidation, 0, 262, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCreatedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTaxID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                            .addComponent(txtTaxName, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTaxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTaxID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cmbIsParasite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCreatedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(cmbValidation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTaxPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(btnDisplayHosts)
                    .addComponent(jButton5)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jLabel11)
                    .addComponent(txtGiNumberLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            m_Species.getGiNumbers().load(frmMain.getfrmMain().getDBConnection());
            frmGiNumbers frm=new frmGiNumbers(m_Species.getGiNumbers());
            frm.setVisible(true);
        }catch(Exception ex){
            frmMain.getfrmMain().displayException(ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            collectSpeciesValues();
            m_Species.save(frmMain.getfrmMain().getDBConnection());
            this.dispose();
        }catch(Exception ex){
            frmMain.getfrmMain().displayException(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDisplayHostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayHostsActionPerformed
        try{
            m_Species.getHosts().loadForParasite(frmMain.getfrmMain().getDBConnection());
            frmHosts frm=new frmHosts(m_Species);
            frm.setVisible(true);
        }catch(Exception ex){
            frmMain.getfrmMain().displayException(ex);
        }
    }//GEN-LAST:event_btnDisplayHostsActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int reply=JOptionPane.showConfirmDialog
                (null, "Are you shure you want to delete this record?", "Species", JOptionPane.YES_NO_OPTION);
        if(reply==JOptionPane.YES_OPTION){
            try{
                m_Species.delete(frmMain.getfrmMain().getDBConnection());
                this.dispose();
            }catch(Exception ex){
                frmMain.getfrmMain().displayException(ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            if(m_Species.getGiNumbers().isEmpty()){
                m_Species.getGiNumbers().load(frmMain.getfrmMain().getDBConnection());
            }
            int limit=Integer.parseInt(txtGiNumberLimit.getText());
            frmPMIDs frm=new frmPMIDs();
            frm.init(m_Species.getGiNumbers(), limit);
            frm.setVisible(true);
        } catch (Exception e) {
            frmMain.getfrmMain().displayException(e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(frmSpecies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSpecies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSpecies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSpecies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmSpecies(null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisplayHosts;
    private javax.swing.JComboBox cmbIsParasite;
    private javax.swing.JComboBox cmbValidation;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtComment;
    private javax.swing.JTextField txtCreatedDate;
    private javax.swing.JTextField txtGiNumberLimit;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtReferences;
    private javax.swing.JTextArea txtTaxChildren;
    private javax.swing.JTextField txtTaxID;
    private javax.swing.JTextField txtTaxName;
    private javax.swing.JTextField txtTaxPath;
    // End of variables declaration//GEN-END:variables

    private void init(){
        try{
            initValidationCombo();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void initValidationCombo(){
        ComboBoxModel m=new ValidationComboBoxModel();
        cmbValidation.setModel(m);
    }
    
    private void collectSpeciesValues(){
        m_Species.setName(txtTaxName.getText());
        m_Species.setComment(txtComment.getText());
        if(!txtTaxID.getText().equals("")){
            int i=Integer.parseInt(txtTaxID.getText());
            m_Species.setTaxID(i);
        }
        if(cmbIsParasite.getSelectedIndex()==0){
            m_Species.setParasiteType(Species.ParasiteType.Unknown);
        }else if(cmbIsParasite.getSelectedIndex()==1){
            m_Species.setParasiteType(Species.ParasiteType.NoParasite);
        }else if(cmbIsParasite.getSelectedIndex()==2){
            m_Species.setParasiteType(Species.ParasiteType.HostAssociated);
        }else if(cmbIsParasite.getSelectedIndex()==3){
            m_Species.setParasiteType(Species.ParasiteType.Symbiant);
        }else if(cmbIsParasite.getSelectedIndex()==4){
            m_Species.setParasiteType(Species.ParasiteType.Parasite);
        }

        m_Species.setReferences(txtReferences.getText());
        if(cmbValidation.getSelectedIndex()==-1){
            m_Species.setValidation(null); 
        }else{
            Validation v=(Validation)cmbValidation.getSelectedItem();
            m_Species.setValidation(v); 
        }
    }
    
    private void displaySpecies()throws Exception{
        txtID.setText(String.valueOf(m_Species.getID()));
        txtTaxName.setText(m_Species.getName());
        txtComment.setText(m_Species.getComment());
        if(m_Species.getTaxID()==null){
            txtTaxID.setText("");
        }else{
            txtTaxID.setText(String.valueOf(m_Species.getTaxID()));
        }
        txtReferences.setText(m_Species.getReferences());
        
        if(m_Species.getParasiteType()==Species.ParasiteType.Unknown){
            cmbIsParasite.setSelectedIndex(0);
        }else if(m_Species.getParasiteType()==Species.ParasiteType.NoParasite){
            cmbIsParasite.setSelectedIndex(1);
        }else if(m_Species.getParasiteType()==Species.ParasiteType.HostAssociated){
            cmbIsParasite.setSelectedIndex(2);
        }else if(m_Species.getParasiteType()==Species.ParasiteType.Symbiant){
            cmbIsParasite.setSelectedIndex(3);
        }else if(m_Species.getParasiteType()==Species.ParasiteType.Parasite){
            cmbIsParasite.setSelectedIndex(4);
        }

        if(m_Species.getCreatedDate()==null){
            txtCreatedDate.setText(frmMain.getDateAsString(new Date()));
        }else{
            txtCreatedDate.setText(frmMain.getDateAsString(m_Species.getCreatedDate()));        
        }
        Validation v=m_Species.getValidation();
        if(v==null){
            cmbValidation.setSelectedIndex(-1);
        }else{
            cmbValidation.getModel().setSelectedItem(m_Species.getValidation());            
        }
        String taxPath=frmMain.getfrmMain().getTaxNodes().getTaxonomyPath(m_Species.getTaxID());
        txtTaxPath.setText(taxPath);
        ArrayList<Integer> childTaxIDs=frmMain.getfrmMain().getTaxNodes().getChildren(m_Species.getTaxID());
        if(childTaxIDs==null){
            txtTaxChildren.setText("(no children)");
        }else{
            Iterator<Integer> iter=childTaxIDs.iterator();
            while(iter.hasNext()){
                int taxID=iter.next();
                String taxName=frmMain.getfrmMain().getTaxNodes().getNames().get(taxID);
                txtTaxChildren.append(taxName);
                txtTaxChildren.append(frmMain.NEWLINE);
            }
        }    
        if(m_Species.getID()<=0){
            btnDisplayHosts.setEnabled(false);
        }
    }    


    
}
