package com.larombe.formvalidation;

import android.content.Intent;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //Initialization
    EditText etUsername, etPassword;
    TextView tvCreateAccout;
    Button btnLogin;
    String username, password;
    int formsuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Find Objects using its ID
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvCreateAccout = findViewById(R.id.tvCreateAccount);

        // Event Listener for LOGIN button
        btnLogin.setOnClickListener(this);
        tvCreateAccout.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                //Function of button Login once it was clicked

                formsuccess = 2;

                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                //Check if username is null
                if (username.equals("")) {
                    etUsername.setError("This field is required");
                    formsuccess--;
                }
                // Check if password is null
                if (password.equals("")) {
                    etPassword.setError("This field is required");
                    formsuccess--;
                }
                break;

            case R.id.tvCreateAccount:

                Intent signup= new Intent(this, SignupActivity.class);
                startActivity(signup);
                break;
        }
    }
}
