package com.learn.hibernate.BasicImpl.demo;

import com.learn.hibernate.BasicImpl.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = sessionFactory.getCurrentSession();
        try {
            //start transaction
            session.beginTransaction();
            // query the student
            List<Student> studentList = session.createQuery("from Student").list();
            //list the students
            for (Student student : studentList) {
                System.out.println(student.toString());
            }
            //query students based on last name
            studentList = session.createQuery("from Student s where s.last_name = 'Kim'").list();
            //print the students
            for (Student student : studentList) {
                System.out.println(student.toString());
            }

            //query students based on last name
            studentList = session.createQuery("from Student s where s.last_name = 'Kim' OR s.first_name = 'jk'").list();
            //print the students
            for (Student student : studentList) {
                System.out.println(student.toString());
            }

            //query students based on last name
            studentList = session.createQuery("from Student s where s.email LIKE '%fun.com'").list();
            //print the students
            for (Student student : studentList) {
                System.out.println(student.toString());
            }
            //saving transaction
            System.out.println("saving object..");

            //commit transaction
            session.getTransaction().commit();
            System.out.println("it's done..");
        } finally {
            sessionFactory.close();
        }
    }
}
