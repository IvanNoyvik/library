package by.gomel.novik.library.persistance.dao.userimpl;

import by.gomel.novik.library.persistance.dao.JdbcDao;
import by.gomel.novik.library.model.UserStatus;
import by.gomel.novik.library.persistance.query.CrudSqlQuery;
import by.gomel.novik.library.persistance.query.userimpl.UserStatusSqlQuery;
import by.gomel.novik.library.persistance.rsmapper.ResultSetMapper;
import by.gomel.novik.library.persistance.rsmapper.userimpl.UserStatusResultSetMapper;
import by.gomel.novik.library.persistance.statement.StatementInit;
import by.gomel.novik.library.persistance.statement.userimpl.UserStatusStatementInit;

public class UserStatusJdbcDao extends JdbcDao<UserStatus> {



    private static long OK = 1L;
    private static long LIMITED = 2L;
    private static long LOCKED = 3L;


    @Override
    protected CrudSqlQuery getSqlQuery() {
        return new UserStatusSqlQuery();
    }

    @Override
    protected ResultSetMapper<UserStatus> getResultSetMapper() {
        return new UserStatusResultSetMapper();
    }

    @Override
    protected StatementInit<UserStatus> getStatementInitializer() {
        return new UserStatusStatementInit();
    }

    public UserStatus getOkStatus(){
        return findById(OK);
    }
    public UserStatus getLimitedStatus(){
        return findById(LIMITED);
    }
    public UserStatus getLockedStatus(){
        return findById(LOCKED);
    }
}
