package com.entity;

import java.util.List;

public interface StudentDao {

    void addStudent(Student student);
    void removeStudentById(long id);
    void updateStudent(long id, Student student);
    Student findStudentById(long id);
    List<Student> getAllStudent();
}
