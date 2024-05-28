package tests;

import com.example.Feline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class FelineTest {

    Feline feline = Mockito.spy(new Feline());

    @Test
    public void testGetKittens(){
        int one = 1;
        Mockito.when(feline.getKittens()).thenReturn(one);
        Assertions.assertEquals(one, feline.getKittens());
    }

    @Test
    public void testGetFamily(){
        String family = feline.getFamily();
        Mockito.when(feline.getFamily()).thenReturn(family);
        Assertions.assertEquals(family, feline.getFamily());
    }

    @Test
    public void testGetKittensCount(){
        int kittensCount = 4;
        Mockito.when(feline.getKittens(kittensCount)).thenReturn(kittensCount);
        Assertions.assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

    @ParameterizedTest
    @MethodSource("tests.testData.TestData#getPredatorTitle")
    public void testEatMeat(String kindOfAnimal) throws Exception {
        List <String> foodList = feline.getFood(kindOfAnimal);
        Mockito.when(feline.getFood(kindOfAnimal)).thenReturn(foodList);
        Assertions.assertEquals(foodList, feline.getFood(kindOfAnimal));
    }

}
