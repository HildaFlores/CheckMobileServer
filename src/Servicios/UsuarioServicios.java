package Servicios;

import Datos.CheckMobileTables;
import Util.Constantes;
import com.google.gson.JsonObject;
import Modelos.*;
import Datos.UtilsDB;
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
import Util.conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static spark.Spark.after;
import static spark.Spark.exception;

public class UsuarioServicios {

    private UsuarioServicios() {
    }

    public static JsonResponse<Personal> queryUsuarioadmin(JsonObject jsonObject) throws SQLException {

        String user = jsonObject.get(Constantes.JSON_USARIO_ADMIN).getAsString();
        String password = jsonObject.get(Constantes.JSON_CLAVE_USUARIO_ADMIN).getAsString();

        String userFormated = "'" + user + "'";
        String passwordFormated = "'" + password + "'";

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setProjection("*");
        sqlStatement.setTable(CheckMobileTables.PERSONAL.TABLE_NAME);
        String argument = " WHERE " + CheckMobileTables.PERSONAL.USUARIO + " = " + userFormated
                + " AND " + CheckMobileTables.PERSONAL.CLAVE + " = " + passwordFormated;

        sqlStatement.setArguments(argument);
        sqlStatement.setOrderBy(null);
        // System.out.print(sqlStatement);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PERSONAL);

        List<Personal> usuario = new ArrayList<>();
        for (Object currentUsuario : objetos) {
            Personal per = (Personal) currentUsuario;
            usuario.add(per);

        }
        
        if (!usuario.isEmpty())
        {
           conectarNuevamente(user, password);
        }
        

        JsonResponse<Personal> response = new JsonResponse<>();
        response.setData(usuario);
        response.setRows(usuario.size());
        response.setMessage("Successful.");

        return response;
   
    }

    private static void conectarNuevamente(String user, String password) {
        
        Utils.log("Cargando...");
        boolean setUpStatus = Utils.setUpConfigParameters(user, password);

        if (!setUpStatus) {
            System.out.println("No se pudo ejecutar la configuracion.");
            
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

    /**
     * Sets the after filter.
     */
    private static void setAfter() {
        after((request, response) -> response.type(Constantes.JSON));
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
        setTablaDgiiRutas(); /**/
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

    }
}
