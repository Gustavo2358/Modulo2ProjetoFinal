package CarRental;

import CarRental.domain.Admin;
import CarRental.domain.Agency;
import CarRental.domain.UserType;
import CarRental.view.AdminPage;
import CarRental.view.EntryPage;
import CarRental.view.ClientPage;


public class Main {

    public static void main(String[] args) {
        Agency agency = new Agency();
        agency.addUsers(new Admin("admin", "admin", UserType.ADMIN));
        while (true) {
            if(agency.getCurrentUser().getType() == UserType.GUEST) {
                EntryPage.execute(agency);
            }else if(agency.getCurrentUser().getType() == UserType.ADMIN){
                AdminPage.execute(agency);
            }else{
                ClientPage.execute(agency);
            }


        }
    }
}

