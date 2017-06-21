/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;


import static Servicios.CondicionPagoServicios.queryCondicion;
import Util.JsonUtils;
import static spark.Spark.post;

/**
 *
 * @author Prueba
 */
public class CondicionPagoRutas {
    
    private CondicionPagoRutas() {
    }

    public static void setCondicionPago() {
        
        post("/condicion", (request, response) -> queryCondicion(JsonUtils.fromJson(request.body())), JsonUtils::toJson);
    }
    
}
