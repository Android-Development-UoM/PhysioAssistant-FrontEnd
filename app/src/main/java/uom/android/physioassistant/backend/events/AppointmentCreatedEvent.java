package uom.android.physioassistant.backend.events;

import uom.android.physioassistant.models.appointment.Appointment;

public class AppointmentCreatedEvent {

    private Appointment appointment;

    public AppointmentCreatedEvent(Appointment appointment){
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }
}
