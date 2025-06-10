package controller;

import dao.LayananDAO;
import java.util.List;
import model.LayananServis;

public class LayananControl {
    private LayananDAO lDao = new LayananDAO();
    
    public void insertDataLayanan(LayananServis l) {
        lDao.insert(l);
    }
    
    public String showAllStringLayanan() {
        List<LayananServis> listC = lDao.showData(0);
        String layananString = " ";
        int i = 0;

        for(LayananServis c : listC) {
            i++;
            layananString += c.getIdLayanan()+ ".  " + c.getNamaLayanan()+ " | " + c.getBiaya()+ " | " + c.getWaktu()+ "\n";
        }
        return layananString;
    }
    
    public LayananServis searchLayananById(int id_layanan) {
        return lDao.search(id_layanan);
    }
    
    public void updateDataLayanan(LayananServis c, int id_layanan) {
        lDao.update(c, id_layanan);
    }
    
    public void deleteDataLayanan(int id_layanan) {
        lDao.delete(id_layanan);
    }
    
    public List<LayananServis> showListLayanan()
    {
        List<LayananServis> dataLayanan = lDao.IShowForDropdown();
        
        return dataLayanan;
    }
    
}
