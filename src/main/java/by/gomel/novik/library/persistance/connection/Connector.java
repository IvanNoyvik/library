package by.gomel.novik.library.persistance.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static by.gomel.novik.library.temp.constatn.ApplicationConstant.DATABASE_PROPERTIES_FILE_PATH;

public class Connector {

    private static Connector connector;

    private HikariConfig config;
    private HikariDataSource ds;

    private Connector() {

         config = new HikariConfig(DATABASE_PROPERTIES_FILE_PATH);
         ds = new HikariDataSource(config);

    }

    public static Connector getInstance(){

        if (connector == null){
            return new Connector();
        }
        return connector;
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


}
