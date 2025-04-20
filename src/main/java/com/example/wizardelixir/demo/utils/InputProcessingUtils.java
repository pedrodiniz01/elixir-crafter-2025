package com.example.wizardelixir.demo.utils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputProcessingUtils {

    public static Set<String> processIngredientsInput(String input) {
        if (input == null || input.isBlank()) {
            return Set.of();
        }

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(String::toLowerCase)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet());
    }
}
