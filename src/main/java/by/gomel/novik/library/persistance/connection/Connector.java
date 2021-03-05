package by.gomel.novik.library.persistance.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static by.gomel.novik.library.temp.constatn.ApplicationConstant.DATABASE_PROPERTIES_FILE_PATH;

public class Connector {

    private static Connector connector;

    private HikariConfig config;
    private HikariDataSource ds;

    private ThreadLocal<Connection> connectionHolder;

    private Connector() {

        try (InputStream resourceAsStream = Connector.class.getResourceAsStream(DATABASE_PROPERTIES_FILE_PATH)) {

            Properties properties = new Properties();
            properties.load(resourceAsStream);

            config = new HikariConfig(properties);
            ds = new HikariDataSource(config);

        } catch (IOException e) {

            e.printStackTrace();
            System.err.println("Error initialization DataBaseConnector: " + e.getMessage());
            throw new RuntimeException("Error initialization DataBaseConnector: " + e.getMessage());

        }



    }

    public static Connector getInstance(){

        if (connector == null){
            return new Connector();
        }
        return connector;
    }

    public Connection getConnection() throws SQLException {

        if(connectionHolder != null && connectionHolder.get() != null) {
            return connectionHolder.get();
        }
        return ds.getConnection();
    }





}
