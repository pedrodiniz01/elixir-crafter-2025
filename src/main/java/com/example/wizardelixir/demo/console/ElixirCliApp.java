package com.example.wizardelixir.demo.console;

import com.example.wizardelixir.demo.service.ElixirService;
import com.example.wizardelixir.demo.utils.ConsolePrinterUtils;
import com.example.wizardelixir.demo.utils.InputProcessingUtils;
import com.example.wizardelixir.demo.utils.PromptUtils;
import com.example.wizardelixirmaker.model.ElixirDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ElixirCliApp {

    @Autowired
    private ElixirService elixirService;

    public ElixirCliApp(ElixirService elixirService) {
        this.elixirService = elixirService;
    }

    public static void main(String[] args) {
        ElixirService elixirService = new ElixirService();
        ElixirCliApp app = new ElixirCliApp(elixirService);
        app.run();
    }

    public void run() {
        ConsolePrinterUtils.printWelcome();

        while (true) {
            Set<String> ingredients = askForIngredients();
            if (ingredients.isEmpty()) {
                ConsolePrinterUtils.printNoIngredientsMessage();
                break;
            }

            handleElixirSearch(ingredients);

            if (!askUserIfWantsToContinue()) {
                break;
            }
        }

        ConsolePrinterUtils.printGoodbye();
    }

    private Set<String> askForIngredients() {
        String input = PromptUtils.prompt("\nEnter the enchanted ingredients at your disposal (separated by commas):");
        return InputProcessingUtils.processIngredientsInput(input);
    }

    private void handleElixirSearch(Set<String> ingredients) {
        try {
            List<ElixirDto> elixirs = elixirService.getElixirsByIngredients(ingredients);
            if (elixirs.isEmpty()) {
                ConsolePrinterUtils.printNoElixirsFound();
            } else {
                ConsolePrinterUtils.printElixirsFoundMessage();
                elixirs.forEach(elixir -> System.out.println("- " + elixir.getName()));
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private boolean askUserIfWantsToContinue() {
        return PromptUtils.promptYesNo("\nWould you like to search for another elixir? (Y/N):");
    }
}
