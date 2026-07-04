package com.pulkit.app;

import com.pulkit.entitiy.Courses;
import com.pulkit.entitiy.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class FinalMapping {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Courses.class).addAnnotatedClass(Student.class).configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // basic students details
        Student stu1 = new Student();
        stu1.setsId(1);
        stu1.setName("pooki");

        Student stu2 = new Student();
        stu2.setsId(2);
        stu2.setName("mitu");

        // basic Courses details
        Courses cour1 = new Courses();
        cour1.setcId(1);
        cour1.setCourseName("Maths");

        Courses cour2 = new Courses();
        cour2.setcId(2);
        cour2.setCourseName("Computer science");

        // storing courses in Students
        List<Courses> l1 = new ArrayList<>();
        l1.add(cour1);
        l1.add(cour2);
        stu1.setCoursesList(l1);
        List<Courses> l2 = new ArrayList<>();
        l2.add(cour2);
        stu2.setCoursesList(l2);

        // Optional (for bidirectional consistency)
        // storing students in courses
        List<Student> s1 = new ArrayList<>();
        s1.add(stu1);
        s1.add(stu2);
        cour1.setStudentList(s1);

        session.persist(stu1);
        session.persist(stu2);
        transaction.commit();
//        // getting back data ->
//        Student stu1 = session.find(Student.class, 1);
//        Courses cour1 = session.find(Courses.class, 1);
//
//        // printing student
//        System.out.println("student name " + stu1.getName());
//        System.out.println("printing student course details : ");
//        stu1.getCoursesList().forEach(x -> System.out.println(x.getCourseName()));
//
//        // printing from course
//        System.out.println("Course name " + cour1.getCourseName());
//        System.out.println("course student details");
//        cour1.getStudentList().forEach(x -> System.out.println(x.getName()));
    }
}
