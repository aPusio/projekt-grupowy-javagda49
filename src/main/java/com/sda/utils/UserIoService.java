package com.sda.utils;

import java.util.List;
import java.util.Scanner;

public class UserIoService {
    private static final int LINE_SEPARATOR_REPEATS = 100;
    private static final String COLOR_RESET = "\u001B[0m";

    public String getString(String message) {
        if (message != null && !message.equals("")) {
            System.out.println(message);
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public Integer getInt(String message) {
        if (message != null && !message.equals("")) {
            System.out.println(message);
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printOnScreen(List<String> content) {
        content.forEach(System.out::println);
    }

    public void printOnScreen(String content) {
        System.out.print(content);
    }

    public void printOnScreenWithColor(String content, TextColor textColor) {
        if (textColor != null) {
            System.out.print(textColor.getColor() + content + COLOR_RESET);
        } else {
            System.out.print(content);
        }
    }

    public void printLineEnd() {
        System.out.println();
    }

    public void clearScreen() {
        System.out.println(System.lineSeparator().repeat(LINE_SEPARATOR_REPEATS));
        try {
            final String os = System.getProperty("os.name");
            final String command = os.contains("Windows") ? "cls" : "clear";
            Runtime.getRuntime().exec(command);
        } catch (final Exception ignored) {
        }
    }
}
