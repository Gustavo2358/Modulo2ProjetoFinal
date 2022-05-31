package CarRental.view;

import CarRental.repositories.CarRepository;
import CarRental.repositories.UserRepository;
import CarRental.domain.Guest;

public class ClientPage {

    public static void execute(){
        System.out.println("### MENU ###");
        System.out.printf("Nome de Usuário logado: %s%n", UserRepository.getCurrentUser().getUserName());
        System.out.println("1 - Fazer logout");
        System.out.println("2 - Veículos disponíveis para locação");
        System.out.println("3 - Alugar carro");
        System.out.println("4 - Devolver carro");
        int option = EntryPage.getEntryPageOption(1,4);
        //TODO implementar opção "Meus veículos" que mostra os carros alugados no nome do cliente
        switch (option){
            case 1:
                logout();
                break;
            case 2:
                showCarsAvailability();
                break;
            case 3:
                rentCar();
                break;
            case 4:
                returnCar();
                break;
        }

    }

    private static void returnCar() {
        TransactionPage.returnCar();
    }

    private static void rentCar() {
        TransactionPage.rentCar();
    }

    private static void logout() {
        System.out.println("fazendo logout...");
        UserRepository.setCurrentUser(new Guest());
    }


    private static void showCarsAvailability() {
        //TODO mostrar somente os carros disponíveis
        CarRepository
                .getCars()
                .forEach(car -> System.out.printf(
                        "%s %s - placa:%s - Valor por dia: R$%.2f - Cliente atual:%s%n",
                        car.getBrand(),
                        car.getModel(),
                        car.getLicensePlate(),
                        car.getValuePerDay(),
                        car.getCurrentClientName()
                ));
    }

}
