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
import Modelos.SqlStatement;
import Modelos.VehiculoModelo;
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
public class ModeloServicios {

    private ModeloServicios() {
    }

    //Queries de la tabla modelo
    public static JsonResponse<VehiculoModelo> queryModelo(JsonObject jsonObject) throws SQLException {

        String idMarca = null;
        String argumentos;
        String parametroFormated;

        if (jsonObject != null) {
            idMarca = jsonObject.has(Constantes.JSON_KEY_MARCA) ? jsonObject.get(Constantes.JSON_KEY_MARCA).getAsString() : null;
        }

        if (idMarca == null) {

            argumentos = " WHERE " + CheckMobileTables.VEHICULO_MODELO.ESTADO + " = " + "'A'" + " AND "
                    + CheckMobileTables.VEHICULO_MODELO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        } else {
            //idMarca = idMarca.substring(1, idMarca.length() - 1);
            parametroFormated = "'" + idMarca + "'";
            argumentos = " WHERE " + CheckMobileTables.VEHICULO_MODELO.ID_MARCA + " = " + parametroFormated + " AND "
                    + CheckMobileTables.VEHICULO_MODELO.ESTADO + " = " + " 'A'" + " AND "
                    + CheckMobileTables.VEHICULO_MODELO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        }

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.VEHICULO_MODELO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.VEHICULO_MODELO.DESCRIPCION);

        //System.out.println(sqlStatement);
        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.VEHICULO_MODELO);
        List<VehiculoModelo> veh = new ArrayList<>();
        for (Object currentCliente : objetos) {
            VehiculoModelo cte = (VehiculoModelo) currentCliente;
            veh.add(cte);

        }
        //UtilsDB.
        JsonResponse<VehiculoModelo> response = new JsonResponse<>();
        response.setData(veh);
        response.setRows(veh.size());
        response.setMessage("Successful.");

        return response;

    }

    /**
     * Inserts a list of modelos.
     *
     * @param jsonObject The request body content.
     * @return The numbers of rows inserted.
     */
    public static String insertModelo(String jsonObject) {
        Type type = new TypeToken<ArrayList<VehiculoModelo>>() {
        }.getType();
        ArrayList<VehiculoModelo> veh = (ArrayList<VehiculoModelo>) JsonUtils.fromJson(jsonObject, type);
        int registroInsertado = UtilsDB.executeInsert(veh, ObjetosDB.VEHICULO_MODELO);
       // System.out.println(jsonObject);
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

        return codigoServidor + "," + UtilsDB.idModelo;
    }

}
