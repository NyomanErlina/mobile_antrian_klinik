package com.example.aplikasiantrianklinik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class registrasidokter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasidokter);

        setToolbarCustom();

        Button btnDaftar = (Button) findViewById(R.id.btn_daftar_dokter);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent daftarIntent = new Intent(registrasidokter.this, DashboardDokterActivity.class);
                startActivity(daftarIntent);
            }
        });
    }

    private void setToolbarCustom(){
        Toolbar myToolbarDaftar = (Toolbar) findViewById(R.id.pendaftaran_toolbar);
        setSupportActionBar(myToolbarDaftar);


        if (myToolbarDaftar != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myToolbarDaftar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(registrasidokter.this, MainActivity.class);
                startActivity(backIntent);

            }
        });
    }
}