package com.blog.service;

import com.blog.entity.Post;
import com.blog.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    void save() {
        Post post = new Post(1, "post 01", 0);
        given(postRepository.save(post)).willReturn(post);

        Post postSaved = postService.save(post);
        assertEquals(postSaved, post);
    }

    @Test
    void findAll() {
        List<Post> posts = new ArrayList();
        posts.add(new Post(1, "post 01", 0));
        posts.add(new Post(2, "post 02", 0));

        given(postRepository.findAll()).willReturn(posts);

        List<Post> listPosts = postService.findAll();
        assertEquals(listPosts, posts);
    }

    @Test
    void incrementUpVote() {
        Post post = new Post(1, "post 01", 0);
        given(postRepository.findById(1)).willReturn(Optional.of(post));

        Post postSaved = postService.incrementUpVote(1);
        verify(postRepository).save(post);
    }
}