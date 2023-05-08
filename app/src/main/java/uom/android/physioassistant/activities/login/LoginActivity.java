package uom.android.physioassistant.activities.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.admin.AdminActivity;
import uom.android.physioassistant.activities.doctor.DoctorActivity;
import uom.android.physioassistant.activities.patient.PatientActivity;

public class LoginActivity extends AppCompatActivity {
    EditText usernameInput;
    EditText passwordInput;
    TextView errorMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.usernameInput = findViewById(R.id.username_input);
        this.passwordInput = findViewById(R.id.password_input);
        this.errorMsg = findViewById(R.id.error_msg);
    }

    public void handleLogin(View view) {
        String username = String.valueOf(usernameInput.getText());
        String password = String.valueOf(passwordInput.getText());
        Log.i("Login", "Username: " + username + " Password: " + password);

        // TO DO: Call login endpoint
        String role = username;
        Intent next_activity;

        if (role.equalsIgnoreCase("admin")) {
            Log.i("Login", "Admin Login");
            next_activity = new Intent(this, AdminActivity.class);
            startActivity(next_activity);
        }
        else if (role.equalsIgnoreCase("patient")) {
            next_activity = new Intent(this, PatientActivity.class);
            startActivity(next_activity);
            Log.i("Login", "Patient Login");
        }
        else if (role.equalsIgnoreCase("doctor")) {
            Log.i("Login", "Doctor Login");
            next_activity = new Intent(this, DoctorActivity.class);
            startActivity(next_activity);
        }
        else {
            Log.w("Login", "Invalid Credentials");
            this.errorMsg.setVisibility(View.VISIBLE);
        }

    }
}