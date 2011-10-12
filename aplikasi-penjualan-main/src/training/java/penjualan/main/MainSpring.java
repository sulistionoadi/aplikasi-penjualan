/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import training.java.penjualan.domain.Barang;
import training.java.penjualan.domain.TrJualDetail;
import training.java.penjualan.domain.TrJualHeader;
import training.java.penjualan.service.AppServiceSpring;

/**
 *
 * @author adi
 */
public class MainSpring {
    private static ApplicationContext appContext;
    private static AppServiceSpring appService;
    
    public static void main(String[] args) {
        appContext = new ClassPathXmlApplicationContext("classpath:training/java/penjualan/config/applicationContext.xml");
        appService = (AppServiceSpring) appContext.getBean("appService");
        
        // Barang
        //simpanBarang();
        //updateBarang();
        //deleteBarang();
        //listBarang();
        
        // Penjualan
        simpanPenjualan();
    }
    
    private static void simpanBarang(){
        Barang b = new Barang();
        b.setKodeBarang("B003");
        b.setNamaBarang("Barang 003");
        b.setHarga(new BigDecimal(5000));
        
        appService.save(b);
    }
    
    private static void listBarang(){
        Integer start = 0;
        Integer rows = 1;
        Long count = appService.countBarang();
        List<Barang> listAll = new ArrayList<Barang>();
        
        while(start < count){
            List<Barang> barangs = appService.getAllBarang(start, rows);
            listAll.addAll(barangs);
            start += rows;
        }
        
        System.out.println("Jumlah Record : " + count);
        System.out.println("=======================\n");
        for (Barang b : listAll) {
            System.out.println("ID : " + b.getId());
            System.out.println("Kode : " + b.getKodeBarang());
            System.out.println("Nama : " + b.getNamaBarang());
            System.out.println("Harga : " + b.getHarga());
            System.out.println("---------------------------");
        }       
    }
    
    private static void updateBarang(){
        Barang b = appService.getBarangById(1L);
        b.setHarga(new BigDecimal(90900));
        b.setNamaBarang("Sabun Mandi");
        appService.update(b);
    }
    
    private static void deleteBarang(){
        Barang b = appService.getBarangById(2L);
        appService.delete(b);
    }
    
    private static void simpanPenjualan(){
        List<TrJualDetail> details = new ArrayList<TrJualDetail>();
        TrJualHeader header = new TrJualHeader();
        header.setNoFaktur("FP001");
        header.setNamaKonsumen("Adi");
        header.setTglFaktur(new Date());
        
        //membuat detail penjualan 1
        TrJualDetail d1 = new TrJualDetail();
        Barang b1 = appService.getBarangById(1L);
        d1.setBarang(b1);
        d1.setHeader(header);
        d1.setQty(4);
        d1.setHarga(b1.getHarga());
        d1.setTotal(new BigDecimal(d1.getQty()).multiply(d1.getHarga()));
        details.add(d1);
        
        //membuat detail penjualan 2
        TrJualDetail d2 = new TrJualDetail();
        Barang b2 = appService.getBarangById(3L);
        d2.setBarang(b2);
        d2.setHeader(header);
        d2.setQty(1);
        d2.setHarga(b2.getHarga());
        d2.setTotal(new BigDecimal(d2.getQty()).multiply(d2.getHarga()));
        details.add(d2);
        
        header.setPenjualanDetails(details);
        header.hitungTotalJual();
        
        appService.save(header);
    }
}
