package com.instagram.instagramcrud.rest;

import com.instagram.instagramcrud.entity.Post;
import com.instagram.instagramcrud.entity.User;
import com.instagram.instagramcrud.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // expose "/posts" and return a list of getPost
    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }

    // add mapping for GET /posts/{postId}
    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Long postId) {
        Post post = postService.findById(postId);

        if (post == null) {
            throw new RuntimeException("Post id not found: " + postId);
        }

        return post;
    }

    @PostMapping
    public Post addPost(@RequestBody Post thePost) {
        return postService.save(thePost);
    }

    // Update existing post
    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody Post thePost) {
        Post existingPost = postService.findById(postId);

        if (existingPost == null) {
            throw new RuntimeException("Post id not found: " + postId);
        }

        existingPost.setText(thePost.getText());
        existingPost.setUser(thePost.getUser());
        return postService.save(existingPost);
    }

    // Delete existing post
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        Post existingPost = postService.findById(postId);

        if (existingPost == null) {
            throw new RuntimeException("Post id not found: " + postId);
        }

        postService.deleteById(postId);
    }
}
