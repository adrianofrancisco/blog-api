package com.blog.service;

import com.blog.entity.Post;
import com.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post save(@RequestBody Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post incrementUpVote(Integer requestId) {
        Optional<Post> post = postRepository.findById(requestId);

        post.get().setCountUpvote(post.get().getCountUpvote() + 1);

        return postRepository.save(post.get());
    }
}
