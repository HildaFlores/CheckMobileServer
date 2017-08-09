package Rutas;

/**
 *
 * @author Prueba
 */
import static Servicios.UsuarioServicios.queryPersonal;
import Util.JsonUtils;
import static Servicios.UsuarioServicios.queryUsuarioadmin;
import static Servicios.UsuarioServicios.queryValidacionClave;
import static spark.Spark.post;

public class UsuarioAdminRutas {

    private UsuarioAdminRutas() {
    }

    public static void setUsuarioAdminRutas() {

        post("/admin-users", ((request, response) -> queryUsuarioadmin(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        post("/user-supervisor", ((request, response) -> queryPersonal()), JsonUtils::toJson);
         post("/validacion-clave", ((request, response) -> queryValidacionClave(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
       

    }
}
