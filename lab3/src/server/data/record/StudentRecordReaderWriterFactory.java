package server.data.record;

import server.data.record.impl.StudentRecordXmlFileReaderWriterImpl;

public class StudentRecordReaderWriterFactory {
    private static final StudentRecordReaderWriter readerWriter = new StudentRecordXmlFileReaderWriterImpl();

    public static StudentRecordReaderWriter getReaderWriter() {
        return readerWriter;
    }

    private StudentRecordReaderWriterFactory() {
    }
}
