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
import Modelos.Pais;
import Modelos.SqlStatement;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class PaisServicios {
    
    
      private PaisServicios() {
    }

    //Queries de la tabla marca
    public static JsonResponse<Pais> queryPais(JsonObject jsonObject) throws SQLException {

        String argumentos = " WHERE " + CheckMobileTables.PAIS.ESTADO + " = " + " 'A' ";

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.PAIS.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.PAIS.DESC_PAIS);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PAIS);
        List<Pais> p = new ArrayList<>();
        for (Object currentPais : objetos) {
            Pais pais = (Pais) currentPais;
            p.add(pais);

        }

        JsonResponse<Pais> response = new JsonResponse<>();
        response.setData(p);
        response.setRows(p.size());
        response.setMessage("Successful.");

        return response;

    }

    
}
