package uom.android.physioassistant.activities.doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.jakewharton.threetenabp.AndroidThreeTen;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.FragmentNavigation;
import uom.android.physioassistant.activities.OnBackPressedListener;
import uom.android.physioassistant.backend.datamanager.DataManager;
import uom.android.physioassistant.backend.events.AppointmentsLoadedEvent;
import uom.android.physioassistant.backend.events.DoctorLoadedEvent;
import uom.android.physioassistant.backend.events.PatientsLoadedEvent;
import uom.android.physioassistant.models.Appointment;
import uom.android.physioassistant.models.Doctor;
import uom.android.physioassistant.models.Patient;
import uom.android.physioassistant.ui.DoctorNavBar;
import uom.android.physioassistant.ui.FragmentType;

public class DoctorActivity extends AppCompatActivity implements FragmentNavigation {

    private DoctorNavBar navBar;
    private Doctor doctor;

    private boolean isDoctorLoaded,isAppointmentsLoaded,initActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);


        DataManager dataManager = new DataManager();
        dataManager.loadDoctorByUsername("Doctor1");

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
    public void onDoctorLoaded(DoctorLoadedEvent event){
        doctor = event.getDoctor();
        isDoctorLoaded = true;
        DataManager dataManager = new DataManager();
        dataManager.loadAppointmentsByDoctorId(doctor.getAfm());
        System.out.println(doctor);
        checkIfAllDataLoaded();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDoctorAppointmentsLoaded(AppointmentsLoadedEvent event){
        if(!isAppointmentsLoaded){
            ArrayList<Appointment> appointments = (ArrayList<Appointment>) event.getAppointments();
            doctor.setAppointments(appointments);
            isAppointmentsLoaded = true;
            DataManager dataManager = new DataManager();
            dataManager.loadAllPatientByDoctorId(doctor.getAfm());
            checkIfAllDataLoaded();
        }
    }



    private void checkIfAllDataLoaded() {
        if (isDoctorLoaded  && isAppointmentsLoaded) {
            if(!initActivity){
                initActivity=true;
                initActivity();
            }
        }
    }

    public void initActivity(){
        replaceFragment(FragmentType.DOCTOR_HOME_FRAGMENT.getFragment(),0,0);
        navBar = findViewById(R.id.navBar);
        navBar.setActivity(this);
        navBar.handleClicks();
    }

    @Override
    public void replaceFragment(Fragment fragment, int enterAnimation, int exitAnimation){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().
                setCustomAnimations(enterAnimation,exitAnimation);
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void replaceFragment(Fragment fragment,int enterAnimation,int exitAnimation,Bundle bundle){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().
                setCustomAnimations(enterAnimation,exitAnimation);
        fragment.setArguments(bundle);
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }



    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);

        if(fragment instanceof OnBackPressedListener){
            ((OnBackPressedListener) fragment).onBackPressed(this);
        }
        else{
            navBar.undo();
        }
    }

    public DoctorNavBar getNavBar() {
        return navBar;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}