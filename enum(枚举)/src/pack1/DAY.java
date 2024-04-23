package pack1;

public class DAY {
    public static enum Week{
        MONDAY("Monday",1) , TUESDAY("Tuesday",2) ,
        WEDNESDAY("Wednesday",3) , THURSDAY("Thursday",4) ,
        FRIDAY("Friday",5) , SATURDAY("Saturday",6) ,
        SUNDAY("Sunday",7);

        Week(String day,int num)
        {
            _day=day;
            _num=num;
        }
        String _day;
        int _num;

    }
}
