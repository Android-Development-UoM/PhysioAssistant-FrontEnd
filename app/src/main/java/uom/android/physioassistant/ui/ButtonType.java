package uom.android.physioassistant.ui;

import androidx.fragment.app.Fragment;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.patient.CalendarFragment;
import uom.android.physioassistant.activities.patient.HomeFragment;
import uom.android.physioassistant.activities.patient.ProfileFragment;

public enum ButtonType {

    PATIENT_HOME(R.drawable.ic_home,R.drawable.ic_home_pressed,FragmentType.HOME_FRAGMENT),
    PATIENT_CALENDAR(R.drawable.ic_calendar,R.drawable.ic_calendar_pressed,FragmentType.CALENDAR_FRAGMENT),
    PATIENT_PROFILE(R.drawable.ic_profile,R.drawable.ic_profile_pressed,FragmentType.PROFILE_FRAGMENT);

    private int pressed,idle;
    private FragmentType fragmentType;
    ButtonType(int idle,int pressed,FragmentType fragmentType){
        this.idle =idle;
        this.pressed = pressed;
        this.fragmentType = fragmentType;
    }

    public int getPressed() {
        return pressed;
    }

    public int getIdle() {
        return idle;
    }

    public Fragment getFragment() {
        return fragmentType.getFragment();
    }
}
