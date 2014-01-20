/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.lahc.totem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ranu
 */
public class TotemPanelListener implements ActionListener {

    TotemAction ta;

    public TotemPanelListener(TotemAction ta) {
        this.ta = ta;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("XXXXYYYX");
        System.out.println(ae.getActionCommand());
        System.out.println("XXXXYYYX");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        if(ae.getActionCommand().equals("OK"))
            ta.theCallback();
        
    }
    
    
    
    
}
