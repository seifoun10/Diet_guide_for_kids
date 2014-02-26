/*
 * GestionPediatreView.java
 */

package gestionpediatre;

import DAO.DAOPediatre;
import Entities.Pediatre;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 * The application's main frame.
 */
public class GestionPediatreView extends FrameView{
    PediatresEnAttenteTableModel pediatresTM;
    SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
    public GestionPediatreView(SingleFrameApplication app){
        super(app);
        getFrame().setResizable(false);
        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e){
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = GestionPediatreApp.getApplication().getMainFrame();
            aboutBox = new GestionPediatreAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        GestionPediatreApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        accepterButton = new javax.swing.JButton();
        refuserButton = new javax.swing.JButton();
        selectionnePanel = new javax.swing.JPanel();
        jLabelPse = new javax.swing.JLabel();
        jLabelNom = new javax.swing.JLabel();
        jLabelPre = new javax.swing.JLabel();
        jLabelEma = new javax.swing.JLabel();
        jLabelDat = new javax.swing.JLabel();
        jLabelNat = new javax.swing.JLabel();
        jLabelSex = new javax.swing.JLabel();
        dateNaissanceLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        nomLabel = new javax.swing.JLabel();
        prenomLabel = new javax.swing.JLabel();
        nationaliteLabel = new javax.swing.JLabel();
        sexeLabel = new javax.swing.JLabel();
        validerButton = new javax.swing.JButton();
        contactButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listePediatresTable = new javax.swing.JTable();
        statesCount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        docsButton = new javax.swing.JButton();
        reinitializeButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        validateOptionPane = new javax.swing.JOptionPane();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(gestionpediatre.GestionPediatreApp.class).getContext().getResourceMap(GestionPediatreView.class);
        mainPanel.setBackground(resourceMap.getColor("mainPanel.background")); // NOI18N
        mainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainPanel.setMaximumSize(new java.awt.Dimension(950, 320));
        mainPanel.setMinimumSize(new java.awt.Dimension(950, 320));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(960, 310));

