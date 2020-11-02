package com.geekteck.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText userPassword;
    private Button userLogin;
    private TextView attemptsInfo;
    private final String Username = "Admin";
    private final String Password = "Dtop";

    boolean isValid = false;
    private int counter = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userPassword = findViewById(R.id.etPassword);
        userLogin = findViewById(R.id.btnLogin);
        attemptsInfo = findViewById(R.id.tvAttemptsInfo);

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName = userName.getText().toString();
                String inputPassword = userPassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all the details correctly", Toast.LENGTH_SHORT).show();
                }else{


                    isValid = validate(inputName, inputPassword);
                    if(!isValid){

                        counter--;

                        Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();

                        attemptsInfo.setText("No. of attempts remaining: " + counter);

                        if (counter == 0){
                            userLogin.setEnabled(false);
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }


                }
            }
        });

    }

    private boolean validate(String name, String password){

        if(name.equals(Username) && password.equals(Password)){
            return true;
        }

        return false;
    }
}