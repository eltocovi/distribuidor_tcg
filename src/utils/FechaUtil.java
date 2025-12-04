package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author manu-Dev
 */

public final class FechaUtil {
    
    public final static String DD_MM_YYYY = "dd-MM-yyyy";                       //Define el patrón de formato para fechas (día-mes-anio)
    public final static String DD_MM_YYYY_HH_MI_SS = "dd/MM/yyyy HH:mm:ss";     //Patrón que agrega hora-minuto-segundo
    
    
    /**
     * Método encargado de transforma una fecha en un texto a un fecha de tipo Date
     * @param fecha la fecha en texto
     * @param formato formato de la fecha
     * @return
     * @throws ParseException 
     */
    
    public static Date textoADate(String fecha, String formato) throws ParseException{  //Él método recibe dos variables, un string con la fecha y otro con el formato.
    
        SimpleDateFormat formatoDate = new SimpleDateFormat(formato);              //Instancia un objeto del tipo SimpleDateFormat usando el string de formato.
        Date fechaDate = formatoDate.parse(fecha);                                 //Parsea el String a date usando el formato dado anteriormente.
        return fechaDate;                                                          //Retorna el date.
    }
    
    public static String DateATexto(Date fecha, String formato){                  //Él método recibe dos variables, un date con la fecha y un string con el formato.
    
        SimpleDateFormat formatoDate = new SimpleDateFormat(formato);             //Instancia un objeto del tipo SimpleDateFormat usando el string de formato.
        String fechaS = formatoDate.format(fecha);                                //Parsea el date con la fecha a String usando el formato dado anteriormente.
        return fechaS;                                                            //Retorna el String.
    }
}
