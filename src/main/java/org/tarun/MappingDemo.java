package org.tarun;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.tarun.Model.Laptop;
import org.tarun.Model.Student;

public class MappingDemo {
    private static SessionFactory sf = null;
    private static Session session = null;
    public void init(){
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        sf = con.buildSessionFactory(reg);
    }
    public static void main(String[] args) {
        MappingDemo m = new MappingDemo();

        m.init();

        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");

        Student student = new Student();
        student.setName("Tarun");
        student.setRollno(1);
        student.setMarks(50);
        student.getLaptop().add(laptop);

        laptop.getStudent().add(student);

        session = sf.openSession();

        session.getTransaction().begin();
        session.persist(laptop);
        session.persist(student);
        session.getTransaction().commit();

    }
}
