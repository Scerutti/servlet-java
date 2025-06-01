package com.scerutti.conexion;

import com.scerutti.shared.ConfigLoader;
import com.scerutti.shared.CustomLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static final Logger LOGGER = CustomLogger.getLogger();
    private static Connection conn = null;

    private Conexion() {}

    public static Connection getConexion() {
        try {
            String host = ConfigLoader.get("db.host");
            String name = ConfigLoader.get("db.name");
            String user = ConfigLoader.get("db.user");
            String pass = ConfigLoader.get("db.pass");

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + name;
            conn = DriverManager.getConnection(url, user, pass);
            LOGGER.info("Conexion establecida correctamente");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,"Error al establecer la conexion a la base de datos." , e);
        }
        return conn;
    }
}
