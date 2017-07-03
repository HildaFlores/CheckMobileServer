/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Prueba
 */
public class Utils {
    public static java.sql.Date getSqlDate(Date date) {
        java.sql.Date sqlDate = null;

        if (date != null) {
            sqlDate = new java.sql.Date(date.getTime());
        }

        return sqlDate;
    }

    /**
     * Sets up the environment configuration into runtime variables.
     *
     * @return Whether or not the set up was successful.
     */
    public static boolean setUpConfigParameters() {
        boolean isSetUp = false;

        try {
            ResourceBundle rs = ResourceBundle.getBundle(ConfigPropiedades.FILE_NAME);
            Constantes.USUARIO_DB = rs.getString(ConfigPropiedades.DATABASE_USER);
            Constantes.CLAVE_DB = rs.getString(ConfigPropiedades.DATABASE_PASSWORD);
            Constantes.IP_SERVIDOR = rs.getString(ConfigPropiedades.SERVER_IP);
            Constantes.PUERTO_DB = rs.getString(ConfigPropiedades.DATABASE_PORT);
            Constantes.SERVICIO_DB = rs.getString(ConfigPropiedades.DATABASE_SERVICE);

            isSetUp = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return isSetUp;
    }
    
      public static boolean setUpConfigParameters(String usuario, String clave) {
        boolean isSetUp = false;

        try {
            ResourceBundle rs = ResourceBundle.getBundle(ConfigPropiedades.FILE_NAME);
            Constantes.USUARIO_DB = usuario;
            Constantes.CLAVE_DB = clave;
            Constantes.IP_SERVIDOR = rs.getString(ConfigPropiedades.SERVER_IP);
            Constantes.PUERTO_DB = rs.getString(ConfigPropiedades.DATABASE_PORT);
            Constantes.SERVICIO_DB = rs.getString(ConfigPropiedades.DATABASE_SERVICE);

            isSetUp = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return isSetUp;
    }


    /**
     * Logs a message into the console.
     *
     * @param message The message to be logged.
     */
    public static void log(String message) {
        System.out.println(message);
    }
}
