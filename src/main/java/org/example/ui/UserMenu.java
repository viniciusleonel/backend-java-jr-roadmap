package org.example.ui;

import org.example.model.user.User;
import org.example.service.UserService;

import java.util.Scanner;

public class UserMenu {

    private final Scanner scanner;
    private final UserService userService;

    public UserMenu(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.userService = userService;
    }

    public void start() {
        System.out.println("Iniciando cadastros de usuários...");
        int answer;

        do {
            answer = getAnswer();

            switch (answer) {
                case 1 -> registerUser();
                case 2 -> showUserData();
                case 3 -> System.out.println("Fechando sistema...");
                default -> System.out.println("Opção inválida");
            }
        } while (answer != 3);
    }

    private void registerUser() {
        System.out.print("Digite o nome: ");
        String name = scanner.nextLine();

        System.out.print("Digite a idade: ");
        int age = readInt();

        while (age <= 0) {
            System.out.print("Idade inválida, digite novamente: ");
            age = readInt();
        }

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.println("Usuário " + name + " cadastrado!" );

        userService.addUser(new User(name, age, email));
    }

    private int readInt() {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private int getAnswer() {
        System.out.println("--------------------");
        System.out.println("1- Cadastrar usuário");
        System.out.println("2- Listar usuários");
        System.out.println("3- Sair");
        return readInt();
    }

    private void showUserData(){
        userService.getAllUsers().forEach(user ->
                System.out.println(
                        "Name: " + user.name() +
                        ", Age: " + user.age() +
                        ", Email: " + user.email()

        ));
        System.out.println("Usuários cadastrados: " + userService.userCount());
        System.out.println("Idade média dos usuários: " + userService.getUsersAverageAge());
    }
}
