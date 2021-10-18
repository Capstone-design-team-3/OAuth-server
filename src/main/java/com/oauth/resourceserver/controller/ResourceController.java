package com.oauth.resourceserver.controller;

import com.oauth.resourceserver.entity.Comment;
import com.oauth.resourceserver.entity.Post;
import com.oauth.resourceserver.repository.CommentRepository;
import com.oauth.resourceserver.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ResourceController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/post")
    public List<Post> getAllPost() {
        log.info("GET /post");
        return postRepository.findAll();
    }

    @PostMapping("/post")
    public Post savePost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/post/{id}/comment")
    public List<Comment> getPostsComment(@PathVariable(value = "id")Integer postId) {
        return commentRepository.findCommentByPostId(postId);
    }

    @PostMapping("/post/{id}/comment")
    public Comment saveComment(@PathVariable(value = "id")Integer postId,
                               @RequestBody Comment comment) throws Exception {
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new Exception());
    }
}
