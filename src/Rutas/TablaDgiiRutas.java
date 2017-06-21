/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import static Servicios.TablaDgiiServicios.queryTablaDGII;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.get;

/**
 *
 * @author Prueba
 */
public class TablaDgiiRutas {
    

 public static void setTablaDgiiRutas() {
          
       // get("/dgii", (req, res) -> queryTablaDGII(JsonUtils.fromJson(req.body())),JsonUtils::toJson) ;
   
        post("/dgii", ((request, response) -> queryTablaDGII(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);

    }
}
