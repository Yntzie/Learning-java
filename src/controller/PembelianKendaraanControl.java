package controller;

import dao.PembelianDAO;
import java.util.List;
import model.PembelianKendaraan;
import table.TablePembelianKendaraan;

public class PembelianKendaraanControl {
    private PembelianDAO pkDao = new PembelianDAO();
    
    public void insertDataPembelianKendaraan(PembelianKendaraan pk)
    {
        pkDao.insert(pk);
    }
    
    public TablePembelianKendaraan showTable(String target)
    {
        List<PembelianKendaraan> dataPembelian = pkDao.showData(target);
        
        TablePembelianKendaraan tablePembelianKendaraan = new TablePembelianKendaraan(dataPembelian);
        
        for(PembelianKendaraan p : dataPembelian)
        {
            System.out.println(p.getKendaraan().getNama());
        }
        
        return tablePembelianKendaraan;
    }
    
    public void updatePembelianKendaraan(PembelianKendaraan pk, int no_resi)
    {
        pkDao.update(pk, Integer.toString(no_resi));
    }
    
    public void deletePembelianKendaraan(int no_resi)
    {
        pkDao.delete(Integer.toString(no_resi));
    }
    
    public double getTotalPendapatan(){
        return pkDao.getTotalPendapatan();
    }
}
