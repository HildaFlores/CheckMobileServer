
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.InspeccionVehiculo;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
import Modelos.PedidoEnc;
import Modelos.SqlStatement;
import Util.Constantes;
import Util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PedidoEncServicios {

    private PedidoEncServicios() {
    }

    //Queries de la tabla pedido_enc
    public static JsonResponse<PedidoEnc> queryPedidoEnc(JsonObject jsonObject) throws SQLException {

        String idDocumento = null;
        String tipoTrans = null;
        String argumentos = null;
        String formated;

        if (jsonObject != null) {
            idDocumento = jsonObject.has(Constantes.JSON_KEY_PEDIDO_ID) ? jsonObject.get(Constantes.JSON_KEY_PEDIDO_ID).getAsString() : null;
            tipoTrans = jsonObject.has(Constantes.JSON_KEY_TIPO_TRANS) ? jsonObject.get(Constantes.JSON_KEY_TIPO_TRANS).getAsString() : null;
        }

        if (idDocumento == null && tipoTrans == null) {
            argumentos = null;
//            argumentos = " WHERE " + CheckMobileTables.PEDIDO_ENC.ESTADO + " = 'A' " + " AND "
//                    + CheckMobileTables.PEDIDO_ENC.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
//                    + " AND " + CheckMobileTables.PEDIDO_ENC.ESTADO_DOCUMENTO + " = 'V'";
        } else if (tipoTrans != null && idDocumento == null) {
            formated = "'" + tipoTrans + "'";
            argumentos = "where p.id_empresa = c.id_empresa\n"
                    + " and p.id_rep_ven = c.id_rep_ven\n"
                    + " and p.id_condicion = co.id_condicion\n"
                    + " and p.estado = 'A' and p.id_empresa = co.id_empresa"
                    + " and p." + CheckMobileTables.PEDIDO_ENC.ID_TIPO_TRANS + " = " + formated
                    + " and p." + CheckMobileTables.PEDIDO_ENC.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " and p." + CheckMobileTables.PEDIDO_ENC.ESTADO_DOCUMENTO + " = 'V'";

        }

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable("pedido_enc p, cte_representante_ven c, condicion_pago co");
        sqlStatement.setProjection(" p.*, c.nombres  || ' ' || c.apellidos as nombre_mecanico, co.descripcion as condicion");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(" to_number(p." + CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO + ")");
       
        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PEDIDO_ENC);
        List<PedidoEnc> pedidos = new ArrayList<>();
        for (Object currentInspeccion : objects) {
            PedidoEnc insp = (PedidoEnc) currentInspeccion;
            pedidos.add(insp);
        }

        JsonResponse<PedidoEnc> response = new JsonResponse<>();
        response.setData(pedidos);
        response.setRows(pedidos.size());
        response.setMessage("Successful.");

        return response;

    }

    //Inserts de lista de pedido
    public static String insertPedidoEnc(String jsonObject) {

        Type pedidoListType = new TypeToken<ArrayList<PedidoEnc>>() {
        }.getType();
        ArrayList<PedidoEnc> pedido
                = (ArrayList<PedidoEnc>) JsonUtils.fromJson(jsonObject, pedidoListType);

        int registroInsertado = UtilsDB.executeInsert(pedido, ObjetosDB.PEDIDO_ENC);

        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;

//        JsonResponse respuesta = new JsonResponse<>();
//        respuesta.setRows(registroInsertado);
//
//        if (codigoServidor.equals(Constantes.RESPONSE_CODE_OK)) {
//            respuesta.setMessage("Listo.");
//        } else {
//            respuesta.setResponseCode(codigoServidor);
//            respuesta.setMessage("Ha ocurrido un error");
//        }
        return codigoServidor + "," + UtilsDB.idDocumento;
    }
    
    public static String updateOrdenTrabajo(String jsonObject) {
        Type inspeccionListType = new TypeToken<ArrayList<PedidoEnc>>() {
        }.getType();
        ArrayList<PedidoEnc> pedido
                = (ArrayList<PedidoEnc>) JsonUtils.fromJson(jsonObject, inspeccionListType);

        int registroActualizado = UtilsDB.executeUpdate(pedido, ObjetosDB.PEDIDO_ENC);

        String codigoServidor = registroActualizado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;

        return codigoServidor;
    }

    public static String anularPedido(String jsonObject) {
        int registroInsertado = UtilsDB.executeUpdate(jsonObject, ObjetosDB.PEDIDO_ENC);

        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;

        return codigoServidor;
    }
}
