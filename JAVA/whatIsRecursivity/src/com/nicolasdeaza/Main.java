package com.nicolasdeaza;

public class Main {

    /**
     * Descripción: Función que contiene la fórmula del factorial para recursividad
     *
     * @param n Indica el número desde el cual inicia el factorial
     * @return Retorna el resultado de la fórmula del factorial del número indicado
     * */

    public static int factorial(int n) {

        System.out.println("Entra a la funcion factorial, n vale: " + n);

        if (n>1){
            System.out.println("La funcion se llamara asi misma otra vez");  //Ingresa capa por capa hasta que el parmetro de factorial en main (5) deje de ser mayor que 1
            return n * factorial(n-1);          //Matematicamente el factorial de cualquier numero n sera igual a """"factorial(n) = (n)*factorial(n-1)""""
        }
        else {
            System.out.println("n = 1, termina la recursividad!"); //Cuando n toma el valor de 1, la funcion me retorna 1 y asi como fui entrando capa por capa por capa, Ahora me regreso capa por capa por capa:
            return 1;                                              //Habiendo retornado 1. En la anterior era n=2, n*1=2 y se regresa con un valor de 2 a la capa anterior que era 3, n*3 = 2*3 = (6) y
        }                                                          //se reguresa a la capa anterior que era 3, (6)*3 = 18 y se regresa a la capa anterior que era 4... hasta llegar de nuevo a donde empece que era 5.
    }                                                              //Al final el resultado que regresa factorial es el resultado que se esta imprimiendo luego de entrar una y otra vez; y se regresa varias veces,
                                                                   //el resultado es: 120
    public static void main(String[] args) {
        System.out.println("Recursividad!");

        int result = factorial(5);
        System.out.println("El resultado es: " + result);

        Math

    }
}
