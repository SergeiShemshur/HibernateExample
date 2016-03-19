package com.common;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Student student = new Student();
        student.setAge(12);
        student.setSurname("Alex");
        student.setBirthdate(new Date("2015/05/10"));
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.addStudent(student);
    }
}
