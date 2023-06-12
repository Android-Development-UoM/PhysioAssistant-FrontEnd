package uom.android.physioassistant.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.jakewharton.threetenabp.AndroidThreeTen;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.doctor.DoctorActivity;
import uom.android.physioassistant.activities.login.LoginActivity;
import uom.android.physioassistant.activities.patient.PatientActivity;
import uom.android.physioassistant.backend.datamanager.DataManager;
import uom.android.physioassistant.backend.events.DoctorsLoadedEvent;
import uom.android.physioassistant.backend.events.PhysioActionsLoadedEvent;
import uom.android.physioassistant.models.Doctor;
import uom.android.physioassistant.models.Patient;
import uom.android.physioassistant.models.PhysioAction;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIMEOUT = 1000;
    private boolean isPhysioActionsLoaded,isDoctorsLoaded;
    private ArrayList<PhysioAction> physioActions;
    private ArrayList<Doctor> doctors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.hideHeaderBar();
        setContentView(R.layout.activity_splash);

        AndroidThreeTen.init(this);
        EventBus.builder().installDefaultEventBus();

        loadData();

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPhysioActionsLoaded(PhysioActionsLoadedEvent event){
        physioActions = (ArrayList<PhysioAction>) event.getPhysioActions();
        isPhysioActionsLoaded = true;
        checkIfAllDataLoaded();
        System.out.println("Splash "+physioActions);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDoctorsLoaded(DoctorsLoadedEvent event){
        doctors = (ArrayList<Doctor>) event.getDoctors();
        isDoctorsLoaded = true;
        System.out.println("Splash "+doctors);
        checkIfAllDataLoaded();
    }

    public void loadData(){
        DataManager dataManager = new DataManager();
        dataManager.loadPhysioActions();
        dataManager.loadDoctors();
    }

    private void hideHeaderBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private void checkIfAllDataLoaded() {
        if (isPhysioActionsLoaded  && isDoctorsLoaded) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    initActivity();
                }
            }, SPLASH_TIMEOUT);
        }
    }

    private void initActivity() {
        Intent intent = new Intent(SplashActivity.this, DoctorActivity.class);
        intent.putExtra("physio_actions",physioActions);
        intent.putExtra("doctors",doctors);
        startActivity(intent);
        finish();
    }
}