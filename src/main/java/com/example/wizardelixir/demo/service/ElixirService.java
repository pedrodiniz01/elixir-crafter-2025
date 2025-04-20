package com.example.wizardelixir.demo.service;

import com.example.wizardelixirmaker.api.ElixirsApi;
import com.example.wizardelixirmaker.invoker.ApiException;
import com.example.wizardelixirmaker.model.ElixirDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElixirService {

    @Autowired
    private ElixirsApi elixirsApi;

    public List<ElixirDto> getElixirsByIngredients(Set<String> userIngredients) {
        try {
            List<ElixirDto> allElixirs = elixirsApi.elixirsGet(null, null, null, null, null);

            return allElixirs.stream()
                    .filter(elixir -> elixir.getIngredients() != null && !elixir.getIngredients().isEmpty())
                    .filter(elixir -> elixir.getIngredients().stream()
                            .allMatch(ingredient -> userIngredients.contains(ingredient.getName().toLowerCase(Locale.ROOT))))
                    .collect(Collectors.toList());

        } catch (ApiException e) {
            throw new RuntimeException("Failed to fetch elixirs from external API", e);
        }
    }
}
