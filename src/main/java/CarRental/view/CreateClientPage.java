package CarRental.view;

import CarRental.domain.Agency;
import CarRental.domain.Client;
import CarRental.domain.UserType;

import java.util.Scanner;

public class CreateClientPage {


    public static Client execute(Agency agency) {
        Scanner sc = new Scanner(System.in);
        System.out.println("### Criar Conta ###");
        String userName = getUserName(sc, agency);
        while(true) {
            System.out.println("Digite uma senha:");
            String password = sc.nextLine();
            System.out.println("Confirme a senha:");
            String passwordConfirmation = sc.nextLine();
            if(password.equals(passwordConfirmation)){
                System.out.println("Conta criada com sucesso");
                System.out.println("Nome do usuário - " + userName);
                return new Client(userName, password, UserType.CLIENT);
            }
            System.out.println("As senhas são diferentes");
        }

    }

    private static String getUserName(Scanner sc, Agency agency){
        boolean nameAlreadyInUse;
        String userName;
        do{
            System.out.println("Nome do usuário:");
            userName = sc.nextLine();
            nameAlreadyInUse = agency.getUserNames().contains(userName);
            if(nameAlreadyInUse) {
                System.out.println("Nome de usuário em uso, por favor, escolha outro.");
            }
        }while(nameAlreadyInUse);

        return userName;
    }


}
