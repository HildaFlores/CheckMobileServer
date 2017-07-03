/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.SQLException;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleDriver;
import java.util.Properties;

/**
 *
 * @author Prueba
 */
public class conexion {

    private static OracleConnection sOracleConnection;
    private static DatabaseShutdownHook sDatabaseShutdownHook;

    public static OracleConnection getConnection() {
        try {
            if (sOracleConnection == null || sOracleConnection.isClosed()) {
                setUpConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sOracleConnection;
    }

    public static void setUpConnection() {
        if (sDatabaseShutdownHook == null) {
            sDatabaseShutdownHook = new DatabaseShutdownHook();
            Runtime.getRuntime().addShutdownHook(sDatabaseShutdownHook);
        }

        OracleDriver oracleDriver = new OracleDriver();

        try {
            String url = String.format(Constantes.URL_DB, Constantes.IP_SERVIDOR, Constantes.PUERTO_DB, Constantes.SERVICIO_DB);
            sOracleConnection = (OracleConnection) oracleDriver.connect(url, getDatabaseProperties());
        } catch (SQLException ex) {
        }
    }

    public static OracleConnection getThinConnection() {
        OracleDriver oracleDriver = new OracleDriver();
        OracleConnection oracleConnection = null;

        try {
            String url = String.format(Constantes.URL_DB, Constantes.IP_SERVIDOR, Constantes.PUERTO_DB, Constantes.SERVICIO_DB);
            oracleConnection = (OracleConnection) oracleDriver.connect(url, getDatabaseProperties());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return oracleConnection;
    }

    private static Properties getDatabaseProperties() {
        Properties properties = new Properties();
        properties.setProperty(Constantes.USUARIO_PROPIEDAD, Constantes.USUARIO_DB);
        properties.setProperty(Constantes.CLAVE_PROPIEDAD, Constantes.CLAVE_DB);
        return properties;
    }

    /**
     * Class to manage the release of the database connection.
     */
    static class DatabaseShutdownHook extends Thread {

        @Override
        public void run() {
            try {
                conexion.getConnection().close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
