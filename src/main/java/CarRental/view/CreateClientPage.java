package CarRental.view;

import CarRental.ApplicationContext;
import CarRental.domain.User;
import CarRental.domain.UserType;
import CarRental.factory.UserFactory;
import CarRental.service.RepositoryService;
import CarRental.repositories.UserRepository;
import CarRental.service.UserService;

import java.util.Scanner;

public class CreateClientPage {

    private UserRepository userRepository = UserRepository.getInstance();
    private RepositoryService<User> userRepositoryService = new RepositoryService<>();

    public CreateClientPage() {
        userRepositoryService.setRepository(userRepository);
    }

    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("### Criar Conta ###");
        String userName = getUserNameFromUser(sc);
        while(true) {
            System.out.println("Digite uma senha:");
            String password = sc.nextLine();
            System.out.println("Confirme a senha:");
            String passwordConfirmation = sc.nextLine();
            if(password.equals(passwordConfirmation)){
                User client = UserFactory.createUser(userName, password, UserType.CLIENT);
                if(userRepositoryService.add(client)){
                    System.out.println("Conta Criada com sucesso");
                    System.out.println("Nome do usuário - " + client.getUserName());
                    System.out.println();
                    ApplicationContext.setCurrentUser(client);
                    return;
                }
            }
            System.out.println("As senhas são diferentes");
        }

    }

    private String getUserNameFromUser(Scanner sc){
        boolean nameAlreadyInUse;
        String userName;
        do{
            System.out.println("Nome do usuário:");
            userName = sc.nextLine();
            nameAlreadyInUse = UserService.getAllUserNames().contains(userName);
            if(nameAlreadyInUse) {
                System.out.println("Nome de usuário em uso, por favor, escolha outro.");
            }
        }while(nameAlreadyInUse);

        return userName;
    }

}
