package com.instagram.instagramcrud.rest;

import com.instagram.instagramcrud.entity.Follower;
import com.instagram.instagramcrud.service.FollowerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/followers")
public class FollowerController {

    private FollowerService followerService;

    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @GetMapping
    public List<Follower> findAll() {
        return followerService.findAll();
    }

    // add mapping for GET /followers/{followerId}
    @GetMapping("/{followerId}")
    public Follower getFollower(@PathVariable Long followerId) {
        Follower theFollower = followerService.findById(followerId);

        if (theFollower == null) {
            throw new RuntimeException("Follower id not found: " + followerId);
        }

        return theFollower;
    }

    @PostMapping
    public Follower addFollower(@RequestBody Follower theFollower) {
        return followerService.save(theFollower);
    }

    // update existing Follower
    @PutMapping("/{followerId}")
    public Follower updateFollower(@PathVariable Long followerId, @RequestBody Follower theFollower) {
        Follower existingFollower = followerService.findById(followerId);

        if (existingFollower == null) {
            throw new RuntimeException("Follower id not found: " + followerId);
        }

        existingFollower.setFollower(theFollower.getFollower());
        existingFollower.setFollowing(theFollower.getFollowing());

        return followerService.save(existingFollower);

    }

    // Delete existing Follower
    @DeleteMapping("/{followerId}")
    public void deleteFollower(@PathVariable Long followerId) {
        Follower existingFollower = followerService.findById(followerId);

        if (existingFollower == null) {
            throw new RuntimeException("Follower id not found: " + followerId);
        }

        followerService.deleteById(followerId);
    }

}
