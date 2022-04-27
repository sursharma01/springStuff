package com.learn.hibernate.one2manyuni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class).
                buildSessionFactory();
        //create session
        Session session = sessionFactory.getCurrentSession();
        try{
            //start transaction
            session.beginTransaction();
           // create course
            Course course = new Course("Data Structure & algorithms with JAVA");
            //add reviews
            course.addReview(new Review("oh my god"));
            course.addReview(new Review("god help me"));
            course.addReview(new Review("somebody send help"));
            course.addReview(new Review("gotta do this"));
            course.addReview(new Review("i'm doing good"));
            //save course and leverage cascade all
            System.out.println("saving course");
            System.out.println("course is "+course);
            System.out.println("reviews about course are "+course.getReviews());
            session.save(course);


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
