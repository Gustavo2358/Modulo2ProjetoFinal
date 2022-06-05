package CarRental.view;

import CarRental.domain.Car;
import CarRental.domain.Client;
import CarRental.repositories.CarRepository;
import CarRental.repositories.UserRepository;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class TransactionPage {


    public static void rentCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("### Alugar veículo ###");
        System.out.println("Digite a placa do veículo escolhido:");
        String plate = sc.nextLine();
        for (Car car : CarRepository.getCars()) {
            if (car.getLicensePlate().equals(plate) && car.getCurrentClientName().equals("Disponível")){
                Client currentClient = (Client) UserRepository.getCurrentUser();
                car.setCurrentClient(currentClient);
                currentClient.rentCar(car);
                System.out.println("Locação realizada com sucesso");
                return;
            }
        }
        System.out.println("Não foi possível realizar a locação");
    }

    public static void returnCar() {
        int days = new Random().nextInt(9);
        days++;

        Scanner sc = new Scanner(System.in);
        System.out.println("### Devolver veículo ###");
        System.out.println("Digite a placa do veículo a ser devolvido:");
        String plate = sc.nextLine();
        for (Car car : CarRepository.getCars()) {
            if (car.getLicensePlate().equals(plate)){
                Client currentClient = (Client) UserRepository.getCurrentUser();
                car.setCurrentClient(null);
                currentClient.returnCar(car);
                System.out.println("Devolução realizada com sucesso");
                System.out.printf("Valor por dia R$%.2f%n", car.getValuePerDay());
                System.out.println("Quantidade de dias: " + days);
                System.out.printf("Valor a pagar: R$%.2f%n", car.getValuePerDay().multiply(BigDecimal.valueOf(days)));
                System.out.println(car);
                return;
            }
        }
        System.out.println("não foi possível realizar a devolução");
    }
}
