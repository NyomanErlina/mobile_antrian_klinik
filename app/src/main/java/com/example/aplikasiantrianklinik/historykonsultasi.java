package com.example.aplikasiantrianklinik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class historykonsultasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historykonsultasi);

        setToolbarCustom();

        CardView cardJadwal = (CardView) findViewById(R.id.card1);
        cardJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dethistoryIntent = new Intent(historykonsultasi.this, detailhistorykonsultasi.class);
                startActivity(dethistoryIntent);
            }
        });
    }

    private void setToolbarCustom(){
        Toolbar myToolbarDaftar = (Toolbar) findViewById(R.id.history_toolbar);
        setSupportActionBar(myToolbarDaftar);


        if (myToolbarDaftar != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myToolbarDaftar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(historykonsultasi.this, DashboardDokterActivity.class);
                startActivity(backIntent);

            }
        });
    }
}