package com.example.repository;

import com.example.entity.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<BlogModel,Integer> {
    List<BlogModel> findByUserId(int userId);
}
