package CarRental.view;

import CarRental.domain.Agency;
import CarRental.domain.Guest;
import CarRental.factory.CarFactory;

public class AdminPage {

    public static void execute(Agency agency){
        System.out.println("### MENU DO ADMINISTRADOR ###");
        System.out.printf("Nome de Usuário logado: %s%n", agency.getCurrentUser().getUserName());
        System.out.println("1 - Listar usuários");
        System.out.println("2 - Cadastrar Veiculo");
        System.out.println("3 - Fazer logout");
        int option = EntryPage.getEntryPageOption(1,3);
        switch (option){
            case 1:
                listUsers(agency);
                break;
            case 2:
                CarFactory.createCar();
                break;
            case 3:
                logout(agency);
                break;
        }

    }

    private static void listUsers(Agency agency) {
        agency.getUsers().forEach(System.out::println);
    }

    private static void logout(Agency agency) {
        System.out.println("fazendo logout...");
        agency.setCurrentUser(new Guest());
    }

}
