/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import static Servicios.ImpuestoServicios.queryImpuesto;
import Util.JsonUtils;
import static spark.Spark.post;

/**
 *
 * @author Prueba
 */
public class ImpuestoRutas {
    
    
    public static void setImpuestoRutas() {
          
        post("/impuesto", ((request, response) -> queryImpuesto(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);

    }
}
