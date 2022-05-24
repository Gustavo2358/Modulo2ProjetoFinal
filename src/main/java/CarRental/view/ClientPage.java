package CarRental.view;

import CarRental.factory.CarFactory;
import CarRental.repositories.CarRepository;
import CarRental.repositories.UserRepository;
import CarRental.domain.Guest;

public class ClientPage {

    public static void execute(){
        System.out.println("### MENU ###");
        System.out.printf("Nome de Usuário logado: %s%n", UserRepository.getCurrentUser().getUserName());
        System.out.println("1 - Fazer logout");
        System.out.println("2 - Veículos disponíveis para locação");
        int option = EntryPage.getEntryPageOption(1,2);
        //TODO Alugar veículos
        //TODO Devolver veículos
        switch (option){
            case 1:
                logout();
                break;
            case 2:
                listCars();
                break;
        }

    }

    private static void logout() {
        System.out.println("fazendo logout...");
        UserRepository.setCurrentUser(new Guest());
    }

    private static void listCars() {
        CarRepository.getCars().forEach(System.out::println);
    }
}
