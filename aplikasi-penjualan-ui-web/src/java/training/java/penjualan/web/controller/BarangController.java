/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import training.java.penjualan.domain.Barang;
import training.java.penjualan.service.AppServiceSpring;

/**
 *
 * @author adi
 */

@Controller
public class BarangController {
    
    @Autowired private AppServiceSpring appService;
    
    @RequestMapping(value="/barang/form", method= RequestMethod.GET)
    public ModelMap formBarang(@RequestParam(value="id", required=false) Long id){
        Barang b = null;
        
        if(id==null){
            b = new Barang();
        } else {
            b = appService.getBarangById(id);
        }
        
        return new ModelMap(b);
    }
    
    @RequestMapping(value="/barang/form", method= RequestMethod.POST)
    public String saveBarang(Barang b, BindingResult result){
        Barang barangDb = appService.getBarangById(b.getId());
        if(barangDb ==null){
            appService.save(b);
        } else {
            appService.update(b);
        }
        return "redirect:list";
    }
    
    @RequestMapping("/barang/list")
    public ModelMap listBarang(){
        return new ModelMap(appService.getAllBarang(0, 100));
    }
    
    @RequestMapping("/barang/delete")
    public String deleteBarang(@RequestParam(value="id", required=true) Long id){
        Barang b = appService.getBarangById(id);
        appService.delete(b);
                
        return "redirect:list";
    }
    
    @RequestMapping(value="/barang/cetak", method= RequestMethod.GET)
    public ModelMap cetakDaftarBarang(@RequestParam(value="format", required=false) String format,
        HttpServletRequest request){
        
        Integer start = 0;
        Integer count = appService.countBarang().intValue();
        
        ModelMap mm = new ModelMap();
        mm.addAttribute("format", format);
        mm.addAttribute("daftarBarang", appService.getAllBarang(start, count));
        return mm;
        
    }
            
}
