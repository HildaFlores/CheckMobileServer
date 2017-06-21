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
import Modelos.Vehiculo;
import Util.Constantes;
import Util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoServicios {

    private VehiculoServicios() {
    }

    //Queries de la tabla vehiculo
    public static JsonResponse<Vehiculo> queryVehiculo(JsonObject jsonObject) throws SQLException {
        String idVehiculo = null;
        String argumentos;

        if (jsonObject != null) {
            idVehiculo = jsonObject.has(Constantes.JSON_KEY_VEHICULO) ? jsonObject.get(Constantes.JSON_KEY_VEHICULO).getAsString() : null;

        }
        if (idVehiculo == null) {
            argumentos = " WHERE " + CheckMobileTables.VEHICULO.ESTADO + " = " + " 'A' " + " AND "
                    + CheckMobileTables.VEHICULO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;

        } else {
            argumentos = " WHERE " + CheckMobileTables.VEHICULO.ID_VEHICULO + " = "
                    + idVehiculo + " AND " + CheckMobileTables.VEHICULO.ESTADO + " = " + " 'A'" + " AND "
                    + CheckMobileTables.VEHICULO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        }

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.VEHICULO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.VEHICULO.ID_VEHICULO);
        //  System.out.print(sqlStatement);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.VEHICULO);
        List<Vehiculo> veh = new ArrayList<>();
        for (Object currentVehiculo : objetos) {
            Vehiculo cte = (Vehiculo) currentVehiculo;
            veh.add(cte);

        }
        //UtilsDB.
        JsonResponse<Vehiculo> response = new JsonResponse<>();
        response.setData(veh);
        response.setRows(veh.size());
        response.setMessage("Successful.");
       
        return response;

    }

  
    public static JsonResponse queryDetVehiculo(JsonObject jsonObject) throws SQLException {

        String referencia = null;
        String argumentos;
       // System.out.println(jsonObject);
        String referenciaFormat = null;

        if (jsonObject != null) {
            referencia = jsonObject.has(Constantes.JSON_KEY_VEHICULO) ? jsonObject.get(Constantes.JSON_KEY_VEHICULO).getAsString() : null;
           
            
        }

        if (referencia == null) {
            argumentos = "WHERE V.estado = 'A' AND V.id_empresa = 3 AND V.id_marca = M.id_marca"
                    + " AND V.id_modelo = O.id_modelo AND V.id_estilo = E.id_estilo"
                    + " AND V.id_empresa = M.id_empresa  AND V.id_empresa = O.id_empresa"
                    + " AND V.id_empresa = E.id_empresa";

        } else {
            referenciaFormat = "'" + referencia + "'"; 
            argumentos = " WHERE " + CheckMobileTables.VEHICULO.REFERENCIA + " = "
                    + referenciaFormat + " AND " +  " V.estado = 'A' AND V.id_empresa = 3 "
                    + " AND V.id_marca = M.id_marca AND V.id_modelo = O.id_modelo"
                    + " AND V.id_estilo = E.id_estilo AND V.id_empresa = M.id_empresa"
                    + " AND V.id_empresa = O.id_empresa"
                    + " AND V.id_empresa = E.id_empresa" ;
        }
      

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(" vehiculo_estilo E, vehiculo V"
         + ", vehiculo_marca M, vehiculo_modelo O");
        sqlStatement.setProjection("V.*, M.descripcion desc_marca, O.descripcion desc_modelo,E.descripcion desc_estilo");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy("V." + CheckMobileTables.VEHICULO.ID_VEHICULO);

       //  System.out.print(sqlStatement);
        
         List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.VEHICULO);
        List<Vehiculo> veh = new ArrayList<>();
        for (Object currentVehiculo : objetos) {
            Vehiculo cte = (Vehiculo) currentVehiculo;
            veh.add(cte);

        }
        
       
        //UtilsDB.
        JsonResponse<Vehiculo> response = new JsonResponse<>();
        response.setData(veh);
        response.setRows(veh.size());
        response.setMessage("Successful.");

        return response;

    }

  /**
     * Inserts lista de vehiculos.
     *
     * @param jsonObject The request body content.
     * @return The numbers of rows inserted.
     */

public static String insertVehiculo(String jsonObject) {
    // System.out.println(jsonObject);
        
     Type type = new TypeToken<ArrayList<Vehiculo>>() {
        }.getType();
           
        ArrayList<Vehiculo> veh = (ArrayList<Vehiculo>) JsonUtils.fromJson(jsonObject, type);
        
        int registroInsertado = UtilsDB.executeInsert(veh, ObjetosDB.VEHICULO);
        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;
      // JsonResponse respuesta = new JsonResponse<>();
     // respuesta.setRows(registroInsertado);
        
      
     /*if (codigoServidor.equals(Constantes.RESPONSE_CODE_OK)) {
            respuesta.setMessage("Listo.");
        } else {
            respuesta.setResponseCode(codigoServidor);
            respuesta.setMessage("Ha ocurrido un error");
        }*/
        
          
        return codigoServidor + ","  + UtilsDB.idVehiculo;
    }

}
