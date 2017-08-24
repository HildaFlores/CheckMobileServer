package Rutas;

import static Servicios.RepVentaServicios.queryMecanico;
import static Servicios.RepVentaServicios.queryRepresentante;
import Util.JsonUtils;
import static spark.Spark.post;

/**
 *
 * @author Prueba
 */
public class RepVentasRutas {

    private RepVentasRutas() {
    }

    public static void setRepVentasRutas() {

        post("/mecanico", ((request, response) -> queryRepresentante(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        post("/idMecanico", ((request, response) -> queryMecanico()), JsonUtils::toJson);

    }

}
