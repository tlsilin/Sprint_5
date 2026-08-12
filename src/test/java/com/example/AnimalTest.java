package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @ParameterizedTest
    @ValueSource(strings = {"Всеядное","Плотоядное"})
    @NullAndEmptySource
    public void getFoodUnknownAnimalKind(String unknownAnimalKind) {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> animal.getFood(unknownAnimalKind));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }


    @Test
    public void getFamilyReturnsCorrectKind() {
        Animal animal = new Animal();
        String familyKind = animal.getFamily();
        assertNotNull(familyKind);
        assertTrue(familyKind.contains("кошачьи"));
    }
}