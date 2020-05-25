package com.sha.LinkedTek.service;

import com.sha.LinkedTek.model.User;

import java.util.List;

public interface IUserService {
    User saveUser(User user);

    User addNewFriend(Long userId, String friendName);

    Long levelBetweenFriends(Long user1Id, Long user2Id);

    List<User> findAll();
}
