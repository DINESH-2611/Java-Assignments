package com.librarymanagement.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CheckAdminSession")
public class CheckAdminSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(123);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  // Prevent caching
        response.setHeader("Pragma", "no-cache");  // For HTTP/1.0
        response.setDateHeader("Expires", 0);
        // Check if the admin session exists
        String admin = (String) request.getSession().getAttribute("admin");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // Send response as JSON (loggedIn: true/false)
        if (admin != null) {
            System.out.println("if");
            out.write("{\"loggedIn\": true}");
        } else {
            System.out.println("else");
            out.write("{\"loggedIn\": false}");
        }
        out.flush();
        out.close();
    }
}

