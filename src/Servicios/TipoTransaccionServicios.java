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
import Modelos.TipoTransaccion;
import Util.Constantes;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class TipoTransaccionServicios {

    //Queries de la tabla marca
    public static List<Object> queryTransaccion(JsonObject jsonObject) throws SQLException {
        String idTipoTrans = jsonObject.get(Constantes.JSON_KEY_TIPO_TRANS).getAsString();
        String parametroFormated;
        parametroFormated = "'" + idTipoTrans + "'";
        // System.out.println(parametroFormated);

        String argumentos = " WHERE " + CheckMobileTables.TIPO_TRANSACCION.ESTADO + " = " + " 'A' "
                + " AND " + CheckMobileTables.TIPO_TRANSACCION.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                + " AND " + CheckMobileTables.TIPO_TRANSACCION.ID_TIPO_TRANS + " = " + parametroFormated;

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.TIPO_TRANSACCION.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(null);
        //System.out.println(sqlStatement);
        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.TIPO_TRASACCION);
        //List<TipoTransaccion> p = new ArrayList<>();
      /*  for (Object currentTransaccion : objetos) {
            TipoTransaccion transaccion = (TipoTransaccion) currentTransaccion;
            p.add(transaccion);

        }

        JsonResponse<TipoTransaccion> response = new JsonResponse<>();
        response.setData(p);
        response.setRows(p.size());
        response.setMessage("Successful.");*/
        return objetos;

    }

}
