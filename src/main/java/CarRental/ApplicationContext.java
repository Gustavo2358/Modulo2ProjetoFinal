package CarRental;

import CarRental.domain.Car;
import CarRental.domain.Guest;
import CarRental.domain.User;
import CarRental.domain.UserType;
import CarRental.repositories.*;
import CarRental.view.AdminPage;
import CarRental.view.ClientPage;
import CarRental.view.EntryPage;

public class ApplicationContext {

    private static User CurrentUser = new Guest();
    private static Repository<User> userRepository = new UserFileRepository();
    private static Repository<Car> carRepository = CarRepository.getInstance();

    public static void start(){
        while (true) {
            if(getCurrentUser().getType() == UserType.GUEST) {
                EntryPage entryPage = new EntryPage();
                entryPage.execute();
            }else if(getCurrentUser().getType() == UserType.ADMIN){
                AdminPage adminPage = new AdminPage();
                adminPage.execute();
            }else{
                ClientPage clientPage = new ClientPage();
                clientPage.execute();
            }
        }
    }

    public static User getCurrentUser() {
        return CurrentUser;
    }

    public static void setCurrentUser(User currentUser) {
        CurrentUser = currentUser;
    }

    public static Repository<User> getUserRepository() {
        return userRepository;
    }

    public static Repository<Car> getCarRepository() {
        return carRepository;
    }
}
