package controller;
import model.*;
import java.sql.*;
/**
 *
 * @author Vitoco
 */
public class ProductoController {

    public boolean insertar(Producto producto){
    boolean resultado = false;

    String query = "INSERT INTO PRODUCTO (SKU, NOMBRE, EDICION, LINEA, TIPO, STOCK, PRECIO, FECHA_SALIDA, DESCRIPCION, "
                 + "CANTIDAD_SOBRE, CANTIDAD_MAZO, CANTIDAD_SOBRE_ESPECIAL, CARTA_PROMO, REGALO_EXTRA) "
                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

       
        Integer cantidadSobre = null;
        Integer cantidadMazo = null;
        Integer cantidadSobreEspecial = null;
        String cartaPromo = null;
        String regaloExtra = null;

        if (producto instanceof CajaMazo) {
            CajaMazo cm = (CajaMazo) producto;
            cantidadMazo = cm.getCantidadPorCaja();
            
        }

        if (producto instanceof CajaSobre) {
            CajaSobre cs = (CajaSobre) producto;
            cantidadSobre = cs.getCantidadPorCaja();
        }

        if (producto instanceof CajaEspecial) {
            CajaEspecial ce = (CajaEspecial) producto;
            cantidadSobreEspecial = ce.getCantidadSobres();
            cartaPromo = ce.getCartasPromo();
            regaloExtra = ce.getRegaloExtra();
        }

       
        if (cantidadSobre != null) ps.setInt(i++, cantidadSobre);
        else ps.setNull(i++, java.sql.Types.INTEGER);

        if (cantidadMazo != null) ps.setInt(i++, cantidadMazo);
        else ps.setNull(i++, java.sql.Types.INTEGER);

        if (cantidadSobreEspecial != null) ps.setInt(i++, cantidadSobreEspecial);
        else ps.setNull(i++, java.sql.Types.INTEGER);

        if (cartaPromo != null) ps.setString(i++, cartaPromo);
        else ps.setNull(i++, java.sql.Types.VARCHAR);

        if (regaloExtra != null) ps.setString(i++, regaloExtra);
        else ps.setNull(i++, java.sql.Types.VARCHAR);

        ps.execute();
        resultado = true;

    } catch (SQLException e) {
        System.out.println("Mensaje de error: " + e);
    }

    return resultado;
}
}
