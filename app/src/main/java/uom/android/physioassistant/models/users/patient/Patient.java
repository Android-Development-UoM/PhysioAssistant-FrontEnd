package uom.android.physioassistant.models.users.patient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import uom.android.physioassistant.models.appointment.Appointment;
import uom.android.physioassistant.models.appointment.AppointmentStatus;
import uom.android.physioassistant.models.appointment.comparators.AppointmentAscendingComp;
import uom.android.physioassistant.models.appointment.comparators.AppointmentDescendingComp;
import uom.android.physioassistant.models.users.User;
import uom.android.physioassistant.models.users.doctor.Doctor;
import uom.android.physioassistant.ui.dropdown.DropDownItem;

public class Patient extends User implements Serializable, DropDownItem {

    private String amka;
    private String name;
    private String address;
    private ArrayList<Doctor> doctors;

    private ArrayList<Appointment> appointments;

    public Patient(String username, String password, String amka, String name, String address) {
        super(username, password);
        this.amka = amka;
        this.name = name;
        this.address = address;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public ArrayList<Appointment> getCurrentAppointments(){

        ArrayList<Appointment> currentAppointments = new ArrayList<>();
        for(Appointment appointment:appointments){
            if(appointment.getStatus().equals(AppointmentStatus.ACCEPTED) || appointment.getStatus().equals(AppointmentStatus.PENDING)){
                currentAppointments.add(appointment);
            }
        }
        Collections.sort(currentAppointments,new AppointmentAscendingComp());
        return currentAppointments;
    }

    public ArrayList<Appointment> getHistoryAppointments(){
        ArrayList<Appointment> historyAppointments = new ArrayList<>();
        historyAppointments.addAll(appointments);
        historyAppointments.removeAll(getCurrentAppointments());
        Collections.sort(historyAppointments,new AppointmentDescendingComp());
        return historyAppointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }


    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "amka='" + amka + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", doctors=" + doctors +
                ", appointments=" + appointments +
                '}';
    }

    @Override
    public String getText() {
        return this.name;
    }
}
