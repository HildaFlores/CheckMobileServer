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
import Modelos.TipoCompFiscal;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class TipoComprobanteServicios {
    
     //Queries de la tabla Tipo_Comp_fiscal
    public static JsonResponse<TipoCompFiscal> queryComprobante(JsonObject jsonObject) throws SQLException {
       
        String argumentos;       
        argumentos = " WHERE " + CheckMobileTables.TIPO_COMP_FISCAL.ESTADO + " = " + " 'A' ";
        
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.TIPO_COMP_FISCAL.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.TIPO_COMP_FISCAL.ID_TIPO_NCF);
         System.out.print(sqlStatement);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.TIPO_COMP_FISCAL);
        List<TipoCompFiscal> comp = new ArrayList<>();
        for (Object currentComprobante : objetos) {
            TipoCompFiscal comprobante = (TipoCompFiscal) currentComprobante;
            comp.add(comprobante);

        }
             
        JsonResponse<TipoCompFiscal> response = new JsonResponse<>();
        response.setData(comp);
        response.setRows(comp.size());
        response.setMessage("Successful.");

        return response;

    }
    
}
