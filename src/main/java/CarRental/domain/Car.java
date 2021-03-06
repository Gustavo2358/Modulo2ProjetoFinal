package CarRental.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private String licensePlate;
    private BigDecimal valuePerDay;
    private Client currentClient;


    public Car(String brand, String model, String licensePlate, BigDecimal valuePerDay) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        if (valuePerDay.compareTo(BigDecimal.valueOf(5000)) >= 0){
            this.valuePerDay = BigDecimal.valueOf(5000);
        }
        else{
            this.valuePerDay = valuePerDay;
        }
        this.currentClient = new Client("Disponível");
    }

    public Car() {}

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getValuePerDay() {
        return valuePerDay;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Client getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
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
