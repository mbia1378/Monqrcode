package com.mbia.cyrille.monqrcode.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.mbia.cyrille.monqrcode.R;
import com.mbia.cyrille.monqrcode.ui.home.HomeActivity;

public class SplashActivity extends AppCompatActivity {

    /**
     * Constantes
     */
    private final int SPLASH_DELAY = 1500;

    /**
     * Fields
     */
    private ImageView mImageViewLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setBackgroundDrawable(null);

        initializeViews();
        animateLogo();
        goToMainPage();
    }

    /**
     * Cette méthode initialise les vues
     */
    private void initializeViews() {
        mImageViewLogo = findViewById(R.id.image_view_logo);
    }

    /**
     * Cette méthode conduit l'utilisateur à la page principale
     */
    private void goToMainPage() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            finish();
        }, SPLASH_DELAY);
    }

    /**
     * Cette méthode anime le logo
     */
    private void animateLogo() {
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_without_duration);
        fadeInAnimation.setDuration(SPLASH_DELAY);

        mImageViewLogo.startAnimation(fadeInAnimation);
    }
}
