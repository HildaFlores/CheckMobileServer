/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.JsonResponse;
import Modelos.ListaParametrosDet;
import Modelos.ListaParametrosEnc;
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
public class ListaParametrosServicios {

    private ListaParametrosServicios() {

    }

    public static JsonResponse<ListaParametrosEnc> queryListaParametrosEnc(JsonObject jsonObject) throws SQLException {
        String idLista;
        String argumentos;
        SqlStatement sqlStatement = new SqlStatement();

        idLista = jsonObject.has(Constantes.JSON_KEY_LISTA) ? jsonObject.get(Constantes.JSON_KEY_LISTA).getAsString() : null;

        argumentos = " WHERE " + CheckMobileTables.LISTA_PARAMETROS_ENC.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                + " AND " + CheckMobileTables.LISTA_PARAMETROS_ENC.ESTADO + " = " + "'A'" + " AND "
                + CheckMobileTables.LISTA_PARAMETROS_ENC.ID_LISTA + " = " + idLista;

        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setProjection("*");
        sqlStatement.setTable(CheckMobileTables.LISTA_PARAMETROS_ENC.TABLE_NAME);
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(null);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.LISTA_PARAMETROS_ENC);
        List<ListaParametrosEnc> listaEnc = new ArrayList<>();

        for (Object currentListaEnc : objetos) {
            ListaParametrosEnc cte = (ListaParametrosEnc) currentListaEnc;
            listaEnc.add(cte);

        }

        JsonResponse<ListaParametrosEnc> response = new JsonResponse<>();
        response.setData(listaEnc);
        response.setRows(listaEnc.size());
        response.setMessage("Successful.");

        return response;

    }

    public static JsonResponse<ListaParametrosDet> queryListaParametrosDet(JsonObject jsonObject) throws SQLException {
        String idLista;
         // String valor;
        String argumentos;
        SqlStatement sqlStatement = new SqlStatement();
            String parametroFormated;
            
         //   System.out.println(jsonObject);
       idLista = jsonObject.has(Constantes.JSON_KEY_LISTA) ? jsonObject.get(Constantes.JSON_KEY_LISTA).getAsString() : null;
      //  valor = jsonObject.has(Constantes.JSON_KEY_VALOR) ? jsonObject.get(Constantes.JSON_KEY_VALOR).getAsString() : null;

      if (idLista != null) {
            argumentos = " WHERE " + CheckMobileTables.LISTA_PARAMETROS_DET.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " AND " + CheckMobileTables.LISTA_PARAMETROS_DET.ESTADO + " = " + "'A'" + " AND "
                    + CheckMobileTables.LISTA_PARAMETROS_DET.ID_LISTA + " = " + idLista; //+ " AND "
                   
                    //+ CheckMobileTables.LISTA_PARAMETROS_DET.VALOR + " = " + valor;

        }
        else{
          parametroFormated = "'" + idLista + "'"; 
         
        argumentos = " WHERE " + CheckMobileTables.LISTA_PARAMETROS_DET.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                + " AND " + CheckMobileTables.LISTA_PARAMETROS_DET.ESTADO + " = " + "'A'" + " AND "
                + CheckMobileTables.LISTA_PARAMETROS_DET.ID_LISTA + " = " + parametroFormated;
      }
        

        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setProjection("*");
        sqlStatement.setTable(CheckMobileTables.LISTA_PARAMETROS_DET.TABLE_NAME);
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.LISTA_PARAMETROS_DET.DESCRIPCION);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.LISTA_PARAMETROS_DET);
        List<ListaParametrosDet> listaDet = new ArrayList<>();

        for (Object currentListaDet : objetos) {
            ListaParametrosDet cte = (ListaParametrosDet) currentListaDet;
            listaDet.add(cte);

        }

        JsonResponse<ListaParametrosDet> response = new JsonResponse<>();
        response.setData(listaDet);
        response.setRows(listaDet.size());
        response.setMessage("Successful.");
        return response;

    }
    
    
    
    public static JsonResponse<ListaParametrosDet> queryListaParametrosDetOtros(JsonObject jsonObject) throws SQLException {
        String idLista;
        String argumentos;
        SqlStatement sqlStatement = new SqlStatement();
         String[] p;
        String parametroFormated;
            
   
       idLista = jsonObject.has(Constantes.JSON_KEY_LISTA) ? jsonObject.get(Constantes.JSON_KEY_LISTA).getAsString() : null;
     
      
          p = idLista.split(",");
          parametroFormated = "'" + p[0] + "', '" + p[1] + "','" + p[2] + "','" + p[3] + "'" + ",'" + p[4] + "'";
          System.out.println(parametroFormated);
         
        argumentos = " WHERE " + CheckMobileTables.LISTA_PARAMETROS_DET.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                + " AND " + CheckMobileTables.LISTA_PARAMETROS_DET.ESTADO + " = " + "'A'" + " AND "
                + CheckMobileTables.LISTA_PARAMETROS_DET.ID_LISTA + " in( " + parametroFormated + ") ";
     
        

        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setProjection("*");
        sqlStatement.setTable(CheckMobileTables.LISTA_PARAMETROS_DET.TABLE_NAME);
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(null);
        
        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.LISTA_PARAMETROS_DET);
        List<ListaParametrosDet> listaDet = new ArrayList<>();

        for (Object currentListaDet : objetos) {
            ListaParametrosDet cte = (ListaParametrosDet) currentListaDet;
            listaDet.add(cte);

        }

        JsonResponse<ListaParametrosDet> response = new JsonResponse<>();
        response.setData(listaDet);
        response.setRows(listaDet.size());
        response.setMessage("Successful.");
        return response;

    }
}
