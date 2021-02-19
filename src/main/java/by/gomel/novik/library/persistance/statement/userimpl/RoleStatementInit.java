package by.gomel.novik.library.persistance.statement.userimpl;

import by.gomel.novik.library.model.Role;
import by.gomel.novik.library.persistance.statement.EntityStatementInit;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleStatementInit extends EntityStatementInit<Role> {

    @Override
    public void initStatement(PreparedStatement ps, Role role) throws SQLException {
        ps.setString(1, role.getRole());

    }

    @Override
    public void initStatement(PreparedStatement ps, Role role, long id) throws SQLException {
        initStatement(ps, role);
        ps.setLong(2, id);
    }
}
