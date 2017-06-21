/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.CondicionPago;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
import Modelos.SqlStatement;
import Util.Constantes;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class CondicionPagoServicios {

    private CondicionPagoServicios() {
    }

    public static JsonResponse<CondicionPago> queryCondicion(JsonObject jsonObject) throws SQLException {
        
        String argument = " WHERE " + CheckMobileTables.CONDICION_PAGO.ESTADO + " = 'A'" 
                + " AND " + CheckMobileTables.CONDICION_PAGO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.CONDICION_PAGO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argument);
        sqlStatement.setOrderBy(CheckMobileTables.CONDICION_PAGO.ID_CONDICION);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.CONDICION_PAGO);

        List<CondicionPago> condicion = new ArrayList<>();

        for (Object currentCondicion : objects) {
            CondicionPago dgii = (CondicionPago) currentCondicion;
            condicion.add(dgii);
        }

        JsonResponse<CondicionPago> respuesta = new JsonResponse<>();

        respuesta.setData(condicion);
        respuesta.setRows(condicion.size());
        respuesta.setMessage("Query successful.");

        return respuesta;
    }

}
