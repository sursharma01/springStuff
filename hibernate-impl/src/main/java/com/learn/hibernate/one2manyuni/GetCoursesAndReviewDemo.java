package com.learn.hibernate.one2manyuni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetCoursesAndReviewDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class)
                .buildSessionFactory();
        //create session
        Session session = sessionFactory.getCurrentSession();
        try{

            //start transaction
            session.beginTransaction();
            //get the course
            int courseId = 10;
            Course course = session.get(Course.class, courseId);
            System.out.println("course is "+course.toString());
            System.out.println("reviews about the course are "+course.getReviews());
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
