/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.CombustibleVehiculo;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
import Modelos.SqlStatement;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class CombustibleServicios {
    
     //Queries de la tabla vehiculo_combustible
    public static JsonResponse<CombustibleVehiculo> queryCombustible(JsonObject jsonObject) throws SQLException {
       
        String argumentos;       
        argumentos = " WHERE " + CheckMobileTables.COMBUSTIBLE_VEHICULO.ESTADO + " = " + " 'A' ";
                         
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.COMBUSTIBLE_VEHICULO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.COMBUSTIBLE_VEHICULO.DESCRIPCION);
        

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.COMBUSTIBLE_VEHICULO);
        List<CombustibleVehiculo> veh = new ArrayList<>();
        for (Object currentCombustible : objetos) {
            CombustibleVehiculo cte = (CombustibleVehiculo) currentCombustible;
            veh.add(cte);

        }
        
       
        JsonResponse<CombustibleVehiculo> response = new JsonResponse<>();
        response.setData(veh);
        response.setRows(veh.size());
        response.setMessage("Successful.");

        return response;

    }

}
