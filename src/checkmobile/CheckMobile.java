package checkmobile;

import static Rutas.ClienteRutas.setClienteRutas;
import static Rutas.CombustibleRutas.setCombustibleRutas;
import static Rutas.CondicionPagoRutas.setCondicionPago;
import static Rutas.EstiloRutas.setEstiloRutas;
import static Rutas.ImpuestoRutas.setImpuestoRutas;
import static Rutas.InspeccionDetRutas.setInspeccionRuta;
import static Rutas.InspeccionRutas.setInspeccionEncRuta;
import static Rutas.ListaParametrosRutas.setListaParametros;
import static Rutas.MarcaRutas.setMarcaRutas;
import static Rutas.ModeloRutas.setModeloRutas;
import static Rutas.PaisRutas.setPais;
import static Rutas.PedidoDetRutas.setPedidoDetRutas;
import static Rutas.PedidoEncRutas.setPedidoEncRutas;
import static Rutas.ProductoPrecioRutas.setProductoPrecioRutas;
import static Rutas.ProductoServicioRutas.setProductoServiciosRutas;
import static Rutas.ProvinciaRutas.setProvinciaRutas;
import static Rutas.RepVentasRutas.setRepVentasRutas;
import static Rutas.TablaDgiiRutas.setTablaDgiiRutas;
import static Rutas.TipoComprobanteRutas.setTipoComprobanteRutas;
import static Rutas.TipoTelefonoRutas.setTipoTelefonoRutas;
import static Rutas.TipoTransaccionRutas.setTipoTransRutas;
import static Rutas.TipoVehiculoRutas.setTipoVehiculoRutas;
import static Rutas.TraccionRutas.setTraccionRutas;
import static Rutas.UsuarioAdminRutas.setUsuarioAdminRutas;
import static Rutas.VehiculoRutas.setVehiculoRutas;
import static Rutas.vehiculoDocumentoRutas.setVehiculoDocRutas;
import Util.Utils;
import Util.*;
import com.google.gson.JsonObject;
import spark.Request;
import static spark.Spark.*;

/**
 *
 * @author Prueba
 */
public class CheckMobile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Utils.log("Cargando...");
        boolean setUpStatus = Utils.setUpConfigParameters();

        if (!setUpStatus) {
            System.out.println("No se pudo ejecutar la configuracion.");
            return;
        }

        Utils.log("Setting up database connection...");

        if (setConnection()) {
            Utils.log("Setting up API filters...");

            //setBefore();
            setAfter();

            Utils.log("Setting up API routes...");
            setRoutes();

            exception(Exception.class, (exception, request, response) -> {
                exception.printStackTrace();
            });

            Utils.log("API up and running.");
        } else {
            Utils.log("Connection with the database could not be established.");
        }
    }

    private static boolean setConnection() {
        return conexion.getConnection() != null;
    }

    private static void setBefore() {
        before((request, response) -> {
            boolean authenticated = authenticateRequest(request);

            if (!authenticated) {
                halt(401, "Accesso denegado");
            }
        });
    }

    private static void setAfter() {
        after((request, response) -> response.type(Constantes.JSON));
    }

    private static boolean authenticateRequest(Request request) {
        String uniqueId = "ANDROIDJAVAORACLE";
        String value = "";
        JsonObject jsonObject = JsonUtils.fromJson(request.body());
        String encryptedValue = jsonObject.has(Constantes.JSON_KEY_API_KEY) ? jsonObject.get(Constantes.JSON_KEY_API_KEY).getAsString() : null;

        try {
            value = Encryption.decrypt(encryptedValue);
        } catch (Exception e) {
        }

        return value.equals(uniqueId);
    }

    //cargando las rutas
    private static void setRoutes() {

        setClienteRutas(); //
        setEstiloRutas(); //
        setInspeccionRuta(); //
        setInspeccionEncRuta(); // 
        setMarcaRutas(); //
        setModeloRutas(); //
        setPedidoDetRutas(); //
        setPedidoEncRutas(); //
        setProductoPrecioRutas(); //
        setProductoServiciosRutas();  //
        setRepVentasRutas(); //
        setTablaDgiiRutas(); //
        setUsuarioAdminRutas(); //
        setVehiculoRutas(); //
        setTraccionRutas(); //
        setCombustibleRutas(); //
        setCondicionPago(); //
        setImpuestoRutas(); //
        setTipoVehiculoRutas(); // 
        setTipoComprobanteRutas();//
        setTipoTelefonoRutas(); // 
        setListaParametros(); //
        setPais(); //
        setTipoTransRutas(); //
        setVehiculoDocRutas();//
        setProvinciaRutas(); //
    }

}
