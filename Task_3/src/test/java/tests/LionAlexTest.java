package tests;

import com.example.LionAlex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class LionAlexTest {

    LionAlex lionAlex;

    {
        try {
            lionAlex = Mockito.spy(new LionAlex());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetFriends(){
        List<String> listOfFriends = lionAlex.getFriends();
        Mockito.when(lionAlex.getFriends()).thenReturn(listOfFriends);
        Assertions.assertEquals(listOfFriends, lionAlex.getFriends());

    }

    @Test
    public void testPlaceOfLiving(){
        String place = lionAlex.getPlaceOfLiving();
        Mockito.when(lionAlex.getPlaceOfLiving()).thenReturn(place);
        Assertions.assertEquals(place, lionAlex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittens(){
        int count = lionAlex.getKittens();
        Mockito.when(lionAlex.getKittens()).thenReturn(count);
        Assertions.assertEquals(count, lionAlex.getKittens());
    }
}
