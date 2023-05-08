package uom.android.physioassistant.activities.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import uom.android.physioassistant.R;

public class AdminActivity extends AppCompatActivity {
    private Button createCenterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        this.createCenterBtn = findViewById(R.id.create_center_btn);
    }

    public void createCenterBtnClicked(View view) {
        Log.i("Admin", "Create Physiotherapy Center button clicked");
        Intent nextActivity = new Intent(this, CreateServiceActivity.class);
        startActivity(nextActivity);
    }
}