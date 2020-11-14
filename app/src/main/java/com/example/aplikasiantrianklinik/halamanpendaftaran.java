package com.example.aplikasiantrianklinik;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class halamanpendaftaran extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private EditText inputTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halamanpendaftaran);

        setToolbarCustom();

        //dateformat
        // object dateFormatter
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        //untuk input datepicker
        inputTanggal = (EditText) findViewById(R.id.pilihtanggal);
        inputTanggal.setInputType(InputType.TYPE_NULL);
        inputTanggal.requestFocus();
        inputTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog(); // method showDateDialog
            }
        });



        Button btnDaftar = (Button) findViewById(R.id.btn_daftar_pasien);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent daftarIntent = new Intent(halamanpendaftaran.this, DashboardActivity.class);
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
                Intent backIntent = new Intent(halamanpendaftaran.this, MainActivity.class);
                startActivity(backIntent);

            }
        });
    }

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
}