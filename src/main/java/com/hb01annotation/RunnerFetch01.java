package com.hb01annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sessionFactory= con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx= session.beginTransaction();

     /*   Student01 student1=session.get(Student01.class,1001);
        Student01 student2=session.get(Student01.class,1002);
        Student01 student3=session.get(Student01.class,1003);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

      */
       /* String sqlQuery ="SELECT * FROM t_student01 order by id";
        List<Object[]> resultList= session.createSQLQuery(sqlQuery).getResultList();

        for (Object [] object:resultList){
            System.out.println(Arrays.toString(object));
        }

        //3.yol HQL
        //Trick : SQL sorgusunda From dan sonra sınıf ismi kullanılmalı
        String hqlQuery ="FROM Student01";
        List<Student01>resultList2=session.createQuery(hqlQuery,Student01.class).getResultList();

        for (Student01 student:resultList2) {
            System.out.println(student);
        }

        */
        String sqlQuery2="SELECT * FROM t_student01 WHERE student_name='Yusuf Bay'";
        Object[] uniqueResult1= (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
        System.out.println(Arrays.toString(uniqueResult1));

        String hqlQuery2="FROM Student01 WHERE student_name='Yusuf Bay2'";
        Student01 uniqueResult2= session.createQuery(hqlQuery2,Student01.class).uniqueResult();
        System.out.println(uniqueResult2);

        tx.commit();
        session.close();

        sessionFactory.close();

    }
}
