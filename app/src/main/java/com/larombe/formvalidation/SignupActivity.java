package com.larombe.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    //Initialization

    EditText etUsername, etPassword, etConfirmPassword, etFullName;
    String username, password, ConfirmPassword, FullName;
    int formsuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etFullName = findViewById(R.id.etFullName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_cancel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnSave:
                formsuccess = 5;

                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                ConfirmPassword = etConfirmPassword.getText().toString();
                FullName = etFullName.getText().toString();

                if (username.equals("")) {
                    etUsername.setError("This field is required");
                    formsuccess--;
                }

                if (password.equals("")) {
                    etPassword.setError("This field is required");
                    formsuccess--;
                }

                if (ConfirmPassword.equals("")) {
                    etConfirmPassword.setError("This field is required");
                    formsuccess--;
                }
                if (!ConfirmPassword.equals(password)) {
                    etConfirmPassword.setError("Password Not Match");
                    formsuccess--;
                }

                if (FullName.equals("")) {
                    etFullName.setError("This field is required");
                    formsuccess--;
                }

                if (formsuccess == 5) {
                    Toast.makeText(this, "Form Successfully Validated", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btncancel:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

