package com.example.aplikasiantrianklinik;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        Button btnSignUp = findViewById(R.id.btn_signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertLoginBuilder = new AlertDialog.Builder(MainActivity.this);
                alertLoginBuilder.setMessage("Anda Ingin Daftar Akun Sebagai ?")
                        .setCancelable(false)
                        .setPositiveButton("Pasien", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent daftarpasienIntent = new Intent(MainActivity.this, halamanpendaftaran.class);
                                startActivity(daftarpasienIntent);
                            }
                        })
                        .setNegativeButton("Dokter", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent daftardokterIntent = new Intent(MainActivity.this, registrasidokter.class);
                                startActivity(daftardokterIntent);
                            }
                        });


                AlertDialog alertDialog = alertLoginBuilder.create();
                alertDialog.show();




            }
        });




    }
}