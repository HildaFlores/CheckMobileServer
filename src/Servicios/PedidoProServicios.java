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
import Modelos.PedidoProducto;
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
public class PedidoProServicios {

    private PedidoProServicios() {
    }

    public static JsonResponse<PedidoProducto> queryPedidoDet(JsonObject jsonObject) throws SQLException {

        String idDocumento = null;
        String tipoTrans = null;
        
        
         if (jsonObject != null) {
            idDocumento = jsonObject.has(Constantes.JSON_KEY_PEDIDO_ID) ? jsonObject.get(Constantes.JSON_KEY_PEDIDO_ID).getAsString() : null;
            tipoTrans = jsonObject.has(Constantes.JSON_KEY_TIPO_TRANS) ? jsonObject.get(Constantes.JSON_KEY_TIPO_TRANS).getAsString() : null;
        }
        
        String argumentos;
        if (idDocumento == null) {
            argumentos = "WHERE " + CheckMobileTables.PEDIDO_PRODUCTO.ID_DOCUMENTO
                    + " = " + CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO + " AND "
                    + CheckMobileTables.PEDIDO_PRODUCTO.ID_EMPRESA + " = "
                    + Constantes.ID_EMPRESA + " AND " + CheckMobileTables.PEDIDO_PRODUCTO.ESTADO + " = 'A'" + " AND "
                    + CheckMobileTables.PEDIDO_PRODUCTO.ID_TIPO_TRANS + " = " + tipoTrans;

        } else {
            argumentos = "WHERE " + CheckMobileTables.PEDIDO_PRODUCTO.ID_DOCUMENTO + " = " + idDocumento
                    + " AND " + CheckMobileTables.PEDIDO_PRODUCTO.ID_DOCUMENTO + " = " + CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO
                    + " AND " + CheckMobileTables.PEDIDO_PRODUCTO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " AND " + CheckMobileTables.PEDIDO_PRODUCTO.ESTADO + " = 'A' ";
        }
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.PEDIDO_PRODUCTO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.PEDIDO_PRODUCTO.ID_DOCUMENTO);

        //System.out.print(sqlStatement.toString());
        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PEDIDO_PRODUCTO);
        List<PedidoProducto> pedProducto = new ArrayList<>();
        for (Object currentInspeccion : objects) {
            PedidoProducto ped = (PedidoProducto) currentInspeccion;
            pedProducto.add(ped);
        }

        JsonResponse<PedidoProducto> response = new JsonResponse<>();
        response.setData(pedProducto);
        response.setRows(pedProducto.size());
        response.setMessage("Successful.");

        return response;

    }

    public static JsonResponse insertPedidoDet(JsonObject jsonObject) {

        Type pedidoListType = new TypeToken<ArrayList<PedidoProducto>>() {
        }.getType();
        ArrayList<PedidoProducto> pedido
                = (ArrayList<PedidoProducto>) JsonUtils.fromJson(jsonObject.get("data").toString(), pedidoListType);

        int registroInsertado = UtilsDB.executeInsert(pedido, ObjetosDB.PEDIDO_PRODUCTO);
        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_OK;
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
