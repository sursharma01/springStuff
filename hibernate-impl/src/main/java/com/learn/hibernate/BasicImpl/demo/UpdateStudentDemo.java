package com.learn.hibernate.BasicImpl.demo;

import com.learn.hibernate.BasicImpl.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session  session = sessionFactory.getCurrentSession();
        try{
            int studentId = 4;

            //start transaction
            sessionFactory.getCurrentSession();
            session.beginTransaction();

            //saving transaction
            System.out.println("getting student with student id "+studentId);
            Student student = session.get(Student.class, studentId);
            System.out.println("student with "+studentId+" is "+student);

            //updating student
            System.out.println("updating student..");
            student.setEmail("bts@fun.com");
            //commit transaction
            session.getTransaction().commit();
            System.out.println("it's done..");

            //updating email for all students
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("updating email for all students..");
            session.createQuery("update Student set email = 'bts@fun.com'").executeUpdate();

            //saving it
            session.getTransaction().commit();
            System.out.println("updated all..");
        }
        finally {
            sessionFactory.close();
        }
    }
}
