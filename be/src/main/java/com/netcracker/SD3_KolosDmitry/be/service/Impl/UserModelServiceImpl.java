package com.netcracker.SD3_KolosDmitry.be.service.Impl;

import com.netcracker.SD3_KolosDmitry.be.entity.UserModel;
import com.netcracker.SD3_KolosDmitry.be.repository.UserRepository;
import com.netcracker.SD3_KolosDmitry.be.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserModelServiceImpl implements UserModelService {

    private UserRepository userRepository;

    @Autowired
    public UserModelServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserModel saveUserModel(UserModel user){
        return userRepository.save(user);
    }

    @Override
    public Iterable<UserModel> getAllUserModel(){
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> getUserModelById(long id){
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserModel(long id){
        userRepository.deleteById(id);
    }
}
