package com.example.aplikasiantrianklinik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JadwalDokterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_dokter);

        setToolbarCustom();


        CardView cardJadwal = (CardView) findViewById(R.id.card_jadwal);
        cardJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detjadwalIntent = new Intent(JadwalDokterActivity.this, DetailJadwalDokterActivity.class);
                startActivity(detjadwalIntent);
            }
        });
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
                Intent dashboardIntent = new Intent(JadwalDokterActivity.this, DashboardActivity.class);
                startActivity(dashboardIntent);

            }
        });
    }


}