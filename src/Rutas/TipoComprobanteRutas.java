/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import static Servicios.TipoComprobanteServicios.queryComprobante;
import Util.JsonUtils;
import static spark.Spark.post;
/**
 *
 * @author Prueba
 */
public class TipoComprobanteRutas {

    private TipoComprobanteRutas() {
    }
    
    public static void setTipoComprobanteRutas()
    {
        post("/comprobante", ((request, response) -> queryComprobante(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
    }

}
