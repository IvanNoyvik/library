package by.gomel.novik.library.persistance.statement;

import by.gomel.novik.library.model.entity.Entity;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class EntityStatementInit<T extends Entity> implements StatementInit<T> {

    @Override
    public void initStatement(PreparedStatement ps, long id) throws SQLException {
        ps.setLong(1, id);
    }


}
