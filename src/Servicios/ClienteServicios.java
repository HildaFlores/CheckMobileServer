package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.*;
import Util.Constantes;
import Util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Prueba
 */
public class ClienteServicios {

    private ClienteServicios() {
    }

    //Queries de la tabla cliente
    public static JsonResponse<Cliente> queryCliente(JsonObject jsonObject) throws SQLException {
        String idCliente = null;
        String documentoIdentidad = null;
        String argumentos = null;
        String idFormated, docIdentidadFormated;

        SqlStatement sqlStatement = new SqlStatement();
        if (jsonObject != null) {
            // System.out.print(jsonObject.toString());
            idCliente = jsonObject.has(Constantes.JSON_KEY_CLIENT) ? jsonObject.get(Constantes.JSON_KEY_CLIENT).getAsString() : null;
            documentoIdentidad = jsonObject.has("documento_identidad") ? jsonObject.get("documento_identidad").getAsString() : null;
        }

        if (idCliente == null && documentoIdentidad == null) {
            argumentos = " WHERE " + " C." + CheckMobileTables.CLIENTE.ESTADO + " = " + " 'A' " + " AND "
                    + " C." + CheckMobileTables.CLIENTE.ID_EMPRESA + " = " + Constantes.ID_EMPRESA + " AND "
                    + " C." + CheckMobileTables.CLIENTE.ID_EMPRESA + " = " + "P." + CheckMobileTables.CONDICION_PAGO.ID_EMPRESA + " AND "
                    + "P." + CheckMobileTables.CONDICION_PAGO.ID_CONDICION + " = " + " C." + CheckMobileTables.CLIENTE.ID_CONDICION;
        } else if (documentoIdentidad == null && idCliente != null) {
            idFormated = "'" + idCliente + "'";
            argumentos = " WHERE " + " C." + CheckMobileTables.CLIENTE.ESTADO + " = " + " 'A' " + " AND "
                    + " C." + CheckMobileTables.CLIENTE.ID_EMPRESA + " = " + Constantes.ID_EMPRESA + " AND "
                    + "C." + CheckMobileTables.CLIENTE.ID_CLIENTE + " = " + idFormated + " AND "
                    + " C." + CheckMobileTables.CLIENTE.ID_EMPRESA + " = " + "P." + CheckMobileTables.CONDICION_PAGO.ID_EMPRESA + " AND "
                    + "P." + CheckMobileTables.CONDICION_PAGO.ID_CONDICION + " = "
                    + " C." + CheckMobileTables.CLIENTE.ID_CONDICION;

        } else if (documentoIdentidad != null && idCliente == null) {
            docIdentidadFormated = "'" + documentoIdentidad + "'";
            argumentos = " WHERE " + " C." + CheckMobileTables.CLIENTE.ESTADO + " = " + " 'A' " + " AND "
                    + " C." + CheckMobileTables.CLIENTE.ID_EMPRESA + " = " + Constantes.ID_EMPRESA + " AND "
                    + " C." + CheckMobileTables.CLIENTE.ID_EMPRESA + " = " + "P." + CheckMobileTables.CONDICION_PAGO.ID_EMPRESA + " AND "
                    + "P." + CheckMobileTables.CONDICION_PAGO.ID_CONDICION + " = "
                    + " C." + CheckMobileTables.CLIENTE.ID_CONDICION + " AND "
                    + "(C." + CheckMobileTables.CLIENTE.DOCUMENTO_IDENTIDAD + " = " + docIdentidadFormated
                    + " OR C." + CheckMobileTables.CLIENTE.RNC + " = " + docIdentidadFormated + ")";
        }

        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.CLIENTE.TABLE_NAME + " C ," + CheckMobileTables.CONDICION_PAGO.TABLE_NAME + " P ");
        sqlStatement.setProjection("C.*, P.descripcion as desc_con");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy("C." + CheckMobileTables.CLIENTE.ID_CLIENTE);

