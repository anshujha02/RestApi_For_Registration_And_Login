package com.example.controller;

import com.example.entity.BlogPostModel;
import com.example.entity.CommentModel;
import com.example.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogPostController {

    private final BlogService blogService;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<BlogPostModel> getAllBlogs(){
        try{
            return blogService.getAllBlog() ;
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/{userId}")
    public List<BlogPostModel> getBlogById(@PathVariable("userId") int userId){
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
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addBlog(@RequestBody BlogPostModel blogPostModel){
        try{
            blogService.addBlogInfo(blogPostModel);
            return "Successfully Added";
        }catch (Exception e){
            throw e;
        }
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String updateBlogPost(@RequestBody BlogPostModel blogPostModel,@RequestParam("id") int id){
        try{
            blogService.updateBlogPost(blogPostModel, id);
            return "Successfully Updated";
        }catch(Exception e){
            throw e;
        }
    }

}
