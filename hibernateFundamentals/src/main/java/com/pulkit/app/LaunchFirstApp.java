// com/pulkit/app/LaunchFirstApp.java
package com.pulkit.app;

import com.pulkit.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchFirstApp {
    public static void main() {
        // Step 1: Configuration Object
        Configuration config= new Configuration();
        // Step 2: link hibernate.cfg.xml file to Configuration object
        config.configure();
        // Step 3: creating SessionFactory object
        SessionFactory sessionFactory = config.buildSessionFactory();
        // Step 4: get the session Object from Session Factory
        Session session = sessionFactory.openSession();
        // Step 5: Begin transaction (required for Non-SELECT operations)
        Transaction transaction = session.beginTransaction();
        // Step 6: Saving the entitiy obj in database
        Student obj = new Student();
        obj.setsId(1);
        obj.setsName("HariKumarShringi");
        obj.setsCity("Kota");
        session.persist(obj);
        transaction.commit();

        session.close();
        sessionFactory.close();
        System.out.println("Data inseretd successfully.");
    }
}
