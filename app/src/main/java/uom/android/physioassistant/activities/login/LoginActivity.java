package uom.android.physioassistant.activities.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.admin.AdminActivity;
import uom.android.physioassistant.backend.api.AuthenticationApi;
import uom.android.physioassistant.backend.requests.LoginRequest;
import uom.android.physioassistant.backend.responses.LoginResponse;
import uom.android.physioassistant.backend.retrofit.RetrofitService;

public class LoginActivity extends AppCompatActivity {
    EditText usernameInput;
    EditText passwordInput;
    TextView errorMsg;
    RetrofitService retrofitService;
    AuthenticationApi authenticationApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.usernameInput = findViewById(R.id.username_input);
        this.passwordInput = findViewById(R.id.password_input);
        this.errorMsg = findViewById(R.id.error_msg);

        this.retrofitService = new RetrofitService();
        this.authenticationApi = retrofitService.getRetrofit().create(AuthenticationApi.class);
    }

    public void handleLogin(View view) {
        String username = String.valueOf(usernameInput.getText());
        String password = String.valueOf(passwordInput.getText());
        Log.i("Login", "Username: " + username + " Password: " + password);

        LoginRequest loginRequest = new LoginRequest(username, password);

        // Attempt to login to the api
        this.authenticationApi.login(loginRequest)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Log.i("Login", "Api call done.");

                        LoginResponse loginResponse = response.body();

                        // Check if login is successful
                        if (response.isSuccessful()) {
                            Log.i("Login", "Login Successful");

                            // Check what is the user role and open corresponding activity
                            String role = loginResponse.getUserRole();

                            Intent next_activity = new Intent(LoginActivity.this, AdminActivity.class);
                            startActivity(next_activity);
                        }
                        else {
                            errorMsg.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.w("Login Error", "Api call failed");
                        Log.e("Error", t.getMessage());
                    }
                });

    }
}