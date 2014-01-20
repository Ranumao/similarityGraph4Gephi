/*
 * GPL v3
 */

package org.lahc.totem;

import java.util.Vector;
import javax.swing.JList;
import javax.swing.JPanel;
import org.gephi.statistics.spi.Statistics;
import org.gephi.statistics.spi.StatisticsUI;
import org.openide.util.Exceptions;
import org.openide.util.lookup.ServiceProvider;
import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeController;
import org.gephi.data.attributes.api.AttributeModel;
/**
 *
 * See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Create_StatisticsUI
 * 
 * @author David Combe <david.combe@gmail.com>
 */
@ServiceProvider(service = StatisticsUI.class)
public class MyMetricUI implements StatisticsUI {

    private TotemPanel panel;
    private Totem myMetric;
    private boolean calledWithMenu;
    private TotemAction ta;
    public MyMetricUI(){
        
    }
    
    MyMetricUI(Totem myMetric, boolean calledWithMenu, TotemAction ta){
        this.myMetric=myMetric;
        this.calledWithMenu=calledWithMenu;
        this.ta=ta;
    }
    
    @Override
    public JPanel getSettingsPanel() {
        panel = new TotemPanel();
        return panel; //null if no panel exists
    }

    
    
    
    @Override
    public void setup(Statistics statistics) {
        this.myMetric = (Totem) statistics;
        if (panel != null) {
            //panel.setDirected(myMetric.isDirected()); //Remove it if not useful
            panel.setTextAttribute(myMetric.columnText);
            
            //try {
                //Package sm = Package.getPackage("uk.ac.shef.wit.simmetrics.similaritymetrics");
                //Class cl = Class.forName("uk.ac.shef.wit.simmetrics.similaritymetrics");
                
                
                /*Vector<String> names=new Vector<String>();
                for(Class c:sm.getClasses()){
                    names.add(c.getName());
                }*/
                
                //JList chooseMet=new JList(namesPackage);
                //panel.setChooseMetric(chooseMet);
            /*} catch (ClassNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }*/
        }
    }

    @Override
    public void unsetup() {
        if (panel != null) {
            //myMetric.setDirected(panel.isDirected()); //Remove it if not useful
            myMetric.setColumnText((String)panel.getattributesList().getSelectedValue());
            myMetric.simClass=(String)panel.getChooseMetric().getSelectedValue();
            myMetric.debug=panel.getDebugCheckBox().isSelected();
            myMetric.threshold=Float.parseFloat(panel.getThresholdField().getText());
            myMetric.weighted=panel.getWeightedCheckBox().isSelected();
            System.out.println("unsetup ok");
            System.out.println(myMetric);
        }
        
        //((MyMetricUI) ((JPanel) panels[0]).getComponent()).unsetup((Totem)importer);
        
        panel = null;
        
        //ta.theCallback();
    }
    
    
    /*public Totem parameterizeTotem(){
        return new Totem(
                ((String)panel.getattributesList().getSelectedValue())
                
                
                
            ,(String)panel.getChooseMetric().getSelectedValue()
            
            //,panel
                ,panel.getWeightedCheckBox().isSelected()
                            ,Float.parseFloat(panel.getThresholdField().getText())

                ,panel.getDebugCheckBox().isSelected());
                
       
    }*/
    
    
    

    @Override
    public Class<? extends Statistics> getStatisticsClass() {
        return Totem.class;
    }

    @Override
    public String getValue() {
        //Returns the result value on the front-end. 
        //If your metric doesn't have a single result value, return null.
        return null;
    }

    @Override
    public String getDisplayName() {
        return "ToTeM";
    }

    @Override
    public String getCategory() {
        //The category is just where you want your metric to be displayed: NODE, EDGE or NETWORK.
        //Choose between:
        //- StatisticsUI.CATEGORY_NODE_OVERVIEW
        //- StatisticsUI.CATEGORY_EDGE_OVERVIEW
        //- StatisticsUI.CATEGORY_NETWORK_OVERVIEW
        return StatisticsUI.CATEGORY_NETWORK_OVERVIEW;
    }

    @Override
    public int getPosition() {
        //The position control the order the metric front-end are displayed. 
        //Returns a value between 1 and 1000, that indicates the position. 
        //Less means upper.
        return 800;
    }

    @Override
    public String getShortDescription() {
        return new String("Not supported yet.");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
