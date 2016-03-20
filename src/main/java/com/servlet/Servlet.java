package com.servlet;

import com.entity.Student;
import com.entity.StudentDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = new StudentDaoImpl().getAllStudent();
        req.setAttribute("students", list);
//        req.setAttribute("name", "Valeriy");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/database.jsp");
        dispatcher.forward(req, resp);
    }

}
