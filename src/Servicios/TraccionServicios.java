
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
import Modelos.SqlStatement;
import Modelos.VehiculoTraccion;
import Util.Constantes;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class TraccionServicios {
    
     private TraccionServicios() {
    }

    //Queries de la tabla vehiculo_traccion
    public static JsonResponse<VehiculoTraccion> queryTraccion(JsonObject jsonObject) throws SQLException {
       
        String argumentos;       
        argumentos = " WHERE " + CheckMobileTables.VEHICULO_TRACCION.ESTADO + " = " + " 'A' " + " AND "
                    + CheckMobileTables.VEHICULO_TRACCION.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.VEHICULO_TRACCION.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.VEHICULO_TRACCION.ID_TRACCION);
        // System.out.print(sqlStatement);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.VEHICULO_TRACCION);
        List<VehiculoTraccion> veh = new ArrayList<>();
        for (Object currentTraccion : objetos) {
            VehiculoTraccion cte = (VehiculoTraccion) currentTraccion;
            veh.add(cte);

        }
             
        JsonResponse<VehiculoTraccion> response = new JsonResponse<>();
        response.setData(veh);
        response.setRows(veh.size());
        response.setMessage("Successful.");

        return response;

    }

    
    
}
