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
        System.out.println("########## Veiculo cadastrado com sucesso ##########");
        System.out.printf("Veiculo %s %n placa %s %n cadastrado com o valor de diária de R$%.2f %n", modelo,placa,valorDia);
        return new Car(modelo,placa,valorDia);


    }

}
