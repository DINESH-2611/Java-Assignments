package com.librarymanagement.servlet;

import com.google.gson.Gson;
import com.librarymanagement.Database.LibraryManagementDatabase;
import com.librarymanagement.model.Book;
import com.librarymanagement.model.IssueBook;
import com.librarymanagement.model.User; // Assuming User class exists

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get all issued books from the database
        List<IssueBook> books = LibraryManagementDatabase.getInstance().getAllIssuedBooks();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        if (books.isEmpty()) {
            // Respond with a message indicating no books have been issued
            String json = new Gson().toJson(Map.of("message", "No Book is issued yet!", "redirectUrl", "adminpage.jsp"));
            resp.getWriter().write(json);
        } else {
            // Respond with the issued books
            String json = new Gson().toJson(Map.of("issuedBooks", books));
            resp.getWriter().write(json);
        }
    }
}




