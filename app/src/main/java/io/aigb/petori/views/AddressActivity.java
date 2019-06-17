package io.aigb.petori.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.aigb.petori.R;

public class AddressActivity extends AppCompatActivity {

    Button btnLanjut;

    EditText edAlamat,edNama, edKota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);


        edAlamat = (EditText) findViewById(R.id.address_alamat);
        edNama = (EditText) findViewById(R.id.address_nama);
        edKota= (EditText) findViewById(R.id.address_kota);

        btnLanjut = (Button) findViewById(R.id.btn_address_lanjut);

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String alamat = edAlamat.getText().toString();
                String nama = edNama.getText().toString();
                String kota = edKota.getText().toString();

                SharedPreferences pref = getApplicationContext().getSharedPreferences("mypref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("alamat", alamat);
                editor.putString("nama", nama);
                editor.putString("kota", kota);
                editor.commit();

                Intent i = new Intent(AddressActivity.this, ConfirmationActivity.class);
                startActivity(i);
            }
        });

    }
}
