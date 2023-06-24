package com.example.service.Impl;

import com.example.entity.BlogPostModel;
import com.example.repository.BlogRepository;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<BlogPostModel> getAllBlog() {
        List<BlogPostModel> blogDTOS =  blogRepository.findAll() ;
        return blogDTOS;
    }

    @Override
    public List<BlogPostModel> getBlogByUserId(int userId) {
        List<BlogPostModel> blogPostModels = blogRepository.findByUserId(userId);

        return blogPostModels;
    }

    @Override
    public void addBlogInfo(BlogPostModel blogPostModel) {
        blogRepository.save(blogPostModel);
    }

    @Override
    public void deleteBlog(int blogId) {
    blogRepository.deleteById(blogId);
    }

    @Override
    public void updateBlogPost(BlogPostModel blogPostModel, int id) {
        BlogPostModel existingBlog = blogRepository.findById(id).orElseThrow(()-> new RuntimeException() );
        existingBlog.setTitle(blogPostModel.getTitle());
        existingBlog.setContent(blogPostModel.getContent());
        existingBlog.setTag(blogPostModel.getTag());
        blogRepository.save(existingBlog);
    }


}
