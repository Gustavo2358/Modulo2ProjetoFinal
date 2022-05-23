package CarRental.domain;

public class Guest extends User{

    public Guest() {
        super.type = UserType.GUEST;
    }
}
