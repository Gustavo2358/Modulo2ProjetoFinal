package CarRental.service;

import CarRental.domain.User;
import CarRental.repositories.UserRepository;

import java.util.HashSet;

public class UserService {

    private static final UserRepository userRepository = UserRepository.getInstance();


    public static boolean checkPassword(String userName, String passWord){
        for(User user: userRepository.getUsers()){
            if(user.getUserName().equals(userName)){
                return user.doesPasswordMatch(passWord);
            }
        }
        return false;
    }

    public static HashSet<String> getAllUserNames(){
        HashSet<String> names = new HashSet<>();
        for(User user : userRepository.getUsers()){
            names.add(user.getUserName());
        }
        return names;
    }
}
