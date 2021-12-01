package domain.date;

import domain.date.impl.DmyDotDateConverterImpl;

public class DateConverterFactory {
    private static final DateConverter converter = new DmyDotDateConverterImpl();

    public static DateConverter getConverter() {
        return converter;
    }

    private DateConverterFactory() {
    }
}
