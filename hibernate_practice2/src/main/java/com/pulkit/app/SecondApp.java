// com/pulkit/app/SecondApp.java
package com.pulkit.app;

import com.pulkit.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SecondApp {
    public static void main() {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Student obj = new Student();
        obj.setsId(2);
        obj.setsName("pookiShringi");
        obj.setsCity("Kota");


        boolean flag = false;

        try {
            // Step 5: Begin transaction (required for Non-SELECT operations)
            transaction = session.beginTransaction();
            // saving data in table
            session.persist(obj);
            flag = true;
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            // committing the transaction
            if (flag) {
                transaction.commit();
            } else {
                transaction.rollback();
            }
            session.close();
            sessionFactory.close();
            System.out.println("Data inseretd successfully.");
        }

    }
}
