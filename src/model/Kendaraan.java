package model;

public abstract class Kendaraan {
    private String id_kendaraan, nama, jenis;
    private float harga;
    
    public Kendaraan(String id_kendaraan, String nama, String jenis, float harga) {
        this.id_kendaraan = id_kendaraan;
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;
    }

    public Kendaraan(String nama, String jenis, float harga) {
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;
    }

    public Kendaraan(String id_kendaraan, String nama, String jenis) {
        this.id_kendaraan = id_kendaraan;
        this.nama = nama;
        this.jenis = jenis;
    }
    
    public void setId_kendaraan(String id_kendaraan){
        this.id_kendaraan = id_kendaraan;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setJenis(String jenis){
        this.jenis = jenis;
    }
    
    public void setHarga(float harga){
        this.harga = harga;
    }
    
    public String getId_kendaraan() {
        return id_kendaraan;
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getJenis(){
        return jenis;
    }
    
    public float getHarga(){
        return harga;
    }
    
    public String getString() {
        return id_kendaraan + " | " + nama + " | " + harga;
    }
    
    public abstract String getSpecial();
    
    @Override
    public String toString(){
        return getNama();
    }
}
