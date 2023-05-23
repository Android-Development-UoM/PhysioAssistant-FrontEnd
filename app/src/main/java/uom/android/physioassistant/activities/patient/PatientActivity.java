package uom.android.physioassistant.activities.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        transaction.addToBackStack(null);
        transaction.commit();

    }

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

        if (fragment instanceof ServiceFragment) {
            replaceFragment(FragmentType.HOME_FRAGMENT.getFragment(), R.anim.fade_in, R.anim.fade_out);
            navBar.setVisibility(View.VISIBLE);
        }
        else{
            navBar.undo();
        }
    }

    public PatientNavBar getNavBar() {
        return navBar;
    }
}