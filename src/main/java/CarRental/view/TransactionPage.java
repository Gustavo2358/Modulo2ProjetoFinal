package CarRental.view;

import CarRental.ApplicationContext;
import CarRental.domain.Car;
import CarRental.domain.Client;
import CarRental.repositories.CarRepository;

import java.util.Scanner;

public class TransactionPage {


    public static void rentCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("### Alugar veículo ###");
        System.out.println("Digite a placa do veículo escolhido:");
        String plate = sc.nextLine();
        for (Car car : CarRepository.getCars()) {
            if (car.getLicensePlate().equals(plate) && car.getCurrentClientName().equals("Disponível")){
                Client currentClient = (Client) ApplicationContext.getCurrentUser();
                car.setCurrentClient(currentClient);
                currentClient.rentCar(car);
                System.out.println("Locação realizada com sucesso");
                return;
            }
        }
        System.out.println("Não foi possível realizar a locação");
    }

    //TODO é possível devolver o carro de outro cliente
    public static void returnCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("### Devolver veículo ###");
        System.out.println("Digite a placa do veículo a ser devolvido:");
        String plate = sc.nextLine();
        for (Car car : CarRepository.getCars()) {
            if (car.getLicensePlate().equals(plate)){
                Client currentClient = (Client) ApplicationContext.getCurrentUser();
                PaymentPage.execute(car, currentClient);
                car.setCurrentClient(null);
                currentClient.returnCar(car);
                System.out.println("Devolução realizada com sucesso");
                System.out.println(car);
                return;
            }
        }
        System.out.println("não foi possível realizar a devolução");
    }
}
