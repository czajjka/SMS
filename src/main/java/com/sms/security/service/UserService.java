package com.sms.security.service;

import com.sms.security.model.UserDtls;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public UserDtls createUser(UserDtls user);
}
