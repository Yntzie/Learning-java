package model;

public class PembelianKendaraan {
    private int id_customer, jumlah, no_resi, id_layanan;
    private String id_kendaraan, tambahan, metode_pembayaran;
    private Customer customer;
    private Kendaraan kendaraan;
    private LayananServis layanan;

    public PembelianKendaraan(int id_customer, int jumlah, int no_resi, String id_kendaraan, int id_layanan, String tambahan, String metode_pembayaran, Customer customer, Kendaraan kendaraan, LayananServis layanan) {
        this.id_customer = id_customer;
        this.jumlah = jumlah;
        this.no_resi = no_resi;
        this.id_kendaraan = id_kendaraan;
        this.id_layanan = id_layanan;
        this.tambahan = tambahan;
        this.metode_pembayaran = metode_pembayaran;
        this.customer = customer;
        this.kendaraan = kendaraan;
        this.layanan = layanan;
    }

public PembelianKendaraan(int id_customer, int jumlah, String id_kendaraan, int id_layanan,
                               String tambahan, String metode_pembayaran, Customer customer, Kendaraan kendaraan, LayananServis layanan) {
        this.id_customer = id_customer;
        this.jumlah = jumlah;
        this.id_kendaraan = id_kendaraan;
        this.id_layanan = id_layanan;
        this.tambahan = tambahan;
        this.metode_pembayaran = metode_pembayaran;
        this.customer = customer;
        this.kendaraan = kendaraan;
        this.layanan = layanan;
    }

    public int getId_layanan() {
        return id_layanan;
    }

    public LayananServis getLayanan() {
        return layanan;
    }

    public void setId_layanan(int id_layanan) {
        this.id_layanan = id_layanan;
    }

    public void setLayanan(LayananServis layanan) {
        this.layanan = layanan;
    }
    

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getNo_resi() {
        return no_resi;
    }

    public void setNo_resi(int no_resi) {
        this.no_resi = no_resi;
    }

    public String getId_kendaraan() {
        return id_kendaraan;
    }

    public void setId_kendaraan(String id_kendaraan) {
        this.id_kendaraan = id_kendaraan;
    }

    public String getTambahan() {
        return tambahan;
    }

    public void setTambahan(String tambahan) {
        this.tambahan = tambahan;
    }

    public String getMetode_pembayaran() {
        return metode_pembayaran;
    }

    public void setMetode_pembayaran(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }
}
