package com.hb01annotation;

import javax.persistence.*;

// @Entity annotation ı koyduğumuz sınıfı DB de bir tabloya karşılık getirir
@Entity
@Table(name="t_student01") // DB de tablo ismim "t_student01" olarak değişti
public class Student01 { // DB'de  "student01" isminde tablo oluşturur.  t_adres

    @Id // primary-key oluşmasını sağlıyor
    // @Column(name="std_id")
    private int id;

    // @Column zorunlu değil ancak customize edebilmek için gerekli
    @Column(name="student_name", length = 100 , nullable = false, unique = false )
    private String name;

    // @Transient // DB deki tabloda "grade" adında bir kolon oluşmasını engeller
    private int grade;

//    @Lob // ---> large object ile büyük boyurlu datalar tutulabilir
//    private byte[] image ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
