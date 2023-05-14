package uom.android.physioassistant.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.patient.PatientActivity;
import uom.android.physioassistant.activities.patient.PatientNavBar;

public abstract class NavBar extends RelativeLayout {

    protected Activity activity;
    public NavBar(Context context) {
        super(context);
    }

    public NavBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected ArrayList<NavButton> buttons;
    protected NavButton currentButton;

    protected abstract void init();

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
        int enterAnimation,exitAnimation;

        float offset = nextButton.getX()-currentButton.getX();
        enterAnimation = R.anim.enter_left_to_right;
        exitAnimation = R.anim.exit_left_to_right;
        if(offset>0){
            enterAnimation = R.anim.enter_right_to_left;
            exitAnimation = R.anim.exit_right_to_left;
        }

        ((PatientActivity)activity).replaceFragment(nextButton.getButtonType().getFragment(),enterAnimation,exitAnimation);
        currentButton = nextButton;

    }

    public void resetButtons(){
        for(NavButton button:buttons){
            button.setIdle();
        }
    }




}
