/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.InspeccionVehiculo;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql.SqlOperation;
import Modelos.SqlStatement;
import Util.Constantes;
import Util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class InspeccionVehServicios {

    private InspeccionVehServicios() {
    }

    //Queries en la tabla inspeccion_vehiculo
    public static JsonResponse<InspeccionVehiculo> queryInspeccionVeh(JsonObject jsonObject) throws SQLException {

        String idInspeccion = null;
        String argumentos;

        if (jsonObject != null) {
            idInspeccion = jsonObject.has(Constantes.JSON_KEY_INSPECCION) ? jsonObject.get(Constantes.JSON_KEY_INSPECCION).getAsString() : null;

        }
        if (idInspeccion != null) {
            argumentos = "WHERE " + CheckMobileTables.INSPECCION_VEHICULO.ID_INSPECCION
                    + " = " + idInspeccion + " AND " + CheckMobileTables.INSPECCION_VEHICULO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " AND " + CheckMobileTables.INSPECCION_VEHICULO.ESTADO + " = 'A' ";
        } else {
            argumentos = "WHERE " + CheckMobileTables.INSPECCION_VEHICULO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " AND " + CheckMobileTables.INSPECCION_VEHICULO.ESTADO + " = 'A' ";
        }
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.INSPECCION_VEHICULO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.INSPECCION_VEHICULO.ID_INSPECCION);
        //System.out.print(sqlStatement);
        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.INSPECCION_VEHICULO);
        List<InspeccionVehiculo> inspeccion = new ArrayList<>();
        for (Object currentInspeccion : objects) {
            InspeccionVehiculo insp = (InspeccionVehiculo) currentInspeccion;
            inspeccion.add(insp);
        }

        JsonResponse<InspeccionVehiculo> response = new JsonResponse<>();
        response.setData(inspeccion);
        response.setRows(inspeccion.size());
        response.setMessage("Successful.");

        return response;

    }

    //Queries en la tabla inspeccion_vehiculo
    public static JsonResponse<InspeccionVehiculo> querydetallado(JsonObject jsonObject) throws SQLException {

        String idInspeccion = null;
        String argumentos;
        SqlStatement sqlStatement = new SqlStatement();

        if (jsonObject != null) {
            idInspeccion = jsonObject.has(Constantes.JSON_KEY_INSPECCION) ? jsonObject.get(Constantes.JSON_KEY_INSPECCION).getAsString() : null;

        }
        if (idInspeccion != null) {
            argumentos = " WHERE i.id_empresa = v.id_empresa\n"
                    + " AND v.id_vehiculo       = i.id_vehiculo\n"
                    + " AND v.id_marca          = a.id_marca\n"
                    + " AND v.id_modelo         = b.id_modelo\n"
                    + " AND v.id_estilo         = es.id_estilo\n"
                    + " AND c.id_cliente        = v.id_cliente\n"
                    + " AND i.id_empresa        = '3'\n"
                    + " AND v.ID_TIPO_VEHICULO = t.ID_TIPO_VEHICULO\n"
                    + " AND p.usuario = i.usuario_insercion\n"
                     +" AND upper(p.usuario) = upper(i.usuario_insercion) "
                    + " AND i.estado = 'A'" + " AND i.id_inspeccion = " + idInspeccion;
        } else {
            argumentos = " WHERE i.id_empresa = v.id_empresa\n"
                    + " AND v.id_vehiculo       = i.id_vehiculo\n"
                    + " AND v.id_marca          = a.id_marca\n"
                    + " AND v.id_modelo         = b.id_modelo\n"
                    + " AND v.id_estilo         = es.id_estilo\n"
                    + " AND c.id_cliente        = v.id_cliente\n"
                    + " AND c.id_empresa        = i.id_empresa\n"
                    + " AND i.id_empresa        = '3'\n"
                    + " AND i.estado_inspeccion = 'P'\n"
                    + " AND v.ID_TIPO_VEHICULO = t.ID_TIPO_VEHICULO\n"
                    + " AND upper(p.usuario) = upper(i.usuario_insercion) "
                    + " AND i.estado = 'A'";
        }
       
        sqlStatement.setOperation(SqlOperation.SELECT);
        
        sqlStatement.setTable(" inspeccion_vehiculo i ,\n"
                + "  cliente c,\n"
                + "  vehiculo v,\n"
                + "  vehiculo_marca a,\n"
                + "  vehiculo_modelo b,\n"
                + "  vehiculo_estilo es,\n"
                + "  tipo_vehiculo t \n,"
                + " personal p\n");

        sqlStatement.setProjection("i.*, Trunc(sysdate - i.fecha_inspeccion) as dias,\n"
                + "  decode(c.tipo_entidad, 'E', c.nombre_empresa, c.nombres\n"
                + "  || ' '\n"
                + "  || c.apellidos) AS nombre_cliente,\n"
                + "  a.descripcion\n"
                + "  || ' '\n"
                + "  || b.descripcion\n"
                + "  || ' '\n"
                + "  || es.descripcion AS nombre_vehiculo, \n"
                + "  t.descripcion as tipo_veh, c.id_condicion, "
                + " v.placa, v.color,"
                + " nvl(c.DOCUMENTO_IDENTIDAD, c.RNC) as identidad,"
                + "  c.TELEFONO, c.TELEFONO_MOVIL as celular , p.nombres || ' ' || p.apellidos as usuario_insercion\n");

        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(" To_number(" + CheckMobileTables.INSPECCION_VEHICULO.ID_INSPECCION + ")");
         // System.out.println(sqlStatement);
        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.INSPECCION_VEHICULO);
        List<InspeccionVehiculo> inspeccion = new ArrayList<>();
        for (Object currentInspeccion : objects) {
            InspeccionVehiculo insp = (InspeccionVehiculo) currentInspeccion;
            inspeccion.add(insp);
        }

        JsonResponse<InspeccionVehiculo> response = new JsonResponse<>();
        response.setData(inspeccion);
        response.setRows(inspeccion.size());
        response.setMessage("Successful.");

        return response;

    }

    public static JsonResponse<InspeccionVehiculo> queryInspeccionFecha(JsonObject jsonObject) throws SQLException {

        String fechaInicial = null;
        String fechaFinal = null;
        String argumentos = null;

        if (jsonObject != null) {
            fechaInicial = jsonObject.has(Constantes.JSON_KEY_FECHA_INICIAL) ? jsonObject.get(Constantes.JSON_KEY_FECHA_INICIAL).getAsString() : null;
            fechaFinal = jsonObject.has(Constantes.JSON_KEY_FECHA_FINAL) ? jsonObject.get(Constantes.JSON_KEY_FECHA_FINAL).getAsString() : null;
        }
        if (fechaInicial != null && fechaFinal != null) {
            argumentos = "WHERE i." + CheckMobileTables.INSPECCION_VEHICULO.FECHA_INSPECCION + " >= "
                    + "To_date(" + "'" + fechaInicial + "'" + ", 'DD/MM/RRRR')" + " AND i."
                    + CheckMobileTables.INSPECCION_VEHICULO.FECHA_INSPECCION + " <= "
                    + "To_date(" + "'" + fechaFinal + "'" + ", 'DD/MM/RRRR')" + " AND i."
                    + CheckMobileTables.INSPECCION_VEHICULO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA + " AND "
                    + "i.id_empresa = v.id_empresa\n"
                    + " AND v.id_vehiculo       = i.id_vehiculo\n"
                    + " AND v.id_marca          = a.id_marca\n"
                    + " AND v.id_modelo         = b.id_modelo\n"
                    + " AND v.id_estilo         = c.id_estilo\n"
                    + " AND c.id_cliente        = v.id_cliente\n"
                    + " AND i.id_empresa        = '3'\n"
                    + " AND v.ID_TIPO_VEHICULO = t.ID_TIPO_VEHICULO";

        }
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.INSPECCION_VEHICULO.TABLE_NAME + " i, "
                + "  cliente c,\n"
                + "  vehiculo v,\n"
                + "  vehiculo_marca a,\n"
                + "  vehiculo_modelo b,\n"
                + "  vehiculo_estilo c,\n"
                + "  tipo_vehiculo t");
        sqlStatement.setProjection("i.*, Trunc(sysdate - i.fecha_inspeccion) as dias, "
                + "c.nombres "
                + " || ' ' || "
                + " c.apellidos AS nombre_cliente, "
                + " a.descripcion"
                + "  || ' ' ||"
                + "  b.descripcion"
                + "  || ' ' || "
                + " c.descripcion AS nombre_vehiculo, "
                + " t.descripcion as tipo_veh, c.id_condicion, "
                + "v.placa, v.color, nvl(c.DOCUMENTO_IDENTIDAD, c.RNC) as identidad,  c.TELEFONO, c.TELEFONO_MOVIL as celular");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy("To_number( i." + CheckMobileTables.INSPECCION_VEHICULO.ID_INSPECCION + ")");

        // System.out.println(sqlStatement);
        //System.out.print(sqlStatement);
        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.INSPECCION_VEHICULO);
        List<InspeccionVehiculo> inspeccion = new ArrayList<>();
        for (Object currentInspeccion : objects) {
            InspeccionVehiculo insp = (InspeccionVehiculo) currentInspeccion;
            inspeccion.add(insp);
        }

        JsonResponse<InspeccionVehiculo> response = new JsonResponse<>();
        response.setData(inspeccion);
        response.setRows(inspeccion.size());
        response.setMessage("Successful.");

        return response;

    }

    //Queries en la tabla inspeccion_vehiculo
    public static JsonResponse<InspeccionVehiculo> queryInspeccionPorVehiculo(JsonObject jsonObject) throws SQLException {

        String referencia = null;
        String argumentos = null;
        SqlStatement sqlStatement = new SqlStatement();

        if (jsonObject != null) {
            referencia = jsonObject.has(Constantes.JSON_KEY_VEHICULO) ? jsonObject.get(Constantes.JSON_KEY_VEHICULO).getAsString() : null;

        }
        if (referencia != null) {
            argumentos = "WHERE i.id_empresa = v.id_empresa\n"
                    + " AND v.id_vehiculo       = i.id_vehiculo\n"
                    + " AND v.id_marca          = a.id_marca\n"
                    + " AND v.id_modelo         = b.id_modelo\n"
                    + " AND v.id_estilo         = c.id_estilo\n"
                    + " AND c.id_cliente        = v.id_cliente\n"
                    + " AND i.id_empresa        = '3'\n"
                    + "AND  i.estado_inspeccion = 'F'"
                    + " AND v.ID_TIPO_VEHICULO = t.ID_TIPO_VEHICULO"
                    + " AND i.estado = 'A'" + " AND i.referencia = " + "'" + referencia + "'";

        }

        sqlStatement.setOperation(SqlOperation.SELECT);
        sqlStatement.setTable("inspeccion_vehiculo i ,\n"
                + "  cliente c,\n"
                + "  vehiculo v,\n"
                + "  vehiculo_marca a,\n"
                + "  vehiculo_modelo b,\n"
                + "  vehiculo_estilo c,\n"
                + "  tipo_vehiculo t");

        sqlStatement.setProjection("i.*, Trunc(sysdate - i.fecha_inspeccion) as dias,\n"
                + "  c.nombres\n"
                + "  || ' '\n"
                + "  || c.apellidos AS nombre_cliente,\n"
                + "  a.descripcion\n"
                + "  || ' '\n"
                + "  || b.descripcion\n"
                + "  || ' '\n"
                + "  || c.descripcion AS nombre_vehiculo, \n"
                + "  t.descripcion as tipo_veh, c.id_condicion, "
                + "v.placa, v.color, nvl(c.DOCUMENTO_IDENTIDAD, c.RNC) as identidad,  c.TELEFONO, c.TELEFONO_MOVIL as celular");

        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(" To_number(" + CheckMobileTables.INSPECCION_VEHICULO.ID_INSPECCION + ")");
        //   System.out.println(sqlStatement);
        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.INSPECCION_VEHICULO);
        List<InspeccionVehiculo> inspeccion = new ArrayList<>();
        for (Object currentInspeccion : objects) {
            InspeccionVehiculo insp = (InspeccionVehiculo) currentInspeccion;
            inspeccion.add(insp);
        }
        //  System.out.println(sqlStatement);
        JsonResponse<InspeccionVehiculo> response = new JsonResponse<>();
        response.setData(inspeccion);
        response.setRows(inspeccion.size());
        response.setMessage("Successful.");

        return response;

    }

    //Inserts lista de inspecciones de vehiculos 
    public static String insertInspeccion(String jsonObject) {
        //  System.out.println(jsonObject);
        Type inspeccionListType = new TypeToken<ArrayList<InspeccionVehiculo>>() {
        }.getType();
        ArrayList<InspeccionVehiculo> inspeccion
                = (ArrayList<InspeccionVehiculo>) JsonUtils.fromJson(jsonObject, inspeccionListType);

        int registroInsertado = UtilsDB.executeInsert(inspeccion, ObjetosDB.INSPECCION_VEHICULO);

        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;

        JsonResponse respuesta = new JsonResponse<>();
        respuesta.setRows(registroInsertado);

        /*if (codigoServidor.equals(Constantes.RESPONSE_CODE_OK)) {
         respuesta.setMessage("Listo.");
         } else {
         respuesta.setResponseCode(codigoServidor);
         respuesta.setMessage("Ha ocurrido un error");
         }*/
        return codigoServidor + "," + UtilsDB.idInspeccion;
    }

    public static String updateInspeccion(String jsonObject) {
        //  System.out.println(jsonObject);
        Type inspeccionListType = new TypeToken<ArrayList<InspeccionVehiculo>>() {
        }.getType();
        ArrayList<InspeccionVehiculo> inspeccion
                = (ArrayList<InspeccionVehiculo>) JsonUtils.fromJson(jsonObject, inspeccionListType);

        int registroActualizado = UtilsDB.executeUpdate(inspeccion, ObjetosDB.INSPECCION_VEHICULO);

        String codigoServidor = registroActualizado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;

//        JsonResponse respuesta = new JsonResponse<>();
//        respuesta.setRows(registroActualizado);

        /*if (codigoServidor.equals(Constantes.RESPONSE_CODE_OK)) {
         respuesta.setMessage("Listo.");
         } else {
         respuesta.setResponseCode(codigoServidor);
         respuesta.setMessage("Ha ocurrido un error");
         }*/
        return codigoServidor;
    }

    public static String anularInspeccion(String jsonObject) {

        String[] parametros = jsonObject.split(",");

        int registroInsertado = UtilsDB.executeUpdate(parametros, ObjetosDB.INSPECCION_VEHICULO);

        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;

        return codigoServidor;
    }

    public static String convertInspeccion(String jsonObject) {

        int registroInsertado = UtilsDB.executeUpdate(jsonObject, ObjetosDB.INSPECCION_VEHICULO);

        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;

        return codigoServidor;
    }
}
