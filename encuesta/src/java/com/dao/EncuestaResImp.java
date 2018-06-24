/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.List;
import com.model.EncuestaRes;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author luis_
 */
public class EncuestaResImp implements EncuestaResDao{

    @Override
    public List<EncuestaRes> getAllEncuestaRes() {
        List<EncuestaRes> resultados = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT f FROM EncuestaRes f";
        
        try {
            resultados = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return resultados;
    }
    
}
