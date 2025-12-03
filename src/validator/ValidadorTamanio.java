package validator;

/**
 *
 * @author ferna
 */


public class ValidadorTamanio {

    /**
    * Método encargado de validar el tamanio del texto ingresado
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
    * Método encargado de validar que el texto ingresado no este vacio
    * @param @texto @tamanioInicial @tamanioFinal @nombreCampo
    * @throws Exception si el texto está vacio
    */
    
    public void validarTextoVacio(String texto, 
            String nombreCampo) throws Exception{
    
        
        if(texto == null || "".equals(texto)){
            
            String mensajeError = "DEBE INGRESAR " + 
                    "INFORMACIÓN EN EL CAMPO " + nombreCampo;
            
            throw new Exception(mensajeError);
        }
        
    }
}