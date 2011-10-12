/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.java.penjualan.service.impl;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training.java.penjualan.domain.Barang;
import training.java.penjualan.domain.TrJualHeader;
import training.java.penjualan.service.AppServiceSpring;

/**
 *
 * @author adi
 */

@Service("appService")
@Transactional
public class AppServiceSpringImpl implements AppServiceSpring{
    
    @Autowired private SessionFactory sessionFactory;
    
    @Override
    public void save(Barang b) {
        sessionFactory.getCurrentSession().save(b);
    }

    @Override
    public Barang getBarangById(Long id) {
        return (Barang) sessionFactory.getCurrentSession()
                .createQuery("select b from Barang b where b.id = :id")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Barang> getAllBarang(Integer start, Integer rows) {
        if(start == null) start = 0;
        if(rows == null) rows = 20;
        
        return sessionFactory.getCurrentSession()
                .createQuery("select b from Barang b")
                .setFirstResult(start)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public Long countBarang() {
        return (Long) sessionFactory.getCurrentSession()
                .createQuery("select count(b) from Barang b")
                .uniqueResult();
    }

    @Override
    public void update(Barang b) {
        sessionFactory.getCurrentSession().update(b);
    }

    @Override
    public void delete(Barang b) {
        sessionFactory.getCurrentSession().delete(b);
    }

    @Override
    public void save(TrJualHeader header) {
        sessionFactory.getCurrentSession().save(header);
    }

    @Override
    public void update(TrJualHeader header) {
        sessionFactory.getCurrentSession().update(header);
    }

    @Override
    public void delete(TrJualHeader header) {
        sessionFactory.getCurrentSession().delete(header);
    }

    @Override
    public TrJualHeader getJualHeaderByNoFaktur(String noFaktur) {
        return (TrJualHeader) sessionFactory.getCurrentSession()
                .createQuery("select h from TrJualHeader h join fetch "
                + "h.penjualanDetails"
                + "where h.noFaktur = :noFaktur")
                .setParameter("noFaktur", noFaktur)
                .uniqueResult();
    }

    @Override
    public List<TrJualHeader> getAllJualHeader(Integer start, Integer rows) {
        List<TrJualHeader> result = sessionFactory.getCurrentSession()
                .createQuery("select h from TrJualHeader h")
                .list();
        
        for (TrJualHeader h : result) {
            Hibernate.initialize(h.getPenjualanDetails());
        }
        
        return result;
    }

    @Override
    public Long countTrJualHeader() {
        return (Long) sessionFactory.getCurrentSession()
                .createQuery("select count(h) from TrJualHeader h")
                .uniqueResult();
    }
    
}
