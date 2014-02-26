/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpediatre;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Killer
 */
public class RowRenderer extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable jt, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp = super.getTableCellRendererComponent(jt, value, isSelected, hasFocus, row, column);
        if(jt.getValueAt(row, 4).equals("Acceptée")){
            comp.setBackground(new Color(170, 237, 170));
            comp.setForeground(Color.BLACK);
            if(isSelected){
                comp.setBackground(new Color(20, 190, 40));
                comp.setFont(comp.getFont().deriveFont(Font.BOLD));
                comp.setForeground(Color.WHITE);
            }
        }
        if(jt.getValueAt(row, 4).equals("Refusée")){
            comp.setBackground(new Color(237, 150, 150));
            comp.setForeground(Color.BLACK);
            if(isSelected){
                comp.setBackground(new Color(237, 50, 70));
                comp.setFont(comp.getFont().deriveFont(Font.BOLD));
                comp.setForeground(Color.WHITE);
            }
        }
        if(jt.getValueAt(row, 4).equals("Non traitée")){
            comp.setBackground(Color.getHSBColor(0f, 0f, 1f));
            comp.setForeground(Color.BLACK);
            if(isSelected){
                comp.setBackground(new Color(51, 153, 255));
                comp.setFont(comp.getFont().deriveFont(Font.BOLD));
                comp.setForeground(Color.WHITE);
            }
        }
        return comp;
    }
}
