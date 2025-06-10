package controller;

import dao.MotorDAO;
import java.util.List;
import model.Kendaraan;
import model.Motor;

public class MotorControl {
    private MotorDAO mDao = new MotorDAO();
    
    public void insertDataKendaraan(Motor mtr) {
        mtr.setId_kendaraan("K" + mDao.generateId());
        mDao.insert(mtr);
    }
    
    public String showStringKendaraan() {
        List<Kendaraan> listK = mDao.showData("Motor");
        String kendaraanString = " ";
        for(Kendaraan k : listK) {
            kendaraanString += k.getString() + "\n";
        }
        return kendaraanString;
    }
    
    public void updateDataKendaraan(Motor K) {
        mDao.update(K, K.getId_kendaraan(), K.getJumlah_tak());
    }
    
}
