package uom.android.physioassistant.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Stack;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.FragmentNavigation;
import uom.android.physioassistant.activities.doctor.DoctorActivity;
import uom.android.physioassistant.activities.patient.PatientActivity;

public abstract class NavBar extends RelativeLayout {

    protected Activity activity;
    protected Stack<NavButton> backStack;
    protected ArrayList<NavButton> buttons;
    protected NavButton currentButton;

    public NavBar(Context context) {
        super(context);
    }

    public NavBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    protected abstract void init(Context context);

    public void handleClicks() {
        for (NavButton button : buttons) {
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    backStack.push(currentButton);
                    transition(button);
                }
            });
        }

    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void undo() {
        if (!backStack.isEmpty()) {
            NavButton prevButton = backStack.pop();
            transition(prevButton);
        }
        else{
            activity.moveTaskToBack(true);
        }
    }

    public void transition(NavButton nextButton) {

        resetButtons();
        nextButton.setPressed();
        int enterAnimation, exitAnimation;

        float offset = nextButton.getX() - currentButton.getX();
        enterAnimation = R.anim.enter_left_to_right;
        exitAnimation = R.anim.exit_left_to_right;
        if (offset > 0) {
            enterAnimation = R.anim.enter_right_to_left;
            exitAnimation = R.anim.exit_right_to_left;
        }

        ((FragmentNavigation) activity).replaceFragment(nextButton.getFragment(), enterAnimation, exitAnimation);
        currentButton = nextButton;
    }

    public void transition(Fragment fragment){
        for(NavButton button:buttons){
            if(button.getButtonType().getFragment().equals(fragment)){
                backStack.push(currentButton);
                transition(button);
            }
        }
    }

    public void resetButtons() {
        for (NavButton button : buttons) {
            button.setIdle();
        }
    }


}
