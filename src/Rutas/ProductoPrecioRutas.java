
package Rutas;



import static Servicios.ProductoDetServicios.insertProductoDet;
import static Servicios.ProductoDetServicios.queryProductoDet;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;



public class ProductoPrecioRutas {
    
 public static void setProductoPrecioRutas() {
      post("/productoDet", ((request, response) -> queryProductoDet(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);    
       put("/productoDet", ((request, response) -> insertProductoDet(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
    } 


}
