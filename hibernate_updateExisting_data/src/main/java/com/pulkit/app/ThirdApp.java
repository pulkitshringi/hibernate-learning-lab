// com/pulkit/app/ThirdApp.java
package com.pulkit.app;

import com.pulkit.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ThirdApp {
    public static void main() {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        boolean flag = false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();

            Student student = new Student();
            student.setSid(3);
            student.setScity("Suwas");
            student.setsName("Sophy");

            session.merge(student);
            flag = true;

        }
        catch (HibernateException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(flag) {
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
