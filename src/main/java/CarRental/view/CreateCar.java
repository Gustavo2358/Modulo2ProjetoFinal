package CarRental.view;

import CarRental.domain.Car;

import java.util.Scanner;

public class CreateCar {

    public static Scanner scanner = new Scanner(System.in);

    public static Car execute(){
        System.out.println("Cadastrando um carro ");
        System.out.println("Informe o modelo ");
        String modelo = scanner.next();

        System.out.println("Informe a placa do veículo ");
        String placa = scanner.next();
        System.out.println("Informe o valor do aluguel ao dia do veículo ");
        Double valorDia = scanner.nextDouble();
        return new Car(modelo,placa,valorDia);

    }

}
