package com.learn.hibernate.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorCourseDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
        //create session
        try {
            Session session = sessionFactory.getCurrentSession();
            //start transaction
            session.beginTransaction();

            //get instructor by id
            int instructorId = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorId);
            System.out.println("Get the instructorDetails " + instructorDetail);
            System.out.println("Get the instructor " + instructorDetail.getInstructor());

            //get course
            int courseId = 10;
            Course course = session.get(Course.class, courseId);
            System.out.println("Get the course Details " + course);
            //delete everything associated with that course
            session.delete(course);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("it's done..");
        }
        finally {
            sessionFactory.close();
        }
    }
}
