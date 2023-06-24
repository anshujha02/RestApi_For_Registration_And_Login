package com.example.service.Impl;

import com.example.entity.CommentModel;
import com.example.repository.CommentRepository;
import com.example.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentsService {

    @Autowired
    private  CommentRepository commentRepository;
    @Override
    public List<CommentModel> getCommentByBlogPostId(int blogId) {
        return commentRepository.findByBlogId(blogId);
    }

    @Override
    public void editComment(CommentModel commentModel, int id) {
   CommentModel existingComment = commentRepository.findById(id).orElseThrow(()-> new RuntimeException());
   existingComment.setComment(commentModel.getComment());
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void addComment(CommentModel commentModel) {
        commentRepository.save(commentModel);
    }
}
