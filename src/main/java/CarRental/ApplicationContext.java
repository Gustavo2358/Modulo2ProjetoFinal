package CarRental;

import CarRental.domain.Admin;
import CarRental.domain.Guest;
import CarRental.domain.User;
import CarRental.domain.UserType;
import CarRental.view.AdminPage;
import CarRental.view.ClientPage;
import CarRental.view.EntryPage;

public class ApplicationContext {

    public static User CurrentUser = new Guest();

    public static void start(){
        while (true) {
            if(getCurrentUser().getType() == UserType.GUEST) {
                EntryPage.execute();
            }else if(getCurrentUser().getType() == UserType.ADMIN){
                AdminPage adminPage = new AdminPage();
                adminPage.execute();
            }else{
                ClientPage.execute();
            }
        }
    }

    public static User getCurrentUser() {
        return CurrentUser;
    }

    public static void setCurrentUser(User currentUser) {
        CurrentUser = currentUser;
    }
}
