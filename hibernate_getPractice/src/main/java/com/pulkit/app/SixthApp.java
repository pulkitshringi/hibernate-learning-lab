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
        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Session session2 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();
        try{

//            Student student1 = session1.find(Student.class, 1);
//            System.out.println(student1);
            Student student = new Student();
            student.setsName("goodHealth");
            student.setScity("heaven");
            session1.persist(student);
        }
        catch (HibernateException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            transaction.commit();
        session1.close();
        session2.close();
        sessionFactory.close();
        }
    }
}
