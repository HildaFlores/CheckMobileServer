
package Rutas;
import static Servicios.vehiculoDocumentoServicios.insertVehiculoDocumento;
import static Servicios.vehiculoDocumentoServicios.queryDocumento;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;
/**
 *
 * @author Prueba
 */
public class vehiculoDocumentoRutas {
    
    
       public static void setVehiculoDocRutas() {
     
           put("/documento", ((request, response) -> insertVehiculoDocumento(request.body())), JsonUtils::toJson);
           post("/documento", ((request, response) -> queryDocumento(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
    }

    
}
