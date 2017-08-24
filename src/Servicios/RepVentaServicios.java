package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.CteRepresentanteVen;
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
public class RepVentaServicios {

    private RepVentaServicios() {
    }

    public static JsonResponse<CteRepresentanteVen> queryRepresentante(JsonObject jsonObject) throws SQLException {
        String tipo = null;
        String argument;

        SqlStatement sqlStatement = new SqlStatement();

        if (jsonObject != null) {
            tipo = jsonObject.has(Constantes.JSON_KEY_MECANICO) ? jsonObject.get(Constantes.JSON_KEY_MECANICO).getAsString() : null;

        }
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setProjection("*");
        sqlStatement.setTable(CheckMobileTables.CTE_REPRESENTANTE_VEN.TABLE_NAME);

        if (tipo == null) {
            argument = "WHERE " + CheckMobileTables.CTE_REPRESENTANTE_VEN.ESTADO + " = 'A' " + " AND "
                    + CheckMobileTables.CTE_REPRESENTANTE_VEN.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        } else {
            argument = "WHERE " + CheckMobileTables.CTE_REPRESENTANTE_VEN.ESTADO + " = 'A' " + " AND "
                    + CheckMobileTables.CTE_REPRESENTANTE_VEN.ID_EMPRESA + " = " + Constantes.ID_EMPRESA + " AND "
                    + CheckMobileTables.CTE_REPRESENTANTE_VEN.MECANICO + " = " + tipo;

        }
        sqlStatement.setArguments(argument);
        sqlStatement.setOrderBy(CheckMobileTables.CTE_REPRESENTANTE_VEN.ID_REPRESENTANTE);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.CTE_REPRESENTANTE_VEN);
        List<CteRepresentanteVen> repVenta = new ArrayList<>();
        for (Object currentProducto : objects) {
            CteRepresentanteVen rep = (CteRepresentanteVen) currentProducto;
            repVenta.add(rep);
        }

        JsonResponse<CteRepresentanteVen> response = new JsonResponse<>();
        response.setData(repVenta);
        response.setRows(repVenta.size());
        response.setMessage("Successful.");

        return response;
    }

    public static String queryMecanico() throws SQLException {
        String idMecanico = null;
        String argument;

        SqlStatement sqlStatement = new SqlStatement();

        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setProjection(" id_rep_ven ");
        sqlStatement.setTable("(SELECT  id_rep_ven, COUNT (*) conteo\n"
                + " FROM pedido_enc\n"
                + " where id_empresa = 3 and estado = 'A' and estado_documento = 'V' and id_tipo_trans = 'OTT'\n"
                + " GROUP BY id_rep_ven\n"
                + " ORDER BY conteo desc)");
        argument = "WHERE ROWNUM <= 1";

        sqlStatement.setArguments(argument);
        sqlStatement.setOrderBy(null);

        List<Object> objects = UtilsDB.executeQuery2(sqlStatement, ObjetosDB.CTE_REPRESENTANTE_VEN);
        idMecanico = UtilsDB.idMecanico;
        //System.out.print(sqlStatement);
//        List<CteRepresentanteVen> repVenta = new ArrayList<>();
//        for (Object currentProducto : objects) {
//            CteRepresentanteVen rep = (CteRepresentanteVen) currentProducto;
//            repVenta.add(rep);
//        }
//
//        JsonResponse<CteRepresentanteVen> response = new JsonResponse<>();
//        response.setData(repVenta);
//        response.setRows(repVenta.size());
//        response.setMessage("Successful.");
//
//        return response;
        return idMecanico;
    }
}
