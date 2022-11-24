import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CustomCalendar{
    private List<CustomCalendarEvent> events = new ArrayList<CustomCalendarEvent>();

    public void addToCalendar(CustomCalendarEvent event){
        events.add(event);
    }

    public void removeFromCalendar(CustomCalendarEvent event){
        events.remove(event);
    }

    public CustomCalendarEvent getEvent(String name){
        CustomCalendarEvent event = null;
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getName() == name){
                event = events.get(i);
            }
        }
        return event;
    }

    public CustomCalendarEvent getEvent(String name, LocalTime time){
        CustomCalendarEvent event = null;
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getName() == name && events.get(i).getTime() == time){
                event = events.get(i);
            }
        }
        return event;
    }

    public CustomCalendarEvent getEvent(String name, LocalDate date){
        CustomCalendarEvent event = null;
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getName() == name && events.get(i).getDate() == date){
                event = events.get(i);
            }
        }
        return event;
    }

    public CustomCalendarEvent getEvent(String name, DayOfWeek day){
        CustomCalendarEvent event = null;
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getName() == name && events.get(i).getDay() == day){
                event = events.get(i);
            }
        }
        return event;
    }

    public CustomCalendarEvent getEvent(String name, DayOfWeek day, LocalTime time){
        CustomCalendarEvent event = null;
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getName() == name && events.get(i).getDay() == day && events.get(i).getTime() == time){
                event = events.get(i);
            }
        }
        return event;
    }

    public CustomCalendarEvent getEvent(String name, LocalDate date, LocalTime time){
        CustomCalendarEvent event = null;
        for (int i = 0; i < events.size(); i++){
            if(events.get(i).getName() == name && events.get(i).getDate() == date && events.get(i).getTime() == time){
                event = events.get(i);
            }
        }
        return event;
    }

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
