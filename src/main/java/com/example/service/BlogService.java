package com.example.service;

import com.example.entity.BlogModel;

import java.util.List;

public interface BlogService {
    List<BlogModel> getAllBlog();

    List<BlogModel> getBlogByUserId(int userId);

    void addBlogInfo(BlogModel blogModel);

    void deleteBlog(int blogId);

    void updateBlogPost(BlogModel blogModel,int id);
}
