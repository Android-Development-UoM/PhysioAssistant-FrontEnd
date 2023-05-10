package uom.android.physioassistant.backend.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import uom.android.physioassistant.backend.requests.LoginRequest;
import uom.android.physioassistant.backend.responses.LoginResponse;
import uom.android.physioassistant.models.Admin;

public interface AuthenticationApi {
    @POST("/api/admin/login")
    Call<LoginResponse> login(@Body LoginRequest request);

}
