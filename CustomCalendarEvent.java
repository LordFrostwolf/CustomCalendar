import java.time.*;

/**
 * An object to store a customizable calendar event.
 */
public class CustomCalendarEvent{
    private String name;
    private LocalTime time;
    private LocalDate date;
    private DayOfWeek day;
    private LocalTime endTime;
    
    private void parseLocalTime(String time){
        try {
            this.time = LocalTime.parse(time);
        } catch (Exception e) {
            System.out.println("Error while parsing time.");
            this.time = LocalTime.now();
        }
    }

    private void parseLocalEndTime(String time){
        try {
            this.endTime = LocalTime.parse(time);
        } catch (Exception e) {
            System.out.println("Error while parsing time.");
            this.endTime = LocalTime.now();
        }
    }

    private void parseLocalDate(String date){
        try {
            this.date = LocalDate.parse(date);
        } catch (Exception e) {
            System.out.println("Error while parsing date.");
            this.date = LocalDate.now();
        }
    }

    /**
     * Creates a new calendar event with the given name, time, endtime and date.
     * <br> It also automatically stores the day of the week according to the date.
     * <br> If parsing the time or date creates an exception, sets these values to the current values of the system clock.
     * @param name the name of the event
     * @param time the time of the event
     * @param endTime the endtime of the event
     * @param date the date of the event
     */
    public CustomCalendarEvent(String name, String time, String endTime, String date){
        this.name = name;
        parseLocalTime(time);
        parseLocalEndTime(endTime);
        parseLocalDate(date);
        this.day = this.date.getDayOfWeek();
    }

    /**
     * Creates a new recurring calendar event with the given name, time, endtime and day of the week.
     * <br> If parsing the time creates an exception, sets this value to the current value of the system clock.
     * @param name the name of the event
     * @param time the time of the event
     * @param endTime the endtime of the event
     * @param day the day of week of the event
     */
    public CustomCalendarEvent(String name, String time, String endTime, DayOfWeek day){
        this.name = name;
        parseLocalTime(time);
        parseLocalEndTime(endTime);
        this.day = day;
    }

    /**
     * Creates a new recurring calendar event with the given name day of week.
     * <br> This event is interpreted as a whole day event.
     * @param name the name of the event
     * @param day the day of the week of the event
     */
    public CustomCalendarEvent(String name, DayOfWeek day){
        this.name = name;
        this.day = day;
    }

    /**
     * Creates a new calendar event with the given name and date.
     * <br> This event is interpreted as a whole day event.
     * <br> If parsing the date creates an exception, sets this value to the current value of the system clock.
     * @param name the name of the event
     * @param date the day of the week of the event
     */
    public CustomCalendarEvent(String name, String date){
        this.name = name;
        parseLocalDate(date);;
        this.day = this.date.getDayOfWeek();
    }

    /**
     * Returns the name of the event.
     * @return the name of the event
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the time of the event.
     * <br> If the event is a whole day event, returns 00:00:00.
     * @return the time of the event
     */
    public LocalTime getTime(){
        if(time == null){
            return LocalTime.MIDNIGHT;
        }
        return time;
    }

    /**
     * Returns the endtime of the event.
     * <br> If the event is a whole day event, returns 00:00:00.
     * @return the endtime of the event.
     */
    public LocalTime getEndTime(){
        if(endTime == null){
            return LocalTime.MIDNIGHT;
        }
        return endTime;
    }

    /**
     * Returns the date of the event.
     * <br> If the event is a recurring event, returns the next date.
     * @return the date of the event
     */
    public LocalDate getDate(){
        if(date == null){
            LocalDate tmp = LocalDate.now();
            while(tmp.getDayOfWeek() != day){
                tmp = tmp.plusDays(1);
            }
            return tmp;
        }
        return date;
    }

    /**
     * Returns the day of week of the event.
     * @return the day of week of the event
     */
    public DayOfWeek getDay(){
        return day;
    }

    /**
     * Sets the name of the event.
     * @param name the name of the event
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the time of the event.
     * <br> To create a whole day event, set the time to {@code null}.
     * <br> If parsing the time creates an exception, sets this value to the current value of the system clock.
     * @param time the time of the event
     */
    public void setTime(String time){
        parseLocalTime(time);
        if(time == null){
            endTime = null;
        }
    }

    /**
     * Sets the endtime of the event.
     * <br> To create a whole day event, set the time with {@code setTime} to {@code null}.
     * <br> If parsing the time creates an exception, sets this value to the current value of the system clock.
     * @param endTime the endtime of the event
     */
    public void setEndTime(String endTime){
        if(endTime != null){
            parseLocalEndTime(endTime);
        }
    }

    /**
     * Sets the date of the event.
     * <br> If the event was a recurring event, it now is a not recurring event.
     * <br> If parsing the date creates an exception, sets this value to the current value of the system clock.
     * @param date the date of the event
     */
    public void setDate(String date){
        parseLocalDate(date);;
        day = this.date.getDayOfWeek();
    }

    /**
     * Sets the day of the event.
     * <br> If the event was not a recurring event, it now is a recurring event.
     * @param day the day of the event
     */
    public void setDay(DayOfWeek day){
        this.day = day;
        date = null;
    }
}
