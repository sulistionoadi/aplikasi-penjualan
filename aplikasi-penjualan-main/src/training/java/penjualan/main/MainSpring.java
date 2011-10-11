/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
    }
}
