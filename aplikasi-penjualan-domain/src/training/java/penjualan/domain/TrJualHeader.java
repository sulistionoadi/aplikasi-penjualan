/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author adi
 */

@Entity
@Table(name="tr_jual_header")
public class TrJualHeader {

    @Id
    @Column(name="no_faktur")
    private String noFaktur;
    
    @Column(name="tgl_faktur")
    @Temporal(TemporalType.DATE)
    private Date tglFaktur;
    
    @Column(name="nama_konsumen")
    private String namaKonsumen;
    
    @Column(name="total_jual")
    private BigDecimal totalJual = BigDecimal.ZERO;
    
    @OneToMany(mappedBy="header", cascade=CascadeType.ALL)
    private List<TrJualDetail> penjualanDetails = new ArrayList<TrJualDetail>();
    
    public void addDetailPenjualan(TrJualDetail tjd){
        penjualanDetails.add(tjd);
    }
    
    public void removeDetailPenjualan(TrJualDetail tjd){
        penjualanDetails.remove(tjd);
    }
    
    public void hitungTotalJual(){
        BigDecimal total = BigDecimal.ZERO;
        for (TrJualDetail tjd : penjualanDetails) {
            total = total.add(tjd.getTotal());
        }
        this.totalJual = total;
    }

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

    public List<TrJualDetail> getPenjualanDetails() {
        return penjualanDetails;
    }

    public void setPenjualanDetails(List<TrJualDetail> penjualanDetails) {
        this.penjualanDetails = penjualanDetails;
    }
    
    
    
}
