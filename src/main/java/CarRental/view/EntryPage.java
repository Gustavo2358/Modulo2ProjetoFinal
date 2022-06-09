package CarRental.view;

import CarRental.repositories.UserRepository;
import CarRental.domain.Client;
import CarRental.factory.ClientFactory;
import CarRental.utils.Utils;

import java.util.Scanner;

public class EntryPage {

    public static void execute() {
        System.out.println("_########## BEM-VINDO A LoCar ##########_");
        System.out.println("1 - Login");
        System.out.println("2 - Criar conta");
        switch (Utils.getPageOption(1,2)){
            case 1:
                LogInPage.execute();
                break;
            case 2:
                Client client = ClientFactory.createClient();
                if(UserRepository.addUser(client)){
                    System.out.println("Conta Criada com sucesso");
                    System.out.println("Nome do usuário - " + client.getUserName());
                    System.out.println();
                    UserRepository.setCurrentUser(client);
                }
                break;
        }

    }

}
