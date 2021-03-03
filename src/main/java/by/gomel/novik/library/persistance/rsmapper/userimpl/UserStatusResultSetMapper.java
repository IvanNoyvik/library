package by.gomel.novik.library.persistance.rsmapper.userimpl;

import by.gomel.novik.library.model.UserStatus;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class UserStatusResultSetMapper implements ResultSetMapper<UserStatus> {
    @Override
    public UserStatus processResultSet(ResultSet rs) throws SQLException {

        long id = rs.getLong("id");
        String status = rs.getString("status");
        LocalDate duration = rs.getDate("duration").toLocalDate();


        return new UserStatus(id, status, duration);
    }
}
