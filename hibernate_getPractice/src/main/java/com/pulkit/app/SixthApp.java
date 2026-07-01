// com/pulkit/app/SixthApp.java
package com.pulkit.app;

import com.pulkit.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SixthApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Session session2 = sessionFactory.openSession();
        try{

            Student student1 = session1.find(Student.class, 1);
            System.out.println(student1);
            Student student2 = session2.find(Student.class, 1);
            System.out.println(student2);
        }
        catch (HibernateException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        session1.close();
        session2.close();
        sessionFactory.close();
        }
    }
}
