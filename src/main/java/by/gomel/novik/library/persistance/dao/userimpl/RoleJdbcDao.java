package by.gomel.novik.library.persistance.dao.userimpl;

import by.gomel.novik.library.model.UserStatus;
import by.gomel.novik.library.persistance.dao.JdbcDao;
import by.gomel.novik.library.model.Role;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;
import by.gomel.novik.library.persistance.query.CrudSqlQuery;
import by.gomel.novik.library.persistance.query.userimpl.RoleSqlQuery;
import by.gomel.novik.library.persistance.query.userimpl.UserStatusSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.userimpl.RoleResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.userimpl.UserStatusResultSetMapper;
import by.gomel.novik.library.persistance.statement.StatementInit;
import by.gomel.novik.library.persistance.statement.userimpl.RoleStatementInit;
import by.gomel.novik.library.persistance.statement.userimpl.UserStatusStatementInit;

public class RoleJdbcDao extends JdbcDao<Role> {

    private static final RoleJdbcDao instance = new RoleJdbcDao();

    private RoleJdbcDao(){}

    public static RoleJdbcDao getInstance(){
        return instance;
    }

    private static long ADMIN = 1L;
    private static long USER = 2L;
    private static long GUEST = 3L;

    @Override
    protected CrudSqlQuery getSqlQuery() {
        return new RoleSqlQuery();
    }

    @Override
    protected ResultSetMapper<Role> getResultSetMapper() {
        return new RoleResultSetMapper();
    }

    @Override
    protected StatementInit<Role> getStatementInitializer() {
        return new RoleStatementInit();
    }

    public Role getAdminStatus(){
        return findById(ADMIN);
    }
    public Role getUserStatus(){
        return findById(USER);
    }
    public Role getGuestStatus(){
        return findById(GUEST);
    }

}
