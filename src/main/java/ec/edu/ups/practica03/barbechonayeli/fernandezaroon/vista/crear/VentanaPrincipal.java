/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.crear;

import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.eliminar.VentanaEliminarDisco;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.eliminar.VentanaEliminarCompositor;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.eliminar.VentanaEliminarCantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.eliminar.VentanaEliminarCancion;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.Buscar.VentanaBuscarDisco;

import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.Buscar.VentanaBuscarCantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.Buscar.VentanaBuscarCantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.Buscar.VentanaBuscarCancion;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.actualizar.VentanaActualizarDisco;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.actualizar.VentanaActualizarCompositor;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.actualizar.VentanaActualizarCantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.actualizar.VentanaActualizarCancion;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.controlador.ControladorCantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.controlador.ControladorCompositor;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.dao.CantanteDAO;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.dao.CompositorDAO;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Cantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.Buscar.VentanaBuscarCancion2;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.Buscar.VentanaBuscarCompositor;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.Buscar.VentanaBuscarDisco1;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.listar.VentanaListarCancion;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.listar.VentanaListarCantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.listar.VentanaListarCompositor;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.vista.listar.VentanaListarDisco;
import java.awt.Graphics;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    //Ventana Crear
     private VentanaCrearCompositor ventanaCrearCompositor;
    private VentanaCrearCantante ventanaCrearCantante;
    private VentanaCrearDisco ventanaCrearDisco;
    private VentanaCrearCancion ventanaCrearCancion;
    //VentanaActualizar
    private VentanaActualizarCompositor ventanaActualizarCompositor;
    private VentanaActualizarCantante ventanaActualizarCantante;
    private VentanaActualizarCancion ventanaActualizarCancionl;
    private VentanaActualizarDisco ventanaActualizarDisco;
    //Ventana Buscar
    private VentanaBuscarCompositor ventanaBuscarCompositor;
    private VentanaBuscarCantante ventanaBuscarCantante;
    private VentanaBuscarDisco ventanaBuscarDisco;
    private VentanaBuscarDisco1 ventanaBuscarDisco1;
    private VentanaBuscarCancion ventanaBuscarCancion;
    private VentanaBuscarCancion2 ventanaBuscarCancion2;
    //Ventana Eliminar
    private VentanaEliminarCompositor ventanaEliminarCompositor;
    private VentanaEliminarCantante ventanaEliminarCantante;
    private VentanaEliminarDisco ventanaEliminarDisco;
    private VentanaEliminarCancion ventanaEliminarCancion;
    //Ventana Listar
    private VentanaListarCancion ventanaListarCancion;
    private VentanaListarDisco ventanaListarDisco;
    private VentanaListarCompositor ventanaListarCompositor;
    private VentanaListarCantante ventanaListarCantante;
    //private VentanaListarCompositor ventanaListarCompositor;
    //private VentanaListarCantante ventanaListarCantante;
    //private VentanaListarCancion ventanaListarCancion;
    //Controladores
    private ControladorCantante cantanteControlador;
    private ControladorCompositor compositorControlador;
    private Cantante cantante;
    //DAO
    private CantanteDAO cantanteDAO;
    private CompositorDAO compositorDAO;
    //Internacionalizacion
    private Locale localizacion;
    private ResourceBundle mensajes;
   
    
   
    

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        cantanteDAO= new CantanteDAO();
        compositorDAO= new CompositorDAO();
        cantanteControlador= new ControladorCantante(cantanteDAO);
        compositorControlador= new ControladorCompositor(compositorDAO);
        
        localizacion = Locale.getDefault();                
        cambiarIdioma();
        
    }
    
 private void cambiarIdioma(){
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        menuCompositor.setText(mensajes.getString("menu.compositor"));
        menuCantante.setText(mensajes.getString("menu.cantante"));
        menuCancion.setText(mensajes.getString("menu.cancion"));
        menuItemCrearCancion.setText(mensajes.getString("menu.crear"));
        menuItemCrearCantante.setText(mensajes.getString("menu.crear"));
        menuItemCrearCompositor.setText(mensajes.getString("menu.crear"));
        menuItemCrearDisco.setText(mensajes.getString("menu.crear"));
        menuItemBuscarCancion.setText(mensajes.getString("menu.buscar"));
        menuItemBuscarDisco.setText(mensajes.getString("menu.buscar"));
        menuItemBuscarCompositor.setText(mensajes.getString("menu.buscar"));
        menuItemBuscarCantante.setText(mensajes.getString("menu.buscar"));
        menuItemActualizarCancion.setText(mensajes.getString("menu.actualizar"));
        menuItemActualizarDisco.setText(mensajes.getString("menu.actualizar"));
        menuItemActualizarCantante.setText(mensajes.getString("menu.actualizar"));
        menuItemActualizarCompositor.setText(mensajes.getString("menu.actualizar"));
        menuItemEliminarCancion.setText(mensajes.getString("menu.eliminar"));
        menuItemEliminarCantante.setText(mensajes.getString("menu.eliminar"));
        menuItemEliminarCompositor.setText(mensajes.getString("menu.eliminar"));
        menuItemEliminarDisco.setText(mensajes.getString("menu.eliminar"));

        menuIdiomas.setText(mensajes.getString("menu.idiomas"));
        
        if(ventanaCrearCompositor != null){
            ventanaCrearCompositor.cambiarIdioma(localizacion);
        }
        if(ventanaCrearCantante != null){
            ventanaCrearCantante.cambiarIdioma(localizacion);
        }
        if(ventanaCrearDisco != null){
            ventanaCrearDisco.cambiarIdioma(localizacion);
        }
        if(ventanaCrearCancion != null){
            ventanaCrearCancion.cambiarIdioma(localizacion);
        }
        if(ventanaBuscarCompositor != null){
            ventanaBuscarCompositor.cambiarIdioma(localizacion);
        }
        if(ventanaBuscarCantante != null){
            ventanaBuscarCantante.cambiarIdioma(localizacion);
        }
         if(ventanaBuscarCancion != null){
            ventanaBuscarCancion.cambiarIdioma(localizacion);
        }
          if(ventanaBuscarCancion2 != null){
            ventanaBuscarCancion2.cambiarIdioma(localizacion);
        }
           if(ventanaBuscarDisco != null){
            ventanaBuscarDisco.cambiarIdioma(localizacion);
        }
           if(ventanaBuscarDisco1 != null){
            ventanaBuscarDisco1.cambiarIdioma(localizacion);
           }
            if(ventanaActualizarCancionl != null){
            ventanaActualizarCancionl.cambiarIdioma(localizacion);
           }
            if(ventanaActualizarCantante != null){
            ventanaActualizarCantante.cambiarIdioma(localizacion);
            }
            if(ventanaActualizarCompositor != null){
            ventanaActualizarCompositor.cambiarIdioma(localizacion);
            }
            if(ventanaActualizarDisco != null){
            ventanaActualizarDisco.cambiarIdioma(localizacion);
           
        
 }
 }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jPanel = new javax.swing.JPanel();
        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCompositor = new javax.swing.JMenu();
        menuItemCrearCompositor = new javax.swing.JMenuItem();
        menuItemBuscarCompositor = new javax.swing.JMenuItem();
        menuItemActualizarCompositor = new javax.swing.JMenuItem();
        menuItemEliminarCompositor = new javax.swing.JMenuItem();
        menuItemListarCompositor = new javax.swing.JMenuItem();
        menuCantante = new javax.swing.JMenu();
        menuItemCrearCantante = new javax.swing.JMenuItem();
        menuItemBuscarCantante = new javax.swing.JMenuItem();
        menuItemActualizarCantante = new javax.swing.JMenuItem();
        menuItemEliminarCantante = new javax.swing.JMenuItem();
        menuItemListarCantante = new javax.swing.JMenuItem();
        menuCancion = new javax.swing.JMenu();
        menuItemCrearCancion = new javax.swing.JMenuItem();
        menuItemBuscarCancion = new javax.swing.JMenuItem();
        menuItemActualizarCancion = new javax.swing.JMenuItem();
        menuItemEliminarCancion = new javax.swing.JMenuItem();
        menuItemListarCancion = new javax.swing.JMenuItem();
        menuItemBuscarCancionCodigo = new javax.swing.JMenuItem();
        menuDisco = new javax.swing.JMenu();
        menuItemCrearDisco = new javax.swing.JMenuItem();
        menuItemBuscarDisco = new javax.swing.JMenuItem();
        menuItemActualizarDisco = new javax.swing.JMenuItem();
        menuItemEliminarDisco = new javax.swing.JMenuItem();
        menuItemListarDisco = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuIdiomas = new javax.swing.JMenu();
        menuItemEspañol = new javax.swing.JMenuItem();
        menuItemIngles = new javax.swing.JMenuItem();
        menuItemFrances = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem9.setText("jMenuItem9");

        jMenuItem10.setText("jMenuItem10");

        jMenuItem17.setText("jMenuItem17");

        jMenuItem21.setText("jMenuItem21");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem3.setText("jMenuItem3");

        jMenu2.setText("jMenu2");

        jMenuItem23.setText("jMenuItem23");

        jMenuItem26.setText("jMenuItem26");

        jPanel.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/3df00f73c3fb7df0305ec950261eddeb.jpg"))); // NOI18N

        desktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menuCompositor.setText("Compositor");

        menuItemCrearCompositor.setText("Crear");
        menuItemCrearCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(menuItemCrearCompositor);

        menuItemBuscarCompositor.setText("Buscar");
        menuItemBuscarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(menuItemBuscarCompositor);

        menuItemActualizarCompositor.setText("Actualizar");
        menuCompositor.add(menuItemActualizarCompositor);

        menuItemEliminarCompositor.setText("Eliminar");
        menuItemEliminarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEliminarCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(menuItemEliminarCompositor);

        menuItemListarCompositor.setText("Listar");
        menuCompositor.add(menuItemListarCompositor);

        jMenuBar1.add(menuCompositor);

        menuCantante.setText("Cantante");

        menuItemCrearCantante.setText("Crear");
        menuItemCrearCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemCrearCantante);

        menuItemBuscarCantante.setText("Buscar");
        menuItemBuscarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemBuscarCantante);

        menuItemActualizarCantante.setText("Actualizar");
        menuItemActualizarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemActualizarCantante);

        menuItemEliminarCantante.setText("Eliminar");
        menuCantante.add(menuItemEliminarCantante);

        menuItemListarCantante.setText("Listar");
        menuCantante.add(menuItemListarCantante);

        jMenuBar1.add(menuCantante);

        menuCancion.setText("Cancion");

        menuItemCrearCancion.setText("Crear");
        menuItemCrearCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearCancionActionPerformed(evt);
            }
        });
        menuCancion.add(menuItemCrearCancion);

        menuItemBuscarCancion.setText("Buscar(Titulo)");
        menuItemBuscarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarCancionActionPerformed(evt);
            }
        });
        menuCancion.add(menuItemBuscarCancion);

        menuItemActualizarCancion.setText("Actualizar");
        menuCancion.add(menuItemActualizarCancion);

        menuItemEliminarCancion.setText("Eliminar");
        menuCancion.add(menuItemEliminarCancion);

        menuItemListarCancion.setText("Listar");
        menuItemListarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListarCancionActionPerformed(evt);
            }
        });
        menuCancion.add(menuItemListarCancion);

        menuItemBuscarCancionCodigo.setText("Buscar (Codigo)");
        menuItemBuscarCancionCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarCancionCodigoActionPerformed(evt);
            }
        });
        menuCancion.add(menuItemBuscarCancionCodigo);

        jMenuBar1.add(menuCancion);

        menuDisco.setText("Disco");

        menuItemCrearDisco.setText("Crear");
        menuItemCrearDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearDiscoActionPerformed(evt);
            }
        });
        menuDisco.add(menuItemCrearDisco);

        menuItemBuscarDisco.setText("Buscar(nombre)");
        menuItemBuscarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarDiscoActionPerformed(evt);
            }
        });
        menuDisco.add(menuItemBuscarDisco);

        menuItemActualizarDisco.setText("Actualizar");
        menuDisco.add(menuItemActualizarDisco);

        menuItemEliminarDisco.setText("Eliminar");
        menuDisco.add(menuItemEliminarDisco);

        menuItemListarDisco.setText("Listar");
        menuItemListarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListarDiscoActionPerformed(evt);
            }
        });
        menuDisco.add(menuItemListarDisco);

        jMenuItem4.setText("Buscar(codigo)");
        menuDisco.add(jMenuItem4);

        jMenuBar1.add(menuDisco);

        menuIdiomas.setText("Idiomas");

        menuItemEspañol.setText("Español");
        menuItemEspañol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEspañolActionPerformed(evt);
            }
        });
        menuIdiomas.add(menuItemEspañol);

        menuItemIngles.setText("Ingles");
        menuItemIngles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInglesActionPerformed(evt);
            }
        });
        menuIdiomas.add(menuItemIngles);

        menuItemFrances.setText("Frances");
        menuItemFrances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFrancesActionPerformed(evt);
            }
        });
        menuIdiomas.add(menuItemFrances);

        jMenuBar1.add(menuIdiomas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemCrearCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearCompositorActionPerformed
         if (ventanaCrearCompositor == null) {
            ventanaCrearCompositor = new VentanaCrearCompositor(compositorControlador);
            desktopPane.add(ventanaCrearCompositor);
        }
         ventanaCrearCompositor.cambiarIdioma(localizacion);
        ventanaCrearCompositor.setVisible(true);
        
        
    }//GEN-LAST:event_menuItemCrearCompositorActionPerformed

    private void menuItemBuscarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarCompositorActionPerformed
         if (ventanaBuscarCompositor == null) {
            ventanaBuscarCompositor = new VentanaBuscarCompositor(compositorControlador,cantanteControlador);
            desktopPane.add(ventanaBuscarCompositor);
        }
        ventanaCrearCompositor.cambiarIdioma(localizacion);
        ventanaBuscarCompositor.setVisible(true);
    }//GEN-LAST:event_menuItemBuscarCompositorActionPerformed

    private void menuItemEliminarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEliminarCompositorActionPerformed
        
    }//GEN-LAST:event_menuItemEliminarCompositorActionPerformed

    private void menuItemCrearCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearCantanteActionPerformed
         if (ventanaCrearCantante == null) {
            ventanaCrearCantante = new VentanaCrearCantante(cantanteControlador);
            desktopPane.add(ventanaCrearCantante);
        }
        ventanaCrearCantante.cambiarIdioma(localizacion);
        ventanaCrearCantante.setVisible(true);
    }//GEN-LAST:event_menuItemCrearCantanteActionPerformed

    private void menuItemBuscarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarCantanteActionPerformed
         if (ventanaBuscarCantante == null) {
            ventanaBuscarCantante = new VentanaBuscarCantante(cantanteControlador);
            desktopPane.add(ventanaBuscarCantante);
        }
        //ventanaBuscarCantante.cambiarIdioma(localizacion);
        ventanaBuscarCantante.setVisible(true);
    }//GEN-LAST:event_menuItemBuscarCantanteActionPerformed

    private void menuItemActualizarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarCantanteActionPerformed
        if (ventanaActualizarCantante== null) {
            ventanaActualizarCantante = new VentanaActualizarCantante(cantanteControlador);
            desktopPane.add(ventanaActualizarCantante);
        }
        //ventanaActualizarCantante.cambiarIdioma(localizacion);
        ventanaActualizarCantante.setVisible(true);
    }//GEN-LAST:event_menuItemActualizarCantanteActionPerformed

    private void menuItemCrearDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearDiscoActionPerformed
        if (ventanaCrearDisco== null) {
            ventanaCrearDisco = new VentanaCrearDisco(cantanteControlador);
            desktopPane.add(ventanaCrearDisco);
        }
        ventanaCrearDisco.cambiarIdioma(localizacion);
        ventanaCrearDisco.setVisible(true);
    }//GEN-LAST:event_menuItemCrearDiscoActionPerformed

    private void menuItemCrearCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearCancionActionPerformed
        if (ventanaCrearCancion== null) {
            ventanaCrearCancion = new VentanaCrearCancion(compositorControlador);
            desktopPane.add(ventanaCrearCancion);
        }
        ventanaCrearCancion.cambiarIdioma(localizacion);
        ventanaCrearCancion.setVisible(true);
    }//GEN-LAST:event_menuItemCrearCancionActionPerformed

    private void menuItemBuscarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarDiscoActionPerformed
       if (ventanaBuscarDisco== null) {
            ventanaBuscarDisco = new VentanaBuscarDisco(cantanteControlador);
            desktopPane.add(ventanaBuscarDisco);
        }
        
        ventanaBuscarDisco.setVisible(true);
    }//GEN-LAST:event_menuItemBuscarDiscoActionPerformed

    private void menuItemListarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListarCancionActionPerformed
         if (ventanaListarCancion== null) {
            ventanaListarCancion = new VentanaListarCancion(compositorControlador);
            desktopPane.add(ventanaListarCancion);
        }
        
        ventanaListarCancion.setVisible(true);
    }//GEN-LAST:event_menuItemListarCancionActionPerformed

    private void menuItemListarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListarDiscoActionPerformed
        if (ventanaListarDisco== null) {
            ventanaListarDisco = new VentanaListarDisco(cantanteControlador);
            desktopPane.add(ventanaListarDisco);
        }
        
        ventanaListarDisco.setVisible(true);
    }//GEN-LAST:event_menuItemListarDiscoActionPerformed

    private void menuItemInglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInglesActionPerformed
        localizacion = new Locale("en", "US");
        cambiarIdioma();
    }//GEN-LAST:event_menuItemInglesActionPerformed

    private void menuItemEspañolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEspañolActionPerformed
