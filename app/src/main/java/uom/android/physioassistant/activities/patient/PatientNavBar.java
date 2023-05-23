package uom.android.physioassistant.activities.patient;

import android.content.Context;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.Stack;

import uom.android.physioassistant.R;
import uom.android.physioassistant.ui.ButtonType;
import uom.android.physioassistant.ui.NavBar;
import uom.android.physioassistant.ui.NavButton;

public class PatientNavBar extends NavBar {
    public PatientNavBar(Context context) {
        super(context);
    }

    public PatientNavBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PatientNavBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void init(){

        NavButton homeButton = activity.findViewById(R.id.homeButton);
        homeButton.setButtonType(ButtonType.PATIENT_HOME);
        homeButton.setPressed();

        NavButton calendarButton = activity.findViewById(R.id.calendarButton);
        calendarButton.setButtonType(ButtonType.PATIENT_CALENDAR);

        NavButton profileButton = activity.findViewById(R.id.profileButton);
        profileButton.setButtonType(ButtonType.PATIENT_PROFILE);

        backStack = new Stack<>();

        currentButton = homeButton;

        buttons = new ArrayList<>();
        buttons.add(homeButton);
        buttons.add(calendarButton);
        buttons.add(profileButton);

    }

}
