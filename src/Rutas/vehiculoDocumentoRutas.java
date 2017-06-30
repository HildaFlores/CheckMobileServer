
package Rutas;
import static Servicios.vehiculoDocumentoServicios.insertVehiculoDocumento;
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
    }

    
}
