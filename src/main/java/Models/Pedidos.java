package Models;

import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author EFICAZ
 */
public class Pedidos {
    
    private int Id;
    private List<Platillos> platillo = new ArrayList<>();
    private List<Extra> extra = new ArrayList<>();

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public List<Platillos> getPlatillo() {
        return platillo;
    }

    public void setPlatillo(List<Platillos> platillo) {
        this.platillo = platillo;
    }

    public List<Extra> getExtra() {
        return extra;
    }

    public void setExtra(List<Extra> extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "Id=" + Id + ", platillo=" + platillo + ", extra=" + extra + '}';
    }
    
    
}
