package com.starrysky.cakelesson.comment.controller;

import com.starrysky.cakelesson.comment.service.CommentService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.xml.stream.events.Comment;
import java.io.IOException;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String content = "aaaaa";
        String email="123@zs.com";

        new CommentService().addComment(id,content,email);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
