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
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView rvDokter;
    private ArrayList<Dokter> listDokter = new ArrayList<>();

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rvDokter = findViewById(R.id.recyclerView_dokter);
        //gunakan setHasFixedSize = true agar ukuran recylerview tidak berubah
        //ketika isi dari recyclerview secara dinamis berubah
        rvDokter.setHasFixedSize(true);

        listDokter.addAll(DataDokter.getListDataDokter());
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

        //TextView myToolbar_title = (TextView) findViewById(R.id.list_title);
       // myToolbar_title.setText(R.string.dental_clinic_app);

    /*
        ImageView notification = (ImageView) findViewById(R.id.icon_notif);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notifIntent = new Intent(DashboardActivity.this, notifikasi.class);
                startActivity(notifIntent);


            }
        });

     */

    }

    private void showRecyclerList(){

        // mengatur layout pada recyclerview
        rvDokter.setLayoutManager(new LinearLayoutManager(this));
        //mengirim ArrayList ke recyclerview
        final ListDokterAdapter listDokterAdapter = new ListDokterAdapter(listDokter);
        rvDokter.setAdapter(listDokterAdapter);

        listDokterAdapter.setOnItemClickCallback(new ListDokterAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Dokter data) {
                Intent konsulIntent = new Intent(DashboardActivity.this, PendaftaranKonsultasiActivity.class);
                konsulIntent.putExtra(PendaftaranKonsultasiActivity.EXTRA_NAMA_DOKTER, data.getNama());
                startActivity(konsulIntent);
                /*
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5);
                startActivity(moveWithDataIntent);

                 */
            }
        });


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