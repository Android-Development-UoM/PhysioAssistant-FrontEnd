package uom.android.physioassistant.ui;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.patient.HomeFragment;
import uom.android.physioassistant.activities.patient.ProfileFragment;

public class ProfileButton extends NavButton{
    public ProfileButton(@NonNull Context context) {
        super(context);
    }

    public ProfileButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProfileButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void init() {
        this.setImageResource(R.drawable.ic_profile);
        this.fragment = new ProfileFragment();
        System.out.println("Profile button init");
    }

    @Override
    public void setPressed() {
        this.setImageResource(R.drawable.ic_profile_pressed);
    }

    @Override
    public void setIdle() {
        this.setImageResource(R.drawable.ic_profile);
    }
}
