package domain.date.impl;

import domain.date.DateConverter;
import domain.date.DateConvertionException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DmyDotDateConverterImpl implements DateConverter {
    private final SimpleDateFormat converter;

    public DmyDotDateConverterImpl() {
        converter = new SimpleDateFormat("dd.MM.yyyy");
    }

    @Override
    public Date convert(String stringDate) throws DateConvertionException {
        if (stringDate == null) {
            throw new IllegalArgumentException("Date shouldn't be null");
        }

        try {
            return converter.parse(stringDate);
        } catch (ParseException e) {
            throw new DateConvertionException("Error converting date " + stringDate, e);
        }
    }
}
