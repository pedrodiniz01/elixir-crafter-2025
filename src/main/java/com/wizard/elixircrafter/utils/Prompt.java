package com.wizard.elixircrafter.utils;

import java.util.Scanner;

public class Prompt {

    private static final Scanner scanner = new Scanner(System.in);

    public static String prompt(String message) {
        ConsolePrinter.printMessage(message);
        return scanner.nextLine();
    }

    public static boolean promptYesNo(String question) {
        while (true) {
            String response = prompt(question).trim().toUpperCase();
            switch (response) {
                case "Y" -> {
                    return true;
                }
                case "N" -> {
                    return false;
                }
                default -> ConsolePrinter.printInvalidYesNoInput();
            }
        }
    }
}
