package com.example.controller;

import com.example.entity.CommentModel;
import com.example.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {


    private final CommentsService commentsService;

    @GetMapping("/{id}")
    public List<CommentModel> getCommentsByBlogId(@PathVariable("id") int id){
        try{
            return commentsService.getCommentByBlogPostId(id) ;
        }catch (Exception e){
            throw e;
        }
    }


    @DeleteMapping("/delete")
    public String deleteComment(@RequestParam("id") int id){
        try{
            commentsService.deleteComment(id);
            return "SuccessFully deleted";
        }catch (Exception e){
            throw e;
        }
    }

    @PostMapping
    public String addComment(@RequestBody CommentModel commentModel){
        try{
            commentsService.addComment(commentModel);
            return "Successfully Added";
        }catch (Exception e){
            throw e;
        }
    }

    @PutMapping("/update")
    public String updateComment(@RequestBody CommentModel commentModel,@RequestParam("id") int id){
        try{
            commentsService.editComment(commentModel, id);
            return "Successfully Updated";
        }catch(Exception e){
            throw e;
        }
    }


}
