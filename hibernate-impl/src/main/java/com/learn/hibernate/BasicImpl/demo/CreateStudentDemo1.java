package com.learn.hibernate.BasicImpl.demo;

import com.learn.hibernate.BasicImpl.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo1 {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = sessionFactory.getCurrentSession();
        try {
            // create object
            System.out.println("creating object..");
            Student student1 = new Student("jk", "jeon", "jk@fun.com");
            Student student2 = new Student("v", "kth", "v@fun.com");
            Student student3 = new Student("rm", "kim", "rm@fun.com");
            Student student4 = new Student("jm", "park", "jm@fun.com");

            //start transaction
            session.beginTransaction();

            //saving transaction
            System.out.println("saving object..");
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.save(student4);

            // printing objects
            System.out.println(student1.toString());
            System.out.println(student2.toString());
            System.out.println(student3.toString());
            System.out.println(student4.toString());

            //commit transaction
            session.getTransaction().commit();
            System.out.println("it's done..");
        } finally {
            sessionFactory.close();
        }
    }

}
