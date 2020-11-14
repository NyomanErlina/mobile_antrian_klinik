package com.example.aplikasiantrianklinik;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.btn_signin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertLoginBuilder = new AlertDialog.Builder(LoginActivity.this);
                alertLoginBuilder.setMessage("Anda Ingin Login Sebagai ?")
                        .setCancelable(false)
                        .setPositiveButton("Pasien", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent loginIntent = new Intent(LoginActivity.this, DashboardActivity.class);
                                startActivity(loginIntent);
                            }
                        })
                        .setNegativeButton("Dokter", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent login2Intent = new Intent(LoginActivity.this, DashboardDokterActivity.class);
                                startActivity(login2Intent);
                            }
                        });


                AlertDialog alertDialog = alertLoginBuilder.create();
                alertDialog.show();



            }
        });
    }
}