        accepterButton.setText(resourceMap.getString("accepterButton.text")); // NOI18N
        accepterButton.setToolTipText(resourceMap.getString("accepterButton.toolTipText")); // NOI18N
        accepterButton.setEnabled(false);
        accepterButton.setName("accepterButton"); // NOI18N
        accepterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptOnClick(evt);
            }
        });

        refuserButton.setText(resourceMap.getString("refuserButton.text")); // NOI18N
        refuserButton.setToolTipText(resourceMap.getString("refuserButton.toolTipText")); // NOI18N
        refuserButton.setEnabled(false);
        refuserButton.setName("refuserButton"); // NOI18N
        refuserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refuseOnClick(evt);
            }
        });

        selectionnePanel.setBackground(resourceMap.getColor("selectionnePanel.background")); // NOI18N
        selectionnePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("selectionnePanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("selectionnePanel.border.titleColor"))); // NOI18N
        selectionnePanel.setEnabled(false);
        selectionnePanel.setName("selectionnePanel"); // NOI18N

        jLabelPse.setFont(resourceMap.getFont("jLabelPse.font")); // NOI18N
        jLabelPse.setText(resourceMap.getString("jLabelPse.text")); // NOI18N
        jLabelPse.setEnabled(false);
        jLabelPse.setName("jLabelPse"); // NOI18N

        jLabelNom.setFont(resourceMap.getFont("jLabelNom.font")); // NOI18N
        jLabelNom.setText(resourceMap.getString("jLabelNom.text")); // NOI18N
        jLabelNom.setEnabled(false);
        jLabelNom.setName("jLabelNom"); // NOI18N

        jLabelPre.setFont(resourceMap.getFont("jLabelPre.font")); // NOI18N
        jLabelPre.setText(resourceMap.getString("jLabelPre.text")); // NOI18N
        jLabelPre.setEnabled(false);
        jLabelPre.setName("jLabelPre"); // NOI18N

        jLabelEma.setFont(resourceMap.getFont("jLabelEma.font")); // NOI18N
        jLabelEma.setText(resourceMap.getString("jLabelEma.text")); // NOI18N
        jLabelEma.setEnabled(false);
        jLabelEma.setName("jLabelEma"); // NOI18N

        jLabelDat.setFont(resourceMap.getFont("jLabelDat.font")); // NOI18N
        jLabelDat.setText(resourceMap.getString("jLabelDat.text")); // NOI18N
        jLabelDat.setEnabled(false);
        jLabelDat.setName("jLabelDat"); // NOI18N

        jLabelNat.setFont(resourceMap.getFont("jLabelNat.font")); // NOI18N
        jLabelNat.setText(resourceMap.getString("jLabelNat.text")); // NOI18N
        jLabelNat.setEnabled(false);
        jLabelNat.setName("jLabelNat"); // NOI18N

        jLabelSex.setFont(resourceMap.getFont("jLabelSex.font")); // NOI18N
        jLabelSex.setText(resourceMap.getString("jLabelSex.text")); // NOI18N
        jLabelSex.setEnabled(false);
        jLabelSex.setName("jLabelSex"); // NOI18N

        dateNaissanceLabel.setText(resourceMap.getString("dateNaissanceLabel.text")); // NOI18N
        dateNaissanceLabel.setEnabled(false);
        dateNaissanceLabel.setName("dateNaissanceLabel"); // NOI18N

        emailLabel.setText(resourceMap.getString("emailLabel.text")); // NOI18N
        emailLabel.setEnabled(false);
        emailLabel.setName("emailLabel"); // NOI18N

        loginLabel.setText(resourceMap.getString("loginLabel.text")); // NOI18N
        loginLabel.setEnabled(false);
        loginLabel.setName("loginLabel"); // NOI18N

        nomLabel.setText(resourceMap.getString("nomLabel.text")); // NOI18N
        nomLabel.setEnabled(false);
        nomLabel.setName("nomLabel"); // NOI18N

        prenomLabel.setText(resourceMap.getString("prenomLabel.text")); // NOI18N
        prenomLabel.setEnabled(false);
        prenomLabel.setName("prenomLabel"); // NOI18N

        nationaliteLabel.setText(resourceMap.getString("nationaliteLabel.text")); // NOI18N
        nationaliteLabel.setEnabled(false);
        nationaliteLabel.setName("nationaliteLabel"); // NOI18N

        sexeLabel.setText(resourceMap.getString("sexeLabel.text")); // NOI18N
        sexeLabel.setEnabled(false);
        sexeLabel.setName("sexeLabel"); // NOI18N

        javax.swing.GroupLayout selectionnePanelLayout = new javax.swing.GroupLayout(selectionnePanel);
        selectionnePanel.setLayout(selectionnePanelLayout);
        selectionnePanelLayout.setHorizontalGroup(
            selectionnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectionnePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectionnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDat)
                    .addComponent(jLabelEma)
                    .addComponent(jLabelPse)
                    .addComponent(jLabelNom)
                    .addComponent(jLabelPre)
                    .addComponent(jLabelNat)
                    .addComponent(jLabelSex))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectionnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sexeLabel)
                    .addComponent(nationaliteLabel)
                    .addComponent(prenomLabel)
                    .addComponent(nomLabel)
                    .addComponent(loginLabel)
                    .addComponent(emailLabel)
                    .addComponent(dateNaissanceLabel))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        selectionnePanelLayout.setVerticalGroup(
            selectionnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectionnePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectionnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPse)
                    .addComponent(loginLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectionnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNom)
                    .addComponent(nomLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectionnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPre)
                    .addComponent(prenomLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectionnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEma)
                    .addComponent(emailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectionnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDat)
                    .addComponent(dateNaissanceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectionnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNat)
                    .addComponent(nationaliteLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectionnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSex)
                    .addComponent(sexeLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        validerButton.setText(resourceMap.getString("validerButton.text")); // NOI18N
        validerButton.setName("validerButton"); // NOI18N
        validerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateOnClick(evt);
            }
        });

        contactButton.setText(resourceMap.getString("contactButton.text")); // NOI18N
        contactButton.setEnabled(false);
        contactButton.setName("contactButton"); // NOI18N
        contactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactOnClick(evt);
            }
        });

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel2.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel2.border.titleColor"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        listePediatresTable.setAutoCreateRowSorter(true);
        listePediatresTable.setModel(pediatresTM = new PediatresEnAttenteTableModel(listePediatresTable));
        listePediatresTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listePediatresTable.setName("listePediatresTable"); // NOI18N
        listePediatresTable.getTableHeader().setReorderingAllowed(false);
        listePediatresTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mouseSelection(evt);
            }
        });
        listePediatresTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mouseDragSelection(evt);
            }
        });
        listePediatresTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keySelection(evt);
            }
        });
        jScrollPane1.setViewportView(listePediatresTable);
        listePediatresTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        statesCount.setText(pediatresTM.countAccepted()
            +" accepté(s) et "
            + pediatresTM.countRefused()
            + " refusé(s) sur "
            + listePediatresTable.getRowCount());
        statesCount.setName("statesCount"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statesCount))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statesCount))
        );

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setLabelFor(mainPanel);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        refreshButton.setText(resourceMap.getString("refreshButton.text")); // NOI18N
        refreshButton.setName("refreshButton"); // NOI18N
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshOnClick(evt);
            }
        });

        docsButton.setText(resourceMap.getString("docsButton.text")); // NOI18N
        docsButton.setEnabled(false);
        docsButton.setName("docsButton"); // NOI18N
        docsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docConsultOnClick(evt);
            }
        });

        reinitializeButton.setText(resourceMap.getString("reinitializeButton.text")); // NOI18N
        reinitializeButton.setToolTipText(resourceMap.getString("reinitializeButton.toolTipText")); // NOI18N
        reinitializeButton.setEnabled(false);
        reinitializeButton.setName("reinitializeButton"); // NOI18N
        reinitializeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reinitializeOnClick(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refreshButton)
                            .addComponent(validerButton))
                        .addGap(2, 2, 2)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contactButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(docsButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(reinitializeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refuserButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accepterButton))
                            .addComponent(selectionnePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(selectionnePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contactButton))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(docsButton)
                    .addComponent(validerButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(accepterButton)
                    .addComponent(refuserButton)
                    .addComponent(reinitializeButton))
                .addGap(37, 37, 37))
        );

        jPanel2.getAccessibleContext().setAccessibleName(resourceMap.getString("jPanel2.AccessibleContext.accessibleName")); // NOI18N

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(gestionpediatre.GestionPediatreApp.class).getContext().getActionMap(GestionPediatreView.class, this);
        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        validateOptionPane.setMessage("aaa");
        validateOptionPane.setMessageType(validateOptionPane.QUESTION_MESSAGE);
        validateOptionPane.setOptionType(JOptionPane.YES_NO_OPTION);
        validateOptionPane.setName("validateOptionPane"); // NOI18N

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

