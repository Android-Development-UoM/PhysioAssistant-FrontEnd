package uom.android.physioassistant.activities.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.admin.AdminHomeActivity;

public class LoginActivity extends AppCompatActivity {
    EditText username_input;
    EditText password_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        this.username_input = findViewById(R.id.username_input);
        this.password_input = findViewById(R.id.password_input);


    }

    public void handleLogin(View view) {
        String username = String.valueOf(username_input.getText());
        String password = String.valueOf(password_input.getText());
        Log.i("Login", "Username: " + username + " Password: " + password);

        // TO DO: Call login endpoint
        String role = username;
        Intent next_activity;

        if (role.equalsIgnoreCase("admin")) {
            Log.i("Login", "Admin Login");
            next_activity = new Intent(this, AdminHomeActivity.class);
            startActivity(next_activity);
        }
        else if (role.equalsIgnoreCase("patient"))
            Log.i("Login", "Patient Login");
        else if (role.equalsIgnoreCase("doctor"))
                Log.i("Login", "Doctor Login");
    }
}