package model;

/**
 *
 * @author Vitoco
 */
public class CajaSobre extends Producto {
    private int cantidadPorCaja;

    public CajaSobre() {
    }

    public CajaSobre(int cantidadPorCaja, String edicion, String nombre, String linea, String tipo, int stock, int precio, String sku, String fechaSalida, String descripcion) {
        super(edicion, nombre, linea, tipo, stock, precio, sku, fechaSalida, descripcion);
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
