package com.example.aplikasiantrianklinik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    private DataHelper database;
    private ArrayList<Dokter> listDokter = new ArrayList<>();
    private ListDokterAdapter dokterAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        showRecyclerList();

        customToolbar();

        navigationView();


            BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_pasien);
            bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.action_home:

                            break;
                        case R.id.action_jadwal :
                            Intent jadwalIntent = new Intent(DashboardActivity.this, JadwalDokterActivity.class);
                            startActivity(jadwalIntent);


                            break;
                        case R.id.action_notifikasi :
                            Intent notifIntent = new Intent(DashboardActivity.this, notifikasi.class);
                            startActivity(notifIntent);

                            break;
                    }

                    return true;
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




    }

    private void showRecyclerList(){
        RecyclerView rvDokter = (RecyclerView) findViewById(R.id.recyclerView_dokter);
        //mengatur layout pada recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvDokter.setLayoutManager(linearLayoutManager);
        //gunakan setHasFixedSize = true agar ukuran recylerview tidak berubah ketika isi recyclerview secara dinamis berubah
        rvDokter.setHasFixedSize(true);

        database = new DataHelper(this);
        listDokter = database.listDokter();

        if(listDokter.size() > 0){
            //rvDokter.setVisibility(View.VISIBLE);

            // get image from drawable
            Bitmap image1 = BitmapFactory.decodeResource(getResources(),
                    R.drawable.dokter1);
            // convert bitmap to byte
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            image1.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] imageInByte1 = stream.toByteArray();

            // get image from drawable
            Bitmap image2 = BitmapFactory.decodeResource(getResources(),
                    R.drawable.dokter2);
            // convert bitmap to byte
            ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
            image2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
            byte[] imageInByte2 = stream.toByteArray();

            // Inserting Dokter
            Log.d("Insert: ", "Inserting ..");
            database.addDokter(new Dokter("1", "dr. Sabrina Permata", "sabrina@gmail.com", "08752635263",
                    982187287, "Jalan Mawar 89", "RSUD Soebandi", imageInByte1  ));
            database.addDokter(new Dokter("2", "dr. Sintya Dewi", "sintyaa@gmail.com", "085652135263",
                    1232187287, "Jalan Melati 12", "RSUD Soebandi", imageInByte2  ));

            // display main List view dokter and reading all dokter from database
            ArrayList<Dokter> dokters = database.listDokter();
            for (Dokter d : dokters) {
                String log = "ID Dokter :" + d.getId() + " Nama Dokter: " + d.getNama()
                        + " ,Image: " + d.getFoto();

                Log.d("Result: ", log);

                //add data dokter in arrayList
                listDokter.add(d);
            }


            dokterAdapter = new ListDokterAdapter(this, listDokter);
            rvDokter.setAdapter(dokterAdapter);

            dokterAdapter.setOnItemClickCallback(new ListDokterAdapter.OnItemClickCallback() {
                @Override
                public void onItemClicked(Dokter data) {
                    Intent konsulIntent = new Intent(DashboardActivity.this, PendaftaranKonsultasiActivity.class);
                    konsulIntent.putExtra(PendaftaranKonsultasiActivity.EXTRA_NAMA_DOKTER, data.getNama());
                    startActivity(konsulIntent);

                }
            });

        }else {
            //rvDokter.setVisibility(View.GONE);
            Toast.makeText(this, "There is no dokter in the database. Start adding now", Toast.LENGTH_LONG).show();
        }

    }



    private void navigationView(){
        // Menginisiasi  NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Mengatur Navigasi View Item yang akan dipanggil untuk menangani item klik menu navigasi
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Memeriksa apakah item tersebut dalam keadaan dicek  atau tidak,
                if(menuItem.isChecked())
                    menuItem.setChecked(false);
                else menuItem.setChecked(true);
                    //Menutup  drawer item klik
                    drawerLayout.closeDrawers();

                //Memeriksa untuk melihat item yang akan dilklik dan melalukan aksi
                switch (menuItem.getItemId()){
                    // pilihan menu item navigasi akan menampilkan pesan toast klik kalian bisa menggantinya
                    //dengan intent activity
                    case R.id.navigasi_profile:
                        Intent profileIntent = new Intent(DashboardActivity.this, ProfileActivity.class);
                        startActivity(profileIntent);
                    case R.id.navigasi_setting:
                        Toast.makeText(getApplicationContext(),"Setting Telah Dipilih",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(),"Kesalahan Terjadi ",Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });

        // Menginisasi Drawer Layout dan ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
                // Kode di sini akan merespons setelah drawer menutup disini kita biarkan kosong
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                //  Kode di sini akan merespons setelah drawer terbuka disini kita biarkan kosong
                super.onDrawerOpened(drawerView);
            }
        };
        //Mensetting actionbarToggle untuk drawer layout
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //memanggil synstate
        actionBarDrawerToggle.syncState();
    }
}