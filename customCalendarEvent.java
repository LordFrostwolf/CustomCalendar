import java.time.*;

public class customCalendarEvent{
    private String name;
    private LocalTime time;
    private LocalDate date;
    private DayOfWeek day;
    
    public customCalendarEvent(String name, LocalTime time, LocalDate date){
        this.name = name;
        this.time = time;
        this.date = date;
        this.day = date.getDayOfWeek();
    }

    public customCalendarEvent(String name, LocalTime time, DayOfWeek day){
        this.name = name;
        this.time = time;
        this.day = day;
    }

    public customCalendarEvent(String name, DayOfWeek day){
        this.name = name;
        this.day = day;
    }

    public customCalendarEvent(String name, LocalDate date){
        this.name = name;
        this.date = date;
        this.day = date.getDayOfWeek();
    }

    public String getName(){
        return name;
    }

    public LocalTime getTime(){
        if(time == null){
            return LocalTime.MIDNIGHT;
        }
        return time;
    }

    public LocalDate getDate(){
        if(date == null){
            LocalDate tmp = LocalDate.now();
            while(date.getDayOfWeek() != day){
                tmp = date.plusDays(1);
            }
            return tmp;
        }
        return date;
    }

    public DayOfWeek getDay(){
        return day;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setTime(LocalTime time){
        this.time = time;
    }

    public void setDate(LocalDate date){
        if(date != null){
            this.date = date;
        }
    }

    public void setDay(DayOfWeek day){
        this.day = day;
        date = null;
    }
}