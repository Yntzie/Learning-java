package dao;

import connection.DbConnection;
import interfaceDao.IDAO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;
import model.*;

public class PembelianDAO implements IDAO<PembelianKendaraan, String>{
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    @Override
    public void insert(PembelianKendaraan pk)
    {
        con = dbCon.makeConnection();
        
       String sql = "INSERT INTO `pembelian_kendaraan` " +
             "(`id_customer`, `id_kendaraan`, `id_layanan`, `jumlah`, `tambahan`, `metode_pembayaran`) " +
             "VALUES ('" + pk.getId_customer() + "', '" + pk.getId_kendaraan() + "', '" + pk.getId_layanan() + "', " +
             pk.getJumlah() + ", '" + pk.getTambahan() + "', '" + pk.getMetode_pembayaran() + "')";
        
        System.out.println("Adding Pembelian...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            
            System.out.println("Added " + result + " Pembelian");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding pembelian...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    
    @Override
    public List<PembelianKendaraan> showData(String query)
    {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * " +
                "FROM pembelian_kendaraan PK " +
                "JOIN customer C ON (PK.id_customer = C.id_customer) " +
                "JOIN kendaraan K ON (PK.id_kendaraan = K.id_kendaraan) " +
                "JOIN layanan_servis L ON (PK.id_layanan = L.id_layanan) " +
                "WHERE (C.nama LIKE '%" + query + "%' " +
                "OR K.nama LIKE '%" + query + "%' " +
                "OR PK.tambahan LIKE '%" + query + "%' " +
                "OR PK.metode_pembayaran LIKE '%" + query + "%' " +
                "OR L.nama_layanan LIKE '%" + query + "%')";

        
        System.out.println("Mengambil data pembelian kendaraan...");
        List<PembelianKendaraan> listPembelian = new ArrayList<>();
        Kendaraan k = null;
        
        
        try {
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
            {
                while(rs.next())
                {
                    //objek untuk customer
                    Customer c = new Customer(
                                    rs.getInt("C.id_customer"),
                                    rs.getString("C.nama"), 
                                    rs.getString("C.alamat"),
                                    rs.getString("C.no_telepon"));
                    
                    // Buat objek Kendaraan (Mobil/Motor)
                    if(rs.getString("jenis").equals("Motor"))
                    {
                        k = new Motor(
                            rs.getString("K.id_kendaraan"),
                            rs.getString("K.nama"),
                            rs.getString("K.jenis"));
                    }
                    else
                    {   
                        k = new Mobil(
                            rs.getString("K.id_kendaraan"),
                            rs.getString("K.nama"),
                            rs.getString("K.jenis"));
                    }
                    
                    // Buat objek LayananServis
                    LayananServis l = new LayananServis(
                        rs.getInt("id_layanan"),
                        rs.getString("nama_layanan"),
                        rs.getFloat("biaya"),
                        rs.getString("waktu")
                    );
                    
                    // Buat objek PembelianKendaraan
                    PembelianKendaraan PK = new PembelianKendaraan(
                        rs.getInt("id_customer"),
                        rs.getInt("jumlah"),
                        rs.getInt("no_resi"),
                        rs.getString("id_kendaraan"),
                        rs.getInt("id_layanan"),
                        rs.getString("tambahan"),
                        rs.getString("metode_pembayaran"),
                        c, k, l
                    );

                    listPembelian.add(PK);
                }
                
                rs.close();
                statement.close();
            }
        } catch (Exception e) {
            System.out.println("Error Fetching Data...");
            System.out.println(e);
        }
        
        System.out.println("Berhasil");
        dbCon.closeConnection();
        
        
        return listPembelian;
    }
    
    
    @Override
    public void update(PembelianKendaraan pk, String no_resi)
    {
        con = dbCon.makeConnection();
        
        String sql = "UPDATE pembelian_kendaraan SET " +
             "id_customer = '" + pk.getId_customer() + "', " +
             "id_kendaraan = '" + pk.getId_kendaraan() + "', " +
             "id_layanan = '" + pk.getId_layanan() + "', " +
             "jumlah = " + pk.getJumlah() + ", " +
             "tambahan = '" + pk.getTambahan() + "', " +
             "metode_pembayaran = '" + pk.getMetode_pembayaran() + "' " +
             "WHERE no_resi = " + no_resi;

        
        System.out.println("Editing Pembelian Kendaraan...");
        
        try
        {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            
            System.out.println("Edited " + result + " Pembelian " + no_resi);
            
            statement.close();
            
        }catch(Exception e)
        {
            System.out.println("Error Updating Pembelian...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    @Override
    public void delete(String no_resi)
    {
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM pembelian_kendaraan " +
                "WHERE no_resi = " + no_resi + "";
        
        System.out.println("Deleting Pembelian Kendaraan...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            
            System.out.println("Delete " + result + " Pembelian " + no_resi);
            
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Pembelian...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        
    }
    
    @Override
    public PembelianKendaraan search(String data)
    {
        return null;
    }
    
    public double getTotalPendapatan() {
        con = dbCon.makeConnection();
        double total = 0;

        String sql = "SELECT SUM(PK.jumlah * L.biaya) AS total_pendapatan " +
                     "FROM pembelian_kendaraan PK " +
                     "JOIN layanan_servis L ON PK.id_layanan = L.id_layanan";

        System.out.println("Menghitung total pendapatan...");

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next()) {
                total = rs.getDouble("total_pendapatan");
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error menghitung total pendapatan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
        return total;
    }
}
