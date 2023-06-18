package uom.android.physioassistant;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.jakewharton.threetenabp.AndroidThreeTen;

import org.greenrobot.eventbus.EventBus;

import uom.android.physioassistant.activities.login.LoginActivity;

/* This is the Splash Activity */
public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIMEOUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.hideHeaderBar();
        setContentView(R.layout.activity_splash);

        AndroidThreeTen.init(this);
        EventBus.builder().installDefaultEventBus();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initActivity();
            }
        }, SPLASH_TIMEOUT);

    }

    private void hideHeaderBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private void initActivity() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}