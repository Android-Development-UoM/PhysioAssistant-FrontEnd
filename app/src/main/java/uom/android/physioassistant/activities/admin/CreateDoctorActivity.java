package uom.android.physioassistant.activities.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uom.android.physioassistant.R;
import uom.android.physioassistant.backend.api.DoctorApi;
import uom.android.physioassistant.backend.retrofit.RetrofitService;
import uom.android.physioassistant.models.Doctor;

public class CreateDoctorActivity extends AppCompatActivity {
    private EditText physioCenterNameInput;
    private EditText addressInput;
    private EditText nameInput;
    private EditText afmInput;
    private EditText passwordInput;
    private TextView errorMsg;
    private RetrofitService retrofitService;
    private DoctorApi doctorApi;
    private Button cancelBtn;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the activity layout using the corresponding XML file
        setContentView(R.layout.activity_create_doctor);

        // Initialize the EditText and Button views
        this.physioCenterNameInput = findViewById(R.id.doctor_name_input);
        this.addressInput = findViewById(R.id.address_input);
        this.afmInput = findViewById(R.id.afm_input);
        this.cancelBtn = findViewById(R.id.cancel_btn);
        this.addBtn = findViewById(R.id.add_service_btn);
        this.passwordInput = findViewById(R.id.doctor_pass_input);
        this.errorMsg = findViewById(R.id.create_doctor_error_msg);

        this.retrofitService = new RetrofitService();
        this.doctorApi = retrofitService.getRetrofit().create(DoctorApi.class);
    }

    // This method is called when the user clicks on the cancel button
    public void cancelBtnClicked(View view) {
        finish();
    }

    // This method is called when the user clicks on the add button
    public void addBtnClicked(View view) {
        Log.i("CreateServiceActivity", "Attempting to add new doctor ");

        // Get the input text from the three EditText views
        String doctorName = String.valueOf(this.physioCenterNameInput.getText());
        String address = String.valueOf(this.addressInput.getText());
        String afm = String.valueOf(this.afmInput.getText());
        String password = String.valueOf(this.passwordInput.getText());

        // Create the Doctor object to send to the backend
        Doctor new_doctor = new Doctor(doctorName, address, afm, password);

        if (detailsAreProvided(doctorName, address, afm, password)) {
            callTheApiToAddDoctor(new_doctor);
            Log.i("CreateServiceActivity", "Added Doctor: " + new_doctor);
        }
        else {
            showErrorMessage("Ελλειπή Στοιχεία Γιατρού");
        }

    }

    private void callTheApiToAddDoctor(Doctor doctor) {
        this.doctorApi.createDoctor(doctor)
                .enqueue(new Callback<Doctor>() {
                    @Override
                    public void onResponse(Call<Doctor> call, Response<Doctor> response) {
                        Doctor addedDoctor = response.body();

                        if (response.isSuccessful()) {
                            Log.i("Create Doctor", "Doctor added");

                            Toast.makeText(getApplicationContext(), "Doctor added!", Toast.LENGTH_LONG)
                                    .show();
                        }
                        else if (response.code() == 406 ){
                            showErrorMessage("Το Φυσικοθεραπευτήριο με ΑΦΜ: " + doctor.getAfm() + " υπάρχει ήδη.");
                        }
                        else {
                            showErrorMessage("Το Φυσικοθεραπευτήριο δεν αποθηκεύτηκε.");
                        }
                    }

                    @Override
                    public void onFailure(Call<Doctor> call, Throwable t) {
                        // Do nothing
                    }
                });
    }

    private void showErrorMessage(String message) {
        errorMsg.setText(message);
        errorMsg.setVisibility(View.VISIBLE);
        errorMsg.postDelayed(() -> errorMsg.setVisibility(View.INVISIBLE), 3000); // 3 seconds delay
    }

    private boolean detailsAreProvided(String name, String address, String afm, String password) {
        return !TextUtils.isEmpty(name) &&
                !TextUtils.isEmpty(address) &&
                !TextUtils.isEmpty(afm) &&
                !TextUtils.isEmpty(password);
    }
}