private void mouseSelection(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseSelection
// TODO add your handling code here:
    enableDisable();
}//GEN-LAST:event_mouseSelection

private void keySelection(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keySelection
// TODO add your handling code here:
    enableDisable();
}//GEN-LAST:event_keySelection

private void mouseDragSelection(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseDragSelection
// TODO add your handling code here:
    enableDisable();
}//GEN-LAST:event_mouseDragSelection

private void refreshOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshOnClick
// TODO add your handling code here:
    int response = JOptionPane.showConfirmDialog(
            null,
            "Voulez-vous vraiment rafraîchir la liste ?",
            "Confirmation du rafraîchissement",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.YES_OPTION){
        refreshTable();
        countStates();
        enableDisable();
    }
}//GEN-LAST:event_refreshOnClick

private void validateOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateOnClick
// TODO add your handling code here:
    if(pediatresTM.countAccepted() == 0 && pediatresTM.countRefused() == 0){
        JOptionPane.showMessageDialog(
                null,
                "Aucune demande traitée.",
                "Confirmer la validation",
                JOptionPane.INFORMATION_MESSAGE);
    }
    else{
        int response = JOptionPane.showConfirmDialog(
                null,
                "Vous venez d'accepter "
                + pediatresTM.countAccepted()
                + " et refuser "
                + pediatresTM.countRefused()
                + " demande(s) d'ajout(s) de pédiatre(s)."
                + "\nVoulez-vous continuer ?",
                "Confirmer la validation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION){
            validateTreatment();
            refreshTable();
            countStates();
            enableDisable();
        }
    }
}//GEN-LAST:event_validateOnClick

private void reinitializeOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reinitializeOnClick
// TODO add your handling code here:
    setState("Non traitée");
    countStates();
    enableDisable();
    listePediatresTable.requestFocusInWindow();
}//GEN-LAST:event_reinitializeOnClick

private void refuseOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refuseOnClick
// TODO add your handling code here:
    setState("Refusée");
    countStates();
    enableDisable();
    listePediatresTable.requestFocusInWindow();
}//GEN-LAST:event_refuseOnClick

private void acceptOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptOnClick
// TODO add your handling code here:
    setState("Acceptée");
    countStates();
    enableDisable();
    listePediatresTable.requestFocusInWindow();
}//GEN-LAST:event_acceptOnClick

private void docConsultOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docConsultOnClick
// TODO add your handling code here:
}//GEN-LAST:event_docConsultOnClick

