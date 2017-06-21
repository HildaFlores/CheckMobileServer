package Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class JsonUtils {

    //Para administrar el analisis de Json Transformer
    private static Gson sGson;

    //creando un objeto Gson
    private static Gson buildGson() {

        return new GsonBuilder().setDateFormat("DD/MM/yyyy HH:mm:ss").create();
    }

    //Configura Json si aun no esta configurado
    private static void setUpGson() {
        if (sGson == null) {
            sGson = buildGson();
        }

    }
    // Codifica un objeto para obtener el formato Json 
    //@param el ojeto a analizar
    //@return una representacion String del objeto Json 

    public static String toJson(Object object) {
        setUpGson();

        return sGson.toJson(object);
    }

    //Obtiene un objeto Json de un String 
    public static JsonObject fromJson(String json) {
        setUpGson();
        return sGson.fromJson(json, JsonObject.class);
       
    }
    
    

    //Obtiene un objeto de un String
    public static Object fromJson(String json, Type type) {
        setUpGson();
        return sGson.fromJson(json, type);
    }


}
