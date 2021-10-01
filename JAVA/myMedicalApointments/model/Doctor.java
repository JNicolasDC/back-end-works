package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{

    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointmentArrayList = new ArrayList<>();

    public Doctor(String name, String email){
        super(name, email);
    }


    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    public void addAvailableAppointment(String date, String time) throws ParseException {
        availableAppointmentArrayList.add(new Doctor.AvailableAppointment(date, time));
    }
    public ArrayList<AvailableAppointment> getAvailableAppointmentArrayList(){
        return availableAppointmentArrayList;
    }


    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: " + speciality + "\nAviable " + availableAppointmentArrayList.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital: Cruz Roja");
        System.out.println("Departamento: Cancerologia");
    }

    public static class AvailableAppointment{
        private int id_availableAppointment;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //formato que nosotros mismos asignaremos dd-MM-yy, como decidamos estandarizarlo en nuestro programa

        public AvailableAppointment(String date, String time) throws ParseException {
            try {
                this.date = format.parse(date);
            } catch (ParseException e){
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId_availableAppointment() {
            return id_availableAppointment;
        }

        public void setId_availableAppointment(int id_availableAppointment) {
            this.id_availableAppointment = id_availableAppointment;
        }

        public Date getDate() {
            return date;
        } //Bandera que nos indica que devuelve un objeto de tipo Date

        public String gatDate(){ //Sobrecargar el método gatDate
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointments \nDate: " +date+ "\nTime: " +time;
        }
    }


}
