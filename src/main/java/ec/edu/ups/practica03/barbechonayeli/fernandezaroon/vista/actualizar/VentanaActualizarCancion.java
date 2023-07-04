/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.actualizar;

import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.controlador.ControladorCompositor;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Cancion;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Compositor;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class VentanaActualizarCancion extends javax.swing.JInternalFrame {
ControladorCompositor compositorControlador;
private ResourceBundle mensajes;
    /**
     * Creates new form VentanaActualizarCancion
     */
    public VentanaActualizarCancion(ControladorCompositor compositorControlador) {
        initComponents();
        this.compositorControlador=compositorControlador;
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
        lblCodigo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblLetra = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtLetra = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        bntCancelar = new javax.swing.JButton();
        lblTiempo = new javax.swing.JLabel();
        txtTiempo = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Cancion"));

        lblCodigo.setText("Codigo:");

        lblTitulo.setText("Titulo:");

        lblLetra.setText("Letra:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        bntCancelar.setText("Cancelar");

        lblTiempo.setText("Tiempo en minutos:");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTiempo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo)
                            .addComponent(lblTitulo)
                            .addComponent(lblLetra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLetra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addComponent(btnBuscar)
                .addGap(147, 147, 147))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btnAceptar)
                .addGap(92, 92, 92)
                .addComponent(bntCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLetra)
                    .addComponent(txtLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTiempo)
                    .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       String titulo= txtTitulo.getText();
        
        String codigo=txtCodigo.getText();
       
       String letra=txtLetra.getText();
       
        
         Cancion cancion = compositorControlador.buscarCancionPorTitulo(titulo);
         
        if (cancion != null) { 
        txtCodigo.setText(cancion.getCodigo()+"");
        txtLetra.setText(cancion.getLetra());
        
        
        cancion.setTitulo(titulo);
        
        }else{
            JOptionPane.showMessageDialog(this, "La cancion con el titulo"+titulo+"No fue econtrado");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String codigo=txtCodigo.getText();
        String letra=txtLetra.getText();
        String titulo=txtTitulo.getText();
        String tiempoU=txtTiempo.getText();
        int codigoUno=Integer.parseInt(codigo);
        double tiempo=Double.parseDouble(tiempoU);
        
        Cancion cancion=new Cancion(codigoUno, titulo, letra, SOMEBITS);
        cancion.setCodigo(codigoUno);
        cancion.setLetra(letra);
        cancion.setTiempoEnMinutos(tiempo);
        
        if(compositorControlador.actualizarCancion(cancion)){
            JOptionPane.showMessageDialog(this, "La cancion ha sido actualizado exitosamente! :)");
            this.limpiarCampos();   
            this.cambiarEstadoCampos(false);
        }else{
            JOptionPane.showMessageDialog(this, "La cancion no ha sido actualizada! :(");
        }
    }//GEN-LAST:event_btnAceptarActionPerformed
private void cambiarEstadoCampos(boolean estado){
        this.txtCodigo.setEnabled(!estado);
        this.txtTitulo.setEnabled(estado);
        this.txtLetra.setEnabled(estado);
        this.txtTiempo.setEnabled(estado);
        
    }
private void limpiarCampos(){
    this.txtCodigo.setText("");
    
    this.txtTitulo.setText("");
    this.txtLetra.setText("");
    this.txtTiempo.setText("");
    
}
public void cambiarIdioma(Locale localizacion){
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        lblCodigo.setText(mensajes.getString("lblcodigo"));
        
        lblLetra.setText(mensajes.getString("lblletra"));
        lblTitulo.setText(mensajes.getString("lbltitulo"));
        lblTiempo.setText(mensajes.getString("lbltiempo"));
        btnBuscar.setText(mensajes.getString("btnbuscar"));
        btnAceptar.setText(mensajes.getString("btnaceptar"));
        bntCancelar.setText(mensajes.getString("btncancelar"));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblLetra;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtLetra;
    private javax.swing.JTextField txtTiempo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
