package CarRental.view;

import CarRental.service.ReturnCarService;

import java.util.Scanner;

public class ReturnCarPage {
    public static void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("### Devolver veículo ###");
        System.out.println("Digite a placa do veículo a ser devolvido:");
        String plate = sc.nextLine();
        ReturnCarService returnCarService = new ReturnCarService();
        returnCarService.returnCar(plate);
    }
}
