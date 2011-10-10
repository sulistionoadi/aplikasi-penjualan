/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.service;

import java.util.List;
import training.java.penjualan.domain.Barang;

/**
 *
 * @author adi
 */
public interface AppServiceJdbc {
    
    public void saveBarang(Barang barang);
    public Barang getBarangById(Long id);
    public List<Barang> getAllBarang();
}
