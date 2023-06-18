package uom.android.physioassistant.backend.events;

import uom.android.physioassistant.models.users.patient.Patient;

public class PatientLoadedEvent {

    private Patient patient;

    public PatientLoadedEvent(Patient patient){
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }
}