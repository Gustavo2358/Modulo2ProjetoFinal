package CarRental.view;

import CarRental.repositories.UserRepository;
import CarRental.domain.Guest;

public class ClientPage {

    public static void execute(){
        System.out.println("### MENU ###");
        System.out.printf("Nome de Usuário logado: %s%n", UserRepository.getCurrentUser().getUserName());
        System.out.println("1 - Fazer logout");
        int option = EntryPage.getEntryPageOption(1,1);
        //TODO Listar veículos disponíveis
        //TODO Alugar veículos
        //TODO Devolver veículos
        switch (option){
            case 1:
                logout();
                break;
        }

    }

    private static void logout() {
        System.out.println("fazendo logout...");
        UserRepository.setCurrentUser(new Guest());
    }
}
