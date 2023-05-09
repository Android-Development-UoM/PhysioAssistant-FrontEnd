package uom.android.physioassistant.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.patient.PatientActivity;

public class NavBar extends RelativeLayout {

    private Activity activity;
    public NavBar(Context context) {
        super(context);
    }

    public NavBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ArrayList<NavButton> buttons;
    private NavButton currentButton;

    private void init(){

        HomeButton homeButton = activity.findViewById(R.id.homeButton);
        CalendarButton calendarButton = activity.findViewById(R.id.calendarButton);
        ProfileButton profileButton = activity.findViewById(R.id.profileButton);

        currentButton = homeButton;

        buttons = new ArrayList<>();
        buttons.add(homeButton);
        buttons.add(calendarButton);
        buttons.add(profileButton);

    }

    public void handleClicks(){
        System.out.println(buttons.size());
        for(NavButton button:buttons){
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    transition(button);
                }
            });
        }

    }

    public void setActivity(Activity activity) {
        this.activity = activity;
        init();
    }

    public void transition(NavButton nextButton){

        resetButtons();
        nextButton.setPressed();

        float offset = nextButton.getX()-currentButton.getX();

        ((PatientActivity)activity).replaceFragment(nextButton.getFragment());
        currentButton = nextButton;

    }

    public void resetButtons(){
        for(NavButton button:buttons){
            button.setIdle();
        }
    }




}
