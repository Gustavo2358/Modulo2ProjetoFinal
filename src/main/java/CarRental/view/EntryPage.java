package CarRental.view;

import CarRental.utils.Utils;

public class EntryPage {

    public void execute() {
        System.out.println("_########## BEM-VINDO A LoCar ##########_");
        System.out.println("1 - Login");
        System.out.println("2 - Criar conta");
        switch (Utils.getPageOption(1,2)){
            case 1:
                LogInPage logInPage = new LogInPage();
                logInPage.execute();
                break;
            case 2:
                CreateClientPage createClientPage = new CreateClientPage();
                createClientPage.execute();
                break;
        }

    }

}
