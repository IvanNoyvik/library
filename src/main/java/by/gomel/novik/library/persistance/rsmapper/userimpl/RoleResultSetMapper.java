package by.gomel.novik.library.persistance.rsmapper.userimpl;

import by.gomel.novik.library.model.Role;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleResultSetMapper implements ResultSetMapper<Role> {
    @Override
    public Role processResultSet(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        String role = rs.getString("role");

        return new Role(id, role);

    }
}
