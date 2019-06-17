package io.aigb.petori.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.aigb.petori.R;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btn_login);

        editTextUsername = (EditText) findViewById(R.id.edit_login_username);
        editTextPassword = (EditText) findViewById(R.id.edit_login_password);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();

            String result = validate(username,password);

            if(result.equals("ok")) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("mypref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("user", username);
                editor.commit();

                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
            }


            }
        });

    }

    public String validate(String username, String password) {
        String result = null;

        if(username == null && password == null) {
            result = "username dan password tidak boleh kosong";
        } else if (!username.equals("aldi")) {
            result = "Username tidak ada";
        } else if (!password.equals("aldi")) {
            result = "Password salah";
        } else {
            result = "ok";
        }

        return result;
    }


}
