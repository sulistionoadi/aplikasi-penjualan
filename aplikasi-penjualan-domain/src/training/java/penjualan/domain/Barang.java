/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author adi
 */
@Entity
@Table(name="t_barang")
public class Barang {

    @Id @GeneratedValue
    private Long id;
    
    @Column(name="kode_barang", length=8, unique=true)
    private String kodeBarang;
    
    @Column(name="nama_barang", length=50)
    private String namaBarang;
    
    @Column(name="harga")
    private BigDecimal harga;

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
    
    
}
