/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurant.orders;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author EFICAZ
 */
public class PedidosController {
    
    int count = 0;
  public List<Pedidos> totalPedidos = new ArrayList<>();
  
    
    public void agregar(String plats,List<Platillos> platArr, List<JCheckBox> chxBoxes,List<Extra> arrExtra){
        count++; 
        Pedidos pedidos = new Pedidos();
        platArr.forEach(e ->{
        if(plats.equals(e.getPlatillo())){
            pedidos.setPlatillo(e);  
        }
        });
        
       
      
       pedidos.setEstado("PENDIENTE");
        pedidos.setId(count);
       
        chxBoxes.forEach(e ->{
        if(e.isSelected()){
            for (Extra extra : arrExtra) {
                if(extra.getExtra().equals(e.getText())){
                    pedidos.getExtra().add(extra);
                }
            }
        }
        });
        
        totalPedidos.add(pedidos);
        JOptionPane.showMessageDialog(null, "Pedido generado con exito!");
    }
    
    public String actualizarEstado(int id,String estado){
    
        if(estado.equals("PENDIENTE")){
        totalPedidos.forEach(i ->{
        if(i.getId() == id){
            i.setEstado("ENTREGADO");
        };
        });
        return "ENTREGADO";
        }else{
         totalPedidos.forEach(i ->{
        if(i.getId() == id){
            i.setEstado("PENDIENTE");
        }
        });
        return "PENDIENTE";
        } 
    }
    
}
