package org.example;

import org.example.service.UserService;
import org.example.ui.UserMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        UserMenu menu = new UserMenu(scanner, userService);

        menu.start();
        scanner.close();
    }
}