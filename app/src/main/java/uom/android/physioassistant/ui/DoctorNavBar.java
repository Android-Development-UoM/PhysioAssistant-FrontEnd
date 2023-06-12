package uom.android.physioassistant.ui;

import android.content.Context;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.Stack;

import uom.android.physioassistant.R;

public class DoctorNavBar extends NavBar{
    public DoctorNavBar(Context context) {
        super(context);
        init(context);
    }

    public DoctorNavBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DoctorNavBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    protected void init(Context context){

        inflate(context, R.layout.doctor_nav_bar_layout,this);

        NavButton homeButton = findViewById(R.id.homeButton);
        homeButton.setButtonType(ButtonType.DOCTOR_HOME);
        homeButton.setPressed();

        NavButton patientsButton = findViewById(R.id.patientsButton);
        patientsButton.setButtonType(ButtonType.DOCTOR_PATIENTS);

        NavButton calendarButton = findViewById(R.id.calendarButton);
        calendarButton.setButtonType(ButtonType.DOCTOR_CALENDAR);

        NavButton notificationsButton = findViewById(R.id.notificationsButton);
        notificationsButton.setButtonType(ButtonType.DOCTOR_NOTIFICATIONS);

        backStack = new Stack<>();

        currentButton = homeButton;

        buttons = new ArrayList<>();
        buttons.add(homeButton);
        buttons.add(patientsButton);
        buttons.add(calendarButton);
        buttons.add(notificationsButton);

    }

}
