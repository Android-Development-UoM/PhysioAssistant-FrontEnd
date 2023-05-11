package uom.android.physioassistant.activities.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
    Button loginBtn;
    Spinner selectUserType;
    RetrofitService retrofitService;
    AuthenticationApi authenticationApi;
    String selectedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponents();

        this.retrofitService = new RetrofitService();
        this.authenticationApi = retrofitService.getRetrofit().create(AuthenticationApi.class);

        configureSpinner();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleLogin(view);
            }
        });
    }

    public void initComponents() {
        this.usernameInput = findViewById(R.id.username_input);
        this.passwordInput = findViewById(R.id.password_input);
        this.errorMsg = findViewById(R.id.error_msg);
        this.loginBtn = findViewById(R.id.login_btn);
    }

    public void configureSpinner() {
        this.selectUserType = (Spinner) findViewById(R.id.select_user_spinner);

        // Set on selected listener
        this.selectUserType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = selectUserType.getSelectedItem().toString();

                if(!selectedItem.equalsIgnoreCase("--Επιλέξτε τύπο Χρήστη--"))
                    selectedUser = selectedItem;
                else
                    selectedUser = null;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void handleLogin(View view) {
        String username = String.valueOf(usernameInput.getText());
        String password = String.valueOf(passwordInput.getText());
        Log.i("Login", "Username: " + username + " Password: " + password);

        String[] userTypes = getResources().getStringArray(R.array.user_types);
        String adminType = userTypes[1];
        String doctorType = userTypes[2];
        String patientType = userTypes[3];

        // Make sure the user provided a user type
        if (this.selectedUser == null)
            showErrorMessage("Παρακαλώ επιλέξτε τύπο χρήστη.");

        else {
            if (credentialsProvided(username, password)){
                LoginRequest loginRequest = new LoginRequest(username, password);

                if (this.selectedUser.equalsIgnoreCase(adminType)) {
                    // Attempt to login to the api
                    this.authenticationApi.login(loginRequest)
                            .enqueue(new Callback<LoginResponse>() {
                                @Override
                                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                                    Log.i("Login", "Api call done.");

                                    LoginResponse loginResponse = response.body();

                                    System.out.println(loginResponse);
                                    // Check if login is successful
                                    if (response.isSuccessful()) {
                                        Log.i("Login", "Login Successful");
                                        handleSuccessfulApiResponse(AdminActivity.class);
                                    }
                                    else {
                                        Log.i("Login", "Login Failed");
                                        showErrorMessage("Λάθος username και/ή password.");
                                    }
                                }

                                @Override
                                public void onFailure(Call<LoginResponse> call, Throwable t) {
                                    Log.w("Login Error", "Api call failed");
                                    Log.e("Error", t.getMessage());
                                }
                            });
                }
                else if (this.selectedUser.equalsIgnoreCase(patientType)) {
                    //
                }
            }
            else {
                showErrorMessage("Παρακαλώ εισάγετε Username και Password.");
            }
        }

    }

    private void handleSuccessfulApiResponse(Class<? extends AppCompatActivity> activityClass) {
        Intent next_activity = new Intent(LoginActivity.this, activityClass);
        startActivity(next_activity);
    }

    private boolean credentialsProvided(String givenUsername, String givenPass) {
        return !TextUtils.isEmpty(givenUsername) && !TextUtils.isEmpty(givenPass);
    }

    private void showErrorMessage(String message) {
        errorMsg.setText(message);
        errorMsg.setVisibility(View.VISIBLE);
    }
}