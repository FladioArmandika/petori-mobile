package io.aigb.petori.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import io.aigb.petori.R;

public class LayananDetailActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLanjut;
    CheckBox chkPedicure, chkGigi, chkFisio;

    int total = 0;

    TextView totalharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layanan_detail);

        btnLanjut = (Button) findViewById(R.id.bt_layanandetail_lanjut);


        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(total == 0) {
                    Toast.makeText(getApplicationContext(), "Pesan minimal 1 layanan", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("mypref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();

                    editor.putInt("totalharga", total);
                    editor.commit();


                    Intent i = new Intent(LayananDetailActivity.this, AddressActivity.class );
                    startActivity(i);
                }

            }
        });


        chkPedicure = (CheckBox) findViewById(R.id.chk_pedicure);
        chkGigi = (CheckBox) findViewById(R.id.chk_gigi);
        chkFisio = (CheckBox) findViewById(R.id.chk_fisio);

        totalharga = (TextView) findViewById(R.id.text_totalharga);


//        chkFisio.setOnClickListener(this);
//        chkPedicure.setOnClickListener(this);
//        chkGigi.setOnClickListener(this);

        chkPedicure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) { total = total + 200000; }
                if(!isChecked) {
                    if(total >= 0) {
                        total = total - 200000;
                    }
                }
                totalharga.setText(String.valueOf(total));
            }
        });

        chkGigi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) { total = total + 150000; }
                if(!isChecked) {
                    if(total >= 0) {
                        total = total - 150000;
                    }
                }
                totalharga.setText(String.valueOf(total));
            }
        });

        chkFisio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) { total = total + 100000;}
                if(!isChecked) {
                    if(total >= 0) {
                        total = total - 100000;
                    }
                }
                totalharga.setText(String.valueOf(total));
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.chk_pedicure:
                break;
            case R.id.chk_gigi:
                break;
            case R.id.chk_fisio:
                break;
        }
    }
}


