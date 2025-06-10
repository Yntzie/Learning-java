package dao;

import connection.DbConnection;
import interfaceDao.IDAO;
import interfaceDao.IShowForDropdown;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.LayananServis;

public class LayananDAO implements IDAO<LayananServis, Integer>, IShowForDropdown<LayananServis> {
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;

    @Override
    public void insert(LayananServis l) {
        con = dbCon.makeConnection();

        String sql = "INSERT INTO layanan_servis (nama_layanan, biaya, waktu) " +
                     "VALUES ('" + l.getNamaLayanan() + "', " + l.getBiaya() + ", '" + l.getWaktu() + "')";

        System.out.println("Adding LayananServis...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " LayananServis");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding LayananServis...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public List<LayananServis> showData(Integer data) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM layanan_servis";
        System.out.println("Fetching LayananServis Data...");

        List<LayananServis> list = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                list.add(new LayananServis(
                    rs.getInt("id_layanan"),
                    rs.getString("nama_layanan"),
                    rs.getFloat("biaya"),
                    rs.getString("waktu")
                ));
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error fetching LayananServis data...");
            System.out.println(e);
        }

        dbCon.closeConnection();
        return list;
    }

    @Override
    public void update(LayananServis l, Integer id_layanan) {
        con = dbCon.makeConnection();

        String sql = "UPDATE layanan_servis SET " +
                     "nama_layanan = '" + l.getNamaLayanan() + "', " +
                     "biaya = " + l.getBiaya() + ", " +
                     "waktu = '" + l.getWaktu() + "' " +
                     "WHERE id_layanan = " + id_layanan;

        System.out.println("Updating LayananServis...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Updated " + result + " LayananServis");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error updating LayananServis...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public void delete(Integer id_layanan) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM layanan_servis WHERE id_layanan = " + id_layanan;

        System.out.println("Deleting LayananServis...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " LayananServis");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting LayananServis...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public LayananServis search(Integer id_layanan) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM layanan_servis WHERE id_layanan = " + id_layanan;

        System.out.println("Searching LayananServis...");
        LayananServis l = null;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                l = new LayananServis(
                    rs.getInt("id_layanan"),
                    rs.getString("nama_layanan"),
                    rs.getFloat("biaya"),
                    rs.getString("waktu")
                );
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error fetching LayananServis...");
            System.out.println(e);
        }

        dbCon.closeConnection();
        return l;
    }

    @Override
    public List<LayananServis> IShowForDropdown() {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM layanan_servis";

        System.out.println("Fetching LayananServis for dropdown...");
        List<LayananServis> list = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                list.add(new LayananServis(
                    rs.getInt("id_layanan"),
                    rs.getString("nama_layanan"),
                    rs.getFloat("biaya"),
                    rs.getString("waktu")
                ));
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error fetching LayananServis for dropdown...");
            System.out.println(e);
        }

        dbCon.closeConnection();
        return list;
    }
}
