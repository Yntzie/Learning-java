package model;

public class LayananServis {
    private int idLayanan;
    private String namaLayanan;
    private float biaya;
    private String waktu;

    public LayananServis(int idLayanan, String namaLayanan, float biaya, String waktu) {
        this.idLayanan = idLayanan;
        this.namaLayanan = namaLayanan;
        this.biaya = biaya;
        this.waktu = waktu;
    }

    public LayananServis(String namaLayanan, float biaya, String waktu) {
        this.namaLayanan = namaLayanan;
        this.biaya = biaya;
        this.waktu = waktu;
    }

    public int getIdLayanan() {
        return idLayanan;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public float getBiaya() {
        return biaya;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setIdLayanan(int idLayanan) {
        this.idLayanan = idLayanan;
    }

    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }

    public void setBiaya(float biaya) {
        this.biaya = biaya;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
    
    @Override
    public String toString() {
        return namaLayanan + " - Rp " + biaya + " (" + waktu + ")";
    }
    
}
