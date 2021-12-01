package domain.date;

import java.util.Date;

public interface DateConverter {
    Date convert(String stringDate) throws DateConvertionException;
}
