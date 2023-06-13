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
        //this.setExtendedState(MAXIMIZED_BOTH);
        createScene(file);
        setTitle("GATO CON BOTAS INTERACTIVO");
        setResizable(false);
        setLocationRelativeTo(null);
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
//                jfxPanel.setPreferredSize(new Dimension(1200, 640));
//                jfxPanel.setMaximumSize(new Dimension(1200, 640));
//                jfxPanel.setMinimumSize(new Dimension(1200, 640));

//                validate(); // Asegura la actualización del diseño
            }
        });
        asiganarTiempo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Panel_Movie = new javax.swing.JPanel();
        VolumeSlider = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        RETROCEDER = new javax.swing.JButton();
        Pausar_Reproducir = new javax.swing.JButton();
        ADELANTAR = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tiempoTranscurridoLabel = new javax.swing.JLabel();
        barraProgreso = new javax.swing.JSlider();
        tiempoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(330, 200));
        jLayeredPane1.setLayout(new java.awt.BorderLayout(2, 0));

        Panel_Movie.setBackground(new java.awt.Color(0, 0, 0));
        Panel_Movie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel_Movie.setPreferredSize(new java.awt.Dimension(344, 226));

        VolumeSlider.setBackground(new java.awt.Color(0, 0, 0));
        VolumeSlider.setFont(new java.awt.Font("Mongolian Baiti", 1, 12)); // NOI18N
        VolumeSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        VolumeSlider.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        VolumeSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VolumeSlider.setValueIsAdjusting(true);
        VolumeSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                VolumeSliderMouseReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        RETROCEDER.setBackground(new java.awt.Color(0, 0, 0));
        RETROCEDER.setFont(new java.awt.Font("Berlin Sans FB", 1, 12)); // NOI18N
        RETROCEDER.setForeground(new java.awt.Color(255, 255, 255));
        RETROCEDER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoproga2/atrasar.png"))); // NOI18N
        RETROCEDER.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RETROCEDER.setContentAreaFilled(false);
        RETROCEDER.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RETROCEDER.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RETROCEDER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RETROCEDERMouseClicked(evt);
            }
        });
        jPanel1.add(RETROCEDER);

        Pausar_Reproducir.setBackground(new java.awt.Color(0, 0, 0));
        Pausar_Reproducir.setFont(new java.awt.Font("Berlin Sans FB", 1, 12)); // NOI18N
        Pausar_Reproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoproga2/Pausa_Playy.png"))); // NOI18N
        Pausar_Reproducir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Pausar_Reproducir.setContentAreaFilled(false);
        Pausar_Reproducir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pausar_Reproducir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pausar_Reproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pausar_ReproducirActionPerformed(evt);
            }
        });
        jPanel1.add(Pausar_Reproducir);

        ADELANTAR.setBackground(new java.awt.Color(0, 0, 0));
        ADELANTAR.setFont(new java.awt.Font("Berlin Sans FB", 1, 12)); // NOI18N
        ADELANTAR.setForeground(new java.awt.Color(255, 255, 255));
        ADELANTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoproga2/adelantar.png"))); // NOI18N
        ADELANTAR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ADELANTAR.setContentAreaFilled(false);
        ADELANTAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ADELANTAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ADELANTAR.setMargin(new java.awt.Insets(4, 14, 2, 14));
        ADELANTAR.setMaximumSize(new java.awt.Dimension(73, 1));
        ADELANTAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADELANTARMouseClicked(evt);
            }
        });
        jPanel1.add(ADELANTAR);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        tiempoTranscurridoLabel.setBackground(new java.awt.Color(255, 255, 255));
        tiempoTranscurridoLabel.setFont(new java.awt.Font("Mongolian Baiti", 1, 12)); // NOI18N
        tiempoTranscurridoLabel.setForeground(new java.awt.Color(255, 255, 255));
        tiempoTranscurridoLabel.setText("00:00:00");
        tiempoTranscurridoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        barraProgreso.setBackground(new java.awt.Color(0, 0, 0));
        barraProgreso.setFont(new java.awt.Font("Mongolian Baiti", 1, 12)); // NOI18N
        barraProgreso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        barraProgreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraProgreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                barraProgresoMouseReleased(evt);
            }
        });

        tiempoLabel.setBackground(new java.awt.Color(255, 255, 255));
        tiempoLabel.setFont(new java.awt.Font("Mongolian Baiti", 1, 12)); // NOI18N
        tiempoLabel.setForeground(new java.awt.Color(255, 255, 255));
        tiempoLabel.setText("00:00:00");
        tiempoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tiempoTranscurridoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tiempoLabel)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tiempoTranscurridoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiempoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Panel_MovieLayout = new javax.swing.GroupLayout(Panel_Movie);
        Panel_Movie.setLayout(Panel_MovieLayout);
        Panel_MovieLayout.setHorizontalGroup(
            Panel_MovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Panel_MovieLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_MovieLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        Panel_MovieLayout.setVerticalGroup(
            Panel_MovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_MovieLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(VolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLayeredPane1.setLayer(Panel_Movie, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.add(Panel_Movie, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
boolean estado = true;
    private void Pausar_ReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pausar_ReproducirActionPerformed
        // TODO add your handling code here:
        if (estado) {
           // Pausar_Reproducir.setText("REPRODUCIR");
            oracleVid.pause();
            estado = false;
        } else if (!estado) {
           // Pausar_Reproducir.setText("PAUSAR");
            oracleVid.play();
            estado = true;
        }
    }//GEN-LAST:event_Pausar_ReproducirActionPerformed

    private void barraProgresoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraProgresoMouseReleased
        // TODO add your handling code here:

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

    private void ADELANTARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADELANTARMouseClicked
        // TODO add your handling code here:
        if (estado) {
            // Obtener la posición actual del video
            Duration currentPosition = oracleVid.getCurrentTime();

            // Calcular la nueva posición adelantada
            Duration newPosition = currentPosition.add(Duration.seconds(10)); // Adelanta 10 segundos

            // Establecer la nueva posición del video
            oracleVid.seek(newPosition);
        }
    }//GEN-LAST:event_ADELANTARMouseClicked

    private void RETROCEDERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RETROCEDERMouseClicked
        // TODO add your handling code here:
        if (estado) {
            // Obtener la posición actual del video
            Duration currentPosition = oracleVid.getCurrentTime();

            // Calcular la nueva posición retrocedida
            Duration newPosition = currentPosition.subtract(Duration.seconds(10)); // Retrocede 10 segundos

            // Establecer la nueva posición del video
            oracleVid.seek(newPosition);
        }
    }//GEN-LAST:event_RETROCEDERMouseClicked

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel tiempoLabel;
    private javax.swing.JLabel tiempoTranscurridoLabel;
    // End of variables declaration//GEN-END:variables
}
