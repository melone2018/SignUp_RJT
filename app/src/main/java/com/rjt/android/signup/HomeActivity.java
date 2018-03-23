package com.rjt.android.signup;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        welcomeHandler();
    }

    public void welcomeHandler() {
        TextView greetView = findViewById(R.id.welcomeTextView);
        String userName = getIntent().getExtras().getString("nameKey");
        //Log.d();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf");
        greetView.setText("Hi " + userName +", thanks for signing up!");
        greetView.setTypeface(typeface);
    }

    public void backSignUpHandler(View view) {
        Button backSignUpBtn = findViewById(R.id.backHomeButton);
        Intent backHomeIntent = new Intent(this, MainActivity.class);
        startActivity(backHomeIntent);
    }
}
