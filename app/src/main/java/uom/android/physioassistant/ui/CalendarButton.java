package uom.android.physioassistant.ui;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.patient.CalendarFragment;


public class CalendarButton extends NavButton{


    public CalendarButton(@NonNull Context context) {
        super(context);
    }

    public CalendarButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CalendarButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void init() {
        this.setImageResource(R.drawable.ic_calendar);
        this.fragment = new CalendarFragment();
        System.out.println("Calendar button init");
    }

    @Override
    public void setPressed() {
        this.setImageResource(R.drawable.ic_calendar_pressed);
    }

    @Override
    public void setIdle() {
        this.setImageResource(R.drawable.ic_calendar);
    }

}
