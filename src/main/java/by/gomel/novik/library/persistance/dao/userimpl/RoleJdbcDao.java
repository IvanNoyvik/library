package by.gomel.novik.library.persistance.dao.userimpl;

import by.gomel.novik.library.persistance.dao.JdbcDao;
import by.gomel.novik.library.model.Role;
import by.gomel.novik.library.persistance.query.CrudSqlQuery;
import by.gomel.novik.library.persistance.query.userimpl.RoleSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.userimpl.RoleResultSetMapper;
import by.gomel.novik.library.persistance.statement.StatementInit;
import by.gomel.novik.library.persistance.statement.userimpl.RoleStatementInit;

public class RoleJdbcDao extends JdbcDao<Role> {
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
}
