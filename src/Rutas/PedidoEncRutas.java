package Rutas;

import static Servicios.PedidoEncServicios.anularPedido;
import static Servicios.PedidoEncServicios.insertPedidoEnc;
import static Servicios.PedidoEncServicios.queryPedidoEnc;
import static Servicios.PedidoEncServicios.queryPedidoEncFecha;
import static Servicios.PedidoEncServicios.updateOrdenTrabajo;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author Prueba
 */
public class PedidoEncRutas {

    public static void setPedidoEncRutas() {
        post("/pedidoEnc", ((request, response) -> queryPedidoEnc(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        post("/anularPedido", ((request, response) -> anularPedido(request.body())), JsonUtils::toJson);
         post("/pedidoEncFecha", ((request, response) -> queryPedidoEncFecha(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        
        put("/pedidoEnc", ((request, response) -> insertPedidoEnc(request.body())), JsonUtils::toJson);
        put("/actualizarPedido", ((request, response) -> updateOrdenTrabajo(request.body())), JsonUtils::toJson);
    }

}
