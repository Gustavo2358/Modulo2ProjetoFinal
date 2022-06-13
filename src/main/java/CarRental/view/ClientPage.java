package CarRental.view;

import CarRental.ApplicationContext;
import CarRental.domain.Car;
import CarRental.domain.Guest;
import CarRental.repositories.CarRepository;
import CarRental.service.RepositoryService;
import CarRental.utils.Utils;

public class ClientPage {

    private CarRepository carRepository = CarRepository.getInstance();
    private RepositoryService<CarRepository, Car> carRepositoryService = new RepositoryService<>();


    public ClientPage(){
        carRepositoryService.setRepository(carRepository);
    }

    public void execute(){
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
                RentCarPage rentCarPage = new RentCarPage();
                rentCarPage.execute();
                break;
            case 3:
                ReturnCarPage returnCarPage = new ReturnCarPage();
                returnCarPage.execute();
                break;
            case 4:
                logout();
                break;
        }

    }

    private void logout() {
        System.out.println("fazendo logout...");
        ApplicationContext.setCurrentUser(new Guest());
    }


    private void showCarsAvailability() {
        //TODO mostrar somente os carros disponíveis
        carRepositoryService
                .getAll()
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
