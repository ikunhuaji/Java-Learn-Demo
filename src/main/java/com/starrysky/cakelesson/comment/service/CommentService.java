package com.starrysky.cakelesson.comment.service;

import com.starrysky.cakelesson.comment.dao.CommentDao;
import com.starrysky.cakelesson.comment.dao.UserDao;

public class CommentService {
    private String id;
    private String content;
    private String email;

    public CommentService(String id, String content, String email) {
        this.id = id;
        this.content = content;
        this.email = email;
    }

    public CommentService() {
    }

    public void addComment(String id, String content, String email){
        new CommentDao().saveComment(id,content,email);
        new UserDao().addScore(email,10);
    }
}
