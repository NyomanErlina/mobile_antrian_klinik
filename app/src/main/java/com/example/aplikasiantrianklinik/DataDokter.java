package com.example.aplikasiantrianklinik;

import java.util.ArrayList;

public class DataDokter {
    private static String[] namaDokter = {
            "dr. Sabrina",
            "dr. Devi",
            "dr. Risky",
            "dr. Sintya",
            "dr. Ike Dewi",
            "dr. Surya"

    };

    private static int[] fotoDokter = {
            R.drawable.dokter1,
            R.drawable.dokter2,
            R.drawable.dokter3,
            R.drawable.dokter1,
            R.drawable.dokter2,
            R.drawable.dokter3
    };

    public static ArrayList<Dokter> getListDataDokter(){
        ArrayList<Dokter> list = new ArrayList<>();
        for (int position = 0; position < namaDokter.length; position++){
            Dokter dokter = new Dokter();
            dokter.setNama(namaDokter[position]);
            dokter.setFoto(fotoDokter[position]);
            list.add(dokter);
        }
        return list;
    }
}
