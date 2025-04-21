package com.wizard.elixircrafter.service;

import com.example.wizardelixirmaker.api.ElixirsApi;
import com.example.wizardelixirmaker.model.ElixirDto;
import com.wizard.elixircrafter.constants.Constants;
import com.wizard.elixircrafter.exception.ElixirApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class ElixirService {

    private final ElixirsApi elixirsApi;
    private final List<ElixirDto> allElixirs;
    private static final Logger logger = LoggerFactory.getLogger(ElixirService.class);

    public ElixirService(ElixirsApi elixirsApi) {
        this.elixirsApi = elixirsApi;
        this.allElixirs = loadElixirs();
    }

    private List<ElixirDto> loadElixirs() {
        try {
            List<ElixirDto> fetchedElixirs = elixirsApi.elixirsGet(null, null, null, null, null);
            logger.info("Successfully fetched {} elixirs.", fetchedElixirs.size());
            return fetchedElixirs != null ? fetchedElixirs : Collections.emptyList();
        } catch (Exception e) {
            logger.error("Failed to load elixirs from API", e);
            throw new ElixirApiException(Constants.ExceptionMessages.INVALID_ELIXIR_API_RESPONSE, e);
        }
    }

    public List<ElixirDto> filterElixirsByIngredients(Set<String> ingredients) {
        return allElixirs.stream()
                .filter(elixir -> elixir.getIngredients() != null && !elixir.getIngredients().isEmpty())
                .filter(elixir -> elixir.getIngredients().stream()
                        .allMatch(ingredient -> ingredients.contains(ingredient.getName().toLowerCase(Locale.ROOT))))
                .collect(Collectors.toList());
    }
}

