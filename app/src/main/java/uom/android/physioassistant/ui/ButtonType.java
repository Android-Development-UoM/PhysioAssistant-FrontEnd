package uom.android.physioassistant.ui;

import androidx.fragment.app.Fragment;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.patient.CalendarFragment;
import uom.android.physioassistant.activities.patient.HomeFragment;
import uom.android.physioassistant.activities.patient.ProfileFragment;

public enum ButtonType {

    PATIENT_HOME(R.drawable.ic_home,R.drawable.ic_home_pressed,new HomeFragment()),
    PATIENT_CALENDAR(R.drawable.ic_calendar,R.drawable.ic_calendar_pressed,new CalendarFragment()),
    PATIENT_PROFILE(R.drawable.ic_profile,R.drawable.ic_profile_pressed,new ProfileFragment());

    private int pressed,idle;
    private Fragment fragment;
    ButtonType(int idle,int pressed,Fragment fragment){
        this.idle =idle;
        this.pressed = pressed;
        this.fragment = fragment;
    }

    public int getPressed() {
        return pressed;
    }

    public int getIdle() {
        return idle;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
