package uom.android.physioassistant.backend.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import uom.android.physioassistant.models.users.patient.Patient;

public interface PatientApi {

    @GET("/api/patients")
    Call<List<Patient>> getPatients();

    @GET("/api/patients/id/{id}")
    Call<Patient> getPatientById(@Path("id") String id);

    @GET("/api/patients/username/{username}")
    Call<Patient> getPatientByUsername(@Path("username") String username);

}
