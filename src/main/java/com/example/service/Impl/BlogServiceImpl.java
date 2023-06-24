package com.example.service.Impl;

import com.example.entity.BlogModel;
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
    public List<BlogModel> getAllBlog() {
        List<BlogModel> blogDTOS =  blogRepository.findAll() ;
        return blogDTOS;
    }

    @Override
    public List<BlogModel> getBlogByUserId(int userId) {
        List<BlogModel> blogModels = blogRepository.findByUserId(userId);

        return blogModels;
    }

    @Override
    public void addBlogInfo(BlogModel blogModel) {
        blogRepository.save(blogModel);
    }

    @Override
    public void deleteBlog(int blogId) {
    blogRepository.deleteById(blogId);
    }

    @Override
    public void updateBlogPost(BlogModel blogModel, int id) {
        BlogModel existingBlog = blogRepository.findById(id).orElseThrow(()-> new RuntimeException() );
        existingBlog.setId(blogModel.getId());
        existingBlog.setText(blogModel.getText());
        existingBlog.setUserId(blogModel.getUserId());
        blogRepository.save(existingBlog);
    }


}
