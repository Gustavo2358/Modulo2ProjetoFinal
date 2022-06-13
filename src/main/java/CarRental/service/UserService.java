package CarRental.service;

import CarRental.domain.User;
import CarRental.repositories.UserRepository;

import java.util.HashSet;

public class UserService {

    private static UserRepository userRepository = UserRepository.getInstance();
    private static RepositoryService<User> userRepositoryService = new RepositoryService<>();

    public UserService(){

    }

    public static boolean checkPassword(String userName, String passWord){
        for(User user: userRepositoryService.getAll()){
            if(user.getUserName().equals(userName)){
                return user.doesPasswordMatch(passWord);
            }
        }
        return false;
    }

    public static HashSet<String> getAllUserNames(){
        HashSet<String> names = new HashSet<>();
        userRepositoryService.setRepository(userRepository);
        for(User user : userRepositoryService.getAll()){
            names.add(user.getUserName());
        }
        return names;
    }
}
