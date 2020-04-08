/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.JDBConnection;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Muhammad_Musharaf
 */
public class CustomerReciepts extends javax.swing.JFrame {

    /**
     * Creates new form CustomerReciepts
     */
    Connection con;
    int totalAccounts = 0;
    ArrayList<String> analogAccounts = new ArrayList<>();
    ArrayList<String> digitalAccounts = new ArrayList<>();

    public CustomerReciepts() {

        initComponents();
        con = new JDBConnection().getConnection();
        first.setEditable(false);
        second.setEditable(false);
        jButton3.setEnabled(true);
        tick.setVisible(false);
        getAccounts();
        centreScreen();
    }

    public void centreScreen() {
        Dimension screenSize, frameSize;
        int x, y;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = getSize();
        x = (screenSize.width - frameSize.width) / 2;
        y = (screenSize.height - frameSize.height) / 2;
        setLocation(x, y);
    }

    public void getAccounts() {
        try {
            String query = "SELECT * FROM cable_manager.analog_connections where activation = 'activated'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String acc = rs.getString("acc_no");
                System.out.println("accANALOG: " + acc);
                analogAccounts.add(acc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String query = "SELECT * FROM cable_manager.digital_connections where activation = 'activated'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String acc = rs.getString("acc_no");
                System.out.println("accDIGITAL: " + acc);
                digitalAccounts.add(acc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void textUp_analog(String acc, String name, String date, int arears, String monthly, String mobile) {
        first.selectAll();
        first.replaceSelection("");
        second.selectAll();
        second.replaceSelection("");
        first.append("     New Star Aero Vision Cable\n"
                + "  Network Jumman Shah Tando Adam\n"
                + "  Zulfiqar Ali(0333-2885288)\n"
                + "            (0312-2885288)\n"
                + "==================================\n"
                + "Acc No:\t\t" + acc + "\n"
                + "Name:\t\t" + name + "\n"
                + "Date:\t\t" + date + "\n"
                + "Arears:\t\t" + arears + "\n"
                + "Monthly:\t" + monthly + "\n"
                + "Total:\t\t" + (arears + Integer.parseInt(monthly)) + "\n"
                + "Credit:\t\t\n"
                + "Balance:\t\n"
                + "Card No:\t\n"
                + "Mobile:\t\t" + mobile
                + "\n==================================\n"
                + "For Software Solution Contact:\n"
                + "Sagar Ali (0308-7158900)\n");

        second.append("     New Star Aero Vision Cable\n"
                + "   Network Jumman Shah Tando Adam\n"
                + "  Zulfiqar Ali(0333-2885288)\n"
                + "            (0312-2885288)\n"
                + "==================================\n"
                + "Acc No:\t\t" + acc + "\n"
                + "Name:\t\t" + name + "\n"
                + "Date:\t\t" + date + "\n"
                + "Arears:\t\t" + arears + "\n"
                + "Monthly:\t" + monthly + "\n"
                + "Total:\t\t" + (arears + Integer.parseInt(monthly)) + "\n"
                + "Credit:\t\t\n"
                + "Balance:\t\n"
                + "Card No:\t\n"
                + "Mobile:\t\t" + mobile
                + "\n==================================\n"
                + "For Software Solution Contact:\n"
                + "Sagar Ali (0308-7158900)\n");;
    }

    public void textUp_digital(String acc, String name, String date, int arears, String monthly, String mobile, String card_no) {
        first.selectAll();
        first.replaceSelection("");
        second.selectAll();
        second.replaceSelection("");
        first.append("     New Star Aero Vision Cable\n"
                + "  Network Jumman Shah Tando Adam\n"
                + "  Zulfiqar Ali(0333-2885288)\n"
                + "            (0312-2885288)\n"
                + "==================================\n"
                + "Acc No:\t\t" + acc + "\n"
                + "Name:\t\t" + name + "\n"
                + "Date:\t\t" + date + "\n"
                + "Arears:\t\t" + arears + "\n"
                + "Monthly:\t" + monthly + "\n"
                + "Total:\t\t" + (arears + Integer.parseInt(monthly)) + "\n"
                + "Credit:\t\t\n"
                + "Balance:\t\n"
                + "Card No:" + card_no + "\n"
                + "Mobile:\t\t" + mobile
                + "\n==================================\n"
                + "For Software Solution Contact:\n"
                + "Sagar Ali (0308-7158900)\n");

        second.append("     New Star Aero Vision Cable\n"
                + "   Network Jumman Shah Tando Adam\n"
                + "  Zulfiqar Ali(0333-2885288)\n"
                + "            (0312-2885288)\n"
                + "==================================\n"
                + "Acc No:\t\t" + acc + "\n"
                + "Name:\t\t" + name + "\n"
                + "Date:\t\t" + date + "\n"
                + "Arears:\t\t" + arears + "\n"
                + "Monthly:\t" + monthly + "\n"
                + "Total:\t\t" + (arears + Integer.parseInt(monthly)) + "\n"
                + "Credit:\t\t\n"
                + "Balance:\t\n"
                + "Card No:" + card_no + "\n"
                + "Mobile:\t\t" + mobile
                + "\n==================================\n"
                + "For Software Solution Contact:\n"
                + "Sagar Ali (0308-7158900)\n");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        first = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        second = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tick = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        first.setColumns(20);
        first.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        first.setRows(5);
        jScrollPane2.setViewportView(first);

        second.setColumns(20);
        second.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        second.setRows(5);
        jScrollPane1.setViewportView(second);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jButton3.setText("Print Silps");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Print Silps");

        jLabel1.setText("<͟B͟a͟c͟k͟");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        tick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/15-512.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tick)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(259, 259, 259))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tick)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void print(String accName) { // USE characters in AccNO that can be used in folder name
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Zulfiqar Ali\\Documents\\CATV Documents\\Customer Slips\\" + accName + ".pdf"));
            document.open();
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(500, 500);
            Graphics2D g2 = template.createGraphics(500, 500);
            g2.scale(0.82, 0.90);
            jPanel1.print(g2);
            g2.dispose();
            contentByte.addTemplate(template, 30, 300);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        for (int i = 0; i < analogAccounts.size(); i++) {
            String acc = analogAccounts.get(i);
            String name = "";
            String date = "";
            int arears = 0;
            String monthly = "";
            String mobile = "";
            try {
                String query = "SELECT * FROM cable_manager.analog_connections WHERE acc_no='" + acc + "'";  // first we find user in Analog_connections Table
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    name = rs.getString("name");
                    date = getDate();
                    arears = rs.getInt("arears");
                    monthly = rs.getString("monthly");
                    mobile = rs.getString("mobile_no");
                    textUp_analog(acc, name, date, arears, monthly, mobile);
                    print(acc);
                }
                st.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < digitalAccounts.size(); i++) {
            String acc = digitalAccounts.get(i);
            String name = "";
            String date = "";
            int arears = 0;
            String monthly = "";
            String mobile = "";
            String card_no = "";
            try {
                String query = "SELECT * FROM cable_manager.digital_connections WHERE acc_no='" + acc + "'";  // first we find user in Analog_connections Table
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    name = rs.getString("name");
                    date = getDate();
                    arears = rs.getInt("arears");
                    monthly = rs.getString("monthly");
                    mobile = rs.getString("mobile_no");
                    card_no = rs.getString("digital_no1") + "," + rs.getString("digital_no2") + "," + rs.getString("digital_no3") + "," + rs.getString("digital_no4");
                    textUp_digital(acc, name, date, arears, monthly, mobile, card_no);
                    print(acc);
                }
                st.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        tick.setVisible(true);
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setVisible(false);
        new DashboardFrame().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(CustomerReciepts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerReciepts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerReciepts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerReciepts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerReciepts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea first;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea second;
    private javax.swing.JLabel tick;
    // End of variables declaration//GEN-END:variables

    private String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //  >> HH:mm:ss (optional time)
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now);
    }
}
