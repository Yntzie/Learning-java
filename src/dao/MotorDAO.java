package dao;

import interfaceDao.IKendaraanDAO;
import java.sql.Statement;
import model.Kendaraan;
import model.Motor;

public class MotorDAO extends KendaraanDAO implements IKendaraanDAO {

    public void insert(Motor M) {
        super.insert(M);
        insertNewRole(M);
    }

    public void insertNewRole(Motor K) {
        con = dbCon.makeConnection();

        String sql
                = "INSERT INTO `motor` (`id_kendaraan`, `jumlah_tak`) VALUES ('"
                + K.getId_kendaraan() + "', '" + K.getJumlah_tak() + "')";

        System.out.println("Adding Kendaraan...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Kendaraan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Kendaraan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void deleteOldRole(String id_kendaraan) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM mobil WHERE id_kendaraan = '" + id_kendaraan + "'";
        System.out.println("Deleting Motor...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Kendaraan " + id_kendaraan);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Kendaraan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    public void update(Kendaraan k, String id_kendaraan, int jumlah_tak) {
        Motor m = new Motor(jumlah_tak, k.getId_kendaraan(), k.getNama(), k.getJenis(), k.getHarga());
        if (cekPerubahanJenis("Motor", id_kendaraan)) {
            deleteOldRole(id_kendaraan);
            insertNewRole(m);
        } else {
            updateRole(k, id_kendaraan);
        }
        super.update(k, id_kendaraan);
    }

    public void updateRole(Kendaraan k, String id_kendaraan) {
        con = dbCon.makeConnection();

        String sql = "UPDATE motor SET jumlah_tak = '" + k.getSpecial() + "'"
            + " WHERE id_kendaraan = '" + id_kendaraan + "'";


        System.out.println("Updating Jenis Kendaraan...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Kendaraan " + id_kendaraan);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Kendaraan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}
