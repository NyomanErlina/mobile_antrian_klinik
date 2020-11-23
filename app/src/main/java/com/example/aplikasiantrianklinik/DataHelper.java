package com.example.aplikasiantrianklinik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "antrian_klinik.db";
    private static final int DATABASE_VERSION = 2;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        String sql = "create table mahasiswa(no integer primary key, nama text null, tgl text null, jk text null, jurusan text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO mahasiswa (no, nama, tgl, jk, jurusan) VALUES ('1001', 'Haidar', '12-12-2002', 'Laki-laki','teknik sipil');";
        db.execSQL(sql);
        */

        //----- table dokter
        String sql_create_dokter = "CREATE TABLE dokter(id_dokter text primary key, nama_dokter text, email text, nomor_telepon text, " +
                "no_ktp integer, alamat text, instansi text, foto blob);";
        Log.d("Data", "onCreate: " + sql_create_dokter);
        db.execSQL(sql_create_dokter);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DataHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + "dokter");
        onCreate(db);
    }

    public ArrayList<Dokter> listDokter(){
        String sql = "SELECT * FROM dokter ORDER BY nama_dokter ";
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Dokter> storeDokter = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                String id = cursor.getString(0);
                String nama = cursor.getString(1);
                String email = cursor.getString(2);
                String no_telp = cursor.getString(3);
                int no_ktp= (Integer.parseInt(cursor.getString(4)));
                String alamat = cursor.getString(5);
                String instansi = cursor.getString(6);
                byte[] foto = cursor.getBlob(7);
                storeDokter.add(new Dokter(id, nama, email, no_telp, no_ktp, alamat, instansi, foto));
            }while (cursor.moveToNext());
        }
        db.close();
        return storeDokter;
    }



    public void addDokter(Dokter dokter) {

            ContentValues values = new ContentValues();
            values.put("id_dokter", dokter.getId());
            values.put("nama_dokter", dokter.getNama());
            values.put("email", dokter.getEmail());
            values.put("nomor_telepon", dokter.getNo_telp());
            values.put("no_ktp", dokter.getNo_ktp());
            values.put("alamat", dokter.getAlamat());
            values.put("instansi", dokter.getInstansi());
            values.put("foto", dokter.getFoto());

            // Inserting Row
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert("dokter", null, values);
            db.close(); // Closing database connection
    }

    public void updateDokter(Dokter dokter){
        ContentValues values = new ContentValues();
        values.put("id_dokter", dokter.getId());
        values.put("nama_dokter", dokter.getNama());
        values.put("email", dokter.getEmail());
        values.put("nomor_telepon", dokter.getNo_telp());
        values.put("no_ktp", dokter.getNo_ktp());
        values.put("alamat", dokter.getAlamat());
        values.put("instansi", dokter.getInstansi());
        values.put("foto", dokter.getFoto());

        SQLiteDatabase db = this.getWritableDatabase();
        db.update("dokter", values, "id_dokter"	+ "	= ?", new String[] {
                String.valueOf(dokter.getId())});
    }
/*
    public Dokter findDokter(String nama){
        String query = "Select * FROM dokter WHERE nama_dokter = " + nama;
        SQLiteDatabase db = this.getWritableDatabase();
        Dokter dokter= null;
        Cursor cursor = db.rawQuery(query,	null);
        if	(cursor.moveToFirst()){
            String id_dokter = cursor.getString(0);
            String nama_dokter = cursor.getString(1);
            dokter = new Dokter()

        }
        cursor.close();
        return dokter;
    }

    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, COLUMN_ID	+ "	= ?", new String[] { String.valueOf(id)});
    }

*/

}
