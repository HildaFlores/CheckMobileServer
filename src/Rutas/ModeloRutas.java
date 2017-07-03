package Rutas;

import static Servicios.ModeloServicios.insertModelo;
import static Servicios.ModeloServicios.queryModelo;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author Prueba
 */
public class ModeloRutas {

    private ModeloRutas() {
    }

    public static void setModeloRutas() {
        post("/modelo", ((request, response) -> queryModelo(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        put("/modelo", ((request, response) -> insertModelo(request.body())), JsonUtils::toJson);
    }
}
