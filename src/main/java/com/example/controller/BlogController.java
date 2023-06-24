package com.example.controller;

import com.example.entity.BlogModel;
import com.example.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/all")
    public List<BlogModel> getAllBlogs(){
        try{
            return blogService.getAllBlog() ;
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/{userId}")
    public List<BlogModel> getBlogById(@PathVariable("userId") int userId){
        try{
            return blogService.getBlogByUserId(userId);
        }catch(Exception e){
            throw e;
        }
    }

    @DeleteMapping("/delete")
    public String deleteBlog(@RequestParam("blogId") int blogId){
        try{
            blogService.deleteBlog(blogId);
            return "SuccessFully deleted";
        }catch (Exception e){
            throw e;
        }
    }

    @PostMapping
    public String addBlog(@RequestBody BlogModel blogModel){
        try{
            blogService.addBlogInfo(blogModel);
            return "Successfully Added";
        }catch (Exception e){
            throw e;
        }
    }

}
