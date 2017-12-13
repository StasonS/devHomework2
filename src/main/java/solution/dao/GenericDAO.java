package solution.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T, ID> {

//    T getById(ID id) throws SQLException; >> read

//    List<T> getAll();

//    void save(T t); >> create

//    void update(T t);

//    void delete(T t);

//    =========================================

    void create(T t);

    void read(ID id) throws SQLException;

    void update(ID  id, T t) throws SQLException;

    void delete(ID id, T t);

    List<T> getAll();
}