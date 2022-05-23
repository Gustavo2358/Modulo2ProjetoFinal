package CarRental.view;

import CarRental.domain.Agency;
import CarRental.domain.User;

import java.util.Scanner;

public class LogInPage {

    public static void login(Agency agency){
        Scanner sc = new Scanner(System.in);
        System.out.println("### FAZER LOGIN ###");
        String userName = getUserName(sc, agency);
        if(userName.equals("")){
            return;
        }
        boolean isPasswordValid = getPassword(sc, agency, userName);
        if (isPasswordValid){
            for(User user : agency.getUsers()) {
                if(user.getUserName().equals(userName))
                agency.setCurrentUser(user);
            }
        }
    }

    private static String getUserName(Scanner sc, Agency agency){
        boolean nameFound;
        String userName;
        System.out.println("Nome do usuário:");
        userName = sc.nextLine();
        nameFound = agency.getUserNames().contains(userName);
        if(nameFound == false) {
            System.out.println("Nome de usuário não encontrado.");
            return  "";
        }
        return userName;
    }

    private static boolean getPassword(Scanner sc, Agency agency, String userName) {
        String passWord;
        boolean ok;
        do{
            System.out.println("Digite a senha ou digite sair para voltar ao menu principal:");
            passWord = sc.nextLine();
            if(passWord.equals("sair")){
                return false;
            }
            ok = agency.checkPassword(userName,passWord);
            if(ok == false){
                System.out.println("senha incorreta");
            }
        }while (ok == false);
        return true;
    }
}
