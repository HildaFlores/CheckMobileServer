/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.Impuesto;
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
public class ImpuestoServicios {
    
    private ImpuestoServicios() {
    }

    public static JsonResponse<Impuesto> queryImpuesto(JsonObject jsonObject) throws SQLException {
        
       
        String argument = " WHERE " + CheckMobileTables.IMPUESTO.ESTADO + " = 'A'" ;

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.IMPUESTO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argument);
        sqlStatement.setOrderBy(CheckMobileTables.IMPUESTO.ID_IMPUESTO);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.IMPUESTO);

        List<Impuesto> impuesto = new ArrayList<>();

        for (Object currentImpuesto : objects) {
            Impuesto imp = (Impuesto) currentImpuesto;
            impuesto.add(imp);
        }

        JsonResponse<Impuesto> respuesta = new JsonResponse<>();
       
        respuesta.setData(impuesto);
        respuesta.setRows(impuesto.size());
        respuesta.setMessage("Query successful.");
        
        
        return respuesta;
    }
    
}
