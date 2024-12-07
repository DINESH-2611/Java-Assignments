package com.librarymanagement.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/AddUserPageRedirect")
public class AddUserPageRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  // Prevent caching
        response.setHeader("Pragma", "no-cache");  // For HTTP/1.0
        response.setDateHeader("Expires", 0);
        // Check if the session attribute "admin" is present
        String admin = (String) request.getSession().getAttribute("admin");

        if (admin == null) {
//            System.out.println("if");
            // If the admin is not logged in, redirect to index.html
            response.sendRedirect("index.html");
        } else {
//            System.out.println("else");
            // If the admin is logged in, allow access to adduser.html
            response.sendRedirect("adduser.html");
        }
    }
}

