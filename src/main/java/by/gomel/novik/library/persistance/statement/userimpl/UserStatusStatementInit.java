package by.gomel.novik.library.persistance.statement.userimpl;

import by.gomel.novik.library.model.UserStatus;
import by.gomel.novik.library.persistance.statement.EntityStatementInit;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserStatusStatementInit extends EntityStatementInit<UserStatus> {
    @Override
    public void initStatement(PreparedStatement ps, UserStatus status) throws SQLException {
        ps.setString(1, status.getStatus());
    }

    @Override
    public void initStatement(PreparedStatement ps, UserStatus status, long id) throws SQLException {
        initStatement(ps, status);
        ps.setLong(2, id);
    }
}
