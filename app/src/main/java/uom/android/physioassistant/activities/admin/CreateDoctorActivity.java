package uom.android.physioassistant.activities.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import uom.android.physioassistant.R;
import uom.android.physioassistant.models.Doctor;

public class CreateDoctorActivity extends AppCompatActivity {
    private EditText physioCenterNameInput;
    private EditText addressInput;
    private EditText afmInput;
    private EditText passwordInput;
    private Button cancelBtn;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the activity layout using the corresponding XML file
        setContentView(R.layout.activity_create_doctor);

        // Initialize the EditText and Button views
        this.physioCenterNameInput = findViewById(R.id.service_name_input);
        this.addressInput = findViewById(R.id.address_input);
        this.afmInput = findViewById(R.id.afm_input);
        this.cancelBtn = findViewById(R.id.cancel_btn);
        this.addBtn = findViewById(R.id.add_service_btn);
        this.passwordInput = findViewById(R.id.doctor_pass_input);
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
        String password = String.valueOf(this.passwordInput.getText());

        // Create the Doctor object to send to the backend
        Doctor new_doctor = new Doctor(doctorName, address, afm, password);

        // Log the input values to the console for debugging purposes
        Log.i("CreateServiceActivity", "Added Doctor: " + new_doctor);


    }

    private void backupMethodToDelete() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Please provide User password");

        // Set up the input
        final EditText input = new EditText(this);
        // Set the input type (optional)
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Get the user input here
                String userInput = input.getText().toString();
                // Do something with the input
                // ...
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}