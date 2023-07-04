/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.actualizar;

import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.controlador.ControladorCantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Cantante;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class VentanaActualizarCantante extends javax.swing.JInternalFrame {
 private ControladorCantante cantanteControlador;
 private ResourceBundle mensajes;
    /**
     * Creates new form VentanaActualizarCantante
     */
    public VentanaActualizarCantante(ControladorCantante cantanteControlador) {
        initComponents();
        this.cantanteControlador=cantanteControlador;
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
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblNacionalidad = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        lblNombreArtistico = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNacionalidad = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNombreArtistico = new javax.swing.JTextField();
        lblGeneroMusical = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        txtNumeroSencillos = new javax.swing.JTextField();
        lblConciertos = new javax.swing.JLabel();
        lblGiras = new javax.swing.JLabel();
        txtNumeroConciertos = new javax.swing.JTextField();
        txtNumeroGiras = new javax.swing.JTextField();
        lblSencillos = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Compositor"), "Buscar Cantante"));

        lblCodigo.setText("Codigo");

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido:");

        lblEdad.setText("Edad:");

        lblNacionalidad.setText("Nacionalidad:");

        lblSalario.setText("Salario:");

        lblNombreArtistico.setText("Nombre Artistico");

        txtNombre.setEditable(false);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtEdad.setEditable(false);

        txtApellido.setEditable(false);

        txtNacionalidad.setEditable(false);

        txtSalario.setEditable(false);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        txtNombreArtistico.setEditable(false);
        txtNombreArtistico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreArtisticoActionPerformed(evt);
            }
        });

        lblGeneroMusical.setText("Genero Musical");

        txtGenero.setEditable(false);

        txtNumeroSencillos.setEditable(false);

        lblConciertos.setText("Numero de conciertos:");

        lblGiras.setText("Numero de giras:");

        txtNumeroConciertos.setEditable(false);

        txtNumeroGiras.setEditable(false);

        lblSencillos.setText("Numero de Sencillos:");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblApellido)
                                    .addComponent(lblNacionalidad))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addGap(71, 71, 71)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreArtistico)
                                    .addComponent(lblGeneroMusical))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreArtistico)
                                    .addComponent(txtGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))))
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAceptar)
                        .addGap(85, 85, 85)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalario))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblSencillos)
                                .addComponent(lblGiras)
                                .addComponent(lblConciertos)))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumeroConciertos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroGiras, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroSencillos, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalario)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEdad)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConciertos)
                    .addComponent(txtNumeroConciertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNacionalidad)
                    .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGiras)
                    .addComponent(txtNumeroGiras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreArtistico)
                    .addComponent(txtNombreArtistico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSencillos)
                    .addComponent(txtNumeroSencillos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGeneroMusical)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String codigo= txtCodigo.getText();

        int codigoUno=Integer.parseInt(codigo);

        Cantante cantante = cantanteControlador.buscar(codigoUno);

        if (cantante != null) {
            txtNombreArtistico.setText(cantante.getNombreArtistico());
            txtNombre.setText(cantante.getNombre());
            txtApellido.setText(cantante.getApellido());
            txtGenero.setText(cantante.getGeneroMusica());
            txtNacionalidad.setText(cantante.getNacionalidad());
            txtEdad.setText(cantante.getEdad()+"");
            txtNumeroConciertos.setText(cantante.getNumeroDeConciertos()+"");
            txtNumeroGiras.setText(cantante.getNumeroDeGiras()+"");
            txtNumeroSencillos.setText(cantante.getNumeroDeSencillos()+"");
            txtSalario.setText(cantante.getSalario()+"");

            cantante.setCodigo(codigoUno);

        }else{
            JOptionPane.showMessageDialog(this, "La persona con la cedula"+codigoUno+"No fue econtrada");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
public void cambiarIdioma(Locale localizacion){
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        lblCodigo.setText(mensajes.getString("lblcodigo"));
        lblNombre.setText(mensajes.getString("lblnombre"));
        lblApellido.setText(mensajes.getString("lblapellido"));
        lblNacionalidad.setText(mensajes.getString("lblnacionalidad"));
        lblNombreArtistico.setText(mensajes.getString("lblartistico"));
        lblGeneroMusical.setText(mensajes.getString("lblgenero"));
        lblConciertos.setText(mensajes.getString("lblconciertos"));
        lblGiras.setText(mensajes.getString("lblgiras"));
        lblSencillos.setText(mensajes.getString("lblsencillos"));
        lblEdad.setText(mensajes.getString("lbledad"));
        lblSalario.setText(mensajes.getString("lblsalario"));
        btnBuscar.setText(mensajes.getString("btnbuscar"));
        btnCancelar.setText(mensajes.getString("btncancelar"));
    }
    private void txtNombreArtisticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreArtisticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreArtisticoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       String codigo=txtCodigo.getText();
        String nombre=txtNombre.getText();
        String apellido=txtApellido.getText();
        String nacionalidad= txtNacionalidad.getText();
        String salario=txtSalario.getText();
        String nombreArtistico=txtNombreArtistico.getText();
        String numeroSencillos= txtNumeroSencillos.getText();
        String numeroConciertos=txtNumeroSencillos.getText();
        String numeroGiras= txtNumeroGiras.getText();
        String generoMusical=txtGenero.getText();
        String edad=txtEdad.getText();
        int codigoUno=Integer.parseInt(codigo);
        int edadUno=Integer.parseInt(edad);
        double salarioUno=Double.parseDouble(salario);
        int numeroSencillosUno=Integer.parseInt(numeroSencillos);
        int numeroConciertoUno=Integer.parseInt(numeroConciertos);
        int numeroGirasUno=Integer.parseInt(numeroGiras);
        Cantante cantante= new Cantante();
        cantante.setNombre(nombre);
        cantante.setNacionalidad(nacionalidad);
        cantante.setCodigo(codigoUno);
        cantante.setApellido(apellido);
        cantante.setGeneroMusica(generoMusical);
        cantante.setNombreArtistico(nombreArtistico);
        cantante.setNumeroDeConciertos(numeroConciertoUno);
        cantante.setEdad(edadUno);
        cantante.setSalario(salarioUno);
        cantante.setNumeroDeGiras(numeroGirasUno);
        cantante.setNumeroDeSencillos(numeroSencillosUno);
        if(cantanteControlador.actualizar(cantante)){
            JOptionPane.showMessageDialog(this, "El compositor ha sido actualizado exitosamente! :)");
            this.limpiarCampos();   
            this.cambiarEstadoCampos(false);
        }else{
            JOptionPane.showMessageDialog(this, "La persona no ha sido actualizada! :(");
        }
    }//GEN-LAST:event_btnAceptarActionPerformed
