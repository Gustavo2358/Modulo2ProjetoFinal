package CarRental.view;

import CarRental.domain.Agency;
import CarRental.domain.Client;

import java.util.Scanner;

public class EntryPage {

    public static void execute(Agency agency) {
        System.out.println("########## BEM-VINDO A LoCar ##########");
        System.out.println("1 - Login");
        System.out.println("2 - Criar conta");
        System.out.println("3 - Cadastrar Veiculo");
        switch (getEntryPageOption(1,3)){
            case 1:
                LogInPage.login(agency);
                break;
            case 2:
                Client client = CreateClientPage.execute(agency);
                if(agency.addUsers(client)){
                    System.out.println("Conta Criada com sucesso");
                    agency.setCurrentUser(client);
                }
                break;
            case 3:
                CreateCar CreateCar = new CreateCar();
                CreateCar.execute();
                break;
        }

    }

    public static int getEntryPageOption(int minRange, int maxRange) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while(true) {
            try {
                option = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Apenas valores numérico");
            }
            if(option >= minRange && option <= maxRange){
                return option;
            }else{
                System.out.println("Opção inválida");
            }
        }
    }
}
