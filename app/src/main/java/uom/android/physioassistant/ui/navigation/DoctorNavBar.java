package uom.android.physioassistant.ui.navigation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.login.LoginActivity;
import uom.android.physioassistant.ui.common.ButtonType;

public class DoctorNavBar extends NavBar{

    private TextView notificationsCount;
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

        inflate(context, R.layout.layout_nav_bar_doctor,this);

        NavButton homeButton = findViewById(R.id.homeButton);
        homeButton.setButtonType(ButtonType.DOCTOR_HOME);
        homeButton.setPressed();

        NavButton patientsButton = findViewById(R.id.patientsButton);
        patientsButton.setButtonType(ButtonType.DOCTOR_PATIENTS);

        NavButton calendarButton = findViewById(R.id.calendarButton);
        calendarButton.setButtonType(ButtonType.DOCTOR_CALENDAR);

        NavButton notificationsButton = findViewById(R.id.notificationsButton);
        notificationsButton.setButtonType(ButtonType.DOCTOR_NOTIFICATIONS);

        TextView homeText = findViewById(R.id.homeNavText);
        TextView patientText = findViewById(R.id.patientsNavText);
        TextView calendarText = findViewById(R.id.calendarNavText);
        TextView notificationText = findViewById(R.id.notificationsNavText);

        NavItem homeItem = findViewById(R.id.homeLayout);
        NavItem patientItem = findViewById(R.id.patientsLayout);
        NavItem calendarItem = findViewById(R.id.calendarLayout);
        NavItem notificationsItem = findViewById(R.id.notificationLayout);

        homeItem.setNavButton(homeButton);
        homeItem.setNavText(homeText);
        homeItem.setPressed();

        patientItem.setNavButton(patientsButton);
        patientItem.setNavText(patientText);

        calendarItem.setNavButton(calendarButton);
        calendarItem.setNavText(calendarText);

        notificationsItem.setNavButton(notificationsButton);
        notificationsItem.setNavText(notificationText);
        notificationsCount = findViewById(R.id.notificationsCount);

        backStack = new Stack<>();

        currentButton = homeItem;

        NavButton logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setButtonType(null);
        logoutButton.setButtonType(ButtonType.LOGOUT);
        logoutButton.setOnClickListener(v -> {
            Log.i("DoctorNavBar", "Logout button clicked");

            // Set this button as pressed
            logoutButton.setPressed();

            // Display a dialog box to confirm logout
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Αποσύνδεση");
            builder.setMessage("Ειστε σίγουροι οτι θέλετε να αποσυνδεθείτε;");
            builder.setPositiveButton("ΝΑΙ", (dialog, which) -> {
                // Logout
                Log.i("DoctorNavBar", "Logging out");

                // Start the logout activity and finish the current activity
                Intent intent = new Intent(getContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);

                ((Activity) getContext()).finish();
            });

            builder.setNegativeButton("ΟΧΙ", (dialog, which) -> {
                // Close dialog
                dialog.cancel();
                logoutButton.setIdle();

            });

            builder.show();
        });

        buttons = new ArrayList<>();
        buttons.add(homeItem);
        buttons.add(patientItem);
        buttons.add(calendarItem);
        buttons.add(notificationsItem);

    }

    public void updateNotificationsCount(String num){
        notificationsCount.setText(num);
    }
    public void hideNotificationsCount(){
        notificationsCount.setVisibility(INVISIBLE);
    }

    public void showNotificationsCount(){
        notificationsCount.setVisibility(VISIBLE);
    }



}
