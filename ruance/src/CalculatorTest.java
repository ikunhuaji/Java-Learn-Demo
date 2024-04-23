import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)//根据Order运行测试项
class CalculatorTest {

    @BeforeEach//每个测试前运行
    public void beEach(){
        System.out.println("BEFORE");
    }

    @BeforeAll//所有测试前运行
    public static void beAll()
    {
        System.out.println("BEFOREALL");
    }

    @ParameterizedTest
    @Order(0)
    @ValueSource(strings = {"a","b"})
    void testWithValueString(String str)
    {
        System.out.println(str);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class,names = {"DAYS","HOURS"})
    void testWithnumSource(TimeUnit timeUnit)
    {
        System.out.println(timeUnit);
    }

//    @ParameterizedTest
//    @CsvFileSource(resources = "/")
//    void testWithCsv(CsvFileSource csvFileSource)
//    {
//        System.out.println(csvFileSource);
//    }

    @Test
    @Order(2)
    @RepeatedTest(2)
    @DisplayName("加法")
    public void testAdd()
    {
        Calculator calculator = new Calculator();
        int res = calculator.add(1,1);
        assertEquals(2,res,"1+1计算错误");
    }

    @Test
    @Order(1)
    @RepeatedTest(1)
    @DisplayName("减法")
    public void testMinus() {
        Calculator calculator = new Calculator();
        int res = calculator.minus(1,1);
        assertEquals(0,res);
    }

}