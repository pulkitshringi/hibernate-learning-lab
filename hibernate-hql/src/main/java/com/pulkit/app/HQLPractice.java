package com.pulkit.app;

import com.pulkit.entitiy.Fruits;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPractice {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClasses(Fruits.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // deleting fruits which are not equal to jamun
        int rowsUpdated = session.createMutationQuery("DELETE FROM Fruits WHERE fruitName!=: someFruitName").setParameter("someFruitName", "Jamun").executeUpdate();
        System.out.println("No of rows updated " + rowsUpdated);
        transaction.commit();

//        // updating single fruit
//        int rowsUpdated = session.createMutationQuery("UPDATE Fruits SET fruitName=: newName WHERE id = 2").setParameter("newName", "Jamun").executeUpdate();
//        System.out.println(rowsUpdated + "rows updated.");
//        transaction.commit();

//        // retrieving data ->
//        Query<Integer> query = session.createQuery("SELECT id FROM  Fruits where fruitName =: someFruitName", Integer.class); // we are giving entitiy name and not the table name
//        query.setParameter("someFruitName", "Apple");
//
//        List<Integer> l1 = query.list();
//        for(Integer fruit: l1){
//            System.out.println(fruit);
//        }
    }
}
