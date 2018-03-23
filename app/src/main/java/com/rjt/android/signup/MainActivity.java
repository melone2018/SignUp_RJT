package com.rjt.android.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener, AdapterView.OnItemSelectedListener {
    private static final int SIGN_UP_CODE = 7;
    private CheckBox remPassword, newUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("onCreat", "onCreate started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialUISetup();
    }

    public void initialUISetup(){
        EditText nameEditText = findViewById(R.id.editTextName);
        nameEditText.setOnFocusChangeListener(this);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setPrompt("select country");
        spinner.setOnItemSelectedListener(this);

        remPassword = findViewById(R.id.checkBox);
        newUser = findViewById(R.id.newUserCheckBox);

        remPassword.setOnCheckedChangeListener(new signUpCheckBoxChangeListerner());
        newUser.setOnCheckedChangeListener(new signUpCheckBoxChangeListerner());

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

    public void textNotification(String notificationText){
        Toast.makeText(this, notificationText, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus){
            Toast.makeText(this,"You are typing your full name",Toast.LENGTH_SHORT).show();
        }
        else
            if(!hasFocus){
            Toast.makeText(this,"You are not typing your name",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "position clicked = "+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    class signUpCheckBoxChangeListerner implements CheckBox.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView == remPassword) {
                    textNotification("You checked \"Remember Password\"");
                }
                if (buttonView == newUser) {
                    textNotification("You checked \"New User\"");
                }
            } else {
                if (buttonView == remPassword) {
                    textNotification("You unchecked \"Remember Password\"");
                }
                if (buttonView == newUser) {
                    textNotification("You unchecked \"New User\"");
                }
            }
        }
    }
}
