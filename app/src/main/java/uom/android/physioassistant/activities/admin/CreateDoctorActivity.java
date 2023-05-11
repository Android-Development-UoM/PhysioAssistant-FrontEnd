package uom.android.physioassistant.activities.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import uom.android.physioassistant.R;
import uom.android.physioassistant.models.Doctor;

public class CreateDoctorActivity extends AppCompatActivity {
    private EditText physioCenterNameInput;
    private EditText addressInput;
    private EditText afmInput;
    private Button cancelBtn;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the activity layout using the corresponding XML file
        setContentView(R.layout.activity_create_service);

        // Initialize the EditText and Button views
        this.physioCenterNameInput = findViewById(R.id.service_name_input);
        this.addressInput = findViewById(R.id.address_input);
        this.afmInput = findViewById(R.id.afm_input);
        this.cancelBtn = findViewById(R.id.cancel_btn);
        this.addBtn = findViewById(R.id.add_service_btn);
    }

    // This method is called when the user clicks on the cancel button
    public void cancelBtnClicked(View view) {
        finish();
    }

    // This method is called when the user clicks on the add button
    public void addBtnClicked(View view) {
        // Get the input text from the three EditText views
        String doctorName = String.valueOf(this.physioCenterNameInput.getText());
        String address = String.valueOf(this.addressInput.getText());
        String afm = String.valueOf(this.afmInput.getText());

        // Create the Doctor object to send to the backend
        Doctor new_doctor = new Doctor(doctorName, address, afm);

        // Log the input values to the console for debugging purposes
        Log.i("CreateServiceActivity", "Added Doctor: " + new_doctor);

        // Create the Toast object with a message and duration
        Toast.makeText(getApplicationContext(), "This is a Toast message!", Toast.LENGTH_SHORT).show();
    }
}