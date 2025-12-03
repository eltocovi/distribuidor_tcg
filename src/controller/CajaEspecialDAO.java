package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.*;

/**
 *
 * @author Vitoco
 */
public class CajaEspecialDAO {
    public boolean insertarCS(CajaEspecial producto){
    boolean resultado = false;

    String query = "INSERT INTO PRODUCTO (SKU, NOMBRE, EDICION, LINEA, TIPO, STOCK, PRECIO, FECHA_SALIDA, DESCRIPCION, "
                 + "CANTIDAD_SOBRE_ESPECIAL, CARTA_PROMO,REGALO_EXTRA) "
                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
        resultado = true;

    } catch (SQLException e) {
        System.out.println("Mensaje de error: " + e);
    }

    return resultado;
}
}
