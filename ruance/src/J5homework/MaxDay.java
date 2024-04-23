package J5homework;

public class MaxDay {
    int GetMaxDay(int year, int month) {
        int maxday = 0;
        if (month >= 1 && month <= 12) {
            if (month == 2) {
                if (year % 4 == 0) {
                    if (year % 100 == 0) {
                        if (year % 400 == 0)
                            maxday = 29;
                        else
                            maxday = 28;
                    } else
                        maxday = 29;
                } else
                    maxday = 28;
            } else if (month == 4 || month == 6 || month == 9 || month == 11)
                maxday = 30;
            else
                maxday = 31;
        }
        return maxday;
    }
}