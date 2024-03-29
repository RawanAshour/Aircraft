/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mscs;

import java.awt.Component;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author ahmed nasser
 */
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    private void groupButton( ) {
        ButtonGroup bg1 = new ButtonGroup( );
        bg1.add(CS);//cataloge section
        bg1.add(SK);//store keeper
        bg1.add(SIM);//stock item manager
    }
    public SignUp() {
        initComponents();
        groupButton();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        passText = new javax.swing.JPasswordField();
        pass2Text = new javax.swing.JPasswordField();
        type = new javax.swing.JPanel();
        CS = new javax.swing.JRadioButton();
        SK = new javax.swing.JRadioButton();
        SIM = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("   Sign up");

        jLabel2.setText("username  :");

        jLabel3.setText("full name :");

        jLabel4.setText("password :");

        jLabel5.setText("re-password :");

        jLabel6.setText("user as :");

        CS.setText("Catalogue section");

        SK.setText("Store keeper");

        SIM.setText("Stock item manager");

        javax.swing.GroupLayout typeLayout = new javax.swing.GroupLayout(type);
        type.setLayout(typeLayout);
        typeLayout.setHorizontalGroup(
            typeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(typeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CS)
                    .addComponent(SK)
                    .addComponent(SIM))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        typeLayout.setVerticalGroup(
            typeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(CS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SIM)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jButton1.setText("sign up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(41, 41, 41)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(usernameText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(passText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(pass2Text, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pass2Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(19, 19, 19)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String type = "";
        
         User user=new User();
        user.setUserName(usernameText.getText());
        user.setPassword(passText.getText());
        user.setName(nameText.getText());
       
        if (CS.isSelected()){
        AbstractRole a;
             a = new CatalogueSectionUser();
            user.setMyRole(a);
            type = "CS";
            
            System.out.println("CS");
        }
        else if (SK.isSelected())
            {
        AbstractRole a;
             a = new StoreKeeper();
                
            user.setMyRole(a);
            type = "SK";
        }
        else if (SIM.isSelected())
            {
        AbstractRole a;
             a = new StockItemManager();
                
            user.setMyRole(a);
            type = "SIM";
        }
        
        
        
        if (!user.checkForSignup()){
         Component frame = null;
        JOptionPane.showMessageDialog(frame," Wrong data entered in username !! ");
       //System.out.println("!user.checkForSignup()");
        }
        
        else if (!passText.getText().equals(pass2Text.getText())){
         Component frame = null;
        JOptionPane.showMessageDialog(frame," Wrong data entered in password !! ");
       
        }
        
        
        else if (user.checkForSignup() && passText.getText().equals(pass2Text.getText())){
            System.out.println("7amada");
        //put in data base ,, then bt-navigate login
            
            
                   Connection conn = null;
       Statement stmt = null;
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(IConstant.DB_URL, IConstant.USER, IConstant.PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();
      /*
       user.setUserName(usernameText.getText());
        user.setPassword(nameText.getText());
        user.setName(nameText.getText());
       */
      String sql = "INSERT INTO user " +
                   "VALUES ('"+ user.getUserName() + "','" + user.getPassword() +"','" + user.getName() +"','" + type + "')";
      stmt.executeUpdate(sql);
      
      System.out.println("Inserted records into the table...");

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");

   //navigate to profile
            if (type.equals("CS")){
                CS_profile p = new CS_profile();
                p.show();
            }
            else if (type.equals("SK")){
                SK_profile p = new SK_profile();
                p.show();
            }
            else if (type.equals("SIM")){
                SIM_profile p = new SIM_profile();
                p.show();
            }
            //close signup window
            setVisible(false); //you can't see me!
            dispose(); //Destroy the JFrame object
        }
    }//GEN-LAST:event_jButton1ActionPerformed
/*
 * ButtonGroup bG = new ButtonGroup();
                bG.add(jRadioButton1);
                bG.add(jRadioButton2);
                bG.add(jRadioButton4);
                
                */
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CS;
    private javax.swing.JRadioButton SIM;
    private javax.swing.JRadioButton SK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nameText;
    private javax.swing.JPasswordField pass2Text;
    private javax.swing.JPasswordField passText;
    private javax.swing.JPanel type;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
