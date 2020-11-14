package com.example.aplikasiantrianklinik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_schedule);

        Toolbar scheduleToolbar = (Toolbar) findViewById(R.id.my_schedule_toolbar);
        setSupportActionBar(scheduleToolbar);


        if (scheduleToolbar != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        scheduleToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dashboardIntent = new Intent(MyScheduleActivity.this, DashboardDokterActivity.class);
                startActivity(dashboardIntent);

            }
        });
    }
}