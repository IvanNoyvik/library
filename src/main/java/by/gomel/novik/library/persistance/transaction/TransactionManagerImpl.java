package by.gomel.novik.library.persistance.transaction;

import by.gomel.novik.library.model.entity.Entity;
import by.gomel.novik.library.persistance.connection.Connector;
import by.gomel.novik.library.persistance.dao.JdbcConnector;
import by.gomel.novik.library.persistance.transaction.process.TransactionProcess;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Transaction Manager Impl
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionManagerImpl<T extends Entity> extends JdbcConnector implements TransactionManager<T> {


    private ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();

    private int transactionIsolationLevel = Connection.TRANSACTION_READ_COMMITTED;

    private T entity;

    private TransactionCommand command;

    @Override
    public T doInTransaction(TransactionProcess<T> process, TransactionCommand command) {
        try {

            startTransactionOnConnectionByTread();

            T result = process.process(entity, command);

            connectionHolder.get().commit();

            return result;

        } catch(Exception exception) {
            try {
                connectionHolder.get().rollback();
            } catch(SQLException rollbackException) {
                System.err.println("Error rollback transaction - " + rollbackException.getMessage());
            }

//            try {
//                connectionHolder.get().commit();
//            } catch(SQLException commitException) {
//                System.err.println("Error save failed transaction on Database - " + commitException.getMessage());
//            }

            System.err.println("Error process transaction - " + exception.getMessage());
            throw new RuntimeException("Error process transaction - " + exception);
        } finally {
            finishTransactionOnConnectionByTread();
        }
    }


    private void startTransactionOnConnectionByTread() {
        try {
            Connection connection = getConnector().getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(transactionIsolationLevel);

            connectionHolder.set(connection);

            Field classConnectionHolder = Connector.class.getDeclaredField("connectionHolder");
            classConnectionHolder.setAccessible(true);
            classConnectionHolder.set(getConnector(), connectionHolder);

        } catch(Exception e) {
            System.err.println("Error start Transaction " + e.getMessage());
            throw new RuntimeException("Error start Transaction " + e);
        }
    }


    private void finishTransactionOnConnectionByTread() {
        try (Connection connection = connectionHolder.get()) {

            connectionHolder.remove();

            Field classConnectionHolder = Connector.class.getDeclaredField("connectionHolder");
            classConnectionHolder.setAccessible(true);
            classConnectionHolder.set(getConnector(), connectionHolder);

        } catch(Exception e) {
            System.err.println("Error finish Transaction " + e.getMessage());
            throw new RuntimeException("Error finish Transaction " + e);
        }
    }



}
