/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import training.java.penjualan.domain.Barang;
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
//        simpanBarang();
//        updateBarang();
        deleteBarang();
        listBarang();
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
}