       //System.out.println(sqlStatement);
        // System.out.print(sqlStatement);
        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.CLIENTE);
        List<Cliente> clientes = new ArrayList<>();

        for (Object currentCliente : objetos) {
            Cliente cte = (Cliente) currentCliente;
            clientes.add(cte);

        }

        JsonResponse<Cliente> response = new JsonResponse<>();
        response.setData(clientes);
        response.setRows(clientes.size());
        response.setMessage("Successful.");

        return response;

    }

    public static JsonResponse<ClienteDirecciones> queryClienteDireccion(JsonObject jsonObject) throws SQLException {
        String idCliente = jsonObject.has(Constantes.JSON_KEY_CLIENT) ? jsonObject.get(Constantes.JSON_KEY_CLIENT).getAsString() : null;
        String idFormated;
        String argumentos;
        SqlStatement sqlStatement = new SqlStatement();
        idFormated = "'" + idCliente + "'";
        argumentos = "WHERE " + "D." + CheckMobileTables.CLIENTE.ESTADO + " = " + " 'A' " + " AND "
                + "D." + CheckMobileTables.CLIENTE.ID_EMPRESA + " = " + Constantes.ID_EMPRESA + " AND "
                + "C." + CheckMobileTables.CLIENTE.ID_CLIENTE + " = " + "D." + CheckMobileTables.CLIENTE_DIRECCIONES.ID_CLIENTE + " AND "
                + "C." + CheckMobileTables.CLIENTE.ID_EMPRESA + " = " + "D." + CheckMobileTables.CLIENTE_DIRECCIONES.ID_EMPRESA
                + " AND C." + CheckMobileTables.CLIENTE.ID_CLIENTE + " = " + idFormated;

        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.CLIENTE.TABLE_NAME + " C " + " , " + CheckMobileTables.CLIENTE_DIRECCIONES.TABLE_NAME + " D ");
        sqlStatement.setProjection("C.id_cliente, C.nombres, C.apellidos, D.secuencia, "
                + "D.id_empresa, D.descripcion, D.ciudad, D.sector, D.municipio, D.apartamento, D.edificio, D.estado");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy("D." + CheckMobileTables.CLIENTE.ID_CLIENTE);

        //System.out.print(sqlStatement);
        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.CLIENTE_DIRECCIONES);
        List<ClienteDirecciones> clientes = new ArrayList<>();

        for (Object currentCliente : objetos) {
            ClienteDirecciones cte = (ClienteDirecciones) currentCliente;
            clientes.add(cte);

        }

        JsonResponse<ClienteDirecciones> response = new JsonResponse<>();
        response.setData(clientes);
        response.setRows(clientes.size());
        response.setMessage("Successful.");

        return response;

    }

    /*Query de los telefonos de los clientes*/
    public static JsonResponse<Telefonos> queryTelefonoCte(JsonObject jsonObject) throws SQLException {
        String idCliente = jsonObject.has(Constantes.JSON_KEY_CLIENT) ? jsonObject.get(Constantes.JSON_KEY_CLIENT).getAsString() : null;
        String argumentos;
        String idFormated;
        SqlStatement sqlStatement = new SqlStatement();
        idFormated = "'" + idCliente + "'";
        argumentos = "WHERE " + "D." + CheckMobileTables.CLIENTE.ESTADO + " = " + " 'A' " + " AND "
                + "C." + CheckMobileTables.CLIENTE.ID_EMPRESA + " = " + Constantes.ID_EMPRESA + " AND "
                + "C." + CheckMobileTables.CLIENTE.ID_CLIENTE + " = " + "T." + CheckMobileTables.TELEFONOS.ID_ENTIDAD + " AND "
                + "C." + CheckMobileTables.CLIENTE.ID_EMPRESA + " = " + "D." + CheckMobileTables.TIPO_TELEFONO.ID_EMPRESA + " AND "
                + "T." + CheckMobileTables.TELEFONOS.ID_TIPO + " = " + "D." + CheckMobileTables.TIPO_TELEFONO.ID_TIPO
                + "AND C." + CheckMobileTables.CLIENTE.ID_CLIENTE + " = " + idFormated;

        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        //From
        sqlStatement.setProjection("T.id_entidad, C.nombres, C.apellidos,"
                + " D.id_tipo, D.descripcion as desc_tipo, T.numero, T.prioridad ");

        sqlStatement.setTable(CheckMobileTables.CLIENTE.TABLE_NAME + " C " + " , "
                + CheckMobileTables.TIPO_TELEFONO.TABLE_NAME + " D " + " , "
                + CheckMobileTables.TELEFONOS.TABLE_NAME + " T");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy("T." + CheckMobileTables.TELEFONOS.ID_ENTIDAD);

        // System.out.print(sqlStatement);
        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.TELEFONO);
        List<Telefonos> tel = new ArrayList<>();

        for (Object currentTelefono : objetos) {
            Telefonos cte = (Telefonos) currentTelefono;
            tel.add(cte);

        }

        JsonResponse<Telefonos> response = new JsonResponse<>();
        response.setData(tel);
        response.setRows(tel.size());
        response.setMessage("Successful.");

        return response;

    }

    /**
     * Inserts a list of clients.
     *
     * @param jsonObject The request body content.
     * @return The numbers of rows inserted.
     */
    public static String insertCliente(String jsonObject) {
        //System.out.println(jsonObject);
        Type type = new TypeToken<ArrayList<Cliente>>() {
        }.getType();

        ArrayList<Cliente> cte = (ArrayList<Cliente>) JsonUtils.fromJson(jsonObject, type);
        int registroInsertado = UtilsDB.executeInsert(cte, ObjetosDB.CLIENTE);
        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;
        //JsonResponse respuesta = new JsonResponse<>();
        //respuesta.setRows(registroInsertado);

        /* if (codigoServidor.equals(Constantes.RESPONSE_CODE_OK)) {
         respuesta.setMessage("Listo. " + " Registros insertados:" + registroInsertado);
         } else {
         respuesta.setResponseCode(codigoServidor);
         respuesta.setMessage("Ha ocurrido un error");
         }*/
        return codigoServidor + "," + UtilsDB.idCliente;
    }

}
