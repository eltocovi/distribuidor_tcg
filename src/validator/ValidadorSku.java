package validator;

/**
 *
 * @author manu-Dev
 */


public class ValidadorSku {
    public static boolean validarSku (String sku) throws Exception {
    /**
    * Método encargado de validar el SKU con Letras A-Z - Dígitos 0-9 y sin espacios.
    * @param sku 
    * @return boolean True Si el SKU es valido
    * @throws Exception si el SKU no cumple las reglas
    */
        
        if (sku == null){
            throw new Exception("El SKU no puede estar vacío.");      //Validador básico para dato vacío.
                                              
        }
        sku = sku.toUpperCase();                                    //Transforma el String a máyusculas.
        sku = sku.replace(" ", "");                                 //Borrando espacios.
        
        if (sku.length() != 15) {                                   //Valida el largo.
            throw new Exception("El largo del SKU debe ser de 15 carácteres.");
            
        }
        
        for (int i = 0; i < sku.length(); i++) {         //Inicializa en 0 - Revisa que el índice llegue hasta el ultimo dígito (el 15) - i++ Hace que despues de cada ciclo, i aumenta 1.
            char a = sku.charAt(i);                      //Inicializo una variable char llamada a, la defino como un charAt que guarda el char en la posición i.
          
            if (!((a >= 'A' && a <= 'Z') ||              //Busco un char que NO se encuentre entre [A Y Z] 
               (a>= '0' && a <= '9'))) {                 //O Busco un char que NO se encuentre entre [0 y 9] 
                                                                      
                throw new Exception("El SKU no debe contener caracteres especiales.");
                                            
            }

                
        }
        return true;
        
    }
}
