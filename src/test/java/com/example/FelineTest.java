package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void eatMeatGetFoodWithPredatorArgument() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        doReturn(expectedFood).when(feline).getFood("Хищник");

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
        verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyReturnsFeline() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensNoParametersGetKittensWithOne() {
        doReturn(5).when(feline).getKittens(1);

        int result = feline.getKittens();

        assertEquals(5, result);
        verify(feline, times(1)).getKittens(1);
    }

    @Test
    public void getKittensNoParametersDefaultReturnsOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 100, -1})
    public void getKittensWithParameterReturnsSameValue(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}