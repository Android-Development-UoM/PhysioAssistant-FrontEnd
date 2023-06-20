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

public class PatientNavBar extends NavBar {

    public PatientNavBar(Context context) {
        super(context);
        init(context);
    }

    public PatientNavBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PatientNavBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    protected void init(Context context){

        inflate(context,R.layout.layout_nav_bar_patient,this);

        NavButton homeButton = findViewById(R.id.homeButton);
        homeButton.setButtonType(ButtonType.PATIENT_HOME);
        homeButton.setPressed();

        NavButton calendarButton = findViewById(R.id.calendarButton);
        calendarButton.setButtonType(ButtonType.PATIENT_CALENDAR);

        TextView homeText = findViewById(R.id.homeNavText);
        TextView calendarText = findViewById(R.id.calendarNavText);

        NavItem homeItem = findViewById(R.id.homeLayout);
        NavItem calendarItem = findViewById(R.id.calendarLayout);

        homeItem.setNavButton(homeButton);
        homeItem.setNavText(homeText);

        calendarItem.setNavButton(calendarButton);
        calendarItem.setNavText(calendarText);

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
                Log.i("PatientNavBar", "Logging out");

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


        backStack = new Stack<>();

        currentButton = homeItem;

        buttons = new ArrayList<>();
        buttons.add(homeItem);
        buttons.add(calendarItem);

    }

}
