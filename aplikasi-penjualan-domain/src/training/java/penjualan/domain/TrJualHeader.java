/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author adi
 */
public class TrJualHeader {

    private String noFaktur;
    private Date tglFaktur;
    private String namaKonsumen;
    private BigDecimal totalJual;

    public String getNamaKonsumen() {
        return namaKonsumen;
    }

    public void setNamaKonsumen(String namaKonsumen) {
        this.namaKonsumen = namaKonsumen;
    }

    public String getNoFaktur() {
        return noFaktur;
    }

    public void setNoFaktur(String noFaktur) {
        this.noFaktur = noFaktur;
    }

    public Date getTglFaktur() {
        return tglFaktur;
    }

    public void setTglFaktur(Date tglFaktur) {
        this.tglFaktur = tglFaktur;
    }

    public BigDecimal getTotalJual() {
        return totalJual;
    }

    public void setTotalJual(BigDecimal totalJual) {
        this.totalJual = totalJual;
    }
    
    
}
