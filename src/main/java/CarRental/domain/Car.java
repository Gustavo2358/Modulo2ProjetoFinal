package CarRental.domain;

import java.util.ArrayList;

public class Car {
    private String model;
    private String licensePlate;
    private double valuePerDay;

    public Car(String model, String licensePlate, double valuePerDay) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.valuePerDay = valuePerDay;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;

    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getValuePerDay() {
        return valuePerDay;
    }

    public void setValuePerDay(double valuePerDay) {
        if (valuePerDay > 5000){
        valuePerDay = 5000;
        }
        else{
            this.valuePerDay = valuePerDay;
        }
    }

}
