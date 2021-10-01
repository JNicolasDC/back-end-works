package com.nicolasdeaza;

public class Main {

    public static void main(String[] args) {

        UberX uberX1 = new UberX("AAA111", new Account("Andres Herrera", "AND123"), "Chevrolet", "Sonic");
        uberX1.setPassenger(4);
        //System.out.println("Car License: " + car1.license);
        uberX1.printDataCar();

        /*Car car2 = new Car("BBB222", new Account("Andrea Herrera", "AND456"));
        car2.passsegenger = 3;
        //System.out.println("Car License: " + car2.license);
        car2.printDataCar();

        User user1 = new User("Juanito Alimaña", "C.C: 1010101010");
        user1.printDataUser();*/

    }
}
