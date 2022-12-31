package com.hb06.unionemany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        //  Student06 student=session.get(Student06.class,1001);
        //  System.out.println(student);

       //String hqlQuery="From Book06 s Where s.id=101";
       //Book06 book1=session.createQuery(hqlQuery, Book06.class).uniqueResult();
       //System.out.println(book1);

        String hqlQuery1="SELECT b.id,b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id=1001";

        List<Object[]>resultList1=session.createQuery(hqlQuery1).getResultList();
        resultList1.forEach(oa->System.out.println(Arrays.toString(oa)));



        tx.commit();
        session.close();
        sf.close();
    }
}
