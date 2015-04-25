/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ralfne
 */
public class ValidationComboBoxModel extends AbstractListModel implements ComboBoxModel { 
    Object selection = null;
    public Object getElementAt(int index) {
        return frmMain.getfrmMain().getValidations().getForIndex(index);
    }
    public int getSize() {
        return frmMain.getfrmMain().getValidations().size();
    }
    public void setSelectedItem(Object anItem) {
        selection = anItem; // to select and register an
    } // item from the pull-down list
    // Methods implemented from the interface ComboBoxModel
    public Object getSelectedItem() {
        return selection; // to add the selection to the combo box
    }
}
