package domain.record;

import domain.record.impl.ImmutableStudentRecordImpl;
import domain.record.impl.SerializableStudentRecordImpl;

import java.util.Date;

public class StudentRecordFactory {
    public static StudentRecord createRecord(int group, String name, String surname, String address, Date dateOfBirth) {
        return new ImmutableStudentRecordImpl(group, name, surname, address, dateOfBirth);
    }

    public static StudentRecord createSerializableRecord(int group, String name, String surname, String address,
                                                         Date dateOfBirth) {
        return new SerializableStudentRecordImpl(group, name, surname, address, dateOfBirth);
    }

    public static StudentRecord createSerializableRecord(StudentRecord record) {
        return createSerializableRecord(record.getGroup(), record.getName(), record.getSurname(), record.getAddress(),
                record.getDateOfBirth());
    }

    private StudentRecordFactory() {
    }
}
