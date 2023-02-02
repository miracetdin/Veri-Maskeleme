package veri_maskeleme;

	
import javax.swing.JFileChooser;
import java.io.File;    
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miracetdin
 */
public class Ekran extends javax.swing.JFrame {
    
    static String orijinalMetin = "";
    static String maskelenmisMetin = "";
    static String dosyaAdi = "";
    
    /**
     * Creates new form Ekran
     */
    public Ekran() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orijinalMetinTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        maskelenmisMetinTextArea = new javax.swing.JTextArea();
        maskeleButon = new javax.swing.JButton();
        dosyaSeçButon = new javax.swing.JButton();
        dosyaYazButon = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mesajTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VERİ MASKELEME PROGRAMI");

        orijinalMetinTextArea.setEditable(false);
        orijinalMetinTextArea.setColumns(5);
        orijinalMetinTextArea.setLineWrap(true);
        orijinalMetinTextArea.setRows(5);
        orijinalMetinTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(orijinalMetinTextArea);

        maskelenmisMetinTextArea.setEditable(false);
        maskelenmisMetinTextArea.setColumns(20);
        maskelenmisMetinTextArea.setLineWrap(true);
        maskelenmisMetinTextArea.setRows(5);
        jScrollPane2.setViewportView(maskelenmisMetinTextArea);

        maskeleButon.setText("Maskele");
        maskeleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maskeleButonActionPerformed(evt);
            }
        });

        dosyaSeçButon.setText("Dosya Seç");
        dosyaSeçButon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dosyaSeçButonMouseClicked(evt);
            }
        });

        dosyaYazButon.setText("Dosya Yaz");
        dosyaYazButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyaYazButonActionPerformed(evt);
            }
        });

        jLabel2.setText("Orijinal Metin");

        jLabel3.setText("Maskelenmiş Metin");

        mesajTextField.setEditable(false);
        mesajTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(127, 127, 127))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mesajTextField)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dosyaSeçButon)
                        .addGap(98, 98, 98)
                        .addComponent(maskeleButon)
                        .addGap(101, 101, 101)
                        .addComponent(dosyaYazButon)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mesajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dosyaSeçButon)
                    .addComponent(maskeleButon)
                    .addComponent(dosyaYazButon))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dosyaSeçButonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dosyaSeçButonMouseClicked
        // TODO add your handling code here:s
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            dosyaAdi = selectedFile.getName();
            mesajTextField.setText("Seçilen dosya: " + dosyaAdi);
            try {
                orijinalMetinTextArea.read( new FileReader( selectedFile.getAbsolutePath()), null);
                orijinalMetin = orijinalMetinTextArea.getText();
            } catch (IOException ex) {
                Logger.getLogger(Ekran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_dosyaSeçButonMouseClicked

    private void maskeleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maskeleButonActionPerformed
        // TODO add your handling code here:
        mesajTextField.setText("Maskeleme işlemi yapılıyor...");
        maskelenmisMetin = Zemberek.zemberek_maskeleme(orijinalMetin);
        maskelenmisMetin = Regex.Regex_Maskeleme(maskelenmisMetin);
        maskelenmisMetinTextArea.setText(maskelenmisMetin);
        mesajTextField.setText("Maskeleme işlemi tamamlandı.");
    }//GEN-LAST:event_maskeleButonActionPerformed

    private void dosyaYazButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyaYazButonActionPerformed
        String konum = System.getProperty("user.home") + "\\Desktop\\Maskelenmiş_" + dosyaAdi; 
        File dosya  = new File(konum);
        try{
            FileWriter fileWriter = new FileWriter(konum);
            fileWriter.write(maskelenmisMetin);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Ekran.class.getName()).log(Level.SEVERE, null, ex);
        }
        mesajTextField.setText("\"Maskelenmiş_" + dosyaAdi + "\" dosyası masaüstünde oluşturuldu.");
    }//GEN-LAST:event_dosyaYazButonActionPerformed

    
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
            java.util.logging.Logger.getLogger(Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ekran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dosyaSeçButon;
    private javax.swing.JButton dosyaYazButon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton maskeleButon;
    private javax.swing.JTextArea maskelenmisMetinTextArea;
    private javax.swing.JTextField mesajTextField;
    private javax.swing.JTextArea orijinalMetinTextArea;
    // End of variables declaration//GEN-END:variables
}
