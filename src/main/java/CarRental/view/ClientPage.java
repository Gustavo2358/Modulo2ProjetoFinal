package CarRental.view;

import CarRental.domain.Agency;
import CarRental.domain.Guest;

public class ClientPage {

    public static void execute(Agency agency){
        System.out.println("### MENU ###");
        System.out.printf("Nome de Usuário logado: %s%n", agency.getCurrentUser().getUserName());
        System.out.println("1 - Fazer logout");
        int option = EntryPage.getEntryPageOption(1,1);
        switch (option){
            case 1:
                logout(agency);
                break;
        }

    }

    private static void logout(Agency agency) {
        System.out.println("fazendo logout...");
        agency.setCurrentUser(new Guest());
    }
}
