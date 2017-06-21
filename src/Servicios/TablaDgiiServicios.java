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
import Modelos.TablaDgii;
import Util.Constantes;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class TablaDgiiServicios {

    private TablaDgiiServicios() {
    }

    public static JsonResponse<TablaDgii> queryTablaDGII(JsonObject jsonObject) throws SQLException {
        
        String docIdentidad = jsonObject.get(Constantes.JSON_KEY_DOC_IDENTIDAD).getAsString();
        String parametroFormated;
        parametroFormated = "'" + docIdentidad + "'";
        //System.out.println(parametroFormated);
        String argument = " WHERE " + CheckMobileTables.TABLA_DGII.RNC_CEDULA + " = " + parametroFormated;

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.TABLA_DGII.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argument);
        sqlStatement.setOrderBy(CheckMobileTables.TABLA_DGII.RAZON_SOCIAL);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.TABLA_DGII);

        List<TablaDgii> tabladgii = new ArrayList<>();

        for (Object currentClient : objects) {
            TablaDgii dgii = (TablaDgii) currentClient;
            tabladgii.add(dgii);
        }

        
       // System.out.print(sqlStatement);
        JsonResponse<TablaDgii> respuesta = new JsonResponse<>();
       
        respuesta.setData(tabladgii);
        respuesta.setRows(tabladgii.size());
        respuesta.setMessage("Query successful.");
        
        
        return respuesta;
    }
}
