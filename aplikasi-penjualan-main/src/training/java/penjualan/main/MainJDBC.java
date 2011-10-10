/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import training.java.penjualan.domain.Barang;
import training.java.penjualan.service.AppServiceJdbc;
import training.java.penjualan.service.impl.AppServiceJdbcImpl;

/**
 *
 * @author adi
 */
public class MainJDBC {

    /**
     * @param args the command line arguments
     */
    private static Connection conn;
    private static AppServiceJdbc appService;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost/trainingdb";
    private static final String username = "root";
    private static final String password = "admin";
    
    public static void main(String[] args) {
        initConnection();
        //simpanBarang();
        getAllBarang();
    }
    
    public static void initConnection(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            appService = new AppServiceJdbcImpl(conn);
        } catch (SQLException ex) {
            Logger.getLogger(MainJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void simpanBarang(){
        Barang b = new Barang();
        b.setKodeBarang("B-001");
        b.setNamaBarang("LIFEBOY");
        b.setHarga(new BigDecimal(2500));
        
        appService.saveBarang(b);
    }
    
    public static void getAllBarang(){
        List<Barang> listbaBarangs = appService.getAllBarang();
        System.out.println("Jumlah Record : " + listbaBarangs.size());
        
        for (Barang b : listbaBarangs) {
            System.out.println("\n====" + b.getId() + " ====");
            System.out.println("Kode Barang : " + b.getKodeBarang());
            System.out.println("Nama Barang : " + b.getNamaBarang());
            System.out.println("Harga : " + b.getHarga());
        }
    }
}
