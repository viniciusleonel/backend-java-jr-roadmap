package org.example;

import org.example.domain.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Iniciando cadastros de usuários...");
        int answer;

        List<User> userList = new ArrayList<>();

        do {
            answer = getAnswer(scanner);

            switch (answer) {
                case 1:
                    userList.add(createUser(scanner));
                    break;
                case 2:
                    showUserData(userList);
                    break;
                case 3:
                    System.out.println("Fechando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (answer != 3);

        scanner.close();
    }

    private static User createUser(Scanner scanner) {
        System.out.print("Digite o nome: ");
        String name = scanner.nextLine();

        System.out.print("Digite a idade: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        while (age <= 0) {
            System.out.print("Idade inválida, digite novamente: ");
            age = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.println("Usuário " + name + " cadastrado!" );

        return new User(name, age, email);
    }

    private static double getAverageAge(List<User> userList){
        if (userList.isEmpty()) {
            return 0;
        }
        int totalAge = 0;
        for (User user : userList) {
            totalAge += user.getAge();
        }
        return (double) totalAge / userList.size();
    }

    private static void showUserData(List<User> userList){
          for (User user : userList) {
            System.out.println(
                "Name: " + user.getName() + ", " +
                "Age: " + user.getAge() + ", " +
                "Email: " + user.getEmail()
            );
        }
        System.out.println("Usuários cadastrados: " + userList.size());
        System.out.println("Idade média dos usuários: " + getAverageAge(userList));
    }

    private static int getAnswer(Scanner scanner) {
        System.out.println("--------------------");
        System.out.println("1- Cadastrar usuário");
        System.out.println("2- Listar usuários");
        System.out.println("3- Sair");
        int answer = scanner.nextInt();
        scanner.nextLine();
        return answer;
    }
}