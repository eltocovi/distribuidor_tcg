/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.*;
import java.sql.*;
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
    
    
}
