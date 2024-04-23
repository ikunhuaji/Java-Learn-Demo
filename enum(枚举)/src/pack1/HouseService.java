package pack1;

public class HouseService {
    public int day;
    public int houseState;

    HouseService(String tmp)
    {
        for(DAY.Week c:DAY.Week.values()){
            if(c._day.equals(tmp))
            {
                day=c._num;
                break;
            }
        }

        if(houseState!=Constant.HOUSE_STATE_BUSY)houseState=Constant.HOUSE_STATE_BUSY;
        else houseState=Constant.HOUSE_STATE_FREE;
    }
}
