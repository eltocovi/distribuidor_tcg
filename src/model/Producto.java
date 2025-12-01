
/**
 *
 * @author Vitoco
 */
public abstract class Producto {
    private String edicion, nombre, linea;
    private int stock;
    private String fecha_salida;

    public Producto() {
    }

    public Producto(String edicion, String nombre, String linea, int stock, String fecha_salida) {
        this.edicion = edicion;
        this.nombre = nombre;
        this.linea = linea;
        this.stock = stock;
        this.fecha_salida = fecha_salida;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    
    
    
  
    @Override
    public String toString() {
        return "Edicion: " + edicion + "\n Nombre: " + nombre + "\n Linea: " + linea + "\n Stock: " + stock + "\n Fecha Salida: " + fecha_salida ;
    }
    
    
    
    
    
    
    
    
    
    
}
