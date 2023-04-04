import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FirstTest {

    @Test
    public void firstTest01(){


        assertTrue(6<9);
        assertFalse(6>9);


    }


    @Test
    public void firstTest02(){
         assertTrue("Test fail", 7<9);
         //if test fail, we will get the message
    }

    @Test
    public void firstTest03(){
        Assert.assertEquals("numbers are not equals","3","3");

    }



}
