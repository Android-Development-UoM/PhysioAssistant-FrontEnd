package uom.android.physioassistant.ui;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class NavButton extends androidx.appcompat.widget.AppCompatImageView {

    protected Fragment fragment;
    public NavButton(@NonNull Context context) {
        super(context);
        init();
    }

    public NavButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NavButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public abstract void init();

    public abstract void setPressed();
    public abstract void setIdle();

    public Fragment getFragment() {
        return fragment;
    }
}
