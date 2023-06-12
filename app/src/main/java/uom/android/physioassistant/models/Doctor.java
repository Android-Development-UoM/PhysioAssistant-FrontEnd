package uom.android.physioassistant.models;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import uom.android.physioassistant.ui.DropDownItem;
import uom.android.physioassistant.models.comparators.AppointmentAscendingComp;

public class Doctor extends User implements Serializable,DropDownItem {


    private String afm;
    private String name;
    private String address;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;


    public Doctor(String username, String password, String afm, String name, String address) {
        super(username, password);
        this.afm = afm;
        this.name = name;
        this.address = address;
    }

    public ArrayList<LocalTime> getTimeSlots(){
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);
        LocalTime currentTime = startTime;

        ArrayList<LocalTime> timeSlots = new ArrayList<>();

        while (currentTime.isBefore(endTime) || currentTime.equals(endTime)) {
            timeSlots.add(currentTime);
            currentTime = currentTime.plusMinutes(30);
        }

        return timeSlots;
    }
    public ArrayList<LocalTime> getAvailableTimeSlots(LocalDate date){
        LocalTime currentTime = LocalTime.now();

        ArrayList<LocalTime> availableTimeSlots = new ArrayList<>();
        availableTimeSlots.addAll(getTimeSlots());

        for(Appointment appointment:getCurrentAppointments()){
            if(appointment.getLocalDate().equals(date)){
                for(LocalTime timeSlot:getTimeSlots()){
                    if(timeSlot.equals(appointment.getLocalTime())){
                        availableTimeSlots.remove(timeSlot);
                    }
                }
            }
        }

        Iterator<LocalTime> iterator = availableTimeSlots.iterator();
        while (iterator.hasNext()) {
            LocalTime timeSlot = iterator.next();
            if (timeSlot.isBefore(currentTime) && date.equals(LocalDate.now())) {
                iterator.remove();
            }
        }

        return availableTimeSlots;
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

    public ArrayList<Appointment> getAppointmentsByDate(LocalDate date){
        ArrayList<Appointment> appointmentsByDate = new ArrayList<>();
        for(Appointment appointment:appointments){
            if(appointment.getLocalDate().equals(date)){
                appointmentsByDate.add(appointment);
            }
        }
        Collections.sort(appointmentsByDate,new AppointmentAscendingComp());
        return appointmentsByDate;
    }
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
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

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    @Override
    public String getText() {
        return this.name;
    }
}
