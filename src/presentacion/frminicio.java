/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package presentacion;

/**
 *
 * @author david
 */
public class frminicio extends javax.swing.JFrame {

    /**
     * Creates new form frminicio
     */
    public frminicio() {
        initComponents();
       this.setExtendedState(frminicio.MAXIMIZED_BOTH);
       this.setTitle("Sistema de Gestión de Reserva.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        lblidpersona = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblprimerapellido = new javax.swing.JLabel();
        lblsegapelldio = new javax.swing.JLabel();
        lblacceso = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        menuarchivo = new javax.swing.JMenu();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        menuconficuracion = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(204, 204, 204));
        escritorio.setForeground(new java.awt.Color(0, 0, 0));

        lblidpersona.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblidpersona.setForeground(new java.awt.Color(0, 0, 0));
        escritorio.add(lblidpersona);
        lblidpersona.setBounds(20, 20, 120, 0);

        lblnombre.setBackground(new java.awt.Color(0, 0, 0));
        lblnombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(255, 255, 255));
        lblnombre.setText("lblnombre");
        escritorio.add(lblnombre);
        lblnombre.setBounds(20, 50, 60, 16);

        lblprimerapellido.setBackground(new java.awt.Color(0, 0, 0));
        lblprimerapellido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblprimerapellido.setForeground(new java.awt.Color(255, 255, 255));
        lblprimerapellido.setText("lblprimerapellido");
        escritorio.add(lblprimerapellido);
        lblprimerapellido.setBounds(80, 50, 70, 16);

        lblsegapelldio.setBackground(new java.awt.Color(0, 0, 0));
        lblsegapelldio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblsegapelldio.setForeground(new java.awt.Color(255, 255, 255));
        lblsegapelldio.setText("lblsegapelldio");
        escritorio.add(lblsegapelldio);
        lblsegapelldio.setBounds(140, 50, 70, 16);

        lblacceso.setBackground(new java.awt.Color(0, 0, 0));
        lblacceso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblacceso.setForeground(new java.awt.Color(255, 255, 255));
        lblacceso.setText("acceso");
        escritorio.add(lblacceso);
        lblacceso.setBounds(20, 90, 120, 16);

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hogar.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("Sist. Reserva");
        menuBar.add(fileMenu);

        menuarchivo.setMnemonic('e');
        menuarchivo.setText("Archivo");

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Habitaciones");
        pasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuItemActionPerformed(evt);
            }
        });
        menuarchivo.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Productos");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        menuarchivo.add(deleteMenuItem);

        menuBar.add(menuarchivo);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Reservas");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Reservas y Consumo");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Clientes");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        menuconficuracion.setText("Configuración");

        jMenuItem2.setText("Usuarios y Accesos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuconficuracion.add(jMenuItem2);

        menuBar.add(menuconficuracion);

        jMenu5.setText("Salir");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        menuBar.add(jMenu5);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuItemActionPerformed
        frmhabitacion form = new frmhabitacion();
        escritorio. add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_pasteMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        frmcliente form = new frmcliente();
        escritorio. add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        frmproducto form = new frmproducto();
        escritorio. add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        frmtrabajador form = new frmtrabajador();
        escritorio. add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        this.dispose();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        frmreserva form = new frmreserva();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        frmreserva.txtidtrabajador.setText(lblidpersona.getText());
        frmreserva.txttrabajador.setText(lblnombre.getText() + " " + lblprimerapellido.getText());
        frmreserva.idusuario=Integer.parseInt(lblidpersona.getText());
        
    }//GEN-LAST:event_contentMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frminicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem2;
    public static javax.swing.JLabel lblacceso;
    public static javax.swing.JLabel lblidpersona;
    public static javax.swing.JLabel lblnombre;
    public static javax.swing.JLabel lblprimerapellido;
    public static javax.swing.JLabel lblsegapelldio;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu menuarchivo;
    public static javax.swing.JMenu menuconficuracion;
    private javax.swing.JMenuItem pasteMenuItem;
    // End of variables declaration//GEN-END:variables

}
