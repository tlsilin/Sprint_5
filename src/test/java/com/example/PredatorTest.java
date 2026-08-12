package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PredatorTest {

    @Mock
    private Predator predator;

    @Test
    public void eatMeatReturnsList() throws Exception {
        Predator predator = new Feline();
        List<String> result = predator.eatMeat();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}