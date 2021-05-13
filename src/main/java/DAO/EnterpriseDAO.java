package DAO;

import model.Enterprise;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EnterpriseDAO {
    public Enterprise findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Enterprise.class, id);
    }

    public void save(Enterprise enterprise) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(enterprise);
        tx1.commit();
        session.close();
    }

    public void update(Enterprise enterprise) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(enterprise);
        tx1.commit();
        session.close();
    }

    public void delete(Enterprise enterprise) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(enterprise);
        tx1.commit();
        session.close();
    }


    public List<Enterprise> findAll() {
        return (List<Enterprise>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Enterprise").list();
    }
}
