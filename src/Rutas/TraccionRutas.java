
package Rutas;

import static Servicios.TraccionServicios.queryTraccion;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;


/**
 *
 * @author Prueba
 */
public class TraccionRutas {
    
    
    private TraccionRutas() {}

  
    /**
     * Sets the traccion routes.
     */
    public static void setTraccionRutas() {
        post("/traccion", ((request, response) -> queryTraccion(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
     }
    
}
