package CarRental.view;

import CarRental.ApplicationContext;
import CarRental.domain.Car;
import CarRental.domain.Guest;
import CarRental.repositories.GenericRepository;
import CarRental.utils.Utils;

public class ClientPage {

    public static void execute(){
        System.out.println("### MENU ###");
        System.out.printf("Nome de Usuário logado: %s%n", ApplicationContext.getCurrentUser().getUserName());
        System.out.println("1 - Veículos disponíveis para locação");
        System.out.println("2 - Alugar carro");
        System.out.println("3 - Devolver carro");
        System.out.println("4 - Fazer logout");
        int option = Utils.getPageOption(1,4);
        //TODO implementar opção "Meus veículos" que mostra os carros alugados no nome do cliente
        switch (option){
            case 1:
                showCarsAvailability();
                break;
            case 2:
                RentCarPage.execute();
                break;
            case 3:
                ReturnCarPage.execute();
                break;
            case 4:
                logout();
                break;
        }

    }

    private static void logout() {
        System.out.println("fazendo logout...");
        ApplicationContext.setCurrentUser(new Guest());
    }


    private static void showCarsAvailability() {
        //TODO mostrar somente os carros disponíveis
        GenericRepository<Car> carRepository = GenericRepository.getInstance();
        carRepository
                .get()
                .forEach(car -> System.out.printf(
                        "%s %s - placa:%s - Valor por dia: R$%.2f - Cliente atual:%s%n",
                        car.getBrand(),
                        car.getModel(),
                        car.getLicensePlate(),
                        car.getValuePerDay(),
                        car.getCurrentClient().getUserName()
                ));
    }

}
