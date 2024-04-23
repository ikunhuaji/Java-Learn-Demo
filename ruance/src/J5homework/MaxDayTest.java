package J5homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class MaxDayTest
{
    @ParameterizedTest
    @CsvFileSource(resources = "/Test.csv",numLinesToSkip = 1)
    void GetMaxDayTest(int year,int mouth,int ans)
    {
        MaxDay maxDay = new MaxDay();

        assertEquals(ans,maxDay.GetMaxDay(year,mouth),year+" "+mouth+"测试错误");
    }


}