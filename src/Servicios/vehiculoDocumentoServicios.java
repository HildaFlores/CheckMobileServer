
package Servicios;

import Datos.UtilsDB;
import Modelos.ObjetosDB;
import Modelos.VehiculoDocumento;
import Util.Constantes;
import Util.JsonUtils;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

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

       /* JsonResponse respuesta = new JsonResponse<>();
        respuesta.setRows(registroInsertado);

        if (codigoServidor.equals(Constantes.RESPONSE_CODE_OK)) {
            respuesta.setMessage("Listo.");
        } else {
            respuesta.setResponseCode(codigoServidor);
            respuesta.setMessage("Ha ocurrido un error");
        }*/
        System.out.print(registroInsertado);
        return codigoServidor;
    }

    
    
}
