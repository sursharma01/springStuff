package com.learn.hibernate.BasicImpl.demo;

import com.learn.hibernate.BasicImpl.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session  session = sessionFactory.getCurrentSession();
        try{
            int studentId = 1;

            //start transaction
            sessionFactory.getCurrentSession();
            session.beginTransaction();

            //saving transaction
            System.out.println("getting student with student id "+studentId);
            Student student = session.get(Student.class, studentId);
            System.out.println("student with "+studentId+" is "+student);

            //deleting student
            System.out.println("deleting student..");
            session.delete(student);

            System.out.println("it's done..");

            //deleting a student within query
            System.out.println("deleting a student within query");
            session.createQuery("delete from Student where id = 2").executeUpdate();

            //commit transaction
            session.getTransaction().commit();
            System.out.println("it's done..");
        }
        finally {
            sessionFactory.close();
        }
    }
}
