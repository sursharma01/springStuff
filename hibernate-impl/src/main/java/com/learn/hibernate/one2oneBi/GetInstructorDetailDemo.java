package com.learn.hibernate.one2oneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();
        //create session
        Session session = sessionFactory.getCurrentSession();
        try{

            //start transaction
            session.beginTransaction();
            //create object
            int instructorId = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorId);
            //get information
            System.out.println("instructor details is "+instructorDetail);
            System.out.println("associated instructor is "+instructorDetail.getInstructor());
            //commit transaction
            session.getTransaction().commit();
            System.out.println("it's done..");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
