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
import Modelos.TipoVehiculo;
import Util.Constantes;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class TipoVehiculoServicios {

    private TipoVehiculoServicios() {
    }

    //Queries de la tabla marca
    public static JsonResponse<TipoVehiculo> queryTipoVeh(JsonObject jsonObject) throws SQLException {

        String argumentos = " WHERE " + CheckMobileTables.TIPO_VEHICULO.ESTADO + " = " + " 'A' ";

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.TIPO_VEHICULO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.TIPO_VEHICULO.ID_TIPO_VEHICULO);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.TIPO_VEHICULO);
        List<TipoVehiculo> veh = new ArrayList<>();
        for (Object currentTipo : objetos) {
            TipoVehiculo tipo = (TipoVehiculo) currentTipo;
            veh.add(tipo);

        }

        JsonResponse<TipoVehiculo> response = new JsonResponse<>();
        response.setData(veh);
        response.setRows(veh.size());
        response.setMessage("Successful.");

        return response;

    }

}
