/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.domain;

import java.math.BigDecimal;

/**
 *
 * @author adi
 */
public class TrJualDetail {
    private TrJualHeader header;
    private Barang barang;
    private Integer qty;
    private BigDecimal harga;
    private BigDecimal total;

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public TrJualHeader getHeader() {
        return header;
    }

    public void setHeader(TrJualHeader header) {
        this.header = header;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    
}
