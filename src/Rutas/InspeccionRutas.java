package Rutas;

import static Servicios.InspeccionVehServicios.anularInspeccion;
import static Servicios.InspeccionVehServicios.convertInspeccion;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;
import static Servicios.InspeccionVehServicios.insertInspeccion;
import static Servicios.InspeccionVehServicios.queryInspeccionVeh;
import static Servicios.InspeccionVehServicios.querydetallado;
import static Servicios.InspeccionVehServicios.updateInspeccion;

public class InspeccionRutas {

    public static void setInspeccionEncRuta() {
        post("/inspeccion", ((request, response) -> queryInspeccionVeh(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        post("/inspeccionDetallada", ((request, response) -> querydetallado(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        post("/anulacionInspeccion", ((request, response) -> anularInspeccion(request.body())), JsonUtils::toJson);
        post("/convert", ((request, response) -> convertInspeccion(request.body())), JsonUtils::toJson);
        put("/inspeccion", ((request, response) -> insertInspeccion(request.body())), JsonUtils::toJson);
        put("/updateInspeccion",  ((request, response) -> updateInspeccion(request.body())), JsonUtils::toJson);
    }

}
