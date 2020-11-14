package com.example.aplikasiantrianklinik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class detailhistorykonsultasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailhistorykonsultasi);

        setToolbarCustom();
    }

    private void setToolbarCustom(){
        Toolbar myToolbarDaftar = (Toolbar) findViewById(R.id.detail_history_toolbar);
        setSupportActionBar(myToolbarDaftar);


        if (myToolbarDaftar != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myToolbarDaftar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(detailhistorykonsultasi.this, historykonsultasi.class);
                startActivity(backIntent);

            }
        });
    }
}