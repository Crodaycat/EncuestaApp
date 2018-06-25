/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.List;
import com.model.EncuestaRes;
import com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
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
        String hql = "FROM EncuestaRes";
        
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
    
    @Override
    public boolean add (EncuestaRes encuesta) {
        Session session = null;        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(encuesta);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public long total() {
        long count = 0;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            count = (long)session.createQuery("SELECT count(*) FROM EncuestaRes").uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
            return count;
        }
    }

    @Override
    public long edadBebida() {
        long count = 0;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            Query query = session.createQuery("SELECT count(*) FROM EncuestaRes WHERE edad>=:min AND edad<=:max AND bebida=:drink");
            query.setInteger("min", 20);
            query.setInteger("max", 30);
            query.setString("drink", "Gaseosa");
            count = (long)query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
            return count;
        }
    }

    @Override
    public String programaMenos() {
        String resultado = "";
        long sistemasCount = 0;
        long telecoCount = 0;
        long industrialCount = 0;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            Query query = session.createQuery("SELECT count(programa) FROM EncuestaRes WHERE programa=:programa");
            
            query.setString("programa", "Ingeniería de sistemas");
            sistemasCount = (long)query.uniqueResult();
            query.setString("programa", "Ingeniería de Telecomunicaciones");
            telecoCount = (long)query.uniqueResult();
            query.setString("programa", "Ingeniería industrial");
            industrialCount = (long)query.uniqueResult();
            
            if (sistemasCount == industrialCount && industrialCount == telecoCount) {
                resultado = "Todos tiene " + sistemasCount + " registros.";
            } else if (sistemasCount < industrialCount && sistemasCount < telecoCount) {
                resultado = "Ingeniería de sistemas " + sistemasCount + " registros.";
            } else if (industrialCount < sistemasCount && industrialCount < telecoCount) {
                resultado = "Ingeniería industrial " + industrialCount + " registros.";
            } else if (telecoCount < sistemasCount && telecoCount < industrialCount) {
                resultado = "Ingeniería de Telecomunicaciones " + telecoCount + " registros.";
            } else if (sistemasCount == telecoCount && sistemasCount < industrialCount) {
                resultado = "Ingeniería de sistemas y Ingeniería de Telecomunicaciones " + telecoCount + " registros.";
            } else if (sistemasCount == industrialCount && sistemasCount < telecoCount) {
                resultado = "Ingeniería de sistemas y Ingeniería industrial " + sistemasCount + " registros.";
            } else if (telecoCount == industrialCount && telecoCount < sistemasCount) {
                resultado = "Ingeniería de Telecomunicaciones y Ingeniería industrial " + industrialCount + " registros.";
            }            
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
            return resultado;
        }
    }

    @Override
    public String proporcion() {
        String resultado = "";
        long mujeresTotal = 0;
        long hombresTotal = 0;
        long mujeres = 0;
        long hombres = 0;
                
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            Query query = session.createQuery("SELECT count(genero) FROM EncuestaRes WHERE genero=:genero");
            
            query.setString("genero", "Mujer");
            mujeresTotal = (long)query.uniqueResult();
            query.setString("genero", "Hombre");
            hombresTotal = (long)query.uniqueResult();
            
            query = session.createQuery("SELECT count(genero) FROM EncuestaRes WHERE genero=:genero AND bebida=:bebida");
            query.setString("genero", "Mujer");
            query.setString("bebida", "Agua de panela");
            mujeres = (long)query.uniqueResult();
            query = session.createQuery("SELECT count(genero) FROM EncuestaRes WHERE genero=:genero AND bebida=:bebida");
            query.setString("genero", "Hombre");
            query.setString("bebida", "Agua de panela");
            hombres = (long)query.uniqueResult();
            
            resultado = mujeres + " de cada " + mujeresTotal + " mujeres y " + hombres + " de cada " + hombresTotal + " hombres prefieren agua de panela.";
            
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
            return resultado;
        }
    }
    
}
