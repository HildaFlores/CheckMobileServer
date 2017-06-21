/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import Util.JsonUtils;
import static spark.Spark.post;
import static Servicios.ListaParametrosServicios.queryListaParametrosEnc;
import static Servicios.ListaParametrosServicios.queryListaParametrosDet;
import static Servicios.ListaParametrosServicios.queryListaParametrosDetOtros;

/**
 *
 * @author Prueba
 */
public class ListaParametrosRutas {

    private ListaParametrosRutas() {
    }

    public static void setListaParametros() {

        post("/parametrosEnc", ((request, response) -> queryListaParametrosEnc(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        post("/parametrosDet", ((request, response) -> queryListaParametrosDet(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
  post("/parametrosDetOtros", ((request, response) -> queryListaParametrosDetOtros(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
      
    }

}
