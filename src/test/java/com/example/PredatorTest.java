package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class PredatorTest {

    @Test
    public void eatMeatReturnsList() throws Exception {
        Predator predator = new Feline();
        List<String> result = predator.eatMeat();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}