package com.learn.hibernate.many2many;

import com.learn.hibernate.one2manyuni.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentDemo {
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
           // create course
            Course course = new Course("Data Structure & algorithms with JAVA");

            //save course and leverage cascade all
            System.out.println("saving course");
            System.out.println("course is "+course);
            session.save(course);

            //create students
            System.out.println("creating students..");
            Student student1 = new Student("JK", "Jeon", "jk@bts.com");
            Student student2 = new Student("KTH", "Kim", "v@bts.com");
            //add students to the course
            course.addStudents(student1);
            course.addStudents(student2);
            //save the students
            System.out.println("saving students...");
            session.save(student1);
            session.save(student2);

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
