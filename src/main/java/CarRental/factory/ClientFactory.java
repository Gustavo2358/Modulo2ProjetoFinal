package CarRental.factory;

import CarRental.repositories.UserRepository;
import CarRental.domain.Client;

import java.util.Scanner;

public class ClientFactory {


    public static Client createClient(String userName, String password) {
        return new Client(userName, password);
    }

}
