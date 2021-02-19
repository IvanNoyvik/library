package by.gomel.novik.library.persistance.rsmapper.userimpl;

import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.model.Role;
import by.gomel.novik.library.model.User;
import by.gomel.novik.library.model.UserStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserResultSetMapper implements ResultSetMapper<User> {


    @Override
    public User processResultSet(ResultSet rs) throws SQLException {

        Long id = rs.getLong("u_id");
        String login = rs.getString("login");
        String password = rs.getString("password");
        String name = rs.getString("name");
        Long rId = rs.getLong("r_id");
        String role = rs.getString("role");
        Long usId = rs.getLong("us_id");
        String status = rs.getString("status");

        User user = new User(id, login, password, name, new UserStatus(usId, status), new Role(rId, role));

        return user;

    }
}
