package server.dao.record;

import domain.record.StudentRecord;
import server.dao.Dao;
import server.dao.DaoException;

import java.util.Date;
import java.util.List;

public interface StudentRecordDao extends Dao<StudentRecord> {
    StudentRecord get(String surname, String name) throws DaoException;

    List<StudentRecord> get(int group);

    void delete(String surname, String name) throws DaoException;

    void update(int group, String name, String surname, String address, Date dateOfBirth) throws DaoException;

    void add(int group, String name, String surname, String address, Date dateOfBirth) throws DaoException;
}
