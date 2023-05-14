package uom.android.physioassistant.backend.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import uom.android.physioassistant.models.Doctor;

public interface DoctorApi {
    @POST("api/doctors/create")
    Call<Doctor> createDoctor(@Body Doctor doctor);
}
