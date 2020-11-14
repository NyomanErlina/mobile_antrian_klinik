package com.example.aplikasiantrianklinik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import android.text.format.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PendaftaranKonsultasiActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private EditText inputTanggal;

    private TimePickerDialog timePickerDialog;
    private EditText inputJam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_konsultasi);

        setToolbarCustom();

        // object dateFormatter
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        //untuk input datepicker
        inputTanggal = (EditText) findViewById(R.id.input_tanggal);
        inputTanggal.setInputType(InputType.TYPE_NULL);
        inputTanggal.requestFocus();
        inputTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog(); // method showDateDialog
            }
        });

        //untuk input timepicker
        inputJam = (EditText) findViewById(R.id.input_jam);
        inputJam.setInputType(InputType.TYPE_NULL);
        inputJam.requestFocus();
        inputJam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeDialog();
            }
        });

        //untuk submit form
        Button btnSubmitKonsul = (Button) findViewById(R.id.btn_submit_konsul);
        btnSubmitKonsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent(PendaftaranKonsultasiActivity.this, DashboardSetelahDaftarActivity.class);
                startActivity(submitIntent);
            }
        });




    }

    private void setToolbarCustom(){
        Toolbar myToolbarKonsul= (Toolbar) findViewById(R.id.konsultasi_toolbar);
        setSupportActionBar(myToolbarKonsul);


        if (myToolbarKonsul != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myToolbarKonsul.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dashboardIntent = new Intent(PendaftaranKonsultasiActivity.this, DashboardActivity.class);
                startActivity(dashboardIntent);

            }
        });
    }

    //-------------------------------------------------------------
    private void showDateDialog() {
    // Calendar untuk mendapatkan tanggal sekarang
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                // Set calender untuk menampung tanggal yang dipilih
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                // update Edittext dengan tanggal yang dipilih
                inputTanggal.setText(dateFormatter.format(newDate.getTime()));


            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH),
                newCalendar.get(Calendar.DAY_OF_MONTH));

        //Tampilkan DatePicker dialog
        datePickerDialog.show();

    }

    private void showTimeDialog(){
        Calendar myCalendar = Calendar.getInstance();
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                inputJam.setText(hourOfDay+":"+minute);
            }
        },myCalendar.get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE),
                DateFormat.is24HourFormat(this));
                timePickerDialog.show();

    }

}