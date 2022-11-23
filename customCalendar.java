import java.util.ArrayList;
import java.util.List;

public class customCalendar{
    private List<customCalendarEvent> events = new ArrayList<customCalendarEvent>();

    public void addToCalendar(customCalendarEvent event){
        events.add(event);
    }

    public void removeFromCalendar(customCalendarEvent event){
        events.remove(event);
    }
}
