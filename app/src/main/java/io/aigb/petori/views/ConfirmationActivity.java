package io.aigb.petori.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.aigb.petori.R;

public class ConfirmationActivity extends AppCompatActivity {

    Button btnLanjut;

    TextView tNama, tAlamat, tKota, tTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);


        tNama = (TextView) findViewById(R.id.conf_nama);
        tAlamat = (TextView) findViewById(R.id.conf_alamat);
        tKota = (TextView) findViewById(R.id.conf_kota);
        tTotal = (TextView) findViewById(R.id.conf_total);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("mypref", MODE_PRIVATE);

        String nama = pref.getString("nama","");
        String alamat = pref.getString("alamat","");
        String kota = pref.getString("kota","");
        int total = pref.getInt("totalharga",0);



        tNama.setText(nama);
        tAlamat.setText(alamat);
        tKota.setText(kota);
        tTotal.setText(String.valueOf(total));


        btnLanjut = (Button) findViewById(R.id.btn_confirmation_lanjut);

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfirmationActivity.this, SuccessActivity.class);
                startActivity(i);
            }
        });
    }
}
