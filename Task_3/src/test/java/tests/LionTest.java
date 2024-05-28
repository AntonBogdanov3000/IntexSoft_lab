package tests;

import com.example.Lion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;


public class LionTest extends BaseTest{

    Lion lion = Mockito.spy(new Lion(feline));

    Lion lionFemale;

    {
        try {
            lionFemale = Mockito.spy(new Lion("Female"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetKittens(){
        int kittensCount = 2;
        Mockito.when(lion.getKittens()).thenReturn(kittensCount);
        Assertions.assertEquals(kittensCount, lion.getKittens());
    }

    @Test
    public void testMane(){
        boolean isHaveMane = true;
        Mockito.when(lion.doesHaveMane()).thenReturn(isHaveMane);
        Assertions.assertEquals(isHaveMane, lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> foodList = lion.getFood();
        Mockito.when(lion.getFood()).thenReturn(foodList);
        Assertions.assertEquals(foodList, lion.getFood());
    }
}
