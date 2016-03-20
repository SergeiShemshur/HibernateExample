package com.entity;

import com.persistence.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addStudent(Student student) {
        if (student == null) {
            return;
        }
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeStudentById(long id) {
        Student student = null;
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();

        student = findStudentById(session, id);

        session.delete(student);
        tr.commit();
        session.close();
    }

    @Override
    public void updateStudent(long id, Student studentUpdate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(studentUpdate);
        transaction.commit();
        session.close();
    }

    @Override
    public Student findStudentById(long id) {
        org.hibernate.classic.Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.eq("id", id));
        return (Student) criteria.uniqueResult();
    }

    private Student findStudentById(Session session, long id) {
        Student student = null;
        Query query = sessionFactory.openSession().createQuery("from Student where id = "+  id);
        student = (Student) query.uniqueResult();
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = null;
        Session session = null;
        Query query = null;

        session = sessionFactory.openSession();
        query = session.createQuery("from Student");
        students = query.list();
        session.flush();
        session.clear();
//        session.close();
        return students;
    }





}
