package by.gomel.novik.library.persistance.rsmapper;

import by.gomel.novik.library.model.entity.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetMapper<T extends Entity> {

    T processResultSet(ResultSet rs) throws SQLException;

}
