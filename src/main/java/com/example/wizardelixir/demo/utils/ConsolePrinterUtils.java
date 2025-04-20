package com.example.wizardelixir.demo.utils;

public final class ConsolePrinterUtils {

    private ConsolePrinterUtils() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printWelcome() {
        printMessage("\nAh... A wizard in the making! Welcome to the Elixir Crafter's class.");
    }

    public static void printNoIngredientsMessage() {
        printMessage("No ingredients provided. Farewell, young wizard...");
    }

    public static void printGoodbye() {
        printMessage("Goodbye Wizard! See you next time.");
    }
    public static void printInvalidYesNoInput() {
        printMessage("Invalid input. Please enter 'Y' for Yes or 'N' for No:");
    }

    public static void printNoElixirsFound() {
        printMessage("The alchemy fails... no elixir can arise from these ingredients.");
    }

    public static void printElixirsFoundMessage() {
        printMessage("\nFrom your offerings, these elixirs shall be born:");
    }
}
