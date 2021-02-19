package by.gomel.novik.library.persistance.statement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementInit<T> {

    void initStatement(PreparedStatement ps, long id) throws SQLException;

    void initStatement(PreparedStatement ps, T t) throws SQLException;

    void initStatement(PreparedStatement ps, T t, long id) throws SQLException;
}
