package by.gomel.novik.library.persistance.statement.userimpl;

import by.gomel.novik.library.model.User;
import by.gomel.novik.library.persistance.statement.EntityStatementInit;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserStatementInit extends EntityStatementInit<User> {


    @Override
    public void initStatement(PreparedStatement ps, User user) throws SQLException {

        ps.setString(1, user.getLogin());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getName());
        ps.setLong(4,user.getRole().getId());
        ps.setLong(5, user.getStatus().getId());
    }

    @Override
    public void initStatement(PreparedStatement ps, User user, long id) throws SQLException {

        initStatement(ps, user);
        ps.setLong(6, id);

    }
}
