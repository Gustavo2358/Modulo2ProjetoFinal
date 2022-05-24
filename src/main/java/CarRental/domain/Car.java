package CarRental.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private String licensePlate;
    //TODO trocar double para BigDecimal
    private double valuePerDay;

    public Car(String brand, String model, String licensePlate, double valuePerDay) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.valuePerDay = valuePerDay;
    }


    //TODO setar essa limitação também no construtor
    public void setValuePerDay(double valuePerDay) {
        if (valuePerDay > 5000){
        this.valuePerDay = 5000;
        }
        else{
            this.valuePerDay = valuePerDay;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(licensePlate, car.licensePlate);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", valuePerDay=" + valuePerDay +
                '}';
    }
}
