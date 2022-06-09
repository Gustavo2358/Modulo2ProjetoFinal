package CarRental.factory;

import CarRental.domain.Car;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarFactory {

    private CarFactory(){

    }

    public static Car createCar(String marca, String modelo, String placa, BigDecimal valorDiaBigDecimal){
        return new Car(marca,modelo,placa,valorDiaBigDecimal);


    }

}
