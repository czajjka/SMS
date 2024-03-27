package com.sms.security.service;

import com.sms.security.model.UserDtls;
import org.springframework.stereotype.Service;

public interface UserService {

    public UserDtls createUser(UserDtls user);

    public boolean checkEmail(String email);

}
