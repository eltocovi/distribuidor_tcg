
package model;

/**
 *
 * @author Manu-DEV
 */
public class CajaEspecial extends Producto{
    private int cantidadSobres;
    private String cartasPromo;
    private String regaloExtra;

    public CajaEspecial() {
    }

    public CajaEspecial(int cantidadSobres, String cartasPromo, String regaloExtra, String edicion, String nombre, String linea, String tipo, int stock, int precio, String sku, String fechaSalida, String descripcion) {
        super(edicion, nombre, linea, tipo, stock, precio, sku, fechaSalida, descripcion);
        this.cantidadSobres = cantidadSobres;
        this.cartasPromo = cartasPromo;
        this.regaloExtra = regaloExtra;
    }

    public int getCantidadSobres() {
        return cantidadSobres;
    }

    public void setCantidadSobres(int cantidadSobres) {
        this.cantidadSobres = cantidadSobres;
    }

    public String getCartasPromo() {
        return cartasPromo;
    }

    public void setCartasPromo(String cartasPromo) {
        this.cartasPromo = cartasPromo;
    }

    public String getRegaloExtra() {
        return regaloExtra;
    }

    public void setRegaloExtra(String regaloExtra) {
        this.regaloExtra = regaloExtra;
    }

    
    //Metodos custom
    
    
    @Override
    public String toString() {
        return "\n cantidadSobres: " + cantidadSobres +
                super.toString() +
               "\n cartasPromo: " + cartasPromo +
               "\n regaloExtra: " + regaloExtra;
    }
    
    
    
    
    
}
