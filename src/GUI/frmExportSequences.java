/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmExportSequences.java
 *
 * Created on 10.mar.2015, 18:51:50
 */
package GUI;

import Classes.Host;
import Classes.Species;
import Classes.SpeciesCollection;
import classes.TaxNodesWrapper;
import com.mysql.jdbc.AbandonedConnectionCleanupThread;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author ralfne
 */
public class frmExportSequences extends javax.swing.JFrame {
    private Thread m_AsyncThread=null;
    
    /** Creates new form frmExportSequences */
    public frmExportSequences() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        chkExportParasites = new javax.swing.JCheckBox();
        chkExportSymbionts = new javax.swing.JCheckBox();
        chkExportHostAssociated = new javax.swing.JCheckBox();
        chkExportFreeLiving = new javax.swing.JCheckBox();
        chkIncludeInternalNodes = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        chkFilterSeqsBySpeciesTaxIDs = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSpeciesTaxIDs = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        chkIncludeChildrenTaxIDs = new javax.swing.JCheckBox();
        chkFilterSeqsByHostTaxIDs = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHostTaxIDs = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtExportFilename = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel17.setText("Export options:");

        chkExportParasites.setText("Parasites");

        chkExportSymbionts.setText("Symbionts");

        chkExportHostAssociated.setText("Host-associated");

        chkExportFreeLiving.setText("Free-living");

