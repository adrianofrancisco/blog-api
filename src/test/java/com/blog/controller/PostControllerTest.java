package com.blog.controller;

import com.blog.entity.Post;
import com.blog.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PostService postService;

    @Test
    void save() throws Exception {
        Post post = new Post(1, "post 01", 0);

        mvc.perform(post("/api/post")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk());
    }

    @Test
    void findAll() throws Exception {
        mvc.perform(get("/api/posts")).andExpect(status().isOk());
    }
}