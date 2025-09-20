package Models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author EFICAZ
 */
public class Platillos {
    
    private String platillo;

    public Platillos(String platillo, double costo) {
        this.platillo = platillo;
        this.costo = costo;
    }

    
    
    public String getPlatillo() {
        return platillo;
    }

    public void setPlatillo(String platillo) {
        this.platillo = platillo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    private double costo;

    @Override
    public String toString() {
        return "Platillos{" + "platillo=" + platillo + ", costo=" + costo + '}';
    }
  
    
}
