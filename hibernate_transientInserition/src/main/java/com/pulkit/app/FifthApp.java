// com/pulkit/app/FifthApp.java
package com.pulkit.app;

import com.pulkit.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FifthApp {
    public static void main() {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean flag = false;
        try{
            transaction = session.beginTransaction();
            Employee obj = new Employee();
            obj.seteId(1);
            obj.seteName("pulkit");
            obj.seteCity("Bangalore");
            obj.setAge(23);
            session.persist(obj);
            flag = true;
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(flag){
                transaction.commit();
            }
            else{
                transaction.rollback();
            }
        session.close();
        sessionFactory.close();
        }
    }
}
