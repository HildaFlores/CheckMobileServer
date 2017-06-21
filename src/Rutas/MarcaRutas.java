
package Rutas;

import static Servicios.MarcaServicios.insertMarca;
import static Servicios.MarcaServicios.queryMarca;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author Prueba
 */
public class MarcaRutas {

    private MarcaRutas() {
    }

    public static void setMarcaRutas() {
        post("/marca", ((request, response) -> queryMarca(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        put("/marca", ((request, response) -> insertMarca(request.body())), JsonUtils::toJson);
    }
}
