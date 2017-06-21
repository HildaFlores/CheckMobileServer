/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import static Servicios.TipoVehiculoServicios.queryTipoVeh;
import Util.JsonUtils;
import static spark.Spark.post;

/**
 *
 * @author Prueba
 */
public class TipoVehiculoRutas {

    private TipoVehiculoRutas() {
    }

    public static void setTipoVehiculoRutas() {
        post("/tipoVeh", ((request, response) -> queryTipoVeh(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
    }

}
