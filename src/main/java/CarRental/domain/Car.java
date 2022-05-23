package CarRental.domain;

import java.util.ArrayList;

public class Car {
    private ArrayList<Car> carros;
    private String modelo;
    private String placa;
    private double valorDia;

    public Car(String modelo, String placa, double valorDia) {
        this.modelo = modelo;
        this.placa = placa;
        this.valorDia = valorDia;
        this.carros = new ArrayList<>();
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValorDia() {
        return valorDia;
    }

    public void setValorDia(double valorDia) {
        if (valorDia > 5000){
        valorDia = 5000;
        }
        else{
            this.valorDia = valorDia;
        }
    }

    public void cadastrarCarro (String modelo, String placa, double valorDia, ArrayList carros){

    carros.add(carros);


    }

}
