package ss.week2.test;
 
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ss.week2.hotel.Safe;

public class TestSafe {
    public Safe safe;
   
    @Before
    public void setUp() {
        safe = new Safe("wachtwoord");
    }
   
    @Test
    public void testActivateRight() {
        safe.activate("wachtwoord");
        assertTrue(safe.isActive());
    }
    @Test
     public void testActivateWrong() {
    	safe.activate("fout");
    	assertFalse(safe.isActive());
    }
    @Test
     public void testDeactivateRight() {
    	safe.deactivate();
    	assertFalse(safe.isActive());
    }
    @Test
     public void testDeactivateWrong() {
    	safe.activate("wachtwoord");
    	assertTrue(safe.isActive());   
    }
    @Test
     public void testOpenRight() {
    	safe.activate("wachtwoord");
    	safe.open("wachtwoord");
    	assertTrue(safe.isOpen());
    }
    @Test
     public void testOpenWrong() {
    	safe.close();
    	assertFalse(safe.isOpen());
    }
    @Test
     public void testCloseright() {
    	safe.open("wachtwoord");
    	safe.close();
    	assertFalse(safe.isOpen());
    } 
    @Test
    public void testIsActive() {
    	safe.activate("wachtwoord");
    	assertTrue(safe.isActive());
    }
    @Test
    public void testIsActiveWrong() {
    	safe.deactivate();
    	assertFalse(safe.isActive());
    }
    @Test
    public void testIsOpenRight() {
    	safe.activate("wachtwoord");
    	safe.open("wachtwoord");
    	assertTrue(safe.isOpen());
    }
    @Test
    public void testIsOpenWrong() {
    	safe.close();
    	assertFalse(safe.isOpen());
    }
    @Test
    public void testGetPassword() {
    	assertEquals("wachtwoord", safe.getPassword().password);
    }
    @Test
    public void test() {
    	assertEquals(1, 1);
    }
 
}