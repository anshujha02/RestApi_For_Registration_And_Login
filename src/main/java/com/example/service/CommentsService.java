package com.example.service;

import com.example.entity.CommentModel;

import java.util.List;

public interface CommentsService {
    List<CommentModel> getCommentByBlogPostId(int blogId);

    void editComment(CommentModel commentModel,int id);

    void deleteComment(int id);

    void addComment(CommentModel commentModel);
}
