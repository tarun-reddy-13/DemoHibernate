package org.tarun;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.tarun.Model.Alien;
import org.tarun.Model.AlienName;


public class App
{
    private SessionFactory sf = null;
    private Session session = null;
    public void init(){
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        this.sf = con.buildSessionFactory(reg);
    }

    public void insertData(int aid, String fname, String mname, String lname, String color){
        Alien alien = new Alien();
        alien.setAid(aid);

        AlienName aname = new AlienName();
        aname.setFname(fname);
        aname.setMname(mname);
        aname.setLname(lname);

        alien.setAname(aname);
        alien.setColor(color);

         this.session = this.sf.openSession();

        Transaction tx =this. session.beginTransaction();
        this.session.persist(alien);
        tx.commit();

        this.session.close();
    }

    public Alien fetchData(){
        this.session = this.sf.openSession();
        return (Alien) session.get(Alien.class, 101);
    }
    public static void main( String[] args ) throws HibernateException {

        App app = new App();
        app.init();
        app.insertData(101, "Thota", "Tarun", "Reddy", "Grey");
        Alien alien = app.fetchData();
        System.out.println(alien);


    }
}
