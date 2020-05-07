package pl.okpol.mdplanner.mappers;

import java.time.LocalDate;
import java.util.Locale;

public class DateConverter {

    public static LocalDate convertFromStringToDate(String date) {
        Locale.setDefault(Locale.GERMANY);
        return LocalDate.parse(date);
    }

    public static String convertFromDateToString(LocalDate date) {
        Locale.setDefault(Locale.GERMANY);
        return date.toString();
    }

    //format from angular MM/dd/yyyy
}
