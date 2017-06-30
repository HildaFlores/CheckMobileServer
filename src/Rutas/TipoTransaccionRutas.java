/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import static Servicios.TipoTransaccionServicios.queryTransaccion;
import Util.JsonUtils;
import static spark.Spark.post;

/**
 *
 * @author Prueba
 */
public class TipoTransaccionRutas {

    public static void  setTipoTransRutas() {

        post("/tipoTrans", ((request, response) -> queryTransaccion(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);

    }

}
