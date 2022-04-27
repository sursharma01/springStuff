package com.learn.hibernate.many2many;

import com.learn.hibernate.one2manyuni.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForJKDemo {
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
           //get student JK from database
            int studentId = 1;
            Student student = session.get(Student.class, studentId);
            System.out.println("the student info is "+student.toString());
            System.out.println("attached courses are "+student.getCourses());
            //create more courses
            Course course1 = new Course("JAVA EE");
            Course course2 = new Course("AWS Certification");
            Course course3 = new Course("Azure Cloud");
            //add student to courses
            System.out.println("adding student to courses...");
            course1.addStudents(student);
            course2.addStudents(student);
            course3.addStudents(student);
            //save courses
            System.out.println("saving all courses..");
            session.save(course1);
            session.save(course2);
            session.save(course3);

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
