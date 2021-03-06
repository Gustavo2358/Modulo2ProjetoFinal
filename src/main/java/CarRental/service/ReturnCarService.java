package CarRental.service;

import CarRental.ApplicationContext;
import CarRental.domain.Car;
import CarRental.domain.Client;
import CarRental.view.PaymentPage;

public class ReturnCarService {

    public void returnCar(String plate){

        Client currentClient = (Client) ApplicationContext.getCurrentUser();
        for (Car car : currentClient.getRentedCars()) {
            if (car.getLicensePlate().equals(plate)){
                PaymentPage paymentPage = new PaymentPage();
                paymentPage.execute(car, currentClient);
                car.setCurrentClient(new Client("Disponível"));
                currentClient.getRentedCars().remove(car);
                System.out.println(car);
                System.out.println("Devolução realizada com sucesso");
                System.out.println();
                return;
            }
        }
        System.out.println("Placa não encontrada nos carros atualmente associados a esse cliente.");
        System.out.println();
    }
}
