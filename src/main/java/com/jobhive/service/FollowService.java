package com.jobhive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobhive.model.Follow;
import com.jobhive.model.User;
import com.jobhive.repository.FollowRepository;
import com.jobhive.repository.UserRepository;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

    public String followUser(Long followerId, Long followedId) {
        User follower = userRepository.findById(followerId).orElse(null);
        User followed = userRepository.findById(followedId).orElse(null);

        if (follower == null || followed == null) {
            return "Failed";
        }

        Follow existingFollow = followRepository.findByFollowerAndFollowed(follower, followed);
        if (existingFollow == null) {
            Follow follow = new Follow();
            follow.setFollower(follower);
            follow.setFollowed(followed);
            follow.setStatus("FOLLOWING");
            followRepository.save(follow);

            String message = follower.getFirstName() + " " + follower.getLastName() + " is now following you.";
            String profileSlug = follower.getProfileUrlSlug();
            String link = "/profile/" + profileSlug;
            notificationService.sendNotification(followedId, message, link, follower.getProfileImage(), false);
            return "Followed";
        } else {
            if ("FOLLOWING".equals(existingFollow.getStatus())) {
                existingFollow.setStatus("NOT_FOLLOWING");
                followRepository.save(existingFollow);

                String message = follower.getFirstName() + " " + follower.getLastName() + " has unfollowed you.";
                String profileSlug = follower.getProfileUrlSlug();
                String link = "/profile/" + profileSlug;
                notificationService.sendNotification(followedId, message, link, follower.getProfileImage(), false);
                return "Unfollowed";
            } else {
                existingFollow.setStatus("FOLLOWING");
                followRepository.save(existingFollow);

                String message = follower.getFirstName() + " " + follower.getLastName() + " is now following you.";
                String profileSlug = follower.getProfileUrlSlug();
                String link = "/profile/" + profileSlug;
                notificationService.sendNotification(followedId, message, link, follower.getProfileImage(), false);
                return "Followed";
            }
        }
    }

    public List<User> getFollowing(Long userId) {
        return followRepository.findFollowingByUserId(userId);
    }

    public List<User> getFollowers(Long userId) {
        return followRepository.findFollowersByUserId(userId);
    }

    public long countFollowing(Long userId) {
        return followRepository.countFollowing(userId);
    }

    public long countFollowers(Long userId) {
        return followRepository.countFollowers(userId);
    }
}
