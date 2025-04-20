package com.wizard.elixircrafter.utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputParserTest {

    @Nested
    class ParseIngredients {

        @Test
        void nullInput() {
            // Act
            Set<String> result = InputParser.parseIngredients(null);

            // Assert
            assertEquals(Set.of(), result);
        }

        @Test
        void emptySpace() {
            // Act
            Set<String> result = InputParser.parseIngredients("   ");

            // Assert
            assertEquals(Set.of(), result);
        }
    }
}