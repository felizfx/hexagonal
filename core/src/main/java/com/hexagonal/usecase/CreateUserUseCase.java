package com.hexagonal.usecase;

import com.hexagonal.domain.user.CreateUser;
import com.hexagonal.domain.user.User;
import com.hexagonal.mapper.UserMapper;
import com.hexagonal.ports.input.CreateUserInputPort;
import com.hexagonal.ports.output.CreateUserOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase implements CreateUserInputPort {
    private final CreateUserOutputPort createUserOutputPort;
    private final UserMapper userMapper;
    @Override
    public User createUser(CreateUser user) {
        return userMapper.toUser(createUserOutputPort.createUser(user));
    }
}
