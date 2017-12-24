package solution.dao.interfaces;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface ParamAdderDAO<T extends DBObject, E extends DBObject> {

    void create(T t, E e) throws SQLException;

//    void read(T t) throws SQLException;

//    void read(T t, E e) throws SQLException;

    void read(T t, E e, Long id) throws SQLException;

    void update(T t, E e, Long id) throws SQLException;

    void delete(T t, E e) throws SQLException;

    List<Long[]> getAll(T t, E e) throws SQLException;
}
