package com.learn.hibernate.one2oneUni;

import com.learn.hibernate.one2oneUni.entity.Instructor;
import com.learn.hibernate.one2oneUni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        //create session
        try {
            Session session = sessionFactory.getCurrentSession();
            //start transaction
            session.beginTransaction();

            //get instructor by id
            int instructorId = 2;
            Instructor instructor = session.get(Instructor.class, instructorId);
            System.out.println("Get the instructor " + instructor);

            // delete instructor
            System.out.println("deleting instructor..");
            session.delete(instructor);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("it's done..");
        }
        finally {
            sessionFactory.close();
        }
    }
}
