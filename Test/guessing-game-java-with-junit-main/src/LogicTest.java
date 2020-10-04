import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogicTest {
    private static Logic logic;

    @BeforeClass
    public static void suiteSetup(){
        logic = new Logic();
    }


    @Test
    public void isInRange() {
        int testNum = 10;
        assertTrue("Not in range!",logic.isInRange(testNum));
    }

    @Test
    public void lower() {
        int testNum = 15;
        assertEquals("too low", logic.lower(testNum));
    }
    @Test
    public void higher() {
        int testNum = 36;
        assertEquals("too high", logic.higher(testNum));
    }

    @Test
    public void isWinner() {
        int testNum = 27;
        assertEquals("You won!", logic.isWinner(testNum));
    }

    @Test
    public void gameResult(){
        assertEquals("system broke!", "You don't get to play anymore!", logic.gameResult(10));
    }

    @Test
    public void randomStartNum(){
      assertTrue("Number out of range", logic.randomStartNum() >= 0 && logic.randomStartNum() <= 50);
    }

    @Test
    public void startNumbArray(){
        logic.startNumbArray();
       assertNotNull("Array is null", logic.getArrayList().get(0));
    }

    @Test
    public void genArrayList(){
        assertFalse(logic.getArrayList().size() > 0 );
    }

    @Test
    public void getWinNum() {
        assertEquals(27, logic.getWinNum());
    }
    @Test
    public void getUpLimit() {
        assertEquals(50, logic.getUpLimit());
    }
    @Test
    public void getLowLimit() {
        assertEquals(0, logic.getLowLimit());
    }
    @Test
    public void getArrayList(){assertFalse(logic.getArrayList().size() > 0 );}


}