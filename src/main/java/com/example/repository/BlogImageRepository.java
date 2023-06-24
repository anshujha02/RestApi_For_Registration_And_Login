package com.example.repository;

import com.example.entity.BlogImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogImageRepository extends JpaRepository<BlogImageData,Long> {
    Optional<BlogImageData> findByName(String fileName);
}
