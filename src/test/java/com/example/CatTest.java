package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSoundReturnsMeow() {
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        assertEquals("Мяу", sound, "Метод getSound должен вернуть Мяу.");
    }

    @Test
    public void getFoodFelineEatMeat() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(feline);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood, "Метод должен вернуть feline.eatMeat");
        verify(feline, times(1)).eatMeat();
    }
}
