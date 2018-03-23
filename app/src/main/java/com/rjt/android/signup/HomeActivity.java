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
        Log.i("welcomeHandler", "welcomeHandler method started");
        TextView greetView = findViewById(R.id.welcomeTextView);
        String userName = getIntent().getExtras().getString("nameKey");
        //Log.d();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf");
        StringBuilder showMsg = new StringBuilder("Hi ");
        showMsg.append(userName);
        showMsg.append(", thanks for signing up!");
        greetView.setText(showMsg.toString());
        greetView.setTypeface(typeface);
    }

    public void backSignUpHandler(View view) {
        Log.i("backSignUpHanlder", "Back to Sign Up Page");
        Intent backHomeIntent = new Intent(this, MainActivity.class);
        startActivity(backHomeIntent);
    }
}
