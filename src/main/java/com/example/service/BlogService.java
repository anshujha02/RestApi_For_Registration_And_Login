package com.example.service;

import com.example.entity.BlogPostModel;

import java.util.List;

public interface BlogService {
    List<BlogPostModel> getAllBlog();

    List<BlogPostModel> getBlogByUserId(int userId);

    void addBlogInfo(BlogPostModel blogPostModel);

    void deleteBlog(int blogId);

    void updateBlogPost(BlogPostModel blogPostModel, int id);
}
