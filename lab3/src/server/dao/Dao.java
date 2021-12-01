package server.dao;

import java.util.List;

public interface Dao<T> {
    void loadFrom(String path) throws DaoException;

    void updateInStorage() throws DaoException;

    List<T> getAll();
}
