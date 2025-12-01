/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maxan
 */
public class CajaMazo extends Producto{
    private int cantidadPorCaja;

    public CajaMazo() {
    }

    public CajaMazo(int cantidadPorCaja, String edicion, String nombre, String linea, String tipo, int stock, int precio, String sku, String fecha_salida, String descripcion) {
        super(edicion, nombre, linea, tipo, stock, precio, sku, fecha_salida, descripcion);
        this.cantidadPorCaja = cantidadPorCaja;
    }

    public int getCantidadPorCaja() {
        return cantidadPorCaja;
    }

    public void setCantidadPorCaja(int cantidadPorCaja) {
        this.cantidadPorCaja = cantidadPorCaja;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n Cantidad Por Caja: " + cantidadPorCaja;
    }
    
    
    
}
