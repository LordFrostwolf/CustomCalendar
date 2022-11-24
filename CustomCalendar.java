import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * An object that can store and evaluate CustomCalendarEvents.
 * @see CustomCalendarEvent
 */
public class CustomCalendar{
    private List<CustomCalendarEvent> events = new ArrayList<CustomCalendarEvent>();

    /**
     * Adds a new CustomCalendarEvent to the calendar.
     * @param event the new CustomCalendarEvent
     */
    public void addToCalendar(CustomCalendarEvent event){
        events.add(event);
    }

    /**
     * Removes the given CustomCalendarEvent from the calendar.
     * @param event the CustomCalendarEvent that should be removed
     */
    public void removeFromCalendar(CustomCalendarEvent event){
        events.remove(event);
    }

    /**
     * Returns the CustomCalendarEvent that has the given name.
     * <br> If the calendar has two CustomCalendarEvents with the same name, returns the first CustomCalendarEvent with the given name.
     * <br> If there is no CustomCalendarEvent with the given name, returns {@code null}.
     * @param name the name of the CustomCalendarEvent
     * @return the CustomCalendarEvent with the given name
     */
    public CustomCalendarEvent getEvent(String name){
        CustomCalendarEvent event = null;
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getName() == name){
                event = events.get(i);
            }
        }
        return event;
    }

    /**
     * Returns the CustomCalendarEvent that has the given name and time.
     * <br> If the calendar has two CustomCalendarEvents with the same name and time, 
     * returns the first CustomCalendarEvent with the given name and time.
     * <br> If there is no CustomCalendarEvent with the given name and time, returns {@code null}.
     * @param name the name of the CustomCalendarEvent
     * @param time the time of the CustomCalendarEvent
     * @return the CustomCalendarEvent with the given name and time
     */
    public CustomCalendarEvent getEvent(String name, LocalTime time){
        CustomCalendarEvent event = null;
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getName() == name && events.get(i).getTime() == time){
                event = events.get(i);
            }
        }
        return event;
    }

    /**
     * Returns the CustomCalendarEvent that has the given name and date.
     * <br> If the calendar has two CustomCalendarEvents with the same name and date, 
     * returns the first CustomCalendarEvent with the given name and date.
     * <br> If there is no CustomCalendarEvent with the given name and date, returns {@code null}.
     * @param name the name of the CustomCalendarEvent
     * @param date the date of the CustomCalendarEvent
     * @return the CustomCalendarEvent with the given name and date
     */
    public CustomCalendarEvent getEvent(String name, LocalDate date){
        CustomCalendarEvent event = null;
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getName() == name && events.get(i).getDate() == date){
                event = events.get(i);
            }
        }
        return event;
    }

    /**
     * Returns the CustomCalendarEvent that has the given name and day.
     * <br> If the calendar has two CustomCalendarEvents with the same name and day, 
     * returns the first CustomCalendarEvent with the given name and day.
     * <br> If there is no CustomCalendarEvent with the given name and day, returns {@code null}.
     * @param name the name of the CustomCalendarEvent
     * @param day the day of the CustomCalendarEvent
     * @return the CustomCalendarEvent with the given name and day
     */
    public CustomCalendarEvent getEvent(String name, DayOfWeek day){
        CustomCalendarEvent event = null;
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getName() == name && events.get(i).getDay() == day){
                event = events.get(i);
            }
        }
        return event;
    }

    /**
     * Returns the CustomCalendarEvent that has the given name, day and time.
     * <br> If the calendar has two CustomCalendarEvents with the same name, day and time, 
     * returns the first CustomCalendarEvent with the given name, day and time.
     * <br> If there is no CustomCalendarEvent with the given name, day and time, returns {@code null}.
     * @param name the name of the CustomCalendarEvent
     * @param day the day of the CustomCalendarEvent
     * @param time the time of the CustomCalendarEvent
     * @return the CustomCalendarEvent with the given name, day and time
     */
    public CustomCalendarEvent getEvent(String name, DayOfWeek day, LocalTime time){
        CustomCalendarEvent event = null;
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getName() == name && events.get(i).getDay() == day && events.get(i).getTime() == time){
                event = events.get(i);
            }
        }
        return event;
    }

    /**
     * Returns the CustomCalendarEvent that has the given name, date and time.
     * <br> If the calendar has two CustomCalendarEvents with the same name, date and time, 
     * returns the first CustomCalendarEvent with the given name, date and time.
     * <br> If there is no CustomCalendarEvent with the given name, date and time, returns {@code null}.
     * @param name the name of the CustomCalendarEvent
     * @param date the date of the CustomCalendarEvent
     * @param time the time of the CustomCalendarEvent
     * @return the CustomCalendarEvent with the given name, date and time
     */
    public CustomCalendarEvent getEvent(String name, LocalDate date, LocalTime time){
        CustomCalendarEvent event = null;
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getName() == name && events.get(i).getDate() == date && events.get(i).getTime() == time){
                event = events.get(i);
            }
        }
        return event;
    }

    /**
     * Returns the next CustomCalendarEvent according to the system clock.
     * <br> If there is no next CustomCalendarEvent, returns null.
     * @return the next CustomCalendarEvent according to the system clock
     */
    public CustomCalendarEvent getNextEvent(){
        CustomCalendarEvent event = null;
        LocalTime curTime = LocalTime.now();
        LocalDate curDate = LocalDate.now();
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getDate().isAfter(curDate) || events.get(i).getDate().equals(curDate)){ 
                if(events.get(i).getTime().isAfter(curTime) || events.get(i).getTime() == null || events.get(i).getDate().isAfter(curDate)){
                    if(event == null || (events.get(i).getTime().isBefore(event.getTime()) && 
                    (events.get(i).getDate().isBefore(event.getDate()) || events.get(i).getDate().equals(event.getDate())))){
                        event = events.get(i);
                    }
                }
            }
        }
        return event;
    }
}
