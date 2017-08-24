/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
import Modelos.SqlStatement;
import Util.Constantes;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class ProvinciaServicios {
    
    
    public static List<Object> queryProvincia() throws SQLException {
        
      String argumentos;
      SqlStatement sqlStatement = new SqlStatement();
            argumentos = " WHERE " + CheckMobileTables.PROVINCIA.ESTADO + " = " + " 'A' ";
       
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.PROVINCIA.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.PROVINCIA.DESC_PROVINCIA);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PROVINCIA);


        return objetos;

    }

    
}
