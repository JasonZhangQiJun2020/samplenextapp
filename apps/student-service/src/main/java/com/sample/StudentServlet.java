package com.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a list of Student objects
        List<Student> students = Arrays.asList(
            new Student(1, "Alice"),
            new Student(2, "Bob"),
            new Student(3, "Charlie"),
            new Student(4, "Diana"),
            new Student(5, "Ethan"),
            new Student(6, "Fiona"),
            new Student(7, "George"),
            new Student(8, "Hannah"),
            new Student(9, "Ivan"),
            new Student(10, "Julia"),
            new Student(11, "Jason")
        );

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(students);

        response.getWriter().write(jsonResponse);
        response.getWriter().flush();
    }
}

