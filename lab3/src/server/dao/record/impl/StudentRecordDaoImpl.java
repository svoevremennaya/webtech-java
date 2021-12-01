package server.dao.record.impl;

import domain.record.StudentRecord;
import domain.record.StudentRecordFactory;
import server.dao.DaoException;
import server.dao.record.StudentRecordDao;
import server.data.ReadWriteException;
import server.data.record.StudentRecordReaderWriterFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class StudentRecordDaoImpl implements StudentRecordDao {
    private List<StudentRecord> students;

    private String path;

    private final Object studentsModifySync;

    @Override
    public StudentRecord get(String surname, String name) throws DaoException {
        String trimmedSurname, trimmedName;

        if ((surname == null) || (name == null)) {
            throw new IllegalArgumentException("Arguments shouldn't be null");
        }

        trimmedName = name.trim();
        trimmedSurname = surname.trim();

        if (trimmedSurname.isEmpty() || trimmedName.isEmpty()) {
            throw new IllegalArgumentException("Arguments shouldn't be empty");
        }

        for (StudentRecord student : students) {
            if (student.getName().equals(trimmedName) && student.getSurname().equals(trimmedSurname)) {
                return student;
            }
        }
        throw new DaoException("No student " + trimmedSurname + ' ' + trimmedName);
    }

    @Override
    public List<StudentRecord> get(int group) {
        ArrayList<StudentRecord> result = new ArrayList<>();

        if (group < 0) {
            throw new IllegalArgumentException("Group shouldn't be negative");
        }

        for (StudentRecord student : students) {
            if (student.getGroup() == group) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public void delete(String surname, String name) throws DaoException {
        String trimmedSurname, trimmedName;

        if ((surname == null) || (name == null)) {
            throw new IllegalArgumentException("Arguments shouldn't be null");
        }

        trimmedName = name.trim();
        trimmedSurname = surname.trim();

        if (trimmedSurname.isEmpty() || trimmedName.isEmpty()) {
            throw new IllegalArgumentException("Arguments shouldn't be empty");
        }

        synchronized (studentsModifySync) {
            for (StudentRecord student : students) {
                if (student.getName().equals(trimmedName) && student.getSurname().equals(trimmedSurname)) {
                    students.remove(student);
                    return;
                }
            }
        }
        throw new DaoException("No student " + trimmedSurname + ' ' + trimmedName);
    }

    @Override
    public void update(int group, String name, String surname, String address, Date dateOfBirth) throws DaoException {
        String trimmedName, trimmedSurname, trimmedAddress;

        if (group < 0) {
            throw new IllegalArgumentException("Group shouldn't be negative");
        }
        if ((name == null) || (address == null) || (surname == null) || (dateOfBirth == null)) {
            throw new IllegalArgumentException("Arguments shouldn't be null");
        }

        trimmedAddress = address.trim();
        trimmedName = name.trim();
        trimmedSurname = surname.trim();

        if (trimmedAddress.isEmpty() || trimmedName.isEmpty() || trimmedSurname.isEmpty()) {
            throw new IllegalArgumentException("Arguments shouldn't be empty");
        }

        synchronized (studentsModifySync) {
            delete(trimmedSurname, trimmedName);
            add(group, trimmedName, trimmedSurname, trimmedAddress, dateOfBirth);
        }
    }

    @Override
    public void add(int group, String name, String surname, String address, Date dateOfBirth) throws DaoException {
        String trimmedName, trimmedSurname, trimmedAddress;

        if (group < 0) {
            throw new IllegalArgumentException("Group shouldn't be negative");
        }
        if ((name == null) || (address == null) || (surname == null) || (dateOfBirth == null)) {
            throw new IllegalArgumentException("Arguments shouldn't be null");
        }

        trimmedAddress = address.trim();
        trimmedName = name.trim();
        trimmedSurname = surname.trim();

        if (trimmedAddress.isEmpty() || trimmedName.isEmpty() || trimmedSurname.isEmpty()) {
            throw new IllegalArgumentException("Arguments shouldn't be empty");
        }

        synchronized (studentsModifySync) {
            for (StudentRecord student : students) {
                if (student.getSurname().equals(trimmedSurname) && student.getName().equals(trimmedName)) {
                    throw new DaoException("Record " + trimmedSurname + ' ' + trimmedName + " already exists");
                }
            }
            students.add(
                    StudentRecordFactory.createRecord(group, trimmedName, trimmedSurname, trimmedAddress, dateOfBirth));
        }
    }

    @Override
    public void loadFrom(String path) throws DaoException {
        String trimmedPath;

        if (path == null) {
            throw new IllegalArgumentException("Path shouldn't be null");
        }

        trimmedPath = path.trim();

        if (trimmedPath.isEmpty()) {
            throw new IllegalArgumentException("Path shouldn't be empty");
        }

        try {
            synchronized (studentsModifySync) {
                students = StudentRecordReaderWriterFactory.getReaderWriter().readFrom(trimmedPath);
                this.path = trimmedPath;
            }
        } catch (ReadWriteException e) {
            throw new DaoException("Error loading from " + path, e);
        }
    }

    @Override
    public void updateInStorage() throws DaoException {
        if (path == null) {
            throw new DaoException("Never loaded");
        }

        try {
            synchronized (studentsModifySync) {
                StudentRecordReaderWriterFactory.getReaderWriter().writeTo(students, path);
            }
        } catch (ReadWriteException e) {
            throw new DaoException("Error updating into " + path, e);
        }
    }

    @Override
    public List<StudentRecord> getAll() {
        return new ArrayList<>(students);
    }

    @Override
    public boolean equals(Object o) {
        StudentRecordDaoImpl toCompare;

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        toCompare = (StudentRecordDaoImpl) o;
        return Objects.equals(students, toCompare.students) && Objects.equals(path, toCompare.path)
                && Objects.equals(studentsModifySync, toCompare.studentsModifySync);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, path, studentsModifySync);
    }

    @Override
    public String toString() {
        return getClass().getName() + "@students: " + students + ", path: " + path + ", studentsModifySync: "
                + studentsModifySync;
    }

    public StudentRecordDaoImpl() {
        path = null;
        students = new ArrayList<>();
        studentsModifySync = new Object();
    }
}
