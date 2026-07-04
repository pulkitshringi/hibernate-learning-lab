package com.pulkit.app;

import com.pulkit.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.*;

public class PracticingLargeObjects {
    public static void main(String[] args) throws IOException {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setsName("Pooki");

        // storing image
        // as we are taking image in bytes that's why we use FileInputStream
        FileInputStream fis = new FileInputStream("/Users/pulkitshringi/Local Folder/IntelliJ (2026)/hibernate/hibernate_lob/src/main/resources/pulkitshringi.jpg");
        byte[] imageArray = new byte[fis.available()]; // length of byte array
        fis.read(imageArray); // bytes from fis stream is being put into ->  image array
        student.setImage(imageArray);

        // storing text
        File file = new File("/Users/pulkitshringi/Local Folder/IntelliJ (2026)/hibernate/hibernate_lob/src/main/resources/about.txt");
        FileReader fileReader = new FileReader(file);
        char[] textArray = new char[(int) file.length()];
        fileReader.read(textArray); // putting data from filereader to text array
        student.setTextFile(textArray);

        session.persist(student);
        transaction.commit();

//        // printing data now
//        Student student = session.find(Student.class, 1);
//        // storing image in a new file
//        FileOutputStream fos = new FileOutputStream("newImage.jpg");
//        fos.write(student.getImage());
//
//        // storing text in new file
//        FileWriter fileWriter = new FileWriter("newTextFile.txt");
//        fileWriter.write(student.getTextFile());
//        fileWriter.close();

    }

}
