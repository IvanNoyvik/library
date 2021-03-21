package by.gomel.novik.library.temp.listener;

import by.gomel.novik.library.persistance.connection.Connector;
import by.gomel.novik.library.temp.CurrentDate;
import by.gomel.novik.library.temp.constatn.ApplicationConstant;
import org.h2.tools.RunScript;
import org.h2.tools.Server;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class ApplicationStartUpListener implements ServletContextListener {

    private static Server SERVER;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            SERVER = Server.createTcpServer().start();
        } catch (SQLException e) {
            throw new RuntimeException("Failed start tcp H2 server");
        }

        final Connector DATABASE_CONNECTOR = Connector.getInstance();

        try (Connection connection = DATABASE_CONNECTOR.getConnection()) {

            URL ddlSql = ApplicationStartUpListener.class.getResource(ApplicationConstant.DDL_INITIALIZATION_SCRIPT_PATH);
            URL dmlSql = ApplicationStartUpListener.class.getResource(ApplicationConstant.DML_INITIALIZATION_SCRIPT_PATH);

            RunScript.execute(connection, Files.newBufferedReader(Paths.get(ddlSql.toURI()), StandardCharsets.UTF_8));
            RunScript.execute(connection, Files.newBufferedReader(Paths.get(dmlSql.toURI()), StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error initialization in-memory database: " + e.getMessage());
            throw new RuntimeException("Error initialization in-memory database: " + e.getMessage());
        }

        sce.getServletContext().setAttribute("now", new CurrentDate());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
