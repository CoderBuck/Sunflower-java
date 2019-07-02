package me.buck.sunflower_java.data;

import androidx.room.TypeConverter;

import java.util.Calendar;

/**
 * Created by gwf on 2019/7/2
 */
public class Converters {

    @TypeConverter
    public long calendarToDatestamp(Calendar calendar) {
        return calendar.getTimeInMillis();
    }

    @TypeConverter
    public Calendar datestampToCalendar(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar;
    }

}
