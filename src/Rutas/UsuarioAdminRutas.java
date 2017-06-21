package Rutas;

/**
 *
 * @author Prueba
 */
import Util.JsonUtils;
import static Servicios.UsuarioServicios.queryUsuarioadmin;
import static spark.Spark.post;

public class UsuarioAdminRutas {

    private UsuarioAdminRutas() {
    }


    public static void setUsuarioAdminRutas() {

        post("/admin-users", ((request, response) -> queryUsuarioadmin(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);

    }
}
