package adapter;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDate {
    private static Calendar instance;

    public CalendarToNewDateAdapter(Calendar calendar) {
        instance = calendar;
    }

    @Override
    public void setDay(int day) {
        instance.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        instance.set(Calendar.MONTH, month);
    }

    @Override
    public void setYear(int year) {
        instance.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return instance.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return instance.get(Calendar.MONTH);
    }

    @Override
    public int getYear() {
        return instance.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        instance.add(Calendar.DAY_OF_MONTH, days);
    }

}
