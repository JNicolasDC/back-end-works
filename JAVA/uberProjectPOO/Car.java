package com.nicolasdeaza;

public class Car {
    int id;
    String license;
    Account driver;
    private Integer passsegenger;

    public Car (String license, Account driver){
        this.license = license;
        this.driver = driver;
    }

    void printDataCar(){
        if(passsegenger != null){
            System.out.println("License: " + license + ", Driver: " + driver.name + ", Passengers: " + passsegenger);
        }
    }

    public Integer getPassenger(){
        return passsegenger;
    }

    public void setPassenger(Integer passenger){
        if(passenger == 4) {
            this.passsegenger = passenger;
        }else{
            System.out.println("Necesitas asignar 4 pasajeros");
        }
    }
}
