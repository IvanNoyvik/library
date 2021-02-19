package by.gomel.novik.library.persistance.dao;

import by.gomel.novik.library.persistance.connection.Connector;

public abstract class JdbcConnector {

    private static final Connector CONNECTOR = Connector.getInstance();

    public Connector getConnector() {
        return CONNECTOR;
    }
}
