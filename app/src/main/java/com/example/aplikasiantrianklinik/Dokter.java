package com.example.aplikasiantrianklinik;

public class Dokter {
    private String id;
    private String nama;
    private String email;
    private String no_telp;
    private int no_ktp;
    private String alamat;
    private String instansi;
    private byte[] foto;

    public Dokter(String id, String nama, String email, String no_telp, int no_ktp, String alamat, String instansi, byte[] foto) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.no_telp = no_telp;
        this.no_ktp = no_ktp;
        this.alamat = alamat;
        this.instansi = instansi;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public int getNo_ktp() {
        return no_ktp;
    }

    public void setNo_ktp(int no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }









}
