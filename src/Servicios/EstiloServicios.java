/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.JsonResponse;
import Modelos.JsonResponse2;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
import Modelos.SqlStatement;
import Modelos.VehiculoEstilo;
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
public class EstiloServicios {

    private EstiloServicios() {
    }

    //Queries de la tabla estilo
    //
    public static List<Object> queryEstilo(JsonObject jsonObject) throws SQLException {
        String idModelo = null;
        String argumentos = null;
        String parametroFormated;
        //System.out.println(jsonObject);
          SqlStatement sqlStatement = new SqlStatement();
        
       if (jsonObject != null) {
         idModelo = jsonObject.has(Constantes.JSON_KEY_MODELO) ? jsonObject.get(Constantes.JSON_KEY_MODELO).getAsString() : null;
         }

        if (idModelo == null) {
            argumentos = " WHERE " + CheckMobileTables.VEHICULO_ESTILO.ESTADO + " = " + " 'A' " + " AND "
                    + CheckMobileTables.VEHICULO_ESTILO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        } else {
            parametroFormated = "'" + idModelo + "'";
            argumentos = " WHERE " + CheckMobileTables.VEHICULO_ESTILO.ID_MODELO + " = " + parametroFormated + " AND "
                    + CheckMobileTables.VEHICULO_ESTILO.ESTADO + " = " + "  'A' " + " AND "
                    + CheckMobileTables.VEHICULO_ESTILO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        }
  
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.VEHICULO_ESTILO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.VEHICULO_ESTILO.DESCRIPCION);
        //  System.out.print(sqlStatement);
        //  System.out.println(sqlStatement);
        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.VEHICULO_ESTILO);

        //List<VehiculoEstilo> veh = new ArrayList<>();
        /*  for (Object currentEstilo : objetos) {
         VehiculoEstilo cte = (VehiculoEstilo) currentEstilo;
         veh.add(cte);

         }*/

        /* //UtilsDB.
         JsonResponse2<VehiculoEstilo> response = new JsonResponse2<>();
         response.setData(veh);
         //response.setRows(veh.size());
         //response.setMessage("Successful.");
        
         return response;*/
        return objetos;

    }

    /**
     * Inserts lista de estilos
     *
     * @param jsonObject The request body content.
     * @return The numbers of rows inserted.
     */
    public static String insertEstilo(String jsonObject) {
        Type type = new TypeToken<ArrayList<VehiculoEstilo>>() {
        }.getType();
        ArrayList<VehiculoEstilo> veh = (ArrayList<VehiculoEstilo>) JsonUtils.fromJson(jsonObject, type);
        int registroInsertado = UtilsDB.executeInsert(veh, ObjetosDB.VEHICULO_ESTILO);
        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;
//        JsonResponse respuesta = new JsonResponse<>();
//        respuesta.setRows(registroInsertado);
//
//        if (codigoServidor.equals(Constantes.RESPONSE_CODE_OK)) {
//            respuesta.setMessage("Listo.");
//        } else {
//            // respuesta.setResponseCode(codigoServidor);
//            respuesta.setMessage("Ha ocurrido un error");
//        }

        return codigoServidor + "," + UtilsDB.idEstilo;
    }

}
