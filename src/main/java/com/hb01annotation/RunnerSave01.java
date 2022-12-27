package com.hb01annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student01 student1 = new Student01();
        student1.setId(1001);
        student1.setName("Samet Güler");
        student1.setGrade(90);

        Student01 student2=new Student01();
        student2.setId(1001);
        student2.setName("Yusuf Bay1");
        student2.setGrade(93);

        Student01 student3=new Student01();
        student3.setId(1004);
        student3.setName("baba 04");
        student3.setGrade(100);

        /*
        Default olarak configuration class'ı, main altındaki resources folder'ına gider.
        configure içerisine cfg (config) dosyamızı belirtmemiz gerekiyor
        addAnnotatedClass, Entity Class'ı belirler.
        */
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        // Hibernate 'e konfigürasyon dosyamı ve Entity clasımı bildirdim.
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // session.save(student1);

        /*
        Session Factory Objesi oluşturduk
        Obje ile session return ettik / oluşturduk
        beginTransaction ile transaction (işlem) başlattık / transaction return ettik
        */


        // student1 objesini session'a kaydettik
        //session.save(student1);
        //session.save(student2);
        session.save(student3);

        // Transaction, Session ve SessionFactory'i kapattık
        tx.commit();
        session.close();
        sf.close();
    }
}
