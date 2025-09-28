/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.restaurant.orders;

import Controller.PedidosController;
import Models.Extra;
import Models.Platillos;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EFICAZ
 */
public class main {
     public static void main(String[] args) {
         
         PedidosController pControll = new PedidosController();
         
         
         Platillos platillo = new Platillos("Hamburguesa ",8.99);
        Platillos platillo2 = new Platillos("Pizza ", 10.25);
        Platillos platillo3 = new Platillos("Ensalada ", 4.10);
        
        Extra extra = new Extra("Queso",1.50);
        Extra extra2 = new Extra("Bacon",2.50);
        
        List<String> plat = new ArrayList<>();
        plat.add(platillo.getPlatillo());
        plat.add(platillo2.getPlatillo());
        plat.add(platillo3.getPlatillo());
        
        List<Platillos> ArrayPlatillos = new ArrayList<>();
        ArrayPlatillos.add(platillo);
        ArrayPlatillos.add(platillo2);
        ArrayPlatillos.add(platillo3);
        
        List<Extra> ingExtras = new ArrayList<>();
        ingExtras.add(extra);
        ingExtras.add(extra2);
        
        String[] platArr = {platillo.getPlatillo(),platillo2.getPlatillo(),platillo3.getPlatillo()};
        List<JCheckBox> checkBoxes = new ArrayList<>();
         
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        
        
         JPanel panel = new JPanel();
         GridLayout gdlMain = new GridLayout(2,2);
         panel.setLayout(gdlMain);
         
         JPanel panel2 = new JPanel();
         GridLayout gdlPedido = new GridLayout(0, 1);
         panel.setSize(300, 200);
         panel2.setSize(20,50);
         panel2.setLayout(gdlPedido);
        // panel2.setBackground(Color.pink);
         JLabel label = new JLabel("Escoja un platillo:");
         label.setForeground(Color.BLACK);
         
         JComboBox<String> cbx = new JComboBox<>(platArr);
         JButton btn = new JButton("Hacer pedido");
         JButton btnCrear = new JButton("Generar pedido");
         
         btnCrear.addActionListener(e->{        
         pControll.agregar(cbx.getSelectedItem().toString(),ArrayPlatillos, checkBoxes, ingExtras);
         });
         
        
        panel2.add(label);
        panel2.add(cbx);
      
         JFrame jfPedido = new JFrame();
         jfPedido.setSize(600,500);
         jfPedido.add(panel2);
         
         JLabel lblExtra = new JLabel();
         lblExtra.setText("Escoja un ingrediente extra: ");
         lblExtra.setForeground(Color.BLACK);
         panel2.add(lblExtra);
         ingExtras.forEach(e->{
           JCheckBox chxExtra = new JCheckBox();
           chxExtra.setText(e.getExtra());
           panel2.add(chxExtra);
           checkBoxes.add(chxExtra);
         });
         panel2.add(btnCrear);     
         btn.addActionListener(e ->jfPedido.setVisible(true));
         
         
         
         JFrame jfMenu = new JFrame();
         jfMenu.setSize(600, 500);
         JPanel panelMenu = new JPanel();
         panelMenu.setSize(40,20);
         GridLayout glayout = new GridLayout(0,1);
         panelMenu.setLayout(glayout);
         JLabel lblTitle = new JLabel();
         lblTitle.setText("Platillos principales:");
         lblTitle.setForeground(Color.BLACK);
         panelMenu.add(lblTitle);
         ArrayPlatillos.forEach(e->{
         JLabel lblPlatillos = new JLabel();
         lblPlatillos.setText("Comida: "+e.getPlatillo() + " - Costo: "+e.getCosto()+"$");
         
         panelMenu.add(lblPlatillos);
         });
         JLabel lblExtras = new JLabel();
         lblExtras.setText("Ingredientes extras:");
         lblExtras.setForeground(Color.BLACK);
         panelMenu.add(lblExtras);
         
         ingExtras.forEach(e ->{
         JLabel lblExtras2 = new JLabel();
         lblExtras2.setText("Comida: "+e.getExtra()+" - Costo: "+e.getPrecio()+"$");
         panelMenu.add(lblExtras2);
         });
         
         
          JButton btnMenu = new JButton("Ver menu");
         btnMenu.addActionListener(e -> jfMenu.setVisible(true));
         
         
         JButton btnMostrar = new JButton("Mostrar");
       
        //Mostrar pedidos
        
      
        
        
        btnMostrar.addActionListener(e->{
              JFrame jfMostrar = new JFrame();
        jfMostrar.setSize(600,500);
        JPanel jpMostar = new JPanel();
        GridLayout glMostar = new GridLayout(0, 1);
        jpMostar.setSize(600, 500);
        jpMostar.setLayout(glMostar);
        JLabel lblTitleMostrar = new JLabel("Tabla de pedidos");
        lblTitleMostrar.setForeground(Color.BLACK);
        
        
        
         String[] columns = {"Id","Platillo","Costo","Extras","Costo total de extras","Total"};
         
         DefaultTableModel model = new DefaultTableModel(columns, 0);
         pControll.totalPedidos.forEach(ee->{
         List<String> extrass = new ArrayList<>();
         int Total =0;
             for (Extra ext : ee.getExtra()) {
                extrass.add(ext.getExtra());
                Total +=ext.getPrecio();
             }
         model.addRow(new Object[]{ee.getId(),ee.getPlatillo().getPlatillo(),ee.getPlatillo().getCosto(),String.join(", ", extrass),Total,ee.getPlatillo().getCosto()+Total,ee.getEstado()});
         });
         JTable table = new JTable(model);
         JScrollPane spane = new JScrollPane(table);
  
        jpMostar.add(lblTitleMostrar);
        jpMostar.add(spane);
        jfMostrar.add(jpMostar);
            
            
            jfMostrar.setVisible(true);} );
        

        //ACTUALIZAR ESTADO
        
        JFrame jfActualizar = new JFrame();
        jfActualizar.setSize(600, 400);
        
        JPanel jpActualizar = new JPanel();
        GridLayout gdAct = new GridLayout(0, 1);
        jpActualizar.setLayout(gdAct);
        
        JLabel lblTitleAct = new JLabel("PEDIDOS:");
        lblTitleAct.setForeground(Color.BLACK);
         jpActualizar.add(lblTitleAct);
        
        pControll.totalPedidos.forEach(a ->{
           
        JLabel lblId = new JLabel("Id: "+String.valueOf(a.getId()));
        JLabel lblPlatillo = new JLabel("Platillo: "+a.getPlatillo().getPlatillo());
        List<String> arrActExtras = new ArrayList<>();
            for (Extra actExtra : a.getExtra()) {
                arrActExtras.add(actExtra.getExtra());
            }
        JLabel lblActExtra = new JLabel("Extras: "+String.join(", ",arrActExtras));
        JLabel lblEstado = new JLabel(a.getEstado());
        JButton btnAct = new JButton("Actualizar estado");
        btnAct.addActionListener(btns ->{
         lblEstado.setText(pControll.actualizarEstado(a.getId(), a.getEstado()));
        });
        jpActualizar.add(lblId);
        jpActualizar.add(lblPlatillo);
        jpActualizar.add(lblActExtra);
        jpActualizar.add(lblEstado);
        jpActualizar.add(btnAct);
        
        });
        
       
        
        
        jfActualizar.add(jpActualizar);
        
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(q -> jfActualizar.setVisible(true));
        //FRAME PRINCIPAL
          //  panel.add(label);
       // panel.add(cbx);
        panel.add(btn);
        panel.add(btnMenu);
        panel.add(btnMostrar);
        panel.add(btnActualizar);
        frame.add(panel);
       
        frame.setVisible(true);
        jfMenu.add(panelMenu);
        
    }

  /*  public static void main(String[] args) {
        
        Platillos platillo = new Platillos("Hamburguesa ",8.99);
        Platillos platillo2 = new Platillos("Pizza ", 10.25);
        Platillos platillo3 = new Platillos("Ensalada ", 4.10);
        
        Extra extra = new Extra("Queso",1.50);
        Extra extra2 = new Extra("Bacon",2.50);
        
        
        PedidosController pController = new PedidosController();
        pController.agregar(platillo, extra);
        pController.agregar(platillo2, extra2);
        
        System.out.println(pController.totalPedidos);
        
    }*/
}
