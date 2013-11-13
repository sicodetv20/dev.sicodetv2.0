/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.vistas;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

/**
 *
 * @author Juan
 */
public class CapturarFotoDialog extends javax.swing.JDialog {

    /**
     * Creates new form CapturarFotoDialog
     */
    public CapturarFotoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        panBarraHerramientas = new javax.swing.JToolBar();
        btnConfiguracion = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnCamara = new javax.swing.JButton();
        btnRecapturar = new javax.swing.JButton();
        btnZoomIn = new javax.swing.JButton();
        btnZoomOut = new javax.swing.JButton();
        fotoPanel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panBarraHerramientas.setRollover(true);

        btnConfiguracion.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ve/com/fsjv/devsicodetv/utilitarios/imgs/historiales.png"))); // NOI18N
        btnConfiguracion.setFocusPainted(false);
        btnConfiguracion.setFocusable(false);
        btnConfiguracion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConfiguracion.setMaximumSize(new java.awt.Dimension(42, 37));
        btnConfiguracion.setMinimumSize(new java.awt.Dimension(42, 37));
        btnConfiguracion.setPreferredSize(new java.awt.Dimension(42, 37));
        btnConfiguracion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panBarraHerramientas.add(btnConfiguracion);

        btnAceptar.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ve/com/fsjv/devsicodetv/utilitarios/imgs/Add.png"))); // NOI18N
        btnAceptar.setFocusPainted(false);
        btnAceptar.setFocusable(false);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setMaximumSize(new java.awt.Dimension(42, 37));
        btnAceptar.setMinimumSize(new java.awt.Dimension(42, 37));
        btnAceptar.setPreferredSize(new java.awt.Dimension(42, 37));
        btnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panBarraHerramientas.add(btnAceptar);

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ve/com/fsjv/devsicodetv/utilitarios/imgs/delete.png"))); // NOI18N
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setMaximumSize(new java.awt.Dimension(42, 37));
        btnCancelar.setMinimumSize(new java.awt.Dimension(42, 37));
        btnCancelar.setPreferredSize(new java.awt.Dimension(42, 37));
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panBarraHerramientas.add(btnCancelar);
        panBarraHerramientas.add(filler1);

        btnCamara.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnCamara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ve/com/fsjv/devsicodetv/utilitarios/imgs/camera.png"))); // NOI18N
        btnCamara.setFocusPainted(false);
        btnCamara.setFocusable(false);
        btnCamara.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCamara.setMaximumSize(new java.awt.Dimension(42, 37));
        btnCamara.setMinimumSize(new java.awt.Dimension(42, 37));
        btnCamara.setPreferredSize(new java.awt.Dimension(42, 37));
        btnCamara.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panBarraHerramientas.add(btnCamara);

        btnRecapturar.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnRecapturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ve/com/fsjv/devsicodetv/utilitarios/imgs/update.png"))); // NOI18N
        btnRecapturar.setFocusPainted(false);
        btnRecapturar.setFocusable(false);
        btnRecapturar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRecapturar.setMaximumSize(new java.awt.Dimension(42, 37));
        btnRecapturar.setMinimumSize(new java.awt.Dimension(42, 37));
        btnRecapturar.setPreferredSize(new java.awt.Dimension(42, 37));
        btnRecapturar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panBarraHerramientas.add(btnRecapturar);

        btnZoomIn.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnZoomIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ve/com/fsjv/devsicodetv/utilitarios/imgs/zoom-remove.png"))); // NOI18N
        btnZoomIn.setFocusPainted(false);
        btnZoomIn.setFocusable(false);
        btnZoomIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZoomIn.setMaximumSize(new java.awt.Dimension(42, 37));
        btnZoomIn.setMinimumSize(new java.awt.Dimension(42, 37));
        btnZoomIn.setPreferredSize(new java.awt.Dimension(42, 37));
        btnZoomIn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panBarraHerramientas.add(btnZoomIn);

        btnZoomOut.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnZoomOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ve/com/fsjv/devsicodetv/utilitarios/imgs/zoom-add.png"))); // NOI18N
        btnZoomOut.setFocusPainted(false);
        btnZoomOut.setFocusable(false);
        btnZoomOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZoomOut.setMaximumSize(new java.awt.Dimension(42, 37));
        btnZoomOut.setMinimumSize(new java.awt.Dimension(42, 37));
        btnZoomOut.setPreferredSize(new java.awt.Dimension(42, 37));
        btnZoomOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panBarraHerramientas.add(btnZoomOut);

        fotoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panBarraHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(fotoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(fotoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panBarraHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CapturarFotoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapturarFotoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapturarFotoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapturarFotoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CapturarFotoDialog dialog = new CapturarFotoDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnCamara() {
        return btnCamara;
    }

    public void setBtnCamara(JButton btnCamara) {
        this.btnCamara = btnCamara;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnConfiguracion() {
        return btnConfiguracion;
    }

    public void setBtnConfiguracion(JButton btnConfiguracion) {
        this.btnConfiguracion = btnConfiguracion;
    }

    public JButton getBtnRecapturar() {
        return btnRecapturar;
    }

    public void setBtnRecapturar(JButton btnRecapturar) {
        this.btnRecapturar = btnRecapturar;
    }

    public JButton getBtnZoomIn() {
        return btnZoomIn;
    }

    public void setBtnZoomIn(JButton btnZoomIn) {
        this.btnZoomIn = btnZoomIn;
    }

    public JButton getBtnZoomOut() {
        return btnZoomOut;
    }

    public void setBtnZoomOut(JButton btnZoomOut) {
        this.btnZoomOut = btnZoomOut;
    }

    public Box.Filler getFiller1() {
        return filler1;
    }

    public void setFiller1(Box.Filler filler1) {
        this.filler1 = filler1;
    }

    public JLabel getFotoPanel() {
        return fotoPanel;
    }

    public void setFotoPanel(JLabel fotoPanel) {
        this.fotoPanel = fotoPanel;
    }

    public JToolBar getPanBarraHerramientas() {
        return panBarraHerramientas;
    }

    public void setPanBarraHerramientas(JToolBar panBarraHerramientas) {
        this.panBarraHerramientas = panBarraHerramientas;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCamara;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btnRecapturar;
    private javax.swing.JButton btnZoomIn;
    private javax.swing.JButton btnZoomOut;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel fotoPanel;
    private javax.swing.JToolBar panBarraHerramientas;
    // End of variables declaration//GEN-END:variables
}