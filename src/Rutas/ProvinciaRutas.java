
package Rutas;

import static Servicios.ProvinciaServicios.queryProvincia;
import Util.JsonUtils;
import static spark.Spark.post;

/**
 *
 * @author Prueba
 */
public class ProvinciaRutas {
    
    
    public static void setProvinciaRutas(){
      post("/provincia", ((request, response) -> queryProvincia()), JsonUtils::toJson);
    }   
    
}
