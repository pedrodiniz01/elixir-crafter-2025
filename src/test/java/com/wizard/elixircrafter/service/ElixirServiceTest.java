package com.wizard.elixircrafter.service;

import com.example.wizardelixirmaker.api.ElixirsApi;
import com.example.wizardelixirmaker.model.ElixirDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ElixirServiceTest {

    @Mock
    private ElixirsApi elixirsApiMock;

    private ElixirService elixirService;

    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws Exception {
        List<ElixirDto> allElixirs = mapper.readValue(new File("src/test/java/testdata/elixirs.json"),
                new com.fasterxml.jackson.core.type.TypeReference<>() {});

        Mockito.when(elixirsApiMock.elixirsGet(null, null, null, null, null)).thenReturn(allElixirs);

        elixirService = new ElixirService(elixirsApiMock);
    }

    // Create nested classes for each method to keep the test class organized as the number of tests increases
    @Nested
    class FilterElixirsByIngredients {
        @Test
        void success() {
            // Act
            List<ElixirDto> filteredElixirs = elixirService.filterElixirsByIngredients(Set.of("cheese"));

            // Assert
            assertEquals(1, filteredElixirs.size());
            assertEquals("Cheese-Based Potions", filteredElixirs.get(0).getName());
        }

        @Test
        void emptyIngredients() {
            // Act
            List<ElixirDto> filteredElixirs = elixirService.filterElixirsByIngredients(Set.of());

            // Assert
            assertEquals(0, filteredElixirs.size());
        }

        @Test
        void givenMultipleIngredients_shouldReturnTwoElixirs() {
            // Act
            List<ElixirDto> filteredElixirs = elixirService.filterElixirsByIngredients(Set.of("neem oil", "jewelweed", "onion juice", "cheese"));

            // Assert
            assertEquals(2, filteredElixirs.size());
            assertEquals("Cheese-Based Potions", filteredElixirs.get(1).getName());
            assertEquals("Fergus Fungal Budge", filteredElixirs.get(0).getName());
        }
    }
}
