package com.learn.hibernate.one2oneUni;

import com.learn.hibernate.one2oneUni.entity.Instructor;
import com.learn.hibernate.one2oneUni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();
        //create session
        Session session = sessionFactory.getCurrentSession();
        try{
            // create object
            System.out.println("creating object..");
            Instructor instructor = new Instructor("big","hit", "BHEnt@fun.com");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com/bangtanTV","luv2hvFun");
            instructor.setInstructorDetail(instructorDetail);

            // create object
            System.out.println("creating 2nd object..");
            Instructor instructor1 = new Instructor("black","pink", "BP@crap.com");
            InstructorDetail instructorDetail1 = new InstructorDetail("youtube.com/blackPink","luv2hvCrap");
            instructor1.setInstructorDetail(instructorDetail1);

            //start transaction
            session.beginTransaction();

            //saving transaction
            System.out.println("saving object..");
            session.save(instructor);
            session.save(instructor1);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("it's done..");
        }
        finally {
            sessionFactory.close();
        }
    }
}