private void contactOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactOnClick
// TODO add your handling code here:
}//GEN-LAST:event_contactOnClick

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accepterButton;
    private javax.swing.JButton contactButton;
    private javax.swing.JLabel dateNaissanceLabel;
    private javax.swing.JButton docsButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDat;
    private javax.swing.JLabel jLabelEma;
    private javax.swing.JLabel jLabelNat;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelPre;
    private javax.swing.JLabel jLabelPse;
    private javax.swing.JLabel jLabelSex;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listePediatresTable;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel nationaliteLabel;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JLabel prenomLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton refuserButton;
    private javax.swing.JButton reinitializeButton;
    private javax.swing.JPanel selectionnePanel;
    private javax.swing.JLabel sexeLabel;
    private javax.swing.JLabel statesCount;
    private javax.swing.JOptionPane validateOptionPane;
    private javax.swing.JButton validerButton;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
    
    public javax.swing.JTable getListePediatresTable(){
        return listePediatresTable;
    }
    
    public void fillLabel(String login){
        Pediatre pediatre = pediatresTM.getPediatre(login);
        
        loginLabel.setText(pediatre.getLogin());
        nomLabel.setText(pediatre.getNom());
        prenomLabel.setText(pediatre.getPrenom());
        emailLabel.setText(pediatre.getEmail());
        dateNaissanceLabel.setText(formater.format(pediatre.getDateDeNaissance()));
        nationaliteLabel.setText(pediatre.getNationalite());
        sexeLabel.setText(pediatre.getSexe()?"Homme":"Femme");
    }
    
    public void refreshTable(){
        listePediatresTable.setModel(new PediatresEnAttenteTableModel(listePediatresTable));
        pediatresTM = (PediatresEnAttenteTableModel) listePediatresTable.getModel();
    }
    
    public void validateTreatment(){
        for(int i=0; i<listePediatresTable.getRowCount(); i++){
            if(listePediatresTable.getValueAt(i, 4).equals("Acceptée"))
                DAOPediatre.acceptPediatre((String)listePediatresTable.getValueAt(i, 0));
            if(listePediatresTable.getValueAt(i, 4).equals("Refusée"))
                DAOPediatre.deletePediatre((String)listePediatresTable.getValueAt(i, 0));
        }
    }
    
    private void enableDisable(){
        if(listePediatresTable.getSelectedRow() >= 0){
            selectionnePanel.setEnabled(true);
            jLabelPse.setEnabled(true);
            jLabelNom.setEnabled(true);
            jLabelPre.setEnabled(true);
            jLabelEma.setEnabled(true);
            jLabelDat.setEnabled(true);
            jLabelNat.setEnabled(true);
            jLabelSex.setEnabled(true);

            loginLabel.setEnabled(true);
            nomLabel.setEnabled(true);
            prenomLabel.setEnabled(true);
            emailLabel.setEnabled(true);
            dateNaissanceLabel.setEnabled(true);
            nationaliteLabel.setEnabled(true);
            sexeLabel.setEnabled(true);

            //accepterButton
            if(!listePediatresTable.getValueAt(listePediatresTable.getSelectedRow(), 4).equals("Acceptée"))
                accepterButton.setEnabled(true);
            else
                accepterButton.setEnabled(false);
            
            //refuserButton
            if(!listePediatresTable.getValueAt(listePediatresTable.getSelectedRow(), 4).equals("Refusée"))
                refuserButton.setEnabled(true);
            else
                refuserButton.setEnabled(false);
            
            //reinitializeButton
            if(!listePediatresTable.getValueAt(listePediatresTable.getSelectedRow(), 4).equals("Non traitée"))
                reinitializeButton.setEnabled(true);
            else
                reinitializeButton.setEnabled(false);
            
            contactButton.setEnabled(true);
            docsButton.setEnabled(true);

            fillLabel(listePediatresTable.getValueAt(listePediatresTable.getSelectedRow(), 0).toString());
        }
        else{
            selectionnePanel.setEnabled(false);
            jLabelPse.setEnabled(false);
            jLabelNom.setEnabled(false);
            jLabelPre.setEnabled(false);
            jLabelEma.setEnabled(false);
            jLabelDat.setEnabled(false);
            jLabelNat.setEnabled(false);
            jLabelSex.setEnabled(false);

            loginLabel.setEnabled(false);
            nomLabel.setEnabled(false);
            prenomLabel.setEnabled(false);
            emailLabel.setEnabled(false);
            dateNaissanceLabel.setEnabled(false);
            nationaliteLabel.setEnabled(false);
            sexeLabel.setEnabled(false);

            accepterButton.setEnabled(false);
            refuserButton.setEnabled(false);
            reinitializeButton.setEnabled(false);
            contactButton.setEnabled(false);
            docsButton.setEnabled(false);
        }
    }
    
    private void setState(String state){
        for(int i=0; i<4; i++)
            listePediatresTable.setValueAt(listePediatresTable.getValueAt(listePediatresTable.getSelectedRow(), i), listePediatresTable.getSelectedRow(), i);        
        listePediatresTable.setValueAt(state, listePediatresTable.getSelectedRow(), 4);
    }
    
    private void countStates(){
        statesCount.setText(pediatresTM.countAccepted() +" acceptée(s) et "
                + pediatresTM.countRefused() + " refusée(s) sur "
                + listePediatresTable.getRowCount());
    }
}
