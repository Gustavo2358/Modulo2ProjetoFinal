package CarRental.domain;

public class Client extends User{


    public Client(String userName, String password) {
        super(userName, password);
        super.type = UserType.CLIENT;
    }
}
