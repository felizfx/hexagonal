package com.hexagonal.ports.output;

import com.hexagonal.domain.user.CreateUser;

public interface CreateUserOutputPort {
    CreateUser createUser (CreateUser user);
}
