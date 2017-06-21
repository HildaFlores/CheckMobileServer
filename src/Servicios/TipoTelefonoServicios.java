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
import Modelos.TipoTelefono;
import Util.Constantes;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class TipoTelefonoServicios {
    
    
         //Queries de la tabla Tipo_telefono
    public static JsonResponse<TipoTelefono> queryTipoTelefono(JsonObject jsonObject) throws SQLException {
       
        String argumentos;       
        argumentos = " WHERE " + CheckMobileTables.TIPO_TELEFONO.ESTADO + " = " + " 'A' " + " AND "
                + CheckMobileTables.TIPO_TELEFONO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.TIPO_TELEFONO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.TIPO_TELEFONO.ID_TIPO);
         System.out.print(sqlStatement);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.TIPO_TELEFONO);
        List<TipoTelefono> tipo = new ArrayList<>();
        for (Object currentComprobante : objetos) {
            TipoTelefono telefono = (TipoTelefono) currentComprobante;
            tipo.add(telefono);

        }
             
        JsonResponse<TipoTelefono> response = new JsonResponse<>();
        response.setData(tipo);
        response.setRows(tipo.size());
        response.setMessage("Successful.");

        return response;

    }
    
    
}
