/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.service;

import java.util.List;
import training.java.penjualan.domain.Barang;
import training.java.penjualan.domain.TrJualHeader;

/**
 *
 * @author adi
 */
public interface AppServiceSpring {
    public void save(Barang b);
    public void update(Barang b);
    public void delete(Barang b);
    public Barang getBarangById(Long id);
    public List<Barang> getAllBarang(Integer start, Integer rows);
    public Long countBarang();
    
    public void save(TrJualHeader header);
    public void update(TrJualHeader header);
    public void delete(TrJualHeader header);
    public TrJualHeader getJualHeaderByNoFaktur(String noFaktur);
    public List<TrJualHeader> getAllJualHeader(Integer start, Integer rows);
    public Long countTrJualHeader();
}
