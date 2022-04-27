package com.learn.hibernate.one2many;

import com.learn.hibernate.BasicImpl.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
        //create session
        Session session = sessionFactory.getCurrentSession();
        try{

            //start transaction
            session.beginTransaction();
            //create object
            int instructorId = 1;
            Instructor instructor = session.get(Instructor.class, instructorId);
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorId);
            //get information
            System.out.println("instructor details is "+instructorDetail);
            System.out.println("associated instructor is "+instructorDetail.getInstructor());
            //get course from instructor
            System.out.println("courses details is "+instructor.getCourses());

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
