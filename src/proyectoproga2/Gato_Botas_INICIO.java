package proyectoproga2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 *
 * @author Lourdes
 */
public class Gato_Botas_INICIO extends javax.swing.JFrame implements EscenaListener {

    private final JFXPanel jfxPanel = new JFXPanel();
    private int escenaActual = 1;
    private MediaPlayer oracleVid;
    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer1_1;
    private MediaView mediaView1;
    private MediaView mediaView1_1;
    private MediaPlayer mediaPlayer1_2;
    private MediaView mediaView1_2;
    private final Object lock = new Object();
    private final Condition opcionSeleccionadaCondition = new ReentrantLock().newCondition();

    public Gato_Botas_INICIO() {
        initComponents();
        //this.setExtendedState(MAXIMIZED_BOTH);
        initMediaPlayer();
        setTitle("GATO CON BOTAS INTERACTIVO");
        setResizable(false);
        setLocationRelativeTo(null);
        Panel_Movie.setLayout(new BorderLayout());
        Panel_Movie.add(jfxPanel, BorderLayout.CENTER); // MediaView en el centro

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

    private void initMediaPlayer() {
        File file1 = new File("C:\\Users\\Lourdes\\Documents\\NetBeansProjects\\ProyectoProga2\\src\\proyectoproga2\\inicio_GCB.mp4");
        mediaPlayer1 = new MediaPlayer(
                new Media(file1.toURI().toString())
        );

        File file1_1 = new File("C:\\Users\\Lourdes\\Documents\\NetBeansProjects\\ProyectoProga2\\src\\proyectoproga2\\inicio_GCB.mp4");
        mediaPlayer1_1 = new MediaPlayer(
                new Media(file1_1.toURI().toString())
        );

        File file1_2 = new File("C:\\Users\\Lourdes\\Documents\\NetBeansProjects\\ProyectoProga2\\src\\proyectoproga2\\inicio_GCB.mp4");
        mediaPlayer1_2 = new MediaPlayer(
                new Media(file1_2.toURI().toString())
        );

        mediaView1 = new MediaView(mediaPlayer1);
        mediaView1.setPreserveRatio(true);

        mediaView1_1 = new MediaView(mediaPlayer1_1);
        mediaView1_1.setPreserveRatio(true);

        mediaView1_2 = new MediaView(mediaPlayer1_2);
        mediaView1_2.setPreserveRatio(true);

    }

    public void siguienteEscena() {
        if (escenaActual == 1) {
            File file1 = new File("C:\\Users\\Lourdes\\Documents\\NetBeansProjects\\ProyectoProga2\\src\\proyectoproga2\\inicio_GCB.mp4"); // Reemplaza "ruta_del_video3_opcion1.mp4" con la ruta del archivo del video 3 correspondiente a la opción 1
            mediaPlayer1 = new MediaPlayer(new Media(file1.toURI().toString()));
            mediaView1_1 = new MediaView(mediaPlayer1);
            mediaView1.setPreserveRatio(true);
            jfxPanel.setScene(new Scene(new Group(mediaView1)));
            mediaPlayer1.play();
            asiganarTiempo(); // Asegúrate de que este método esté definido en tu clase
            // Detener el video actual si se está reproduciendo
            if (mediaPlayer1.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer1.stop();
            }
            // Mostrar la escena con las opciones de decisión para el usuario
            // y esperar a que el usuario seleccione una opción
            int decisionUsuario = mostrarOpcionesDecision();

            // Cargar y reproducir el siguiente video según la decisión del usuario
            if (decisionUsuario == 1) {
                File file1_1 = new File("C:\\Users\\Lourdes\\Documents\\NetBeansProjects\\ProyectoProga2\\src\\proyectoproga2\\inicio_GCB.mp4"); // Reemplaza "ruta_del_video3_opcion1.mp4" con la ruta del archivo del video 3 correspondiente a la opción 1
                mediaPlayer1_1 = new MediaPlayer(new Media(file1_1.toURI().toString()));
                mediaView1_1 = new MediaView(mediaPlayer1_1);
                mediaView1_1.setPreserveRatio(true);
                jfxPanel.setScene(new Scene(new Group(mediaView1_1)));
                mediaPlayer1_1.play();
                asiganarTiempo(); // Asegúrate de que este método esté definido en tu clase
            } else if (decisionUsuario == 2) {
                File file1_2 = new File("C:\\Users\\Lourdes\\Documents\\NetBeansProjects\\ProyectoProga2\\src\\proyectoproga2\\inicio_GCB.mp4"); // Reemplaza "ruta_del_video3_opcion2.mp4" con la ruta del archivo del video 3 correspondiente a la opción 2
                mediaPlayer1_2 = new MediaPlayer(new Media(file1_2.toURI().toString()));
                mediaView1_2 = new MediaView(mediaPlayer1_2);
                mediaView1_2.setPreserveRatio(true);
                jfxPanel.setScene(new Scene(new Group(mediaView1_2)));
                mediaPlayer1_2.play();
                asiganarTiempo(); // Asegúrate de que este método esté definido en tu clase
            }

            escenaActual++; // Incrementa la escena actual para la siguiente vez
            // Agrega más condiciones if/else if según sea necesario para las demás escenas
        }
    }
    private int opcionSeleccionada = 0;

    private int mostrarOpcionesDecision() {

        // Agrega los botones al panel
        opcionesPanel.add(PELEAR_CON_UN_DIOS);
        opcionesPanel.add(PELEAR_CON_UN_ARBOL);

        // Agrega un ActionListener a cada botón para capturar la opción seleccionada
        PELEAR_CON_UN_DIOS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionSeleccionada = 1;
                signalOpcionSeleccionada();
            }
        });

        PELEAR_CON_UN_ARBOL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Opción 2 seleccionada
                opcionSeleccionada = 2;
                signalOpcionSeleccionada();
            }
        });

         waitForOpcionSeleccionada();

        // Remueve los botones del panel
        opcionesPanel.remove(PELEAR_CON_UN_DIOS);
        opcionesPanel.remove(PELEAR_CON_UN_ARBOL);

        // Devuelve la opción seleccionada por el usuario
        return opcionSeleccionada;
    }

    public int getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    private void signalOpcionSeleccionada() {
        synchronized (lock) {
            opcionSeleccionadaCondition.signal();
        }
    }

    private void waitForOpcionSeleccionada() {
        synchronized (lock) {
            try {
                opcionSeleccionadaCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Panel_Movie = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tiempoTranscurridoLabel = new javax.swing.JLabel();
        barraProgreso = new javax.swing.JSlider();
        tiempoLabel = new javax.swing.JLabel();
        opcionesPanel = new javax.swing.JPanel();
        PELEAR_CON_UN_DIOS = new javax.swing.JButton();
        RETROCEDER = new javax.swing.JButton();
        Pausar_Reproducir = new javax.swing.JButton();
        ADELANTAR = new javax.swing.JButton();
        PELEAR_CON_UN_ARBOL = new javax.swing.JButton();
        VolumeSlider = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(330, 200));
        jLayeredPane1.setLayout(new java.awt.BorderLayout());

        Panel_Movie.setBackground(new java.awt.Color(0, 0, 0));
        Panel_Movie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel_Movie.setPreferredSize(new java.awt.Dimension(344, 226));

        javax.swing.GroupLayout Panel_MovieLayout = new javax.swing.GroupLayout(Panel_Movie);
        Panel_Movie.setLayout(Panel_MovieLayout);
        Panel_MovieLayout.setHorizontalGroup(
            Panel_MovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        Panel_MovieLayout.setVerticalGroup(
            Panel_MovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        jLayeredPane1.setLayer(Panel_Movie, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.add(Panel_Movie, java.awt.BorderLayout.CENTER);

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
                .addContainerGap(12, Short.MAX_VALUE))
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

        jLayeredPane1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        opcionesPanel.setBackground(new java.awt.Color(0, 0, 0));

        PELEAR_CON_UN_DIOS.setBackground(new java.awt.Color(0, 0, 51));
        PELEAR_CON_UN_DIOS.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        PELEAR_CON_UN_DIOS.setForeground(new java.awt.Color(255, 255, 255));
        PELEAR_CON_UN_DIOS.setText("   PELEAR CON UN DIOS  ");
        PELEAR_CON_UN_DIOS.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        opcionesPanel.add(PELEAR_CON_UN_DIOS);

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
        opcionesPanel.add(RETROCEDER);

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
        opcionesPanel.add(Pausar_Reproducir);

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
        opcionesPanel.add(ADELANTAR);

        PELEAR_CON_UN_ARBOL.setBackground(new java.awt.Color(0, 0, 51));
        PELEAR_CON_UN_ARBOL.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        PELEAR_CON_UN_ARBOL.setForeground(new java.awt.Color(255, 255, 255));
        PELEAR_CON_UN_ARBOL.setText("   PELEAR CON UN ARBOL  ");
        PELEAR_CON_UN_ARBOL.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        opcionesPanel.add(PELEAR_CON_UN_ARBOL);

        jLayeredPane1.add(opcionesPanel, java.awt.BorderLayout.PAGE_START);

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
        jLayeredPane1.add(VolumeSlider, java.awt.BorderLayout.LINE_END);

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
    private void Pausar_ReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pausar_ReproducirActionPerformed
        if (oracleVid.getStatus() == MediaPlayer.Status.PLAYING) {
            oracleVid.pause();
        } else if (oracleVid.getStatus() == MediaPlayer.Status.PAUSED) {
            oracleVid.play();
        }
    }//GEN-LAST:event_Pausar_ReproducirActionPerformed

    private void barraProgresoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraProgresoMouseReleased

        //reproduce se obtiene el valor del jSlider1 y se manda al video
        int val = barraProgreso.getValue();
        oracleVid.seek(Duration.seconds(val));

    }//GEN-LAST:event_barraProgresoMouseReleased

    private void VolumeSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolumeSliderMouseReleased
        double val = VolumeSlider.getValue() / 10.0;
        oracleVid.setVolume(val);
    }//GEN-LAST:event_VolumeSliderMouseReleased

    private void ADELANTARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADELANTARMouseClicked

        if (oracleVid.getStatus() == MediaPlayer.Status.PLAYING) {
            // Obtener la posición actual del video
            Duration currentPosition = oracleVid.getCurrentTime();

            // Calcular la nueva posición adelantada
            Duration newPosition = currentPosition.add(Duration.seconds(10)); // Adelanta 10 segundos

            // Establecer la nueva posición del video
            oracleVid.seek(newPosition);
        }
    }//GEN-LAST:event_ADELANTARMouseClicked

    private void RETROCEDERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RETROCEDERMouseClicked
        if (oracleVid.getStatus() == MediaPlayer.Status.PLAYING) {
            // Obtener la posición actual del video
            Duration currentPosition = oracleVid.getCurrentTime();

            // Calcular la nueva posición retrocedida
            Duration newPosition = currentPosition.subtract(Duration.seconds(10)); // Retrocede 10 segundos

            // Establecer la nueva posición del video
            oracleVid.seek(newPosition);
        }
    }//GEN-LAST:event_RETROCEDERMouseClicked

    void asiganarTiempo() {
        VolumeSlider.setMinimum(0);
        VolumeSlider.setMaximum(10);
        double sec = oracleVid.getTotalDuration().toSeconds();
        int val = (int) sec;
        barraProgreso.setMaximum(val);
        tiempoLabel.setText(obtenerMinutos(val));
        hilo.start();
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
    private javax.swing.JButton PELEAR_CON_UN_ARBOL;
    private javax.swing.JButton PELEAR_CON_UN_DIOS;
    private javax.swing.JPanel Panel_Movie;
    private javax.swing.JButton Pausar_Reproducir;
    private javax.swing.JButton RETROCEDER;
    private javax.swing.JSlider VolumeSlider;
    private javax.swing.JSlider barraProgreso;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel opcionesPanel;
    private javax.swing.JLabel tiempoLabel;
    private javax.swing.JLabel tiempoTranscurridoLabel;
    // End of variables declaration//GEN-END:variables
}
