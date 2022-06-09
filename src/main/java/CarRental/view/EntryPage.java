package CarRental.view;

import CarRental.utils.Utils;

public class EntryPage {

    public static void execute() {
        System.out.println("_########## BEM-VINDO A LoCar ##########_");
        System.out.println("1 - Login");
        System.out.println("2 - Criar conta");
        switch (Utils.getPageOption(1,2)){
            case 1:
                LogInPage.execute();
                break;
            case 2:
                CreateClientPage.execute();
                break;
        }

    }

}
