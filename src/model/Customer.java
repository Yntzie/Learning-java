package model;

public class Customer {
     private int id_customer;
    private String nama;
    private String alamat;
    private String no_telepon;
    
    public Customer(String nama, String alamat, String no_telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
    }
    
    public Customer(int id_customer, String nama, String alamat, String no_telepon) {
        this.id_customer = id_customer;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public int getId_customer() {
        return id_customer;
    }
    
    public String getNama() {  
        return nama;
    }

    public String getNo_telepon() {
        return no_telepon;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setNo_telepon(String no_telepon){
        this.no_telepon = no_telepon;
    }
    
     @Override
    public String toString(){
        return getNama();
    }
    
}
