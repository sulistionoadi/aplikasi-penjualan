/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import training.java.penjualan.domain.Barang;
import training.java.penjualan.service.AppServiceSpring;

/**
 *
 * @author adi
 */

@Service("appService")
public class AppServiceSpringImpl implements AppServiceSpring{

    @Override
    public void save(Barang b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Barang getBarangById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Barang> getAllBarang(int start, int rows) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Long countBarang() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
