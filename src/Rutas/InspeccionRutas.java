
package Rutas;

import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;
import static Servicios.InspeccionVehServicios.insertInspeccion;
import static Servicios.InspeccionVehServicios.queryInspeccionVeh;


public class InspeccionRutas {
    
    
     public static void setInspeccionEncRuta() {
        post("/inspeccion", ((request, response) -> queryInspeccionVeh(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        put("/inspeccion", ((request, response) -> insertInspeccion(request.body())), JsonUtils::toJson);
    }
    
}
