package com.example.wizardelixir.demo.utils;

import java.util.Scanner;

public class PromptUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static String prompt(String message) {
        ConsolePrinterUtils.printMessage(message);
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
                default -> ConsolePrinterUtils.printInvalidYesNoInput();
            }
        }
    }
}
