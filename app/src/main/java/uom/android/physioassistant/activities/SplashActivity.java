package uom.android.physioassistant.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import uom.android.physioassistant.MainActivity;
import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIMEOUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.hideHeaderBar();

        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMEOUT);
    }

    private void hideHeaderBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}