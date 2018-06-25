/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Usuarios;
import com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author luis_
 */
public class UsuariosImp implements UsuariosDao {
    @Override
    public List<Usuarios> getAllUsuarios() {
        List<Usuarios> usuarios = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Usuarios";
        
        try {
            usuarios = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return usuarios;
    }

    @Override
    public List<Usuarios> login(String user, String password) {
        List<Usuarios> usuarios = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Usuarios WHERE nombre=:user AND password=:password ";
        try {
            Query query = session.createQuery(hql);
            query.setString("user", user);
            query.setString("password", password);
            usuarios = query.list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return usuarios;
    }
}
