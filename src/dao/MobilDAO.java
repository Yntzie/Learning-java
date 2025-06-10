package dao;

import interfaceDao.IKendaraanDAO;
import java.sql.Statement;
import model.Kendaraan;
import model.Mobil;

public class MobilDAO extends KendaraanDAO implements IKendaraanDAO {

    public void insert(Mobil mbl) {
        super.insert(mbl);
        insertNewRole(mbl);
    }

    public void insertNewRole(Mobil mbl) {
        con = dbCon.makeConnection();

        String sql
                = "INSERT INTO `mobil` (`id_kendaraan`, `jenis_mesin`) VALUES ('"
                + mbl.getId_kendaraan() + "', '" + mbl.getJenis_mesin() + "')";

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
        String sql = "DELETE FROM motor WHERE id_kendaraan = '" + id_kendaraan + "'";
        System.out.println("Deleting Mobil...");

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

    public void update(Kendaraan k, String id_kendaraan, String jenis_mesin) {
        Mobil m = new Mobil(jenis_mesin, k.getId_kendaraan(), k.getNama(), k.getJenis(), k.getHarga());
        if (cekPerubahanJenis("Mobil", id_kendaraan)) {
            deleteOldRole(id_kendaraan);
            insertNewRole(m);
        } else {
            updateRole(k, id_kendaraan);
        }
        super.update(k, id_kendaraan);
    }

    public void updateRole(Kendaraan k, String id_kendaraan) {
        con = dbCon.makeConnection();

        String sql = "UPDATE mobil SET jenis_mesin = '"
                + k.getSpecial()
                + "' WHERE id_kendaraan = '"
                + id_kendaraan
                + "'";
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
