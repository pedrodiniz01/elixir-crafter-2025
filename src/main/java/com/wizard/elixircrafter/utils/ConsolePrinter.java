package com.wizard.elixircrafter.utils;

import com.example.wizardelixirmaker.model.ElixirDto;

import java.util.List;

public class ConsolePrinter {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printWelcomeMessage() {
        printMessage("\nAh... A wizard in the making! Welcome to the Elixir Crafter's class.");
    }

    public static void printNoIngredientsMessage() {
        printMessage("No ingredients offered. Focus your mind, young wizard!");
    }

    public static void printGoodbye() {
        printMessage("Goodbye Wizard! See you next time.");
    }

    public static void printInvalidYesNoInput() {
        printMessage("Invalid input. Please enter 'Y' for Yes or 'N' for No:");
    }

    public static void printNoElixirs() {
        printMessage("The alchemy fails... no elixir can arise from these ingredients.");
    }

    public static void printElixirsFound(List<ElixirDto> elixirs) {
        printMessage("\nFrom your offerings, these elixirs shall be born:");
        elixirs.forEach(elixir -> printMessage("- " + elixir.getName()));
    }
}
