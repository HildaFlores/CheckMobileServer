
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
import Modelos.SqlStatement;
import Modelos.VehiculoDocumento;
import Util.Constantes;
import Util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class vehiculoDocumentoServicios {
    
    //Inserts inspecciones de vehiculos
    public static String insertVehiculoDocumento(String jsonObject) {
        Type documentoListType = new TypeToken<ArrayList<VehiculoDocumento>>() {
        }.getType();
        ArrayList<VehiculoDocumento> inspeccion
                = (ArrayList<VehiculoDocumento>) JsonUtils.fromJson(jsonObject, documentoListType);
          int registroInsertado;          
          registroInsertado = UtilsDB.executeInsert(inspeccion, ObjetosDB.VEHICULO_DOCUMENTO);
       
       
        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;

        System.out.print(registroInsertado);
        return codigoServidor;
    }
    
    
    public static JsonResponse<VehiculoDocumento> queryDocumento(JsonObject jsonObject) throws SQLException {
       
        String argumentos;       
        String idDocumento;
        idDocumento = jsonObject.has(Constantes.JSON_KEY_PEDIDO_ID) ? jsonObject.get(Constantes.JSON_KEY_PEDIDO_ID).getAsString():null;
      //System.out.print(jsonObject);
        argumentos = " WHERE " + CheckMobileTables.VEHICULO_DOCUMENTO.ESTADO + " = " + " 'A' " + " AND " 
                + "id_documento = " + idDocumento  + " AND id_tipo_trans = " + "'IV'";
                         
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.VEHICULO_DOCUMENTO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.VEHICULO_DOCUMENTO.SECUENCIA);
        //System.out.println(sqlStatement);
        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.VEHICULO_DOCUMENTO);
        List<VehiculoDocumento> veh = new ArrayList<>();
        for (Object currentDocumento : objetos) {
            VehiculoDocumento cte = (VehiculoDocumento) currentDocumento;
            veh.add(cte);

        }        
       
        JsonResponse<VehiculoDocumento> response = new JsonResponse<>();
        response.setData(veh);
        response.setRows(veh.size());
        response.setMessage("Successful.");
        return response;

    }
    
    
}
