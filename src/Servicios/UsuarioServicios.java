/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Util.Constantes;
import com.google.gson.JsonObject;
import Modelos.*;
import Datos.UtilsDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class UsuarioServicios {

    private UsuarioServicios() {
    }

    public static JsonResponse<Personal> queryUsuarioadmin(JsonObject jsonObject) throws SQLException {

        String user = jsonObject.get(Constantes.JSON_USARIO_ADMIN).getAsString();
        String password = jsonObject.get(Constantes.JSON_CLAVE_USUARIO_ADMIN).getAsString();

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setProjection("*");
        sqlStatement.setTable(CheckMobileTables.PERSONAL.TABLE_NAME);
        String argument = " WHERE " + CheckMobileTables.PERSONAL.USUARIO + " = " + user
                + " AND " + CheckMobileTables.PERSONAL.CLAVE + " = " + password;

        sqlStatement.setArguments(argument);
        sqlStatement.setOrderBy(null);
        System.out.print(sqlStatement);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PERSONAL);

        List<Personal> usuario = new ArrayList<>();
        for (Object currentUsuario : objetos) {
            Personal per = (Personal) currentUsuario;
            usuario.add(per);

        }

        JsonResponse<Personal> response = new JsonResponse<>();
        response.setData(usuario);
        response.setRows(usuario.size());
        response.setMessage("Successful.");

        return response;

    }
}
