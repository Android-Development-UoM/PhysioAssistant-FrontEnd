package uom.android.physioassistant.ui;

import android.util.Log;

import androidx.fragment.app.Fragment;

import uom.android.physioassistant.activities.patient.CalendarFragment;
import uom.android.physioassistant.activities.patient.HomeFragment;
import uom.android.physioassistant.activities.patient.ProfileFragment;
import uom.android.physioassistant.activities.patient.ServiceFragment;

public enum FragmentType {

    HOME_FRAGMENT(new HomeFragment()),
    CALENDAR_FRAGMENT(new CalendarFragment()),
    PROFILE_FRAGMENT(new ProfileFragment()),
    SERVICE_FRAGMENT(new ServiceFragment());

    private Fragment fragment;

    FragmentType(Fragment fragment){
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
