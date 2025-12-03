package controller;
import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author maxan
 */
public class ProductoDAO {
    
    public boolean insertar(Producto producto) {
        boolean resultado = false;
        
        if (producto instanceof CajaSobre) {
            return insertarCajaSobre((CajaSobre) producto);
        } else if (producto instanceof CajaMazo) {
            return insertarCajaMazo((CajaMazo) producto);
        } else if (producto instanceof CajaEspecial) {
            return insertarCajaEspecial((CajaEspecial) producto);
        }
        
        return false;
    }
    
    private boolean insertarCajaSobre(CajaSobre producto) {
        String query = "INSERT INTO PRODUCTO (SKU, NOMBRE, EDICION, LINEA, TIPO, STOCK, PRECIO, " +
                       "FECHA_SALIDA, DESCRIPCION, CANTIDAD_SOBRE) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(query);
            int i = 1;
            
            ps.setString(i++, producto.getSku());
            ps.setString(i++, producto.getNombre());
            ps.setString(i++, producto.getEdicion());
            ps.setString(i++, producto.getLinea());
            ps.setString(i++, producto.getTipo());
            ps.setInt(i++, producto.getStock());
            ps.setInt(i++, producto.getPrecio());
            ps.setString(i++, producto.getFechaSalida());
            ps.setString(i++, producto.getDescripcion());
            ps.setInt(i++, producto.getCantidadPorCaja());
            
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar CajaSobre: " + e.getMessage());
        }
        return false;
    }
    
    private boolean insertarCajaMazo(CajaMazo producto) {
        String query = "INSERT INTO PRODUCTO (SKU, NOMBRE, EDICION, LINEA, TIPO, STOCK, PRECIO, " +
                       "FECHA_SALIDA, DESCRIPCION, CANTIDAD_MAZO) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(query);
            int i = 1;
            
            ps.setString(i++, producto.getSku());
            ps.setString(i++, producto.getNombre());
            ps.setString(i++, producto.getEdicion());
            ps.setString(i++, producto.getLinea());
            ps.setString(i++, producto.getTipo());
            ps.setInt(i++, producto.getStock());
            ps.setInt(i++, producto.getPrecio());
            ps.setString(i++, producto.getFechaSalida());
            ps.setString(i++, producto.getDescripcion());
            ps.setInt(i++, producto.getCantidadPorCaja());
            
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar CajaMazo: " + e.getMessage());
        }
        return false;
    }
    
    private boolean insertarCajaEspecial(CajaEspecial producto) {
        String query = "INSERT INTO PRODUCTO (SKU, NOMBRE, EDICION, LINEA, TIPO, STOCK, PRECIO, " +
                       "FECHA_SALIDA, DESCRIPCION, CANTIDAD_SOBRE_ESPECIAL, CARTA_PROMO, REGALO_EXTRA) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(query);
            int i = 1;
            
            ps.setString(i++, producto.getSku());
            ps.setString(i++, producto.getNombre());
            ps.setString(i++, producto.getEdicion());
            ps.setString(i++, producto.getLinea());
            ps.setString(i++, producto.getTipo());
            ps.setInt(i++, producto.getStock());
            ps.setInt(i++, producto.getPrecio());
            ps.setString(i++, producto.getFechaSalida());
            ps.setString(i++, producto.getDescripcion());
            ps.setInt(i++, producto.getCantidadSobres());
            ps.setString(i++, producto.getCartasPromo());
            ps.setString(i++, producto.getRegaloExtra());
            
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar CajaEspecial: " + e.getMessage());
        }
        return false;
    }
    
    public List<Producto> listar(String tipoFiltro) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTO";

       
        if (tipoFiltro != null && !tipoFiltro.isEmpty()) {
            sql += " WHERE TIPO = ?";
        }

        try (PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(sql)) {
            
            
            if (tipoFiltro != null && !tipoFiltro.isEmpty()) {
                ps.setString(1, tipoFiltro);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    
                    
                    String sku = rs.getString("SKU");
                    String nombre = rs.getString("NOMBRE");
                    String edicion = rs.getString("EDICION");
                    String linea = rs.getString("LINEA");
                    String tipoBd = rs.getString("TIPO");
                    int stock = rs.getInt("STOCK");
                    int precio = rs.getInt("PRECIO");
                    String fecha = rs.getString("FECHA_SALIDA");
                    String descripcion = rs.getString("DESCRIPCION");

                    Producto p = null;

                  
                    
                    switch (tipoBd) { 
                        case "Caja Sobres": 
                            int cantSobre = rs.getInt("CANTIDAD_SOBRE");
                            
                            p = new CajaSobre(
                                cantSobre, // Hijo
                                edicion, nombre, linea, tipoBd, stock, precio, sku, fecha, descripcion 
                            );
                            break;

                        case "Caja Mazos":
                            // Asumo que tu clase CajaMazo es igual a CajaSobre pero con CANTIDAD_MAZO
                            int cantMazo = rs.getInt("CANTIDAD_MAZO");
                            
                            p = new CajaMazo(
                                cantMazo, // Hijo
                                edicion, nombre, linea, tipoBd, stock, precio, sku, fecha, descripcion // Padre
                            );
                            break;
                            
                        case "Caja Especial":
                            // En DB: CANTIDAD_SOBRE_ESPECIAL, CARTA_PROMO, REGALO_EXTRA
                            int cantEsp = rs.getInt("CANTIDAD_SOBRE_ESPECIAL");
                            String promo = rs.getString("CARTA_PROMO");
                            String regalo = rs.getString("REGALO_EXTRA");

                            p = new CajaEspecial(
                                cantEsp, promo, regalo, // Hijo (Orden específico de tu constructor)
                                edicion, nombre, linea, tipoBd, stock, precio, sku, fecha, descripcion // Padre
                            );
                            break;
                            
                        default:
                             // Opción por si hay datos basura o nuevos tipos no implementados
                             System.out.println("Tipo no reconocido: " + tipoBd);
                             break;
                    }

                    if (p != null) {
                        lista.add(p);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }    
    
    
}
