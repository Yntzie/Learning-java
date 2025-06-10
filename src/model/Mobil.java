package model;

public class Mobil extends Kendaraan {
    private String jenis_mesin;
    
    public Mobil(String jenis_mesin, String nama, String jenis, float harga) {
        super(nama, "Mobil", harga);
        this.jenis_mesin = jenis_mesin;
    }
    
    public Mobil(String jenis_mesin, String id_kendraaan, String nama, String jenis, float harga) {
        super(id_kendraaan, nama, "Mobil", harga);
        this.jenis_mesin = jenis_mesin;
    }
    
    public Mobil(String id_kendaraan, String nama, String jenis){
        super(id_kendaraan, nama, "Mobil");
    }
    
    public String getJenis_mesin() {
        return jenis_mesin;
    }
    
    public String getString(){
        return super.getString() + " | " + jenis_mesin;
    }

    @Override
    public String getSpecial() {
        return jenis_mesin;
    }
    
}
