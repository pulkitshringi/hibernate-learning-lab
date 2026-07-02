package com.pulkit.app;

import com.pulkit.entity.Employees;
import com.pulkit.entity.ITDepartment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MappingExampleAgain {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employees.class).addAnnotatedClass(ITDepartment.class).buildSessionFactory();
        Session sesson = sessionFactory.openSession();
        Employees e1 = sesson.find(Employees.class, 1);
        System.out.println("employee id " + e1.getId());
        System.out.println("name " + e1.getEmployeeName());
        System.out.println("department " + e1.getItDepartment().getDepartmentName());
        System.out.println();
        // because it's bidirectional ->
        ITDepartment itDepartment = sesson.find(ITDepartment.class, 1);
        System.out.println("department id " + itDepartment.getId());
        itDepartment.getEmployees_list().forEach(x -> System.out.println("Employee Name: " + x.getEmployeeName()));


//        Transaction transaction = sesson.beginTransaction();
//
//        ITDepartment itDepartment = new ITDepartment();
//        itDepartment.setId(1);
//        itDepartment.setDepartmentName("Developers");
//
//        Employees employee1 = new Employees();
//        employee1.setId(1);
//        employee1.setEmployeeName("pooki");
//
//        Employees employee2 = new Employees();
//        employee2.setId(2);
//        employee2.setEmployeeName("mitu");
//        // storing department in employee
//        employee1.setItDepartment(itDepartment);
//        employee2.setItDepartment(itDepartment);
//
//        // storing employees in department now
//        List<Employees> l1 = new ArrayList<>();
//        l1.add(employee1);
//        l1.add(employee2);
//        itDepartment.setEmployees_list(l1);
//
//        sesson.persist(itDepartment);
//        transaction.commit();


    }
}
