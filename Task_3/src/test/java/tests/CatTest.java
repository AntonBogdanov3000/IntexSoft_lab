package tests;

import com.example.Cat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class CatTest extends BaseTest{

    Cat cat = Mockito.spy(new Cat(feline));

    @Test
    public void testCatSound(){
        String sound = cat.getSound();
        Mockito.when(cat.getSound()).thenReturn(sound);
        Assertions.assertEquals(sound, cat.getSound());
    }

    @Test
    public void testGetFood(){
        List<String> foodList = cat.getFood();
        Mockito.when(cat.getFood()).thenReturn(foodList);
        Assertions.assertEquals(foodList, cat.getFood());
    }
}
