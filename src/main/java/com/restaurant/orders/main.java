/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.restaurant.orders;

import Controller.PedidosController;
import Models.Extra;
import Models.Platillos;

/**
 *
 * @author EFICAZ
 */
public class main {

    public static void main(String[] args) {
        
        Platillos platillo = new Platillos("Hamburguesa ",8.99);
        Platillos platillo2 = new Platillos("Pizza ", 10.25);
        Platillos platillo3 = new Platillos("Ensalada ", 4.10);
        
        Extra extra = new Extra("Queso",1.50);
        Extra extra2 = new Extra("Bacon",2.50);
        
        
        PedidosController pController = new PedidosController();
        pController.agregar(platillo, extra);
        pController.agregar(platillo2, extra2);
        
        System.out.println(pController.totalPedidos);
        
    }
}
