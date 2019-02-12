import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class DriverPrivateTest {
    @Test
    public void testSetDriverNum() throws Exception{

        System.out.println("test Driver Number");
        Driver driver = new Driver("Paul",145);
        Class secretClass = driver.getClass();

        Field f = secretClass.getDeclaredField("driverNum");

        f.setAccessible(true);

        System.out.println("the value in f(driver Number)is "+ f.get(driver));

        int result = f.getInt(driver);
        assertEquals("the driver Numbers should be equal",145,result);
    }



@Test
public void testsetDriverNum1()throws Exception {
    System.out.println("setDriverNum1");

    Driver driver = new Driver("Paul", 150);

    Method method = Driver.class.getDeclaredMethod("setDriverNum", int.class);

    method.setAccessible(true);

    method.invoke(driver, 150);

    Class secretClass = driver.getClass();

    Field f = secretClass.getDeclaredField("driverNum");

    f.setAccessible(true);

    int result = f.getInt(driver);
    System.out.println("the value in f(driver Number is " + f.get(driver));
    assertEquals("The numbers should be equal", 150, result);


}
}