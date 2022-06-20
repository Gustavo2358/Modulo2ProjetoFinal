package CarRental.domain;

public class Admin extends User{

    public Admin(){
        super.type = UserType.ADMIN;
    }

    public Admin(String userName, String password) {
        super(userName, password);
        super.type = UserType.ADMIN;
    }


}
