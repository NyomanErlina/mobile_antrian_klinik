package com.example.aplikasiantrianklinik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileDokterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_dokter);

        Toolbar myToolbarProfile = (Toolbar) findViewById(R.id.profile_dokter_toolbar);
        setSupportActionBar(myToolbarProfile);


        if (myToolbarProfile != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myToolbarProfile.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dashboardIntent = new Intent(ProfileDokterActivity.this, DashboardDokterActivity.class);
                startActivity(dashboardIntent);

            }
        });
    }
}