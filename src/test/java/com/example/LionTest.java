package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class LionTest {
    @Mock
    private Feline feline;

    @Test
    public void getKittensFelineGetKittens() throws Exception {
        int expectedKittensCount = 5;
        when(feline.getKittens()).thenReturn(expectedKittensCount);
        Lion lion = new Lion("Самец", feline);
        int actualKittensCount = lion.getKittens();

        assertEquals(expectedKittensCount, actualKittensCount);
        Mockito.verify(feline, times(1)).getKittens();
    }

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void doesHaveManeReturnsExpectedResult(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, feline);

        assertEquals(expected, lion.doesHaveMane(), "Для пола '" + sex + "' ожидается наличие гривы: " + expected);
    }

    @Test
    public void getFoodFelineWithCorrectArgument() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood, "Список еды должен совпадать с возвращаемым Feline");
        verify(feline, times(1)).getFood("Хищник");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Кот", "Male", "123"})
    public void lionConstructor_InvalidSex_ThrowsException(String invalidSex) {
        Exception exception = assertThrows(Exception.class,() -> new Lion(invalidSex, feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}