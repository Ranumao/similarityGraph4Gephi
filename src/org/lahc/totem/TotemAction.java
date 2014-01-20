/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lahc.totem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import org.gephi.data.attributes.api.AttributeController;
import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.graph.api.GraphController;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.awt.ActionRegistration;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionID;
import org.openide.util.NbBundle.Messages;

import org.gephi.graph.api.GraphModel;
import org.openide.util.Lookup;

@ActionID(category = "Edit",
id = "org.lahc.totem.TotemAction")
@ActionRegistration(displayName = "#CTL_TotemAction")
@ActionReferences({
    @ActionReference(path = "Menu/Plugins", position = 3333)
})
@Messages("CTL_TotemAction=Similarity graph generator")
public final class TotemAction implements ActionListener {

    Totem tot;
    DialogDescriptor dd;
    MyMetricUI a;
    
    public void actionPerformed(ActionEvent e) {
        tot = new Totem(); //a.createTotem();
        a = new MyMetricUI(tot, true, this);
        System.out.println("abcd");
        
        
        System.out.println(tot.threshold);
        System.out.println(tot.simClass);
        System.out.println("abcde");
        dd = new DialogDescriptor(a.getSettingsPanel(), "Similarity graph generator", false, new TotemPanelListener(this));
        Object obj = DialogDisplayer.getDefault().notify(dd);
        a.setup(tot);
        System.out.println("abc");
        //a.unsetup();
        System.out.println(tot.threshold);
        System.out.println(tot.simClass);
    }
    
    public void theCallback(){
        a.unsetup();
        
        System.out.println("regardons");
        System.out.println(tot.simClass);
        
        GraphModel graphModel = Lookup.getDefault().lookup(GraphController.class).getModel();
        AttributeModel attribModel = Lookup.getDefault().lookup(AttributeController.class).getModel();
        tot.execute(graphModel, attribModel);
        
        //System.err.println("FINI");
        //DialogDisplayer.getDefault().notify(dd);
    }
    
    
}
