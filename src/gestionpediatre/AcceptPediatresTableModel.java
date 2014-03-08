/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpediatre;

import dao.PediatreDAO;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import entities.Pediatre;
import java.util.List;

/**
 *
 * @author Killer
 */
public class AcceptPediatresTableModel extends AbstractTableModel{
    JTable jt;
    List<Pediatre> inacceptedPediatres;
    Object[][] pediatresMatrix;
    
    public AcceptPediatresTableModel(JTable jt){
        jt.setSelectionModel(new ForcedListSelectionModel());
        jt.setDefaultRenderer(String.class, new RowRenderer());
        inacceptedPediatres = PediatreDAO.displayAllInacceptedPediatres();
        pediatresMatrix = new Object[inacceptedPediatres.size()][5];
        fillMatrix();
    }

    public List<Pediatre> getInacceptedPediatres() {
        return inacceptedPediatres;
    }

    public void setInacceptedPediatres(List<Pediatre> inacceptedPediatres) {
        this.inacceptedPediatres = inacceptedPediatres;
    }
        
    final String columnNames[] = {
        "Login",
        "Nom",
        "Prénom",
        "Email",
        "Etat de la demande",
    };
    
    final Class<?> columnClass[] = {
        String.class,
        String.class,
        String.class,
        String.class,
        String.class,
    };
    public int getRowCount() {
        return inacceptedPediatres.size();
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        return pediatresMatrix[rowIndex][columnIndex];
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex){
        pediatresMatrix[rowIndex][columnIndex] = value;
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public Pediatre getPediatre(String login){
        for(Pediatre pediatre : inacceptedPediatres){
            if (pediatre.getLogin().equalsIgnoreCase(login)){
                return pediatre;
            }
        }
        return null;
    }
    
    private void fillMatrix(){
        for(int i=0; i<inacceptedPediatres.size(); i++){
            pediatresMatrix[i][0] = inacceptedPediatres.get(i).getLogin();
            pediatresMatrix[i][1] = inacceptedPediatres.get(i).getNom();
            pediatresMatrix[i][2] = inacceptedPediatres.get(i).getPrenom();
            pediatresMatrix[i][3] = inacceptedPediatres.get(i).getEmail();
            pediatresMatrix[i][4] = "Non traitée";
        }
    }
    
    public int countAccepted(){
        int count = 0;
        for(int i=0; i<pediatresMatrix.length; i++){
            if(pediatresMatrix[i][4].equals("Acceptée"))
                count ++;
        }
        return count;
    }
    
    public int countRefused(){
        int count = 0;
        for(int i=0; i<pediatresMatrix.length; i++){
            if(pediatresMatrix[i][4].equals("Refusée"))
                count ++;
        }
        return count;
    }
}