localizacion = new Locale("es", "EC");
        cambiarIdioma();
    }//GEN-LAST:event_menuItemEspañolActionPerformed

    private void menuItemFrancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFrancesActionPerformed
        localizacion = new Locale("fr", "FR");
        cambiarIdioma();
    }//GEN-LAST:event_menuItemFrancesActionPerformed

    private void menuItemBuscarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarCancionActionPerformed
        if (ventanaBuscarCancion== null) {
            ventanaBuscarCancion = new VentanaBuscarCancion(compositorControlador);
            desktopPane.add(ventanaBuscarCancion);
        }
        ventanaBuscarCancion.cambiarIdioma(localizacion);
        ventanaBuscarCancion.setVisible(true);
    }//GEN-LAST:event_menuItemBuscarCancionActionPerformed

    private void menuItemBuscarCancionCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarCancionCodigoActionPerformed
        if (ventanaBuscarCancion2== null) {
            ventanaBuscarCancion2 = new VentanaBuscarCancion2(compositorControlador);
            desktopPane.add(ventanaBuscarCancion2);
        }
        ventanaBuscarCancion2.cambiarIdioma(localizacion);
        ventanaBuscarCancion2.setVisible(true);
    }//GEN-LAST:event_menuItemBuscarCancionCodigoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JMenu menuCancion;
    private javax.swing.JMenu menuCantante;
    private javax.swing.JMenu menuCompositor;
    private javax.swing.JMenu menuDisco;
    private javax.swing.JMenu menuIdiomas;
    private javax.swing.JMenuItem menuItemActualizarCancion;
    private javax.swing.JMenuItem menuItemActualizarCantante;
    private javax.swing.JMenuItem menuItemActualizarCompositor;
    private javax.swing.JMenuItem menuItemActualizarDisco;
    private javax.swing.JMenuItem menuItemBuscarCancion;
    private javax.swing.JMenuItem menuItemBuscarCancionCodigo;
    private javax.swing.JMenuItem menuItemBuscarCantante;
    private javax.swing.JMenuItem menuItemBuscarCompositor;
    private javax.swing.JMenuItem menuItemBuscarDisco;
    private javax.swing.JMenuItem menuItemCrearCancion;
    private javax.swing.JMenuItem menuItemCrearCantante;
    private javax.swing.JMenuItem menuItemCrearCompositor;
    private javax.swing.JMenuItem menuItemCrearDisco;
    private javax.swing.JMenuItem menuItemEliminarCancion;
    private javax.swing.JMenuItem menuItemEliminarCantante;
    private javax.swing.JMenuItem menuItemEliminarCompositor;
    private javax.swing.JMenuItem menuItemEliminarDisco;
    private javax.swing.JMenuItem menuItemEspañol;
    private javax.swing.JMenuItem menuItemFrances;
    private javax.swing.JMenuItem menuItemIngles;
    private javax.swing.JMenuItem menuItemListarCancion;
    private javax.swing.JMenuItem menuItemListarCantante;
    private javax.swing.JMenuItem menuItemListarCompositor;
    private javax.swing.JMenuItem menuItemListarDisco;
    // End of variables declaration//GEN-END:variables

}
