package com.example.wizardelixir.demo.controller;

import com.example.wizardelixir.demo.service.ElixirService;
import com.example.wizardelixirmaker.model.ElixirDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/elixirs")
@RequiredArgsConstructor
public class ElixirController {

    @Autowired
    private ElixirService elixirService;

    @GetMapping
    public List<ElixirDto> getElixirs() {
        return elixirService.getElixirsByIngredients(Set.of("Jewelweed", "Onion juice", "Neem oil", "oil"));
    }
}
