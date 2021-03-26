package by.gomel.novik.library.persistance.query;

import java.util.List;

public interface CrudSqlQuery {

    String findByIdSqlQuery();
    String findAllSqlQuery();
    String saveSqlQuery();
    String updateSqlQuery();
    String deleteByIdSqlQuery();

}
