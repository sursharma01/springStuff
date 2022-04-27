package com.learn.hibernate.BasicImpl.demo;

import com.learn.hibernate.BasicImpl.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session  session = sessionFactory.getCurrentSession();
        try{
            // create object
            System.out.println("creating object..");
            Student student = new Student("jin","kim", "jin@fun.com");

            //start transaction
            session.beginTransaction();

            //saving transaction
            System.out.println("saving object..");
            session.save(student);

            // new code

            //find out by primary key:id
            System.out.println("saved student is "+student.getId());
            sessionFactory.getCurrentSession();

            Student student1 = session.get(Student.class, student.getId());
            System.out.println("getting student "+ student1);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("it's done..");
        }
        finally {
            sessionFactory.close();
        }
    }
}
