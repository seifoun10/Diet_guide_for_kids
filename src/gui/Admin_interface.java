
package gui;

import dao.AdminDAO;
import entities.Administrateur;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;



public class Admin_interface extends javax.swing.JFrame {

Integer attemps=0;
    Administrateur admin1,admin2;
          AdminDAO  admindao;
          String log1,pass1,log2,pass2,etatcon;
    public Admin_interface() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        login = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passwd = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Se connecter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        login.setText("login");

        jLabel1.setText("Login");

        jLabel2.setText("Mot de passe");

        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText(" ici");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setText("En cas d'oublie de mot depasse, veuillez vous mettre hors ligne ");

        jLabel5.setText("et cliquez ");

        jLabel6.setText("pour accéder a l'interface de renouvellement de mot de passe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(passwd)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       Administrateur adminn1=new Administrateur();
        AdminDAO adminn=new AdminDAO();
        adminn.recuperer_admin();
        //adminn1.getLogin();
        //adminn1.getPassword();
      //  System.out.println(adminn1);
       log2=adminn.log;
       pass2=adminn.pass;
        System.out.println("c'est log2"+log2+"   "+pass2);
       //j'ai arrivé jusqu'ici
       log1=login.getText();
      //  admin1.setLogin(login.getText());
       
       pass1=passwd.getText();
        //admin1.setPassword(passwd.getText());
        System.out.println(log1+"   "+pass1);
        if((log2.equals(log1))&&(pass2.equals(pass1)))
        {
           
            JOptionPane.showMessageDialog(null, "Connecté correctement","Connexion",1);
             //System.out.println("Connecter correctement");
        }
        
        else if(!(log2.equals(log1))&&(pass2.equals(pass1)))
        {
             JOptionPane.showMessageDialog(null, "Vérifiez votre login","Connexion",0);
            attemps=attemps+1;
            JOptionPane.showMessageDialog(null, "Nombre de tentatives ="+(attemps+1),"Connexion",2);
        }
        else if((log2.equals(log1))&&!(pass2.equals(pass1)))
        {
            JOptionPane.showMessageDialog(null, "Vérifiez votre mot de passe","Connexion",0);
            attemps=attemps+1;
            JOptionPane.showMessageDialog(null, "Nombre de tentatives ="+(attemps+1),"Connexion",2);
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Vérifiez votre login et mot de passe","Connexion",0);
            //System.out.println("Vérifiez votre login et votre mot de passe");
            JOptionPane.showMessageDialog(null, "Nombre de tentatives ="+(attemps+1),"Connexion",2);
            attemps=attemps+1;
        }
        
        if(attemps==3)
        {
            JOptionPane.showMessageDialog(null, "Trois fausse tentatives!!!  le Système se Fermera","Connexion",0);
            this.dispose();
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
         try {
        //make a URL to a known source
        URL url = new URL("http://www.google.com");

        //open a connection to that source
        HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

        //trying to retrieve data from the source. If there
        //is no connection, this line will fail
        Object objData = urlConnect.getContent();
       // System.out.println("SUCCESSFUL INTERNET CONNECTION");
        etatcon="ok";

    } catch (UnknownHostException e) {
        // TODO Auto-generated catch block

       // System.out.println("CONNECTION FAILED");
        e.printStackTrace();
       etatcon="no";
    }
    catch (IOException e) {
        // TODO Auto-generated catch block
      //  System.out.println("CONNECTION FAILED");
        e.printStackTrace();
        etatcon="no";
    }
      if(etatcon.equals("ok"))
         {
           JOptionPane.showMessageDialog(null, "Fermez votre connexion Internet","Connexion",0);  
         }
         
         else if(etatcon.equals("no"))
         {
             this.dispose();
           Inerface_renouveler_mot_de_passe form=new Inerface_renouveler_mot_de_passe();
            form.setVisible(true);
         }
         else {
             JOptionPane.showMessageDialog(null, "Erreur Fatale","Connexion",0);
         }
    }//GEN-LAST:event_jLabel3MouseClicked

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
                new Admin_interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField login;
    private javax.swing.JPasswordField passwd;
    // End of variables declaration//GEN-END:variables
}
