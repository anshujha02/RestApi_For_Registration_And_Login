package com.example.repository;

import com.example.entity.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commentRepository extends JpaRepository<CommentModel,Integer> {
}
