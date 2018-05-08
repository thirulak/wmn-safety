package in.paperwrk.safetycollabproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import in.paperwrk.safetycollabproject.accounts.SigninActivity;
import in.paperwrk.safetycollabproject.utilities.PrefManager;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Boolean isFirstLaunch = getSharedPreferences("pref",MODE_PRIVATE)
                .getBoolean("isfirstLaunch",true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (isFirstLaunch){
                    intent = new Intent(SplashActivity.this,PageIntroActivity.class);
                    getSharedPreferences("pref",MODE_PRIVATE).edit().putBoolean("isfirstLaunch",false).apply();
                } else {
                    intent = new Intent(SplashActivity.this,HomeActivity.class);
                }
                startActivity(intent);
            }
        },2000);


    }

}
