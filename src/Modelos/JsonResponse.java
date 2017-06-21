/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Util.Constantes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class JsonResponse <T>{
    
    /**
     * Holds the response code of the response.
     */
  private String responseCode = Constantes.RESPONSE_CODE_OK;

    /**
     * Holds the data of the response.
     */
    private List<T> data;
    
   

    /**
     * Holds the message of the response.
     */
    private String message;

    /**
     * Holds a list of errors.
     */
    private ArrayList<String> errors;

    /**
     * Holds the rows inserted/updated/queried.
     */
    private int rows;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }


}
