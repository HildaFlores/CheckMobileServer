/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import static Servicios.EstiloServicios.insertEstilo;
import static Servicios.EstiloServicios.queryEstilo;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author Prueba
 */
public class EstiloRutas {

    private EstiloRutas() {
    }

    public static void setEstiloRutas() {
        
        post("/estilos", (request, response) -> queryEstilo(JsonUtils.fromJson(request.body())), JsonUtils::toJson);
       
        put("/estilos", ((request, response) -> insertEstilo(request.body())), JsonUtils::toJson);
    }

}
