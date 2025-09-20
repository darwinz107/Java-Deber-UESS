/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author EFICAZ
 */
public class Extra {
    
    private String extra;
    private double precio;

    public Extra(String extra, double precio) {
        this.extra = extra;
        this.precio = precio;
    }

    
    
    
    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Extra{" + "extra=" + extra + ", precio=" + precio + '}';
    }
    
    
}
