package CarRental.view;

import CarRental.domain.Car;
import CarRental.factory.CarFactory;
import CarRental.repositories.CarRepository;
import CarRental.service.RepositoryService;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateCarPage {

    private CarRepository carRepository = CarRepository.getInstance();
    private RepositoryService<Car> carRepositoryService = new RepositoryService<>();


    public CreateCarPage(){
        carRepositoryService.setRepository(carRepository);
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastrando um carro ");
        System.out.println("Informe a marca ");
        String marca = scanner.nextLine();
        System.out.println("Informe o modelo ");
        String modelo = scanner.nextLine();

        //TODO validar se a placa já existe no repositório (usar modelo do Client que verifica se o userName já existe)
        System.out.println("Informe a placa do veículo ");
        String placa = scanner.nextLine();
        System.out.println("Informe o valor do aluguel ao dia do veículo ");
        double valorDia = 0.0;
        do {
            try {
                valorDia = Double.parseDouble(scanner.nextLine().replace(",","."));

            } catch (NumberFormatException e) {
                System.out.println("Digite um valor real válido");
            }
            if(valorDia <= 0.0)
                System.out.println("Digite um valor maior que zero");
        }while(valorDia <= 0.0);
        System.out.println("########## Veiculo cadastrado com sucesso ##########");
        BigDecimal valorDiaBigDecimal = BigDecimal.valueOf(valorDia);
        System.out.printf("Veiculo %s %n placa %s %n cadastrado com o valor de diária de R$%.2f %n", modelo,placa,valorDia);
        carRepositoryService.add(CarFactory.createCar(marca,modelo,placa,valorDiaBigDecimal));


    }

}
