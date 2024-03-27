package com.sms.security.service;

import com.sms.security.model.UserDtls;
import com.sms.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDtls createUser(UserDtls user) {
        return userRepository.save(user);
    }
}
