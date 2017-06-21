package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
import Modelos.ProductoServicios;
import Modelos.SqlStatement;
import Util.Constantes;
import Util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class ProductoEncServicios {

    private ProductoEncServicios() {
    }

    public static JsonResponse<ProductoServicios> queryProductoEnc(JsonObject jsonObject) throws SQLException {

        String idServicio = null;
        String idClasificacion = null;
        String argumentos = null;
       String parametroFormated = null;
       
      

        if (jsonObject != null) {
            idServicio = jsonObject.has(Constantes.JSON_KEY_PRODUCTO_ID) ? jsonObject.get(Constantes.JSON_KEY_PRODUCTO_ID).getAsString() : null;
            idClasificacion = jsonObject.has(Constantes.JSON_KEY_CLASIFICACION) ? jsonObject.get(Constantes.JSON_KEY_CLASIFICACION).getAsString() : null;            
        }
        if (idServicio == null && idClasificacion == null) {
            argumentos = " WHERE " + CheckMobileTables.PRODUCTO_SERVICIOS.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " AND " + CheckMobileTables.PRODUCTO_SERVICIOS.ESTADO + " = 'A'";
        } else if (idClasificacion != null && idServicio == null){
          parametroFormated = "'" + idClasificacion + "'";
          // System.out.print(parametroFormated);
            argumentos = "WHERE " + CheckMobileTables.PRODUCTO_SERVICIOS.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " AND " + CheckMobileTables.PRODUCTO_SERVICIOS.ESTADO + " = 'A'" + " AND "
                   + CheckMobileTables.PRODUCTO_SERVICIOS.ID_CLASIFICACION + " = " + idClasificacion;
            
            // + CheckMobileTables.PRODUCTO_SERVICIOS.ID_SERVICIO + "=" + idServicio + " AND "

        }
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.PRODUCTO_SERVICIOS.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.PRODUCTO_SERVICIOS.ID_SERVICIO);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PRODUCTO_SERVICIOS);
        List<ProductoServicios> producto_servicio = new ArrayList<>();
        for (Object currentProducto : objects) {
            ProductoServicios prod = (ProductoServicios) currentProducto;
            producto_servicio.add(prod);
        }

        JsonResponse<ProductoServicios> response = new JsonResponse<>();
        response.setData(producto_servicio);
        response.setRows(producto_servicio.size());
        response.setMessage("Successful.");

        return response;

    }

    public static JsonResponse insertProductoEnc(JsonObject jsonObject) {

        Type pedidoListType = new TypeToken<ArrayList<ProductoServicios>>() {
        }.getType();
        ArrayList<ProductoServicios> producto_servicio
                = (ArrayList<ProductoServicios>) JsonUtils.fromJson(jsonObject.get("data").toString(), pedidoListType);

        int registroInsertado = UtilsDB.executeInsert(producto_servicio, ObjetosDB.PRODUCTO_SERVICIOS);

        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;

        JsonResponse respuesta = new JsonResponse<>();
        respuesta.setRows(registroInsertado);

        if (codigoServidor.equals(Constantes.RESPONSE_CODE_OK)) {
            respuesta.setMessage("Listo.");
        } else {
            respuesta.setResponseCode(codigoServidor);
            respuesta.setMessage("Ha ocurrido un error");
        }
        return respuesta;
    }
}
