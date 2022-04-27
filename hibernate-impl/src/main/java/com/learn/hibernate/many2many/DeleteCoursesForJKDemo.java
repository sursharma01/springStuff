package com.learn.hibernate.many2many;

import com.learn.hibernate.one2manyuni.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesForJKDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class).
                addAnnotatedClass(Student.class).
                buildSessionFactory();
        //create session
        Session session = sessionFactory.getCurrentSession();
        try{
            //start transaction
            session.beginTransaction();

            //get the course Azure Cloud
            int courseId = 13;
            Course course = session.get(Course.class, courseId);
            System.out.println("the course info is "+course.toString());
            //delete course
            System.out.println("deleting the course");
            session.delete(course);

            //get student JK from database
            int studentId = 1;
            Student student = session.get(Student.class, studentId);
            System.out.println("the student info is "+student.toString());
            System.out.println("checking the attached courses are "+student.getCourses());


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
