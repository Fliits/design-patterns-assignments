package adapter;

import java.util.Calendar;
import java.time.Month;
import java.time.Year;
import java.time.LocalDate;
import java.time.MonthDay;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        NewDate newDate = new CalendarToNewDateAdapter(calendar);
        newDate.setDay(27);
        newDate.setMonth(2);
        newDate.setYear(2600);
        System.out.println("Initial date: " + newDate.getDay() + "/" + newDate.getMonth() + "/" + newDate.getYear());
        newDate.advanceDays(10);
        System.out.println("Date after 10 days: " + newDate.getDay() + "/" + newDate.getMonth() + "/" + newDate.getYear());
    }
}
