/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lahc.totem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionRegistration;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionID;
import org.openide.util.NbBundle.Messages;

@ActionID(category = "Edit",
id = "org.lahc.totem.SimilarityGraphAction")
@ActionRegistration(displayName = "#CTL_SimilarityGraphAction")
@ActionReferences({
    @ActionReference(path = "Menu/Plugins", position = 3333)
})
@Messages("CTL_SimilarityGraphAction=Similarity graph from an attribute")
public final class SimilarityGraphAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
