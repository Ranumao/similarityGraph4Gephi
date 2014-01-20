/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.lahc.totem;

import java.util.Vector;
import javax.swing.AbstractListModel;
import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeController;
import org.gephi.data.attributes.api.AttributeModel;
import org.openide.util.Lookup;

/**
 *
 * @author David
 */
public class AttributesList  extends AbstractListModel{
    
String[] strings;

    public AttributesList() {
        
        //attributesList = new javax.swing.JList();
        //List node columns
        AttributeController ac = Lookup.getDefault().lookup(AttributeController.class);
        AttributeModel model = ac.getModel();
        Vector<String> vec=new Vector<String>();


        model.getNodeTable().getColumns();



        for (AttributeColumn col : model.getNodeTable().getColumns()) {
            vec.add(col.getTitle());
        }
        strings=new String[vec.size()];
        vec.toArray(strings);
    }
    
    public int getSize() { return strings.length; }
    public Object getElementAt(int i) { return strings[i];}
}
