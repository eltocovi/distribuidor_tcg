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
                                cantSobre, 
                                edicion, nombre, linea, tipoBd, stock, precio, sku, fecha, descripcion 

                            );
                            break;

                        case "Caja Mazos":
                            int cantMazo = rs.getInt("CANTIDAD_MAZO");
                            
                            p = new CajaMazo(
                                cantMazo, 
                                edicion, nombre, linea, tipoBd, stock, precio, sku, fecha, descripcion 
                            );
                            break;
                            
                        case "Caja Especial":
                            int cantEsp = rs.getInt("CANTIDAD_SOBRE_ESPECIAL");
                            String promo = rs.getString("CARTA_PROMO");
                            String regalo = rs.getString("REGALO_EXTRA");

                            p = new CajaEspecial(
                                cantEsp, promo, regalo, 
                                edicion, nombre, linea, tipoBd, stock, precio, sku, fecha, descripcion 
                            );
                            break;
                            
                        default:
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
    
    public boolean eliminarProducto (String SKU) {
        boolean resultado = false;
        
        String query = "DELETE FROM PRODUCTO WHERE SKU = ?";
        
        try {
            PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(query);
            int i = 1;
            ps.setString(i++, SKU);            
            int filasBorradas = ps.executeUpdate();
            if (filasBorradas > 0) {
            resultado = true;
        }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return resultado;
    }
    
    public boolean actualizarProducto (Producto producto) {
        
        if (producto instanceof CajaSobre) {
            return actualizarCajaSobre((CajaSobre) producto);
        } else if (producto instanceof CajaMazo) {
            return actualizarCajaMazo((CajaMazo) producto);
        } else if (producto instanceof CajaEspecial) {
            return actualizarCajaEspecial((CajaEspecial) producto);
        }
        return false;    
    
    }
    
   public boolean actualizarCajaSobre(CajaSobre producto) {
    boolean resultado = false;
    // ✅ Agregada coma después de LINEA = ?
    String query = "UPDATE PRODUCTO SET NOMBRE = ?, EDICION = ?, LINEA = ?, " + 
            "STOCK = ?, PRECIO = ?, FECHA_SALIDA = ?, DESCRIPCION = ?, CANTIDAD_SOBRE = ? " + 
            "WHERE SKU = ?";
    
    try {
        PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(query);
        int i = 1;
        ps.setString(i++, producto.getNombre());
        ps.setString(i++, producto.getEdicion());
        ps.setString(i++, producto.getLinea());
        ps.setInt(i++, producto.getStock());
        ps.setInt(i++, producto.getPrecio());
        ps.setString(i++, producto.getFechaSalida());
        ps.setString(i++, producto.getDescripcion());
        ps.setInt(i++, producto.getCantidadPorCaja());
        ps.setString(i++, producto.getSku());
        
        ps.execute(); // ✅ También funciona executeUpdate()
        resultado = true;
        
        System.out.println("CajaSobre actualizada correctamente");
    } catch (Exception ex) {
        System.out.println("Error en actualizarCajaSobre: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    return resultado;
}

public boolean actualizarCajaMazo(CajaMazo producto) {
    boolean resultado = false;
    // ✅ Agregada coma después de LINEA = ?
    String query = "UPDATE PRODUCTO SET NOMBRE = ?, EDICION = ?, LINEA = ?, " + 
            "STOCK = ?, PRECIO = ?, FECHA_SALIDA = ?, DESCRIPCION = ?, " +
            "CANTIDAD_MAZO = ? " + "WHERE SKU = ?";
    
    try {
        PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(query);
        int i = 1;
        ps.setString(i++, producto.getNombre());
        ps.setString(i++, producto.getEdicion());
        ps.setString(i++, producto.getLinea());
        ps.setInt(i++, producto.getStock());
        ps.setInt(i++, producto.getPrecio());
        ps.setString(i++, producto.getFechaSalida());
        ps.setString(i++, producto.getDescripcion());
        ps.setInt(i++, producto.getCantidadPorCaja());
        ps.setString(i++, producto.getSku());
        
        ps.execute();
        resultado = true;
        
        System.out.println("CajaMazo actualizada correctamente");
    } catch (Exception ex) {
        System.out.println("Error en actualizarCajaMazo: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    return resultado;
}

public boolean actualizarCajaEspecial(CajaEspecial producto) {
    boolean resultado = false;
    // ✅ Agregada coma después de LINEA = ? y después de DESCRIPCION = ?
    String query = "UPDATE PRODUCTO SET NOMBRE = ?, EDICION = ?, LINEA = ?, " + 
            "STOCK = ?, PRECIO = ?, FECHA_SALIDA = ?, DESCRIPCION = ?, " +
            "CANTIDAD_SOBRE_ESPECIAL = ?, CARTA_PROMO = ?, REGALO_EXTRA = ? " + 
            "WHERE SKU = ?";
    
    try {
        PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(query);
        int i = 1;
        ps.setString(i++, producto.getNombre());
        ps.setString(i++, producto.getEdicion());
        ps.setString(i++, producto.getLinea());
        ps.setInt(i++, producto.getStock());
        ps.setInt(i++, producto.getPrecio());
        ps.setString(i++, producto.getFechaSalida());
        ps.setString(i++, producto.getDescripcion());
        ps.setInt(i++, producto.getCantidadSobres());
        ps.setString(i++, producto.getCartasPromo());
        ps.setString(i++, producto.getRegaloExtra());
        ps.setString(i++, producto.getSku());
        
        ps.execute();
        resultado = true;
        
        System.out.println("CajaEspecial actualizada correctamente");
    } catch (Exception ex) {
        System.out.println("Error en actualizarCajaEspecial: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    return resultado;
}
    
    public Producto buscarPorSku(String skuBuscado) {
    Producto p = null;
    String sql = "SELECT * FROM PRODUCTO WHERE SKU = ?";

    try (PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(sql)) {
        ps.setString(1, skuBuscado);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) { 
                
                String sku = rs.getString("SKU");
                String nombre = rs.getString("NOMBRE");
                String edicion = rs.getString("EDICION");
                String linea = rs.getString("LINEA");
                String tipoBd = rs.getString("TIPO");
                int stock = rs.getInt("STOCK");
                int precio = rs.getInt("PRECIO");
                String fecha = rs.getString("FECHA_SALIDA");
                String descripcion = rs.getString("DESCRIPCION");

                switch (tipoBd) { 
                    case "Caja Sobres": 
                        int cantSobre = rs.getInt("CANTIDAD_SOBRE");
                        p = new CajaSobre(cantSobre, edicion, nombre, linea, tipoBd, stock, precio, sku, fecha, descripcion);
                        break;

                    case "Caja Mazos":
                        int cantMazo = rs.getInt("CANTIDAD_MAZO");
                        p = new CajaMazo(cantMazo, edicion, nombre, linea, tipoBd, stock, precio, sku, fecha, descripcion);
                        break;
                        
                    case "Caja Especial":
                        int cantEsp = rs.getInt("CANTIDAD_SOBRE_ESPECIAL");
                        String promo = rs.getString("CARTA_PROMO");
                        String regalo = rs.getString("REGALO_EXTRA");
                        p = new CajaEspecial(cantEsp, promo, regalo, edicion, nombre, linea, tipoBd, stock, precio, sku, fecha, descripcion);
                        break;
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al buscar por SKU: " + e.getMessage());
    }
    return p;
}
    public List<Producto> buscarPorNombre(String nombreBuscado) {
    List<Producto> lista = new ArrayList<>();
    String sql = "SELECT * FROM PRODUCTO WHERE NOMBRE = ?"; 
    
    try (PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(sql)) {
        ps.setString(1, nombreBuscado);
        
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
                        p = new CajaSobre(rs.getInt("CANTIDAD_SOBRE"), edicion, nombre, linea, tipoBd, stock, precio, sku, fecha, descripcion);
                        break;
                    case "Caja Mazos":
                        p = new CajaMazo(rs.getInt("CANTIDAD_MAZO"), edicion, nombre, linea, tipoBd, stock, precio, sku, fecha, descripcion);
                        break;
                    case "Caja Especial":
                        p = new CajaEspecial(rs.getInt("CANTIDAD_SOBRE_ESPECIAL"), rs.getString("CARTA_PROMO"), rs.getString("REGALO_EXTRA"), edicion, nombre, linea, tipoBd, stock, precio, sku, fecha, descripcion);
                        break;
                }
                
                if (p != null) {
                    lista.add(p);
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al buscar por Nombre: " + e.getMessage());
    }
    return lista;
}
}