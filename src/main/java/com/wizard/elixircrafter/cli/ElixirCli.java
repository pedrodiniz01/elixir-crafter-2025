package com.wizard.elixircrafter.cli;

import com.example.wizardelixirmaker.model.ElixirDto;
import com.wizard.elixircrafter.service.ElixirService;
import com.wizard.elixircrafter.utils.ConsolePrinter;
import com.wizard.elixircrafter.utils.InputParser;
import com.wizard.elixircrafter.utils.Prompt;

import java.util.List;
import java.util.Set;

public class ElixirCli {

    private final ElixirService elixirService;

    public ElixirCli(ElixirService elixirService) {
        this.elixirService = elixirService;
    }

    /**
     * Main execution loop for the CLI application.
     */
    public void run() {
        ConsolePrinter.printWelcomeMessage();

        do {
            Set<String> ingredients = promptIngredients();

            if (!ingredients.isEmpty()) {
                List<ElixirDto> filteredElixirs = elixirService.filterElixirsByIngredients(ingredients);
                displayElixirs(filteredElixirs);
            } else {
                ConsolePrinter.printNoIngredientsMessage();
            }

        } while (shouldContinue());

        ConsolePrinter.printGoodbye();
    }

    private boolean shouldContinue() {
        return Prompt.promptYesNo("\nWould you like to search for another elixir? (Y/N):");
    }

    private void displayElixirs(List<ElixirDto> elixirs) {
        if (elixirs.isEmpty()) {
            ConsolePrinter.printNoElixirs();
        } else {
            ConsolePrinter.printElixirsFound(elixirs);
        }
    }

    private Set<String> promptIngredients() {
        String ingredients = Prompt.prompt("\nEnter the enchanted ingredients at your disposal (separated by commas):");
        return InputParser.parseIngredients(ingredients);
    }
}
