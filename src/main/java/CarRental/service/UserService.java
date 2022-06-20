package CarRental.service;

import CarRental.ApplicationContext;
import CarRental.domain.User;

import java.util.HashSet;

public class UserService {

    private static RepositoryService<User> userRepositoryService = new RepositoryService<>();

    public UserService(){
        userRepositoryService.setRepository(ApplicationContext.getUserRepository());
    }
    //TODO separar responsabilidades

    public boolean checkPassword(String userName, String passWord){
        for(User user: userRepositoryService.getAll()){
            if(user.getUserName().equals(userName)){
                return user.doesPasswordMatch(passWord);
            }
        }
        return false;
    }

    public HashSet<String> getAllUserNames(){
        HashSet<String> names = new HashSet<>();
        for(User user : userRepositoryService.getAll()){
            names.add(user.getUserName());
        }
        return names;
    }
}
