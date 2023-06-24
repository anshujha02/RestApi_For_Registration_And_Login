package com.example.repository;

import com.example.entity.BlogPostModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<BlogPostModel,Integer> {
    List<BlogPostModel> findByUserId(int userId);
}
