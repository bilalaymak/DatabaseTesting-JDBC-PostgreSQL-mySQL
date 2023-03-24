import org.junit.Assert;
import org.junit.Test;

public class FirstTest {

    @Test
    public void firstTest01(){


        Assert.assertTrue(6<9);

    }


    @Test
    public void firstTest02(){
         Assert.assertTrue("Test fail", 7<9);
         //if test fail, we will get the message
    }

    @Test
    public void firstTest03(){
        Assert.assertEquals("numbers are not equals","3","3");

    }



}
