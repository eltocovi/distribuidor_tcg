package model;
/**
 *
 * @author Vitoco
 */
public abstract class Producto {
    private String edicion, nombre, linea;
    private String tipo;
    private int stock, precio;
    private String sku;
    private String fechaSalida;
    private String descripcion;

    public Producto() {
    }

    public Producto(String edicion, String nombre, String linea, String tipo, int stock, int precio, String sku, String fechaSalida, String descripcion) {
        this.edicion = edicion;
        this.nombre = nombre;
        this.linea = linea;
        this.tipo = tipo;
        this.stock = stock;
        this.precio = precio;
        this.sku = sku;
        this.fechaSalida = fechaSalida;
        this.descripcion = descripcion;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    

    
    
    
  
    @Override
    public String toString() {
        return "Edicion: " + edicion + "\n Nombre: " + nombre + "\n Linea: " + linea +"\n Tipo de producto: "+ tipo + "\n Stock: " + stock +"\n SKU: "+ sku +"\n Precio "+ precio+ "\n Fecha Salida: " + fechaSalida + "\n Descripcion: "+descripcion;
    }
    
    
    
    
    
    
    
    
    
    
}
