package validator;

/**
 *
 * @author manu-DEV
 */


public class ValidadorGeneral {

    /**
    * Método encargado de validar el tamanio del String ingresado
    * @param @texto @tamanioInicial @tamanioFinal @nombreCampo
    * @throws Exception si el texto no cumple las reglas de tamanio
    */

    
    public static void validarTamanioTexto(String texto,
            int tamanioInicial, int tamanioFinal,
            String nombreCampo) throws Exception{
    
        
        if(texto.length() < tamanioInicial ||
                texto.length() > tamanioFinal){
        
            String mensajeError = "EL TAMAÑO DE " + nombreCampo + " DEBE SER MAYOR QUE "  +
                    tamanioInicial + " Y MENOR QUE " + tamanioFinal;
            
            throw new Exception(mensajeError);
        }        
    }
    
    /**
    * Método encargado de validar que el String ingresado no este vacio
    * @param @texto @tamanioInicial @tamanioFinal @nombreCampo
    * @throws Exception si el texto está vacio
    */
    
    public static void validarTextoVacio(String texto, 
            String nombreCampo) throws Exception{
    
        
        if(texto == null || texto.trim().isEmpty()) {
            
            String mensajeError = "Debe ingresar " + 
                    "informacion en el campo " + nombreCampo;
            
            throw new Exception(mensajeError);
        }
        
    }
    
    /**
    * Método encargado de validar atributos tipo int en general
    * @param @texto @nombreCampo
    * @throws Exception si el texto esta vacio o no es entero
    */
    public static int validarNumeroEntero(String texto, String nombreCampo) throws Exception {
        if (texto == null || texto.trim().isEmpty()) {                                  //.trim es para eliminar espacios
        throw new Exception("Debe ingresar un valor en " + nombreCampo);
        }
        
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            throw new Exception(nombreCampo + " debe ser un número entero.");
        }
    }

    /**
    * Método encargado de validar que el int sea positivo, pensado para precio
    * @param @texto @nombreCampo
    * @throws Exception si el numero no es mayor a 0
    */    
    
    public static int validarEnteroPositivo(String texto, String nombreCampo) throws Exception {
    int numero = validarNumeroEntero(texto, nombreCampo);
    
    if (numero <= 0) {
        throw new Exception(nombreCampo + " debe ser mayor a 0");
    }

    return numero;
}
    
    /**
    * Método encargado de validar que el int sea 0 o un numero positivo, pensado para stock
    * @param @texto @nombreCampo
    * @throws Exception si el numero no es mayor a 0
    */    
    
    public static int validarStock(String texto, String nombreCampo) throws Exception {
    int numero = validarNumeroEntero(texto, nombreCampo);
    
    if (numero < 0) {
        throw new Exception(nombreCampo + " debe ser igual o mayor a 0");
    }

    return numero;
}
    
    /**
    * Método encargado de validar que la cantidad de sobres en las cajas sea correcta
    * @param @texto @nombreCampo
    * @throws Exception si el texto no es un numero entre 1 y 9999
    */
    public static int validarCantidadEnSobre(String texto, String nombreCampo) throws Exception {
   
    int numero = validarNumeroEntero(texto, nombreCampo);

        if (numero < 1 || numero > 9999) {
            throw new Exception(nombreCampo + " debe estar entre 1 y 9999.");
        }

        return numero;
    }
        
        
}

