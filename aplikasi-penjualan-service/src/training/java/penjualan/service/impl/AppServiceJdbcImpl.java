/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.service.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import training.java.penjualan.domain.Barang;
import training.java.penjualan.service.AppServiceJdbc;

/**
 *
 * @author adi
 */
public class AppServiceJdbcImpl implements AppServiceJdbc{
    
    private Connection connection;
    private PreparedStatement psInsert;
    private PreparedStatement psSelectAll;
    
    private final String sqlInsert = "insert into t_barang (kode_barang, nama_barang, harga) "
            + "values (?,?,?);";
    private final String sqlSelectAll = "select * from t_barang order by kode_barang";

    public AppServiceJdbcImpl(Connection connection) {
        try {
            this.connection = connection;
            psInsert = connection.prepareStatement(sqlInsert);
            psSelectAll = connection.prepareStatement(sqlSelectAll);
        } catch (SQLException ex) {
            Logger.getLogger(AppServiceJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void saveBarang(Barang barang) {
        try {
            psInsert.setString(1, barang.getKodeBarang());
            psInsert.setString(2, barang.getNamaBarang());
            psInsert.setBigDecimal(3, barang.getHarga());
            psInsert.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AppServiceJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Barang getBarangById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Barang> getAllBarang() {
        List<Barang> result = new ArrayList<Barang>();
        try {
            ResultSet rs = psSelectAll.executeQuery();
            while(rs.next()){
                Barang b = new Barang();
                b.setId(rs.getLong("id"));
                b.setKodeBarang(rs.getString("kode_barang"));
                b.setNamaBarang(rs.getString("nama_barang"));
                b.setHarga(rs.getBigDecimal("harga"));
                
                result.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppServiceJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
