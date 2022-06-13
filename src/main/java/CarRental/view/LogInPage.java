package CarRental.view;

import CarRental.ApplicationContext;
import CarRental.domain.User;
import CarRental.service.RepositoryService;
import CarRental.repositories.UserRepository;
import CarRental.service.UserService;

import java.util.Scanner;

public class LogInPage {

    private UserRepository userRepository = UserRepository.getInstance();
    private RepositoryService<UserRepository, User> userRepositoryService = new RepositoryService<>();

    public LogInPage(){
        userRepositoryService.setRepository(userRepository);
    }

    public void execute(){
        Scanner sc = new Scanner(System.in);
        System.out.println("### FAZER LOGIN ###");
        String userName = getUserName(sc);
        if(userName.equals("")){
            return;
        }
        boolean isPasswordValid = getPassword(sc, userName);
        if (isPasswordValid){
            for(User user : userRepositoryService.getAll()) {
                if(user.getUserName().equals(userName))
                ApplicationContext.setCurrentUser(user);
            }
        }
    }

    private String getUserName(Scanner sc){
        boolean nameFound;
        String userName;
        System.out.println("Nome do usuário:");
        userName = sc.nextLine();
        nameFound = UserService.getAllUserNames().contains(userName);
        if(!nameFound) {
            System.out.println("Nome de usuário não encontrado.");
            return  "";
        }
        return userName;
    }

    private boolean getPassword(Scanner sc, String userName) {
        String passWord;
        boolean ok;
        do{
            System.out.println("Digite a senha ou digite sair para voltar ao menu principal:");
            passWord = sc.nextLine();
            if(passWord.equals("sair")){
                return false;
            }
            ok = UserService.checkPassword(userName,passWord);
            if(!ok){
                System.out.println("senha incorreta");
            }
        }while (!ok);
        return true;
    }
}
