package CarRental.view;

import CarRental.ApplicationContext;
import CarRental.domain.Car;
import CarRental.domain.User;
import CarRental.repositories.CarRepository;
import CarRental.service.RepositoryService;
import CarRental.domain.Guest;
import CarRental.repositories.UserRepository;
import CarRental.utils.Utils;

public class AdminPage {

    private CarRepository carRepository = CarRepository.getInstance();
    private RepositoryService<Car> carRepositoryService = new RepositoryService<>();

    private UserRepository userRepository = UserRepository.getInstance();
    private RepositoryService<User> userRepositoryService = new RepositoryService<>();

    public AdminPage(){
        carRepositoryService.setRepository(carRepository);
        userRepositoryService.setRepository(userRepository);
    }

    public void execute(){
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
                CreateCarPage createCarPage = new CreateCarPage();
                createCarPage.execute();
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

    private void showCarsAvailability() {
        this.carRepositoryService
                .getAll()
                .forEach(e -> System.out.printf(
                        "%s %s - placa:%s - Cliente atual:%s%n",
                        e.getBrand(),
                        e.getModel(),
                        e.getLicensePlate(),
                        e.getCurrentClient().getUserName()
                ));
    }

    private void listUsers() {
        userRepositoryService.getAll().forEach(System.out::println);
    }

    private void logout() {
        System.out.println("fazendo logout...");
        ApplicationContext.setCurrentUser(new Guest());
    }

    private void listCars() {
        carRepositoryService.getAll().forEach(System.out::println);
    }

}
