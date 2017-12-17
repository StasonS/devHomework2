package solution.dao.interfaces;

import solution.dao.GenericDAO;

import java.sql.SQLException;
import java.util.List;

public interface ParamAdderDAO<T extends DBObject, E extends DBObject> {

    void create(T t, E e);

    void read(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;

    List<Long> getAll() throws SQLException;
}
