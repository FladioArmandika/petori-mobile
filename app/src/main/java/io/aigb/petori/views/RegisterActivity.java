package io.aigb.petori.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.aigb.petori.R;

public class RegisterActivity extends AppCompatActivity {


    Button btnRegister;
    TextView btnChangeToLogin;

    String username,email,password;

    EditText editUsername, editEmail, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button) findViewById(R.id.btn_register);
        btnChangeToLogin = (TextView) findViewById(R.id.btn_changetologin);

        editUsername = (EditText) findViewById(R.id.reg_username);
        editEmail = (EditText) findViewById(R.id.reg_email);
        editPassword = (EditText) findViewById(R.id.reg_password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = editUsername.getText().toString();
                email = editEmail.getText().toString();
                password = editPassword.getText().toString();

                if(!username.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    register();
                } else {
                    Toast.makeText(RegisterActivity.this, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnChangeToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }



    public void register() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("mypref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("user", username);
        editor.commit();

        Intent i = new Intent(RegisterActivity.this, HomeActivity.class);
        startActivity(i);
    }

}
