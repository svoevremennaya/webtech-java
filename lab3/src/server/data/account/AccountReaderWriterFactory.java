package server.data.account;

import server.data.account.impl.AccountXmlFileReaderWriterImpl;

public class AccountReaderWriterFactory {
    private static final AccountReaderWriter readerWriter = new AccountXmlFileReaderWriterImpl();

    public static AccountReaderWriter getReaderWriter() {
        return readerWriter;
    }

    private AccountReaderWriterFactory() {
    }
}
