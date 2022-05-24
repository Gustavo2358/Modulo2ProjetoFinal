package CarRental.view;

import CarRental.domain.Agency;
import CarRental.domain.Client;
import CarRental.factory.ClientFactory;

import java.util.Scanner;

public class EntryPage {

    public static void execute(Agency agency) {
        System.out.println("_########## BEM-VINDO A LoCar ##########_");
        System.out.println("1 - Login");
        System.out.println("2 - Criar conta");
        switch (getEntryPageOption(1,2)){
            case 1:
                LogInPage.login(agency);
                break;
            case 2:
                Client client = ClientFactory.createClient(agency);
                if(agency.addUsers(client)){
                    System.out.println("Conta Criada com sucesso");
                    System.out.println("Nome do usuário - " + client.getUserName());
                    System.out.println();
                    agency.setCurrentUser(client);
                }
                break;
        }

    }

    public static int getEntryPageOption(int minRange, int maxRange) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while(true) {
            try {
                option = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Apenas valores numérico");
            }
            if(option >= minRange && option <= maxRange){
                return option;
            }else{
                System.out.println("Opção inválida");
            }
        }
    }
}
