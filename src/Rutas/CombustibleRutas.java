/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;


import static Servicios.CombustibleServicios.queryCombustible;
import Util.JsonUtils;
import static spark.Spark.post;


/**
 *
 * @author Prueba
 */
public class CombustibleRutas {
    
     /**
     * Sets the traccion routes.
     */
    public static void setCombustibleRutas() {
        
        post("/combustible", ((request, response) -> queryCombustible(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
     
    }
    
    
}
