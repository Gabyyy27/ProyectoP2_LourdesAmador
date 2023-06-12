package proyectoproga2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 *
 * @author Lourdes
 */
public class Gato_Botas_INICIO extends javax.swing.JFrame {

    private final JFXPanel jfxPanel = new JFXPanel();
//    LllamarVideo  v = new LllamarVideo();
    MediaPlayer oracleVid;
    boolean control = false;

    public Gato_Botas_INICIO(Media file) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        createScene(file);
        setTitle("GATO CON BOTAS INTERACTIVO");
        setResizable(true);
        //setLocationRelativeTo(null);
        Panel_Movie.setLayout(new BorderLayout());
        Panel_Movie.add(jfxPanel, BorderLayout.CENTER); // MediaView en el centro
//        jPanel2.add(barraProgreso, BorderLayout.SOUTH); // JSlider en la parte inferior
//        jPanel2.add(VolumeSlider, BorderLayout.EAST); // JSlider en el lado derecho
//        jPanel2.add(tiempoLabel, BorderLayout.EAST);
//        jPanel2.add(tiempoTranscurridoLabel, BorderLayout.WEST); // JLabel en el lado izquierdo
//
//        
    }

    Thread hilo = new Thread() {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                    actualizarBarraYTiempo();
                }
            } catch (InterruptedException e) {
            }
        }
    };

    private void createScene(Media file) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                StackPane root = new StackPane();
                oracleVid = new MediaPlayer(file);
                oracleVid.setAutoPlay(true);

                MediaView theView = new MediaView(oracleVid);
                root.getChildren().add(theView);
                //se añade video al jfxPanel
                Scene scene = new Scene(root, 1200, 640);

                jfxPanel.setScene(scene);
                jfxPanel.setPreferredSize(new Dimension(1200, 640));
                jfxPanel.setMaximumSize(new Dimension(1200, 640));
                jfxPanel.setMinimumSize(new Dimension(1200, 640));

                validate(); // Asegura la actualización del diseño

            }
        });
        asiganarTiempo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RETROCEDER = new javax.swing.JButton();
        Pausar_Reproducir = new javax.swing.JButton();
        ADELANTAR = new javax.swing.JButton();
        tiempoTranscurridoLabel = new javax.swing.JLabel();
        barraProgreso = new javax.swing.JSlider();
        tiempoLabel = new javax.swing.JLabel();
        VolumeSlider = new javax.swing.JSlider();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        Panel_Movie = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        RETROCEDER.setText("RETROCEDER");
        getContentPane().add(RETROCEDER);

        Pausar_Reproducir.setText("PLAY");
        Pausar_Reproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pausar_ReproducirActionPerformed(evt);
            }
        });
        getContentPane().add(Pausar_Reproducir);

        ADELANTAR.setText("ADELANTAR");
        getContentPane().add(ADELANTAR);

        tiempoTranscurridoLabel.setText("00:00:00");
        getContentPane().add(tiempoTranscurridoLabel);

        barraProgreso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        barraProgreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                barraProgresoMouseReleased(evt);
            }
        });
        getContentPane().add(barraProgreso);

        tiempoLabel.setText("00:00:00");
        getContentPane().add(tiempoLabel);

        VolumeSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        VolumeSlider.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        VolumeSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                VolumeSliderMouseReleased(evt);
            }
        });
        getContentPane().add(VolumeSlider);

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(330, 200));

        Panel_Movie.setPreferredSize(new java.awt.Dimension(344, 226));

        javax.swing.GroupLayout Panel_MovieLayout = new javax.swing.GroupLayout(Panel_Movie);
        Panel_Movie.setLayout(Panel_MovieLayout);
        Panel_MovieLayout.setHorizontalGroup(
            Panel_MovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        Panel_MovieLayout.setVerticalGroup(
            Panel_MovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );

        jLayeredPane1.setLayer(Panel_Movie, javax.swing.JLayeredPane.MODAL_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Panel_Movie, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Panel_Movie, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(jLayeredPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
boolean estado = true;
    private void Pausar_ReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pausar_ReproducirActionPerformed
        // TODO add your handling code here:
        if (estado) {
            Pausar_Reproducir.setText("Reproducir");
            oracleVid.pause();
            estado = false;
        } else if (!estado) {
            Pausar_Reproducir.setText("Pausar");
            oracleVid.play();
            estado = true;
        }
    }//GEN-LAST:event_Pausar_ReproducirActionPerformed

    private void barraProgresoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraProgresoMouseReleased
        // TODO add your handling code here:
        //tratar de trabajar todo en segundo

        //reproduce se obtiene el valor del jSlider1 y se manda al video
        int val = barraProgreso.getValue();
        oracleVid.seek(Duration.seconds(val));

    }//GEN-LAST:event_barraProgresoMouseReleased

    private void VolumeSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolumeSliderMouseReleased
        // TODO add your handling code here:
        double val = VolumeSlider.getValue();
        val *= 0.1;
        oracleVid.setVolume(val);

    }//GEN-LAST:event_VolumeSliderMouseReleased

    void asiganarTiempo() {
        try {
            Thread.sleep(1000);
            VolumeSlider.setMinimum(0);
            VolumeSlider.setMaximum(10);
            double sec = oracleVid.getTotalDuration().toSeconds();
            int val = (int) sec;
            barraProgreso.setMaximum(val);

            tiempoLabel.setText(obtenerMinutos(val) + "");
            hilo.start();

        } catch (InterruptedException ex) {
            Logger.getLogger(videoFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String obtenerMinutos(int val) {
        int horas = 0;
        int minutos = 0;

        while (val > 59) {
            if (val > 59) {
                val -= 60;
                minutos++;
            }
            if (minutos > 59) {
                minutos -= 60;
                horas++;
            }
        }
        String hor = horas + "";
        String min = minutos + "";
        String sec = val + "";
        if (horas < 10) {
            hor = "0" + hor;
        }
        if (minutos < 10) {
            min = "0" + min;
        }
        if (val < 10) {
            sec = "0" + sec;
        }
        return hor + ":" + min + ":" + sec;
    }

    public void actualizarBarraYTiempo() {

        double sec = oracleVid.getCurrentTime().toSeconds();
        int val = (int) sec;
        barraProgreso.setValue(val);

        tiempoTranscurridoLabel.setText(obtenerMinutos(val));

    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gato_Botas_INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gato_Botas_INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gato_Botas_INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gato_Botas_INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Gato_Botas_INICIO(Media file).setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADELANTAR;
    private javax.swing.JPanel Panel_Movie;
    private javax.swing.JButton Pausar_Reproducir;
    private javax.swing.JButton RETROCEDER;
    private javax.swing.JSlider VolumeSlider;
    private javax.swing.JSlider barraProgreso;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel tiempoLabel;
    private javax.swing.JLabel tiempoTranscurridoLabel;
    // End of variables declaration//GEN-END:variables
}
