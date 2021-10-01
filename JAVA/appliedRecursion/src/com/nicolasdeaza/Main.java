package com.nicolasdeaza;

import java.util.Scanner;

public class Main {

    public static char[] indexColumns = new char[27];

    public static void recursiveFunction(int consult) {

        int consult2 = consult;
        int consult3;
        int consult4;

        if (consult <= 26) {
            System.out.println(indexColumns[consult]);
        } else if (consult<53 && consult>26) {
            consult = 1;
            consult3 = consult2 - 26;
            System.out.println(indexColumns[consult] + (" ") + indexColumns[consult3]);
        }
        //return consult;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char x;
        int i=1, consult;

        for (x = 'A'; x <= 'Z'; x++) {
            indexColumns[i]=x;
            i++;
        }

        System.out.println("Ingresa el numero de columna que deseas consultar: ");
        consult = sc.nextInt();
        recursiveFunction(consult);






        /*Scanner sc = new Scanner(System.in);
        char[] indexColumns = new char[27];
        char x;
        int i=1, consult;

        for (x = 'A'; x <= 'Z'; x++) {
            indexColumns[i]=x;
            i++;
        }

        System.out.println("Ingresa el numero de columna que deseas consultar: \n");
            consult = sc.nextInt();
            int consult2 = consult;

            if (consult<=26)
            {
                System.out.println(indexColumns[consult]);
            }
            else if (consult>26)
            {
                consult = 1;
                int consult3 = consult2-26;
                System.out.println(indexColumns[consult] + (" ") + indexColumns[consult3]);
            }*/

        }
    }