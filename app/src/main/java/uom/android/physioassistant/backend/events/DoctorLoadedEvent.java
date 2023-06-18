package uom.android.physioassistant.backend.events;

import uom.android.physioassistant.models.users.doctor.Doctor;

public class DoctorLoadedEvent {

    private Doctor doctor;

    public DoctorLoadedEvent(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
