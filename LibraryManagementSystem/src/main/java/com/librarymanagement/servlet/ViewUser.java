package com.librarymanagement.servlet;

import com.google.gson.Gson;
import com.librarymanagement.Database.LibraryManagementDatabase;
import com.librarymanagement.model.User; // Assuming User class exists

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/ViewUser")
public class ViewUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get all users from the database
        List<User> users = LibraryManagementDatabase.getInstance().getAllUsers();
        System.out.println(users.size());
        for (User user:users)
            System.out.println(user);

        // Set the users list as an attribute to be used in the JSP page
//        req.setAttribute("users", users);
//
//        // Forward the request to viewuser.jsp
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewuser.jsp");
//        dispatcher.forward(req, resp);

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        // Convert the list of books to JSON
        String json = new Gson().toJson(Map.of("users", users));
        out.write(json);
        out.flush();
    }
}
