package Rutas;

import static Servicios.VehiculoServicios.insertVehiculo;
import static Servicios.VehiculoServicios.queryDetVehiculo;
import static Servicios.VehiculoServicios.queryVehiculo;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author Prueba
 */
public class VehiculoRutas {

    private VehiculoRutas() {
    }

    /**
     * Sets the client routes.
     */
    public static void setVehiculoRutas() {
        post("/vehiculo", ((request, response) -> queryVehiculo(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        post("/vehiculoDet", ((request, response) -> queryDetVehiculo(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);

        put("/vehiculo", ((request, response) -> insertVehiculo(request.body())), JsonUtils::toJson);
    }

}
