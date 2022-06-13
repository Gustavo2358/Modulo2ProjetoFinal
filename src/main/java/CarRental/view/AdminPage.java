package CarRental.view;

import CarRental.ApplicationContext;
import CarRental.repositories.CarRepository;
import CarRental.repositories.UserRepository;
import CarRental.domain.Guest;
import CarRental.utils.Utils;

public class AdminPage {

    public static void execute(){
        System.out.println("### MENU DO ADMINISTRADOR ###");
        System.out.printf("Nome de Usuário logado: %s%n", ApplicationContext.getCurrentUser().getUserName());
        System.out.println("1 - Listar usuários");
        System.out.println("2 - Cadastrar Veiculo");
        System.out.println("3 - Informações da frota");
        System.out.println("4 - Veículos disponíveis para locação");
        System.out.println("5 - Fazer logout");
        int option = Utils.getPageOption(1,5);
        switch (option){
            case 1:
                listUsers();
                break;
            case 2:
                CreateCarPage.execute();
                break;
            case 3:
                listCars();
                break;
            case 4:
                showCarsAvailability();
                break;
            case 5:
                logout();
                break;
        }

    }

    private static void showCarsAvailability() {

        CarRepository
                .getCars()
                .forEach(e -> System.out.printf(
                        "%s %s - placa:%s - Cliente atual:%s%n",
                        e.getBrand(),
                        e.getModel(),
                        e.getLicensePlate(),
                        e.getCurrentClient().getUserName()
                ));
    }

    private static void listUsers() {
        UserRepository.getUsers().forEach(System.out::println);
    }

    private static void logout() {
        System.out.println("fazendo logout...");
        ApplicationContext.setCurrentUser(new Guest());
    }

    private static void listCars() {
        CarRepository.getCars().forEach(System.out::println);
    }

}
