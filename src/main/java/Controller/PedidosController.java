/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Extra;
import Models.Pedidos;
import Models.Platillos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author EFICAZ
 */
public class PedidosController {
    
    int count = 0;
  public List<Pedidos> totalPedidos = new ArrayList<>();
    
    public void agregar(Platillos plat, Extra extra){
        count++;
        Pedidos pedidos = new Pedidos();
        pedidos.getPlatillo().add(plat); 
        pedidos.setId(count);
       
            pedidos.getExtra().add(extra);     
        totalPedidos.add(pedidos);
        
    }
}
