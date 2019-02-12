import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class DriverTest {

    Driver driver = new Driver("Paul",12345);

    @Test
    public void TestgetName(){
        assertEquals("Paul", driver.getDriverName());
    }

    @Test
    public void TestgetDriveNum(){
        assertEquals(12345, driver.getDriverNum());
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestgetDriverNumFail() {
        Driver chuck = new Driver("", 2);
        assertEquals("2", chuck.getDriverNum());
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestgetDriverNameFail() {
        Driver chuck = new Driver("chucky urlaw", 2);
        assertEquals("chucky urlaw", chuck.getDriverName());
    }

    @Test
    public void TestisNotBanned(){
        assertFalse(driver.check_status());
    }

    @Test (timeout=1000)//milliseconds
    public void TestwaitTillWorking(){
        driver.waitTillbanned();
    }
    //week 2 tests
    @Test(expected = IllegalArgumentException.class)
    public void testDriverNameEmpty(){
        Driver driver2 = new Driver("",145);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDriverNumberLessThan100(){
        Driver driver3 = new Driver("Paddy",45);
    }

    @Test
    public void testtoString(){
        String expected = "\nDriver Name: Paul\nDriver Number: 12345";
        assertEquals(expected, driver.toString());
    }

}
