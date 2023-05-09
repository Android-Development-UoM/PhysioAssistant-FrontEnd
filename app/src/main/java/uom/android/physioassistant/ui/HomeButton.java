package uom.android.physioassistant.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.patient.CalendarFragment;
import uom.android.physioassistant.activities.patient.HomeFragment;

public class HomeButton extends NavButton{
    public HomeButton(@NonNull Context context) {
        super(context);
    }

    public HomeButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void init() {
        this.setImageResource(R.drawable.ic_home_pressed);
        this.fragment = new HomeFragment();
        System.out.println("Home button init");
    }



    @Override
    public void setPressed() {
        this.setImageResource(R.drawable.ic_home_pressed);
    }

    @Override
    public void setIdle() {
        this.setImageResource(R.drawable.ic_home);
    }
}
