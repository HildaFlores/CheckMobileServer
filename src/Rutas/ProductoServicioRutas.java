
package Rutas;

import static Servicios.ProductoEncServicios.insertProductoEnc;
import static Servicios.ProductoEncServicios.queryProductoEnc;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author Prueba
 */
public class ProductoServicioRutas {
    
     

    public static void setProductoServiciosRutas() {
        post("/productoEnc", ((request, response) -> queryProductoEnc(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        put("/productoEnc", ((request, response) -> insertProductoEnc(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
    } 
}
