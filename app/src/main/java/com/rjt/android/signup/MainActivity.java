package com.rjt.android.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int SIGN_UP_CODE = 7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("onCreat", "onCreate started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signUpHandler(View view) {
        Log.i("signUpHandler", "signUpHandler Started");
        EditText editTextName = findViewById(R.id.editTextName);
        String userName = editTextName.getText().toString();
        Intent signUpIntent = new Intent(MainActivity.this, HomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("nameKey", userName);
        signUpIntent.putExtras(bundle);
        startActivityForResult(signUpIntent, SIGN_UP_CODE);
    }
}
