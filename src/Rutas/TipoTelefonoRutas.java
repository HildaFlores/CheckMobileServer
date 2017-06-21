/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import static Servicios.TipoTelefonoServicios.queryTipoTelefono;
import Util.JsonUtils;
import static spark.Spark.post;

/**
 *
 * @author Prueba
 */
public class TipoTelefonoRutas {

    private TipoTelefonoRutas() {

    }

    public static void setTipoTelefonoRutas() {
        post("/tipoTelefono", ((request, response) -> queryTipoTelefono(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);

    }

}
