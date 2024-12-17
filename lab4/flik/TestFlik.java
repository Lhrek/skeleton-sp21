package flik;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {
    @Test
    public void test(){
        int a = 128;int b = 128;
        assertTrue(Flik.isSameNumber(a,b));
    }
}
