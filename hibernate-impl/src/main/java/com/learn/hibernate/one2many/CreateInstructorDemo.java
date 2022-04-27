package com.learn.hibernate.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                buildSessionFactory();
        //create session
        Session session = sessionFactory.getCurrentSession();
        try{

            //create object
            Instructor instructor = new Instructor("me", "myself", "i@live.com");
            InstructorDetail instructorDetail = new InstructorDetail("yt.com/unknown", "peace");
            instructor.setInstructorDetail(instructorDetail);

            //start transaction
            session.beginTransaction();
            //save object
            session.persist(instructor);
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
