package CarRental.view;

import CarRental.domain.Client;
import CarRental.factory.ClientFactory;
import CarRental.repositories.UserRepository;

import java.util.Scanner;

public class CreateClientPage {

    public static void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("### Criar Conta ###");
        String userName = getUserNameFromUser(sc);
        while(true) {
            System.out.println("Digite uma senha:");
            String password = sc.nextLine();
            System.out.println("Confirme a senha:");
            String passwordConfirmation = sc.nextLine();
            if(password.equals(passwordConfirmation)){
                Client client = ClientFactory.createClient(userName,password);
                if(UserRepository.addUser(client)){
                    System.out.println("Conta Criada com sucesso");
                    System.out.println("Nome do usuário - " + client.getUserName());
                    System.out.println();
                    UserRepository.setCurrentUser(client);
                    return;
                }
            }
            System.out.println("As senhas são diferentes");
        }

    }

    private static String getUserNameFromUser(Scanner sc){
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
