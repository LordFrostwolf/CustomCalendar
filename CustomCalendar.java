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

    private boolean isYearLeapYear(int year){
        if(year % 4 == 0 && (!(year % 100 == 0) || year % 400 == 0)){
            return true;
        }
        return false;
    }

    /**
     * Prints the remaining time until the next event based on the system clock.
     */
    public void howLongUntilNextEvent(){
        LocalTime curTime = LocalTime.now();
        LocalDate curDate = LocalDate.now();
        CustomCalendarEvent nextEvent = getNextEvent();
        System.out.println(nextEvent.getName() + " " + nextEvent.getDate());

        int yearDiff = nextEvent.getDate().getYear() - curDate.getYear();
        int monthDiff = (nextEvent.getDate().getMonthValue() - curDate.getMonthValue()) % 12;
        int dayDiff;
        switch(nextEvent.getDate().getMonthValue()){
            case 1,3,5,7,8,10,12: 
                dayDiff = (nextEvent.getDate().getDayOfMonth() - curDate.getDayOfMonth()) % 31;
                break;
            case 2:
                if(isYearLeapYear(nextEvent.getDate().getYear())){
                    dayDiff = (nextEvent.getDate().getDayOfMonth() - curDate.getDayOfMonth()) % 29;
                }
                else{
                    dayDiff = (nextEvent.getDate().getDayOfMonth() - curDate.getDayOfMonth()) % 28;
                }
                break;
            default:
                dayDiff =(nextEvent.getDate().getDayOfMonth() - curDate.getDayOfMonth()) % 30;
        }
        int hourDiff = (nextEvent.getTime().getHour() - curTime.getHour()) % 24;
        int minuteDiff = (nextEvent.getTime().getMinute() - curTime.getMinute()) % 60;
        int secondsDiff = (nextEvent.getTime().getSecond() - curTime.getSecond()) % 60;
        if(monthDiff < 0){monthDiff+=12;}
        if(dayDiff < 0){
            switch(nextEvent.getDate().getMonthValue()){
                case 1,3,4,7,8,10,12:
                    dayDiff += 31;
                    break;
                case 2:
                    if(isYearLeapYear(nextEvent.getDate().getYear())){dayDiff += 29;}
                    else{dayDiff += 28;}
                    break;
                default:
                    dayDiff += 30;
            }
        }
        if(hourDiff < 0){
            hourDiff+=24;
            dayDiff -= 1;
        }
        if(minuteDiff < 0){
            minuteDiff+=60;
            hourDiff -= 1;
        }
        if(secondsDiff < 0){
            secondsDiff+=60;
            minuteDiff -= 1;
        }

        String output = new String("Bis zum nächsten Event mit dem Namen \"" + nextEvent.getName() + 
            "\" am " + nextEvent.getDate() + 
            " um " + nextEvent.getTime().getHour() + ":" + 
            (nextEvent.getTime().getMinute() > 10 ? nextEvent.getTime().getMinute() : "0" + nextEvent.getTime().getMinute()) 
            + " sind es noch:");

        String output1 = yearDiff != 0 ? output.concat("\n" + yearDiff + " Jahre") : output;
        String output2 = monthDiff != 0 ? output1.concat("\n" + monthDiff + " Monate") : output1;
        String output3 = dayDiff != 0 ? output2.concat("\n" + dayDiff + " Tage") : output2;
        String output4 = hourDiff != 0 ? output3.concat("\n" + hourDiff + " Stunden") : output3;
        String output5 = minuteDiff != 0 ? output4.concat("\n" + minuteDiff + " Minuten") : output4;
        String output6 = secondsDiff != 0 ? output5.concat("\n" + secondsDiff + " Sekunden") : output5;

        System.out.println(output6);
    }
}
