package com.hexagonal.ports.input;

import com.hexagonal.domain.user.CreateUser;
import com.hexagonal.domain.user.User;

public interface CreateUserInputPort {
    public User createUser(CreateUser user);
}
