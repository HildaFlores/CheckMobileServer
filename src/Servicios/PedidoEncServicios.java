package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
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
        String formated = null;

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
                    + " and p.id_supervisor = pe.id_personal\n"
                    + " and p.estado = 'A' and p.id_empresa = co.id_empresa"
                    + " and p.id_empresa = pe.id_empresa\n"
                    + " and p." + CheckMobileTables.PEDIDO_ENC.ID_TIPO_TRANS + " = " + formated
                    + " and p." + CheckMobileTables.PEDIDO_ENC.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " and p." + CheckMobileTables.PEDIDO_ENC.ESTADO_DOCUMENTO + " = 'V'";

        }

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable("pedido_enc p, cte_representante_ven c, condicion_pago co, personal pe");
        sqlStatement.setProjection(" p.*, c.nombres  || ' ' || c.apellidos as nombre_mecanico,"
                + " co.descripcion as condicion, pe.nombres || ' '|| pe.apellidos as nombreSupervisor");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(" to_number(p." + CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO + ")");

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PEDIDO_ENC);

        //  System.out.println(sqlStatement);
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

    //Queries de la tabla pedido_enc
    public static JsonResponse<PedidoEnc> queryPedidoPorReferencia(JsonObject jsonObject) throws SQLException {

        String referencia = null;
        String argumentos = null;

        if (jsonObject != null) {
            referencia = jsonObject.has(Constantes.JSON_KEY_VEHICULO) ? jsonObject.get(Constantes.JSON_KEY_VEHICULO).getAsString() : null;
        }

        if (referencia != null) {

            argumentos = " where p.id_empresa = c.id_empresa\n"
                    + " and p.id_rep_ven = c.id_rep_ven\n"
                    + " and p.id_condicion = co.id_condicion\n"
                    + " and p.id_supervisor = pe.id_personal\n"
                    + " and p.estado = 'A' and p.id_empresa = co.id_empresa"
                    + " and p.id_empresa = pe.id_empresa\n"
                    + " and p." + CheckMobileTables.PEDIDO_ENC.ID_TIPO_TRANS + " = " + "'OTT'"
                    + " and p." + CheckMobileTables.PEDIDO_ENC.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " and p." + CheckMobileTables.PEDIDO_ENC.ESTADO_DOCUMENTO + " = 'V'"
                    + " and p.referencia = " + "'" + referencia + "'";

        }

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable("pedido_enc p, cte_representante_ven c, condicion_pago co, personal pe");
        sqlStatement.setProjection(" p.*, c.nombres  || ' ' || c.apellidos as nombre_mecanico,"
                + " co.descripcion as condicion, pe.nombres || ' '|| pe.apellidos as nombreSupervisor");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(" to_number(p." + CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO + ")");

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PEDIDO_ENC);

        //  System.out.println(sqlStatement);
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

    
     //Queries de la tabla pedido_enc
    public static JsonResponse<PedidoEnc> queryMantenimientoPorReferencia(JsonObject jsonObject) throws SQLException {

        String referencia = null;
        String argumentos = null;

        if (jsonObject != null) {
            referencia = jsonObject.has(Constantes.JSON_KEY_VEHICULO) ? jsonObject.get(Constantes.JSON_KEY_VEHICULO).getAsString() : null;
        }

        if (referencia != null) {

            argumentos = " where p.id_empresa = c.id_empresa\n"
                    + " and p.id_rep_ven = c.id_rep_ven\n"
                    + " and p.id_condicion = co.id_condicion\n"
                    + " and p.id_supervisor = pe.id_personal\n"
                    + " and p.estado = 'A' and p.id_empresa = co.id_empresa"
                    + " and p.id_empresa = pe.id_empresa\n" 
                    + " and p.id_tipo_trans = pro.id_tipo_trans\n"
                    + " and p.id_documento = pro.id_documento\n"
                    + " and p.id_empresa = pro.id_empresa\n" 
                    + " and p.id_inspeccion = ins.id_inspeccion\n"
                    + " and p." + CheckMobileTables.PEDIDO_ENC.ID_TIPO_TRANS + " = " + "'OTT'"
                    + " and p." + CheckMobileTables.PEDIDO_ENC.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " and p." + CheckMobileTables.PEDIDO_ENC.ESTADO_DOCUMENTO + " = 'V'"
                    + " and p.referencia = " + "'" + referencia + "'" 
                    + " and pro.id_producto = '2937' ";

        }

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable("pedido_enc p, cte_representante_ven c,"
                + " condicion_pago co, personal pe, pedido_producto pro, inspeccion_vehiculo ins");
        sqlStatement.setProjection(" p.*, c.nombres  || ' ' || c.apellidos as nombre_mecanico,"
                + " co.descripcion as condicion, pe.nombres || ' '|| pe.apellidos as nombreSupervisor, ins.kilometraje");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(" to_number(p." + CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO + ")");

        List<Object> objects = UtilsDB.executeQuery2(sqlStatement, ObjetosDB.PEDIDO_ENC);

        //  System.out.println(sqlStatement);
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
    
    //Queries de la tabla pedido_enc
    public static JsonResponse<PedidoEnc> queryPedidoEncFecha(JsonObject jsonObject) throws SQLException {

        String fechaIni = null;
        String fechaFin = null;
        String tipoTrans = null;
        String argumentos = null;
        String formated;

        if (jsonObject != null) {
            fechaIni = jsonObject.has(Constantes.JSON_KEY_FECHA_INICIAL) ? jsonObject.get(Constantes.JSON_KEY_FECHA_INICIAL).getAsString() : null;
            fechaFin = jsonObject.has(Constantes.JSON_KEY_FECHA_FINAL) ? jsonObject.get(Constantes.JSON_KEY_FECHA_FINAL).getAsString() : null;
            tipoTrans = jsonObject.has(Constantes.JSON_KEY_TIPO_TRANS) ? jsonObject.get(Constantes.JSON_KEY_TIPO_TRANS).getAsString() : null;
        }

        if (tipoTrans != null && fechaIni != null && fechaFin != null) {
            formated = "'" + tipoTrans + "'";
            argumentos = " WHERE p.id_empresa      = c.id_empresa "
                    + "AND p.id_rep_ven        = c.id_rep_ven "
                    + "AND p.id_condicion      = co.id_condicion "
                    + "AND p.id_empresa        = co.id_empresa "
                    + "AND p.id_inspeccion       = i.id_inspeccion "
                    + "AND p.id_empresa        = i.id_empresa "
                    + "AND p." + CheckMobileTables.PEDIDO_ENC.ID_TIPO_TRANS + " = " + formated + " "
                    + "AND p." + CheckMobileTables.PEDIDO_ENC.ID_EMPRESA + " = " + Constantes.ID_EMPRESA + " "
                    + "AND p." + CheckMobileTables.PEDIDO_ENC.ESTADO_DOCUMENTO + " <> 'N' "
                    + "AND p.estado            = 'A' "
                    + "AND p.id_documento      = prod.id_documento "
                    + "AND p.id_tipo_trans     = prod.id_tipo_trans "
                    + "AND p.id_empresa        = prod.id_empresa "
                    + "AND p.id_supervisor     = pe.id_personal "
                    + "AND p.id_empresa = pe.id_empresa "
                    + "AND prod.id_producto    = " + Constantes.ID_PRODUCTO_MANTENIMIENTO + " "
                    + "AND p.fecha_pedido   >= to_date(' " + fechaIni + "', 'DD/MM/RRRR') "
                    + "AND p.fecha_pedido <= to_date('" + fechaFin + "', 'DD/MM/RRRR') ";

        }

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable("pedido_enc p, cte_representante_ven c,"
                + " condicion_pago co, pedido_producto prod, inspeccion_vehiculo i, personal pe");
        sqlStatement.setProjection(" p.*, c.nombres  || ' ' || c.apellidos as nombre_mecanico, "
                + "co.descripcion as condicion, i.kilometraje, pe.nombres || ' '|| pe.apellidos as nombreSupervisor ");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(" to_number(p." + CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO + ")");

        //System.out.print(sqlStatement);
        List<Object> objects = UtilsDB.executeQuery2(sqlStatement, ObjetosDB.PEDIDO_ENC);
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
