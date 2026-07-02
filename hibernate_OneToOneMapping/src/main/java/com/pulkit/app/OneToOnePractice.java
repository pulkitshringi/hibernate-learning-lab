package com.pulkit.app;

import com.pulkit.entitiy.Passport;
import com.pulkit.entitiy.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOnePractice {
    public static void main() {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClasses(Passport.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Passport passport = new Passport();
        passport.setId(1);
        passport.setPassportNumber("ABC12345");

        Person person = new Person();
        person.setId(1);
        person.setName("pooki");
        person.setPassport(passport); // IMP
        passport.setPerson(person); // IMP

        session.persist(person);
        transaction.commit();
    }
}
