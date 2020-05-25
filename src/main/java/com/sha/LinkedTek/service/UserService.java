package com.sha.LinkedTek.service;

import com.sha.LinkedTek.model.User;
import com.sha.LinkedTek.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User saveUser(User user){

        return userRepository.save(user);
    }

    @Override
    public User addNewFriend(Long userId, String friendName){

        return userRepository.addFriendRelation(userId,friendName);

    }

    @Override
    public Long levelBetweenFriends(Long user1Id, Long user2Id){

        return userRepository.levelBetweenFriends(user1Id,user2Id);

    }

    @Override
    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return  users;
    }
}
