package CarRental;

import CarRental.domain.Admin;
import CarRental.repositories.UserRepository;
import CarRental.domain.UserType;
import CarRental.view.AdminPage;
import CarRental.view.EntryPage;
import CarRental.view.ClientPage;


public class Main {

    public static void main(String[] args) {

        FakeData.addClients();
        FakeData.addCars();

        UserRepository.addUser(new Admin("admin", "admin"));
        while (true) {
            if(UserRepository.getCurrentUser().getType() == UserType.GUEST) {
                EntryPage.execute();
            }else if(UserRepository.getCurrentUser().getType() == UserType.ADMIN){
                AdminPage.execute();
            }else{
                ClientPage.execute();
            }


        }
    }
}