        chkIncludeInternalNodes.setText("Include internal taxonomy nodes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(chkExportParasites)
                .addGap(18, 18, 18)
                .addComponent(chkExportSymbionts)
                .addGap(18, 18, 18)
                .addComponent(chkExportHostAssociated)
                .addGap(18, 18, 18)
                .addComponent(chkExportFreeLiving)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(chkIncludeInternalNodes)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(chkExportParasites)
                    .addComponent(chkExportSymbionts)
                    .addComponent(chkExportHostAssociated)
                    .addComponent(chkExportFreeLiving)
                    .addComponent(chkIncludeInternalNodes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Status:");

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        chkFilterSeqsBySpeciesTaxIDs.setFont(new java.awt.Font("Tahoma", 1, 11));
        chkFilterSeqsBySpeciesTaxIDs.setText("Filter sequences by species tax-IDs");
        chkFilterSeqsBySpeciesTaxIDs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFilterSeqsBySpeciesTaxIDsActionPerformed(evt);
            }
        });

        jLabel1.setText("Species tax-IDs:");

        txtSpeciesTaxIDs.setColumns(20);
        txtSpeciesTaxIDs.setRows(5);
        jScrollPane1.setViewportView(txtSpeciesTaxIDs);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addComponent(chkFilterSeqsBySpeciesTaxIDs))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkFilterSeqsBySpeciesTaxIDs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        chkIncludeChildrenTaxIDs.setText("Include children tax-IDs");

        chkFilterSeqsByHostTaxIDs.setFont(new java.awt.Font("Tahoma", 1, 11));
        chkFilterSeqsByHostTaxIDs.setText("Filter sequences by species tax-IDs");
        chkFilterSeqsByHostTaxIDs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFilterSeqsByHostTaxIDsActionPerformed(evt);
            }
        });

        jLabel2.setText("Host tax-IDs:");

        txtHostTaxIDs.setColumns(20);
        txtHostTaxIDs.setRows(5);
        jScrollPane2.setViewportView(txtHostTaxIDs);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkFilterSeqsByHostTaxIDs)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                        .addComponent(chkIncludeChildrenTaxIDs))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkFilterSeqsByHostTaxIDs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(chkIncludeChildrenTaxIDs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setText("Export");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel18.setText("Filename:");

        jButton1.setText("Browse...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtExportFilename, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel18)
                    .addComponent(txtExportFilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String s=frmMain.getfrmMain().getFilename("Output file:");
            if(s!=null){
                txtExportFilename.setText(s);
            }
        } catch (Exception e) {
            frmMain.getfrmMain().displayException(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            export();
        } catch (Exception e) {
            frmMain.getfrmMain().displayException(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void chkFilterSeqsBySpeciesTaxIDsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFilterSeqsBySpeciesTaxIDsActionPerformed
        if(chkFilterSeqsBySpeciesTaxIDs.isSelected()){
            chkFilterSeqsByHostTaxIDs.setSelected(false);
        }
    }//GEN-LAST:event_chkFilterSeqsBySpeciesTaxIDsActionPerformed

    private void chkFilterSeqsByHostTaxIDsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFilterSeqsByHostTaxIDsActionPerformed
        if(chkFilterSeqsByHostTaxIDs.isSelected()){
            chkFilterSeqsBySpeciesTaxIDs.setSelected(false);
        }
    }//GEN-LAST:event_chkFilterSeqsByHostTaxIDsActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(m_AsyncThread!=null){
            m_AsyncThread.stop();
            m_AsyncThread=null;
        }
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(frmExportSequences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmExportSequences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmExportSequences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmExportSequences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmExportSequences().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkExportFreeLiving;
    private javax.swing.JCheckBox chkExportHostAssociated;
    private javax.swing.JCheckBox chkExportParasites;
    private javax.swing.JCheckBox chkExportSymbionts;
    private javax.swing.JCheckBox chkFilterSeqsByHostTaxIDs;
    private javax.swing.JCheckBox chkFilterSeqsBySpeciesTaxIDs;
    private javax.swing.JCheckBox chkIncludeChildrenTaxIDs;
    private javax.swing.JCheckBox chkIncludeInternalNodes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtExportFilename;
    private javax.swing.JTextArea txtHostTaxIDs;
    private javax.swing.JTextArea txtSpeciesTaxIDs;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables

    private void export(){
        m_AsyncThread=new Thread(new AsynchExporter());
        m_AsyncThread.start();
    }

    private class AsynchExporter implements Runnable{
        public void run(){
            try{
                doExport();
                txtStatus.setText("Done!");
            }catch(Exception e){
                txtStatus.setText("Errors occured!");
                frmMain.getfrmMain().displayException(e);
            }
        }
        
        private void doExport()throws Exception{
            txtStatus.setText("Loading species...");
            ArrayList<SpeciesCollection> exportSpecies=new ArrayList<SpeciesCollection>();
            SpeciesCollection species=new SpeciesCollection();
            exportSpecies.add(species);
            if(chkExportFreeLiving.isSelected()){
                species.load("%", false, null, null, null, Species.ParasiteType.NoParasite, true, frmMain.getfrmMain().getDBConnection());
            }
            species=new SpeciesCollection();
            exportSpecies.add(species);
            if(chkExportHostAssociated.isSelected()){
                species.load("%", false, null, null, null, Species.ParasiteType.HostAssociated, true, frmMain.getfrmMain().getDBConnection());
            }
            species=new SpeciesCollection();
            exportSpecies.add(species);
            if(chkExportParasites.isSelected()){
                species.load("%", false, null, null, null, Species.ParasiteType.Parasite, true, frmMain.getfrmMain().getDBConnection());
            }
            species=new SpeciesCollection();
            exportSpecies.add(species);
            if(chkExportSymbionts.isSelected()){
                species.load("%", false, null, null, null, Species.ParasiteType.Symbiant, true, frmMain.getfrmMain().getDBConnection());
            }
            txtStatus.setText("Loading filtering tax-IDs...");
            HashMap<Integer, String> validTaxIDs=null;
            if(chkFilterSeqsBySpeciesTaxIDs.isSelected()){
                validTaxIDs=getValidSpeciesTaxIDs();
            }
            if(chkFilterSeqsByHostTaxIDs.isSelected()){
                validTaxIDs=getValidHostTaxIDs();
            }
            txtStatus.setText("Exporting...");

            Iterator <SpeciesCollection> iter=exportSpecies.iterator();
            ArrayList<Integer> taxIDs=new ArrayList<Integer>();
            while(iter.hasNext()){
                SpeciesCollection thisSpecies=iter.next();
                Iterator<Integer>iterSpecies=thisSpecies.keySet().iterator();
                while(iterSpecies.hasNext()){
                    Integer key=iterSpecies.next();
                    Species sp=thisSpecies.get(key);                
                    if(isValidTaxID(sp, validTaxIDs)){
                        taxIDs.add(sp.getTaxID());
                        //sp.writeTaxIDAndSpeciesNames(bw);
                    }
                }
            }
            txtStatus.setText("Writing file...");
            BufferedWriter bw=new BufferedWriter(new FileWriter(txtExportFilename.getText()));
            writeFile(taxIDs, bw);            
            bw.flush();
            bw.close();
        }
        
        private void writeFile(ArrayList<Integer> taxIDs, BufferedWriter bw) throws Exception{
            if(chkIncludeInternalNodes.isSelected()){
                SelectedInternalList internalNodes=createInternalNodes(taxIDs);
                Iterator<Integer> iter=internalNodes.getAllNodes().keySet().iterator();
                while(iter.hasNext()){
                    Integer taxID=iter.next();
                    writeTaxIDandTaxName(bw, taxID);
                }
            }else{
                Iterator<Integer> iter=taxIDs.iterator();
                while(iter.hasNext()){
                    Integer taxID=iter.next();
                    writeTaxIDandTaxName(bw, taxID);
                }
            }
        }
        
        private SelectedInternalList createInternalNodes(ArrayList<Integer> speciesTaxIDs) throws Exception{
            SelectedInternalList internalNodes=new SelectedInternalList();
            internalNodes.init(speciesTaxIDs, frmMain.getfrmMain().getTaxNodes());
            while(internalNodes.processCurrentStage()){ }
            return internalNodes;
        }

        private void writeTaxIDandTaxName(BufferedWriter bw, int taxID) throws Exception{
            String name=frmMain.getfrmMain().getTaxNodes().getName(taxID);
            bw.write(String.valueOf(taxID));
            bw.write("\t");
            bw.write(name);
            bw.newLine();
        }

        private boolean isValidTaxID(Species sp, HashMap<Integer, String> validTaxIDs)throws Exception{
            if(validTaxIDs==null){
                return true;
            }else{
                if(chkFilterSeqsBySpeciesTaxIDs.isSelected()){
                    String tmp=validTaxIDs.get(sp.getTaxID());
                    if(tmp==null){
                        return false;
                    }else{
                        return true;
                    }
                }
                if(chkFilterSeqsByHostTaxIDs.isSelected()){
                    sp.getHosts().loadForParasite(frmMain.getfrmMain().getDBConnection());
                    Iterator<Host> iter=sp.getHosts().iterator();
                    while(iter.hasNext()){
                        Host h=iter.next();
                        String tmp=validTaxIDs.get(h.getTaxID());
                        if(tmp!=null){
                            return true;
                        }   
                    }
                    return false;
                }
            }
            return false;
        }

        private HashMap<Integer, String> getValidSpeciesTaxIDs()throws Exception{
            TaxNodesWrapper taxonomy=frmMain.getfrmMain().getTaxNodes();
            HashMap<Integer, String> taxIDs= new HashMap<Integer, String>();
            String [] taxID_S=txtSpeciesTaxIDs.getText().split("\\r?\\n");
            for(String s: taxID_S){ 
                Integer taxID=Integer.parseInt(s);
                taxIDs.put(taxID, taxonomy.getName(taxID));
            }
            return taxIDs;
        }

        private HashMap<Integer, String> getValidHostTaxIDs()throws Exception{
            TaxNodesWrapper taxonomy=frmMain.getfrmMain().getTaxNodes();
            HashMap<Integer, String> taxIDs= new HashMap<Integer, String>();
            String [] taxID_S=txtHostTaxIDs.getText().split("\\r?\\n");
            for(String s: taxID_S){
                Integer taxID=Integer.parseInt(s);
                taxIDs.put(taxID, taxonomy.getName(taxID));
                if(chkIncludeChildrenTaxIDs.isSelected()){
                    ArrayList<Integer> childrenTaxIDs=taxonomy.getChildrenRecursive(taxID);
                    Iterator<Integer> iter=childrenTaxIDs.iterator();
                    while(iter.hasNext()){
                        Integer childTaxID=iter.next();
                        String tmp=taxIDs.get(childTaxID);
                        if(tmp==null){
                            taxIDs.put(childTaxID, taxonomy.getName(childTaxID));
                        }
                    }
                }
            }
            return taxIDs;
        }
               
        
    }
    
    private class SelectedInternalList{
        private HashMap<Integer, Integer> m_AllNodes=null;
        private ArrayList<ArrayList<Integer>> m_ProcessedNodesList=null;
        private ArrayList<Integer> m_NewStageNodes=null;
        private TaxNodesWrapper m_Taxnomy=null;
        
        public HashMap<Integer, Integer> getAllNodes(){
            return m_AllNodes;
        }
        
        private void init(ArrayList<Integer> speciesTaxIDs, TaxNodesWrapper tnw){
            m_Taxnomy=tnw;
            m_AllNodes=new HashMap<Integer, Integer>();
            ArrayList<Integer> currentStage=new ArrayList<Integer>();
            Iterator<Integer> iter=speciesTaxIDs.iterator();
            while(iter.hasNext()){
                Integer taxID=iter.next();
                m_AllNodes.put(taxID, taxID);
                currentStage.add(taxID);
            }
            m_ProcessedNodesList=new ArrayList<ArrayList<Integer>>();
            m_ProcessedNodesList.add(currentStage);
            
        }
        
        private boolean  processCurrentStage(){
            int tmp=1408153;
            Iterator<Integer> iter= getCurrentStageNodes().iterator();
            while(iter.hasNext()){
                Integer taxID=iter.next();
                if(taxID==tmp){
                    String asd="";
                }
                int parentTaxID=m_Taxnomy.getParentID(taxID);
                if(allChildrenAreSelected(parentTaxID)){
                    if(!NodeIsSelected(parentTaxID)){
                        addNewStageNode(parentTaxID);
                    }
                }
            }
            if(m_NewStageNodes==null){
                return false;
            }
            if (m_NewStageNodes.isEmpty()){
                return false;
            }else{
                addNewStageNodes();
                return true;
            }
        }
        
        private boolean allChildrenAreSelected(int taxID){
            ArrayList<Integer> children=m_Taxnomy.getChildren(taxID);
            Iterator<Integer> iter= children.iterator();
            while(iter.hasNext()){
                Integer childTaxID=iter.next();
                if(!NodeIsSelected(childTaxID)){
                    return false;
                }
            }
            return true;
        }
        
        private boolean NodeIsSelected(Integer taxID){
            Integer tmp=m_AllNodes.get(taxID);
            if(tmp==null){
                if(m_NewStageNodes==null){
                    return false;
                }else{
                    if(m_NewStageNodes.contains(taxID)){
                        return true;
                    }else{
                        return false;
                    }
                }
            }else{
                return true;
            }
        }
        
        public ArrayList<Integer> getCurrentStageNodes(){
            return m_ProcessedNodesList.get(m_ProcessedNodesList.size()-1);
        }
        public void addNewStageNode(int taxID){
            if(m_NewStageNodes==null){
                m_NewStageNodes=new ArrayList<Integer>();
            }
            m_NewStageNodes.add(taxID);
        }
        public void addNewStageNodes(){
            Iterator<Integer> iter=m_NewStageNodes.iterator();
            while(iter.hasNext()){
                Integer taxID=iter.next();
                Integer tmp=m_AllNodes.get(taxID);
                if(tmp==null){
                    m_AllNodes.put(taxID, taxID);
                }
            }
            m_ProcessedNodesList.add(m_NewStageNodes);
            m_NewStageNodes=null;
        }
        
    }
}




