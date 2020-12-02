package com.blog.controller;

import com.blog.entity.Post;
import com.blog.repository.PostRepository;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/api/post")
    public ResponseEntity<Post> save(@RequestBody Post post) {
        return ResponseEntity.ok().body(postService.save(post));
    }

    @GetMapping("/api/posts")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @PutMapping("/api/post/{requestId}")
    public ResponseEntity<?> incrementUpVote(@PathVariable Integer requestId) {
        Post post = postService.incrementUpVote(requestId);

        return ResponseEntity.ok().body(post);
    }
}
