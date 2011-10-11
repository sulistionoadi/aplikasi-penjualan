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
public interface AppServiceSpring {
    public void save(Barang b);
    public Barang getBarangById(Long id);
    public List<Barang> getAllBarang(int start, int rows);
    public Long countBarang();
}
