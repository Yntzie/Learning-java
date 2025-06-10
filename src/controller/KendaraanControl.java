package controller;

import dao.KendaraanDAO;
import java.util.List;
import model.Kendaraan;

public class KendaraanControl {
    private KendaraanDAO kDao = new KendaraanDAO();
    
    public String generateId() {
        return "K" + kDao.generateId();
    }
    
    public Kendaraan searchDataKendaraan(String id) {
        return kDao.search(id);
    }
    
    public void deleteDataKendaraan(String id) {
        kDao.delete(id);
    }
    
    public List<Kendaraan> showListKendaraan()
    {
        List<Kendaraan> dataKendaraan = kDao.IShowForDropdown();
        
        return dataKendaraan;
    }
    
}
