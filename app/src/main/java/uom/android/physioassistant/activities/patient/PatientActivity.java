package uom.android.physioassistant.activities.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import uom.android.physioassistant.R;
import uom.android.physioassistant.ui.ButtonType;
import uom.android.physioassistant.ui.FragmentType;

public class PatientActivity extends AppCompatActivity {


    private PatientNavBar navBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        replaceFragment(FragmentType.HOME_FRAGMENT.getFragment(),R.anim.enter_left_to_right,R.anim.exit_left_to_right);

        navBar = findViewById(R.id.navBar);
        navBar.setActivity(this);
        navBar.handleClicks();

    }

    public void replaceFragment(Fragment fragment,int enterAnimation,int exitAnimation){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().
                setCustomAnimations(enterAnimation,exitAnimation);
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();

    }


    public PatientNavBar getNavBar() {
        return navBar;
    }
}