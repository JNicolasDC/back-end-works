package ui;

import model.Doctor;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<Doctor>();

    public static void showDoctorMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName());
            System.out.println("1. Add Available Appointment"); //Dara la posibilidad de definir las fechas en las que estará disponible para las citas
            System.out.println("2. My Scheduled Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAddAvailableAppointmentsMenu(); //Cuando el doctor defina una respuesta ya tenemos lista esta primera opción
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while (response != 0);
    }

    private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do{
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a Month");

            for (int i = 0; i <3 ; i++) {
                int j = i + 1; //Utilizo una variable auxiliar para no alterar el cilco del for
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4){
                //1, 2, 3
                int monthSelected = response; //La asigno en esta variable para que sea mas entendible para mi como programador
                System.out.println(monthSelected + " . " + UIMenu.MONTHS[monthSelected-1]); //-1 por que aquí las respuestas siempre van desde 1 hasta n y lo que queremos en este caso son los índices por eso usamos n-1

                System.out.println("Insert the day available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("You date is: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue;


                int responseTime = 0;
                String time = "";

                do {
                    System.out.println("Insert the time available for date: " + date + "[16:00]");
                    time = sc.nextLine();
                    System.out.println("You time is: " + time + "\n1. Correct \n2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());

                }while (responseTime == 2); //El único fragmento que nos va a mostrar si la respuesta es cambiar
                //No deberia mostrar todo desde el inicio por eso usamos do while en comparacion de continue
                //En el momento en el que se sale del ciclo y confirma el doctor que es correcto debemos crear o asignarle a nuestro doctor la cita o la fecha disponible:
                try {
                    UIMenu.doctorLogged.addAvailableAppointment(date, time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                checkDoctorAvailableAppointments(UIMenu.doctorLogged); //A la asignacion de fechas disponibles nada mas le paso el doctor loggeado

            }else if(response == 0){
                showDoctorMenu();
            }
        }while (response != 0);
    }


    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if (doctor.getAvailableAppointmentArrayList().size()>0
        && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
