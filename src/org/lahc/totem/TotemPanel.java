/*
 * GPL v3
 *
 * If you don't need it, remove this file and edit MyMetricUI accordingly.
 */

package org.lahc.totem;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTextField;
import org.gephi.graph.api.Graph;
import org.gephi.graph.api.GraphModel;
import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeController;
import org.gephi.data.attributes.api.AttributeModel;
import org.openide.util.Lookup;
/**
 *
 * See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Create_StatisticsUI
 * @author David Combe <David.Combe@gmail.com>
 */
public class TotemPanel extends javax.swing.JPanel {
    private String ta;
    String col;
    Graph graph;
        
    /** Creates new form TotemPanel */
    public TotemPanel() {
        initComponents();
    }

    /** Add here setters and getters for all properties users can edit. */


    
    /** Only useful if the algorithm takes graph type into account. */
    
    /*public boolean isDirected() {
        return 
        
        return directedRadioButton.isSelected();
        
    }*/

    /*public void setDirected(boolean directed) {
        directedButtonGroup.setSelected(directed ? directedRadioButton.getModel() : undirectedRadioButton.getModel(), true);
    }*/
    
    public void setTextAttribute(String ta){
        this.ta=ta;
    }
    
    public String getTextAttribute(){
        return this.ta;
    }

    /** ----------------------------------------------------------- */

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        directedButtonGroup = new javax.swing.ButtonGroup();
        header = new org.jdesktop.swingx.JXHeader();
        jLabel1 = new javax.swing.JLabel();
        thresholdField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        attributesList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        chooseMetric = new javax.swing.JList();
        weightedCheckBox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        debugCheckBox = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(456, 375));

        header.setDescription(org.openide.util.NbBundle.getMessage(TotemPanel.class, "TotemPanel.header.description")); // NOI18N
        header.setTitle(org.openide.util.NbBundle.getMessage(TotemPanel.class, "TotemPanel.header.title")); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(TotemPanel.class, "TotemPanel.jLabel1.text")); // NOI18N

        thresholdField.setText(org.openide.util.NbBundle.getMessage(TotemPanel.class, "TotemPanel.thresholdField.text")); // NOI18N
        thresholdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thresholdFieldActionPerformed(evt);
            }
        });

        attributesList.setModel(new AttributesList());
        jScrollPane1.setViewportView(attributesList);

        chooseMetric.setModel(new SimList());
        jScrollPane2.setViewportView(chooseMetric);

        weightedCheckBox.setText(org.openide.util.NbBundle.getMessage(TotemPanel.class, "TotemPanel.weightedCheckBox.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(TotemPanel.class, "TotemPanel.jLabel2.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(TotemPanel.class, "TotemPanel.jLabel3.text")); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(TotemPanel.class, "TotemPanel.jLabel4.text")); // NOI18N

        debugCheckBox.setText(org.openide.util.NbBundle.getMessage(TotemPanel.class, "TotemPanel.debugCheckBox.text")); // NOI18N
        debugCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weightedCheckBox)
                            .addComponent(debugCheckBox)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(36, 36, 36)
                                .addComponent(thresholdField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(thresholdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(weightedCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(debugCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void thresholdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thresholdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thresholdFieldActionPerformed

    private void debugCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugCheckBoxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_debugCheckBoxActionPerformed

    public JList getattributesList() {
        return attributesList;
    }

    public void setattributesList1(JList attributesList) {
        this.attributesList = attributesList;
    }


    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList attributesList;
    private javax.swing.JList chooseMetric;
    private javax.swing.JCheckBox debugCheckBox;
    private javax.swing.ButtonGroup directedButtonGroup;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField thresholdField;
    private javax.swing.JCheckBox weightedCheckBox;
    // End of variables declaration//GEN-END:variables

    public JCheckBox getWeightedCheckBox() {
        return weightedCheckBox;
    }

    public JTextField getThresholdField() {
        return thresholdField;
    }

    public JCheckBox getDebugCheckBox() {
        return debugCheckBox;
    }

    public JList getChooseMetric() {
        return chooseMetric;
    }

    public void setChooseMetric(JList chooseMetric) {
        this.chooseMetric = chooseMetric;
    }

}
