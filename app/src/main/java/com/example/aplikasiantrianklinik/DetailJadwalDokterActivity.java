package com.example.aplikasiantrianklinik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailJadwalDokterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jadwal_dokter);

        setToolbarCustom();
    }


    private void setToolbarCustom(){
        Toolbar myToolbarJadwal = (Toolbar) findViewById(R.id.jadwal_toolbar);
        setSupportActionBar(myToolbarJadwal);


        if (myToolbarJadwal != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myToolbarJadwal.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(DetailJadwalDokterActivity.this, JadwalDokterActivity.class);
                startActivity(backIntent);

            }
        });
    }
}