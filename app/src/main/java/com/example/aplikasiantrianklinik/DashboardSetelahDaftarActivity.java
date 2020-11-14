package com.example.aplikasiantrianklinik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardSetelahDaftarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_setelah_daftar);

        customToolbar();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:

                        break;
                    case R.id.action_jadwal :
                        Intent jadwalIntent = new Intent(DashboardSetelahDaftarActivity.this, JadwalDokterActivity.class);
                        startActivity(jadwalIntent);


                        break;
                    case R.id.action_profile :
                        Intent profileIntent = new Intent(DashboardSetelahDaftarActivity.this, ProfileActivity.class);
                        startActivity(profileIntent);

                        break;
                }

                return true;
            }
        });

        Button btnKonsul = (Button) findViewById(R.id.btn_daftar_konsul);
        btnKonsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent konsulIntent = new Intent(DashboardSetelahDaftarActivity.this, PendaftaranKonsultasiActivity.class);
                startActivity(konsulIntent);
            }
        });

    }


    private void customToolbar(){
        //set Toolbar custom
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (myToolbar != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
        }

        //TextView myToolbar_title = (TextView) findViewById(R.id.list_title);
        // myToolbar_title.setText(R.string.dental_clinic_app);


        ImageView notification = (ImageView) findViewById(R.id.icon_notif);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

    }


}