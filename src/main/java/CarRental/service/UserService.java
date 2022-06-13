package CarRental.service;

import CarRental.domain.User;
import CarRental.repositories.GenericRepository;

import java.util.HashSet;

public class UserService {


    public static boolean checkPassword(String userName, String passWord){
        GenericRepository<User> userRepository = GenericRepository.getInstance();
        for(User user: userRepository.get()){
            if(user.getUserName().equals(userName)){
                return user.doesPasswordMatch(passWord);
            }
        }
        return false;
    }

    public static HashSet<String> getAllUserNames(){
        GenericRepository<User> userRepository = GenericRepository.getInstance();
        HashSet<String> names = new HashSet<>();
        for(User user : userRepository.get()){
            names.add(user.getUserName());
        }
        return names;
    }
}
