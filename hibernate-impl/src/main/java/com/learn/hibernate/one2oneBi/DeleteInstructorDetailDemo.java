package com.learn.hibernate.one2oneBi;

import com.learn.hibernate.BasicImpl.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.PrintStream;

public class DeleteInstructorDetailDemo {

    public static final PrintStream PRINT_STREAM = System.out;

    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = sessionFactory.getCurrentSession();
        try {
            //start transaction
            session.beginTransaction();

            //get instructor by id
            int instructorId = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorId);
            PRINT_STREAM.println("Get the instructorDetails " + instructorDetail);
            PRINT_STREAM.println("Get the instructor " + instructorDetail.getInstructor());

            // delete instructor
            PRINT_STREAM.println("deleting instructor with instructorDetails");
            //to not cascade delete, we need to remove association
            //instructorDetail.getInstructor().setInstructorDetail(null); and then delete
            session.delete(instructorDetail);

            //commit transaction
            session.getTransaction().commit();
            PRINT_STREAM.println("it's done..");
        }
        finally {
            sessionFactory.close();
        }
    }
}
