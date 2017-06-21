/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
import Modelos.ProductoPrecio;
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
public class ProductoDetServicios {

    private ProductoDetServicios() {
    }

    public static JsonResponse<ProductoPrecio> queryProductoDet(JsonObject jsonObject) throws SQLException {

        String idServicio = null;
        String argumentos;

        if (jsonObject != null) {
            idServicio = jsonObject.has(Constantes.JSON_KEY_PRODUCTO_ID) ? jsonObject.get(Constantes.JSON_KEY_PRODUCTO_ID).getAsString() : null;
        
            
        }
        if (idServicio == null) {
            argumentos = "WHERE " + CheckMobileTables.PRODUCTO_PRECIO.ESTADO + " = 'A'"
                    + " AND " + CheckMobileTables.PRODUCTO_PRECIO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;

        } else {
            argumentos = "WHERE " + CheckMobileTables.PRODUCTO_PRECIO.ESTADO + " = 'A' "
                    + " AND " + CheckMobileTables.PRODUCTO_PRECIO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " AND " + CheckMobileTables.PRODUCTO_PRECIO.ID_SERVICIO + " = " + idServicio;

        }

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.PRODUCTO_PRECIO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.PRODUCTO_PRECIO.ID_SERVICIO);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PRODUCTO_PRECIO);
        List<ProductoPrecio> producto_precio = new ArrayList<>();
        for (Object currentProducto : objects) {
            ProductoPrecio prod = (ProductoPrecio) currentProducto;
            producto_precio.add(prod);
        }

        JsonResponse<ProductoPrecio> response = new JsonResponse<>();
        response.setData(producto_precio);
        response.setRows(producto_precio.size());
        response.setMessage("Successful.");

        return response;

    }

    public static JsonResponse insertProductoDet(JsonObject jsonObject) {

        Type pedidoListType = new TypeToken<ArrayList<ProductoPrecio>>() {
        }.getType();
        ArrayList<ProductoPrecio> producto_servicio
                = (ArrayList<ProductoPrecio>) JsonUtils.fromJson(jsonObject.get("data").toString(), pedidoListType);

        int registroInsertado = UtilsDB.executeInsert(producto_servicio, ObjetosDB.PRODUCTO_PRECIO);

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
