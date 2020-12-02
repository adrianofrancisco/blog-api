package com.blog.controller;

import com.blog.entity.Post;
import com.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @PostMapping("/api/post")
    public ResponseEntity<Post> save(@RequestBody Post post) {
        return ResponseEntity.ok().body(postRepository.save(post));
    }

    @GetMapping("/api/posts")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(postRepository.findAll());
    }

    @PutMapping("/api/post/{requestId}")
    public ResponseEntity<?> incrementUpVote(@PathVariable Integer requestId) {
        Optional<Post> post = postRepository.findById(requestId);

        post.get().setCountUpvote(post.get().getCountUpvote() + 1);

        return ResponseEntity.ok().body(postRepository.save(post.get()));
    }
}
