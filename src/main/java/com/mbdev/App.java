package com.mbdev;

import com.mbdev.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("TEST1", 31);
            Person person2 = new Person("TEST2", 32);
            Person person3 = new Person("TEST3", 33);
            Person person4 = new Person("TEST4", 34);

            session.save(person);
            session.save(person2);
            session.save(person3);
            session.save(person4);
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}