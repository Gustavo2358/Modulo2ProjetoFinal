package CarRental.view;

import CarRental.service.RentCarService;

import java.util.Scanner;

public class RentCarPage {


    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("### Alugar veículo ###");
        System.out.println("Digite a placa do veículo escolhido:");
        String plate = sc.nextLine();
        RentCarService rentCarService = new RentCarService();
        rentCarService.rentCar(plate);
    }

}
