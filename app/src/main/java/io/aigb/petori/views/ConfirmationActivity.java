package io.aigb.petori.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;

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


    public void makeOrder() {

        String nama = tNama.getText().toString();
        String alamat = tAlamat.getText().toString();
        String kota = tKota.getText().toString();
        String total = tTotal.getText().toString();

        URL url = new URL("http://petoriapi.herokuapp.com/user/login");
        HttpURLConnection client = null;
        try {
            client = (HttpURLConnection) url.openConnection();
            client.setRequestMethod("POST");
            client.setRequestProperty("nama",nama);
            client.setRequestProperty("alamat",alamat);
            client.setRequestProperty("kota",kota);
            client.setRequestProperty("total",total);
            client.setDoOutput(true);
        } catch (Exception e) {

        } finally {
            if(client != null) // Make sure the connection is not null.
                client.disconnect();
        }
    }
}
