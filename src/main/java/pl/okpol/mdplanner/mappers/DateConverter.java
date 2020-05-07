package pl.okpol.mdplanner.mappers;

import java.time.LocalDate;

public class DateConverter {
    public static LocalDate convertFromStringToDate(String date) {
        return LocalDate.parse(date);
    }

    public static String convertFromDateToString(LocalDate date) {
        return date.toString();
    }

    //format from angular MM/dd/yyyy
}
