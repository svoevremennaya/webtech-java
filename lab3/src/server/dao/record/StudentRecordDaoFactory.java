package server.dao.record;

import server.dao.record.impl.StudentRecordDaoImpl;

public class StudentRecordDaoFactory {
    private static final StudentRecordDao dao = new StudentRecordDaoImpl();

    public static StudentRecordDao getDao() {
        return dao;
    }

    private StudentRecordDaoFactory() {
    }
}