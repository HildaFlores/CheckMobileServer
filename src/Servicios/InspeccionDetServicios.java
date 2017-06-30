package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.InspeccionVehiculoDetalle;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
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
public class InspeccionDetServicios {

    private InspeccionDetServicios() {
    }

    //Queries tabla Inspeccion_Vehiculo_detalle
    public static JsonResponse<InspeccionVehiculoDetalle> queryInspeccionVehDet(JsonObject jsonObject) throws SQLException {

        String idInspeccion = null;
        String argumentos;
        String formated;

        if (jsonObject != null) {
            idInspeccion = jsonObject.has(Constantes.JSON_KEY_INSPECCION) ? jsonObject.get(Constantes.JSON_KEY_INSPECCION).getAsString() : null;

        }

        if (idInspeccion == null) {
            argumentos = "WHERE " + CheckMobileTables.INSPECCION_VEHICULO.ID_INSPECCION
                    + " = " + CheckMobileTables.INSPECCION_VEHICULO_DETALLE.ID_INSPECCION + " AND "
                    + CheckMobileTables.INSPECCION_VEHICULO_DETALLE.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " AND " + CheckMobileTables.INSPECCION_VEHICULO_DETALLE.ESTADO + " = 'A' ";
        } else {

            argumentos = "WHERE i.id_respuesta = r.id_respuesta\n"
                    + " and i.id_empresa = r.id_empresa and i.id_empresa = 3\n"
                    + " and i.estado = 'A' and i.id_inspeccion = " + idInspeccion
                    + " and l.valor = i.id_elemento_inspeccion and l.id_lista = i.id_lista_parametro\n"
                    + " and i.id_empresa = l.id_empresa";
        }
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable("inspeccion_vehiculo_detalle i, respuestas r, lista_parametro_det l");
        sqlStatement.setProjection("i.*, r.descripcion as desc_respuesta, l.DESCRIPCION as desc_elemento");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.INSPECCION_VEHICULO_DETALLE.ID_INSPECCION);

        
        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.INSPECCION_VEHICULO_DETALLE);
        List<InspeccionVehiculoDetalle> inspeccion = new ArrayList<>();

        for (Object currentInspeccion : objects) {
            InspeccionVehiculoDetalle insp = (InspeccionVehiculoDetalle) currentInspeccion;
            inspeccion.add(insp);
        }

        JsonResponse<InspeccionVehiculoDetalle> response = new JsonResponse<>();
        response.setData(inspeccion);
        response.setRows(inspeccion.size());
        response.setMessage("Successful.");

        return response;

    }

    //Inserts inspecciones de vehiculos
    public static String insertInspeccionDet(String jsonObject) {
        Type inspeccionListType = new TypeToken<ArrayList<InspeccionVehiculoDetalle>>() {
        }.getType();
        ArrayList<InspeccionVehiculoDetalle> inspeccion
                = (ArrayList<InspeccionVehiculoDetalle>) JsonUtils.fromJson(jsonObject, inspeccionListType);
        int registroInsertado;
        registroInsertado = UtilsDB.executeInsert(inspeccion, ObjetosDB.INSPECCION_VEHICULO_DETALLE);

        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;

        /* JsonResponse respuesta = new JsonResponse<>();
         respuesta.setRows(registroInsertado);

         if (codigoServidor.equals(Constantes.RESPONSE_CODE_OK)) {
         respuesta.setMessage("Listo.");
         } else {
         respuesta.setResponseCode(codigoServidor);
         respuesta.setMessage("Ha ocurrido un error");
         }*/
        System.out.print(registroInsertado);
        return codigoServidor;
    }

}
