package by.gomel.novik.library.persistance.rsmapper.userimpl;

import by.gomel.novik.library.model.UserStatus;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserStatusResultSetMapper implements ResultSetMapper<UserStatus> {
    @Override
    public UserStatus processResultSet(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        String status = rs.getString("status");

        return new UserStatus(id, status);
    }
}
