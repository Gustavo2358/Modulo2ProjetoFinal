package CarRental.service;

import CarRental.ApplicationContext;
import CarRental.domain.Car;
import CarRental.domain.Client;
import CarRental.repositories.CarRepository;


public class RentCarService {

    public void rentCar(String plate) {

        for (Car car : CarRepository.getCars()) {
            if (car.getLicensePlate().equals(plate)) {
                if(!car.getCurrentClientName().equals("Disponível")){
                    System.out.println("Veículo indisponível no momento");
                    return;
                }
                Client currentClient = (Client) ApplicationContext.getCurrentUser();
                car.setCurrentClient(currentClient);
                currentClient.getRentedCars().add(car);
                System.out.println(car);
                System.out.println("Locação realizada com sucesso");
                System.out.println();
                return;
            }
        }
        System.out.println("Placa não encontrada");
        System.out.println();
    }

}