private void limpiarCampos(){
    this.txtCodigo.setText("");
    
    this.txtNombre.setText("");
    this.txtApellido.setText("");
    this.txtNacionalidad.setText("");
    this.txtSalario.setText("");
    this.txtGenero.setText("");
    this.txtNombreArtistico.setText("");
    this.txtNumeroSencillos.setText("");
    this.txtNumeroConciertos.setText("");
    this.txtNumeroGiras.setText("");
    this.txtEdad.setText("");
}
private void cambiarEstadoCampos(boolean estado){
    this.txtCodigo.setEnabled(estado);
    
    this.txtNombre.setEnabled(estado);
    this.txtApellido.setEnabled(estado);
    this.txtNacionalidad.setEnabled(estado);
    this.txtSalario.setEnabled(estado);
    this.txtGenero.setEnabled(estado);
    this.txtNombreArtistico.setEnabled(estado);
    this.txtNumeroSencillos.setEnabled(estado);
    this.txtNumeroConciertos.setEnabled(estado);
    this.txtNumeroGiras.setEnabled(estado);
    this.txtEdad.setEnabled(estado);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblConciertos;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblGeneroMusical;
    private javax.swing.JLabel lblGiras;
    private javax.swing.JLabel lblNacionalidad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreArtistico;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSencillos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreArtistico;
    private javax.swing.JTextField txtNumeroConciertos;
    private javax.swing.JTextField txtNumeroGiras;
    private javax.swing.JTextField txtNumeroSencillos;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
