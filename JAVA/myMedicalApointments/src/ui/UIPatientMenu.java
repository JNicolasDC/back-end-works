package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome: " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while (response !=0);
    }

    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println("::Book an appointment");
            System.out.println(":: Select date: ");
            //Numeración de la lista de fechas
            //Índice de la fecha que seleccionada
            //Estructura de datos:
            //Lista de Doctores [Doctors] : -Doctor 1 / -Doctor n (cada uno con su array de citas disponibles)
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0; //Variable que captura los datos del índice de la lista de los Doctores, que pueda perdurar y su Scope sea mucho mas alto que el de la lista de doctores y la lista de fechas, por el echo de tener fors anidados

            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments //AvailableAppointment = Clase estática anidada accedida a partir del nombre de la clase Doctor
                = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointmentArrayList(); //En vez de new accederemos con doctorsAvailableAppointments

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;//Desplego aqui la variable K, por que es aqui donde voy a estar imprimiendo la lista de fechas de todos los doctores
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());  //Nuestro gateDate(); ya esta optimizado para devolvernos una fecha de tipo String en lugar de una de tipo Date
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i)); //En este capturaremos por un lado el indice de la fecha y por el otro lado el objeto Doctor de la fecha seleccionada
                    doctors.put(Integer.valueOf(k), doctorAppointments);

                    //Si finalmente ya logramos mostrar la lista de fechas disponibles, esperariamos que una vez terminados los for anidados el usuario seleccionase una respuesta
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            //Con esto al obtener la fecha seleccionada ya podriamos saber de inmediato que doctor mostrar,
            //A que doctor pertenece esa fecha que el detectó
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");

            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) { //.entrySet permite recorrer una estructura de árbol map
               indexDate = doc.getKey(); //Obtengo el Key
               doctorSelected = doc.getValue(); //Obtengo el Value
            }

            System.out.println(doctorSelected.getName() +
                    ". Date: " + doctorSelected.getAvailableAppointmentArrayList().get(indexDate).getDate() +
                    ". Time: " +
                    doctorSelected.getAvailableAppointmentArrayList().get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());

            if(response == 1){
                UIMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointmentArrayList().get(indexDate).getDate(),
                        doctorSelected.getAvailableAppointmentArrayList().get(indexDate).getTime());

                showPatientMenu();
            }

        } while (response != 0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println("::My Appointments");
            if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0){
                System.out.println("Don´t have appointments");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i+1;
                System.out.println(j + ". " +
                        "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        " Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\n Doctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName()
                        );
            }
            System.out.println("0. Return");
        } while (response != 0);

    }

}
