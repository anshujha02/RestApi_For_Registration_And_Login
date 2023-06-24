package com.example.repository;

import com.example.entity.BlogPostModel;
import com.example.entity.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentModel,Integer> {
    List<CommentModel> findByBlogId(int blogId);
}
