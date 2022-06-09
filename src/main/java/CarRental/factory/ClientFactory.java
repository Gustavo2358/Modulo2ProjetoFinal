package CarRental.factory;

import CarRental.repositories.UserRepository;
import CarRental.domain.Client;

import java.util.Scanner;

public class ClientFactory {


    public static Client createClient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("### Criar Conta ###");
        String userName = getUserName(sc);
        while(true) {
            System.out.println("Digite uma senha:");
            String password = sc.nextLine();
            System.out.println("Confirme a senha:");
            String passwordConfirmation = sc.nextLine();
            if(password.equals(passwordConfirmation)){
                return new Client(userName, password);
            }
            System.out.println("As senhas são diferentes");
        }

    }

    private static String getUserName(Scanner sc){
        boolean nameAlreadyInUse;
        String userName;
        do{
            System.out.println("Nome do usuário:");
            userName = sc.nextLine();
            nameAlreadyInUse = UserRepository.getAllUserNames().contains(userName);
            if(nameAlreadyInUse) {
                System.out.println("Nome de usuário em uso, por favor, escolha outro.");
            }
        }while(nameAlreadyInUse);

        return userName;
    }


}
