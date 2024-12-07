package com.librarymanagement.servlet;

import com.google.gson.Gson;
import com.librarymanagement.Database.LibraryManagementDatabase;
import com.librarymanagement.model.Book;
import com.librarymanagement.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Map the servlet to "/AddUser"
@WebServlet("/GetBook")
public class GetBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve form data from the request
        String name = req.getParameter("name");
        name = name.toUpperCase(); // Optional: make name case-insensitive
        HttpSession session = req.getSession();

//        int userId = Integer.parseInt((String) (session.getAttribute("userid")));

        // Check if the user has reached the limit
//        if (LibraryManagementDatabase.getInstance().reachLimit(userId)) {
//            String message = "You have reached the limit. You have to return the book before you can get another one!";
//            String redirectUrl = "userpage.jsp"; // Redirect URL if limit is reached
//
//            String encodedMessage = URLEncoder.encode(message, "UTF-8");
//            resp.sendRedirect("userpage.jsp?message=" + encodedMessage);
//            return;
//        }

        // Search for books based on the name
        List<Book> books = LibraryManagementDatabase.getInstance().getBooksByName(name);
        if(books.size()==0){
            String message = "Book doesn't exist!"; // Message to show if no books are found
            resp.sendRedirect("userpage.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
            return;
        }

        // If no books are found, redirect to the user page with a message
//        if (books == null || books.isEmpty()) {
//            String message = "Book doesn't exist!"; // Message to show if no books are found
//            resp.sendRedirect("userpage.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
//        } else {
//            // If books are found, filter for available books
//            List<Book> availableBooks = new ArrayList<>();
//            for (Book book : books) {
//                if (book.getQuantity() > 0) {
//                    availableBooks.add(book);
//                }
//            }
//
//            if (availableBooks.isEmpty()) {
//                // If no available books, redirect with a "No available books found!" message
//                String message = "No available books found!";
//                resp.sendRedirect("userpage.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
//            } else {
                // If available books exist, return them as JSON
                resp.setContentType("application/json");
                PrintWriter out = resp.getWriter();
                String json = new Gson().toJson(Map.of("books", books));
                out.write(json);
                out.flush();
//            }
        }
    }


