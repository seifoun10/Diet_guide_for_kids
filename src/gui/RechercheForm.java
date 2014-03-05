/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import dao.UserDAO;
import java.awt.Image;
import static javax.management.Query.and;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.UIManager;

/**
 *
 * @author tictacf12
 */
public class RechercheForm extends javax.swing.JFrame {

    /**
     * Creates new form RechercheForm
     */
    Boolean sexe=null;
    String type="Admin Forum Parent Pediatre ";
    public RechercheForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexeBG = new javax.swing.ButtonGroup();
        typeBG = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        loginTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        rechercheT = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nomTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        prenomTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateInscriptionDP = new org.jdesktop.swingx.JXDatePicker();
        dateNaissanceDP = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nationnaliteTF = new javax.swing.JTextField();
        femmeRB = new javax.swing.JRadioButton();
        hommeRB = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        tousRB = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        adminCB = new javax.swing.JCheckBox();
        forumCB = new javax.swing.JCheckBox();
        parentCB = new javax.swing.JCheckBox();
        pediatreCB = new javax.swing.JCheckBox();
        viderChampsB = new javax.swing.JButton();
        consulterB = new javax.swing.JButton();
        supprimerB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Login");

        loginTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginTFActionPerformed(evt);
            }
        });
        loginTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginTFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                loginTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                loginTFKeyTyped(evt);
            }
        });

        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
        rechercheT.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(rechercheT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nom");

        nomTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomTFKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Prenom");

        prenomTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prenomTFKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("E-mail");

        emailTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailTFKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Date d'inscription");

        dateInscriptionDP.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateInscriptionDPPropertyChange(evt);
            }
        });

        dateNaissanceDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateNaissanceDPActionPerformed(evt);
            }
        });
        dateNaissanceDP.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateNaissanceDPPropertyChange(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Date de Naissance");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nationnalité");

        nationnaliteTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nationnaliteTFKeyReleased(evt);
            }
        });

        sexeBG.add(femmeRB);
        femmeRB.setText("Femme");
        femmeRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femmeRBActionPerformed(evt);
            }
        });

        sexeBG.add(hommeRB);
        hommeRB.setText("Homme");
        hommeRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hommeRBActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Sexe");

        sexeBG.add(tousRB);
        tousRB.setSelected(true);
        tousRB.setText("Tous");
        tousRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tousRBActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Type");

        adminCB.setSelected(true);
        adminCB.setText("Administrateur");
        adminCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminCBActionPerformed(evt);
            }
        });

        forumCB.setSelected(true);
        forumCB.setText("Administrateur forum");
        forumCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forumCBActionPerformed(evt);
            }
        });

        parentCB.setSelected(true);
        parentCB.setText("Parent");
        parentCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parentCBActionPerformed(evt);
            }
        });

        pediatreCB.setSelected(true);
        pediatreCB.setText("Pédiatre");
        pediatreCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pediatreCBActionPerformed(evt);
            }
        });

        viderChampsB.setText("Vider les champs");
        viderChampsB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viderChampsBActionPerformed(evt);
            }
        });

        consulterB.setText("Consulter le profil");
        consulterB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consulterBActionPerformed(evt);
            }
        });

        supprimerB.setText("Supprimer le profil");
        supprimerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viderChampsB)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5))
                            .addGap(4, 4, 4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pediatreCB)
                                .addComponent(parentCB)
                                .addComponent(forumCB)
                                .addComponent(adminCB)
                                .addComponent(nomTF)
                                .addComponent(prenomTF)
                                .addComponent(emailTF)
                                .addComponent(dateInscriptionDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(hommeRB)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(femmeRB)
                                    .addGap(2, 2, 2)
                                    .addComponent(tousRB))
                                .addComponent(dateNaissanceDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nationnaliteTF)
                                .addComponent(loginTF)))
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel9)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(supprimerB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consulterB)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(adminCB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forumCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parentCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pediatreCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(loginTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(prenomTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(hommeRB)
                            .addComponent(femmeRB)
                            .addComponent(tousRB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateNaissanceDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateInscriptionDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nationnaliteTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consulterB)
                    .addComponent(supprimerB)
                    .addComponent(viderChampsB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginTFActionPerformed

    private void loginTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginTFKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_loginTFKeyTyped

    private void loginTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginTFKeyPressed
        // TODO add your handling code here: 
        
    }//GEN-LAST:event_loginTFKeyPressed

    private void loginTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginTFKeyReleased
        // TODO add your handling code here:
        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_loginTFKeyReleased

    private void nomTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomTFKeyReleased
        // TODO add your handling code here:
         rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_nomTFKeyReleased

    private void prenomTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prenomTFKeyReleased
        // TODO add your handling code here:
         rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_prenomTFKeyReleased

    private void emailTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTFKeyReleased
        // TODO add your handling code here:
        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_emailTFKeyReleased

    private void nationnaliteTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nationnaliteTFKeyReleased
        // TODO add your handling code here:
       rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_nationnaliteTFKeyReleased

    private void dateInscriptionDPPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateInscriptionDPPropertyChange
        // TODO add your handling code here:
        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_dateInscriptionDPPropertyChange

    private void dateNaissanceDPPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateNaissanceDPPropertyChange
        // TODO add your handling code here:
        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_dateNaissanceDPPropertyChange

    private void femmeRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femmeRBActionPerformed
        // TODO add your handling code here:
        sexe= new Boolean(false);
        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_femmeRBActionPerformed

    private void hommeRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hommeRBActionPerformed
        // TODO add your handling code here:
        sexe= new Boolean(true);
        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_hommeRBActionPerformed

    private void tousRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tousRBActionPerformed
        // TODO add your handling code here:
        sexe= null;
        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_tousRBActionPerformed

    private void adminCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminCBActionPerformed
        // TODO add your handling code here:
        if(adminCB.isSelected()) type += "Admin ";
        else type = type.replace("Admin ", "");
        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_adminCBActionPerformed

    private void forumCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forumCBActionPerformed
        // TODO add your handling code here:
        if(forumCB.isSelected()) type += "Forum ";
        else type = type.replace("Forum ", "");
        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_forumCBActionPerformed

    private void parentCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parentCBActionPerformed
        // TODO add your handling code here:
        if(parentCB.isSelected()) type += "Parent ";
        else type = type.replace("Parent ", "");
        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_parentCBActionPerformed

    private void pediatreCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pediatreCBActionPerformed
        // TODO add your handling code here:
        if(pediatreCB.isSelected()) type += "Pediatre ";
        else type = type.replace("Pediatre ", "");
        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_pediatreCBActionPerformed

    private void viderChampsBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viderChampsBActionPerformed
        // TODO add your handling code here:
        loginTF.setText("");
        nomTF.setText("");
        prenomTF.setText("");
        dateInscriptionDP.setDate(null);
        dateNaissanceDP.setDate(null);
        emailTF.setText("");
        nationnaliteTF.setText("");
        rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
    }//GEN-LAST:event_viderChampsBActionPerformed

    private void dateNaissanceDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateNaissanceDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateNaissanceDPActionPerformed

    private void supprimerBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerBActionPerformed
        if(rechercheT.getSelectedRow()!=-1){
            String login= (String)rechercheT.getValueAt(rechercheT.getSelectedRow(), 0);
            if (JOptionPane.showConfirmDialog(null,"Êtes-vous sur de vouloir supprimer l'utilisateur "+login+" ?","Confirmation de suppression.",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE )==JOptionPane.YES_OPTION) {
                new UserDAO().deleteUser(login);
                rechercheT.setModel(new MyTableModel(loginTF.getText(), nomTF.getText(),prenomTF.getText(),emailTF.getText(),nationnaliteTF.getText(),dateInscriptionDP.getDate(),dateNaissanceDP.getDate(),sexe,type.split(" ")));
            }
        }
    
    }//GEN-LAST:event_supprimerBActionPerformed

    private void consulterBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consulterBActionPerformed
        // TODO add your handling code here:
        JFrame pf = new ParentForm((String) rechercheT.getValueAt(rechercheT.getSelectedRow(), 0));
        pf.setVisible(true);
    }//GEN-LAST:event_consulterBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        String system_lf = UIManager.getSystemLookAndFeelClassName().toLowerCase();
        if(system_lf.contains("metal")){
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                }catch (Exception e) {}
        }else{
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch (Exception e) {}
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RechercheForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox adminCB;
    private javax.swing.JButton consulterB;
    private org.jdesktop.swingx.JXDatePicker dateInscriptionDP;
    private org.jdesktop.swingx.JXDatePicker dateNaissanceDP;
    private javax.swing.JTextField emailTF;
    private javax.swing.JRadioButton femmeRB;
    private javax.swing.JCheckBox forumCB;
    private javax.swing.JRadioButton hommeRB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField loginTF;
    private javax.swing.JTextField nationnaliteTF;
    private javax.swing.JTextField nomTF;
    private javax.swing.JCheckBox parentCB;
    private javax.swing.JCheckBox pediatreCB;
    private javax.swing.JTextField prenomTF;
    private javax.swing.JTable rechercheT;
    private javax.swing.ButtonGroup sexeBG;
    private javax.swing.JButton supprimerB;
    private javax.swing.JRadioButton tousRB;
    private javax.swing.ButtonGroup typeBG;
    private javax.swing.JButton viderChampsB;
    // End of variables declaration//GEN-END:variables
}
