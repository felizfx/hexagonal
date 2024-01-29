package com.hexagonal.adapter;

import com.hexagonal.adapter.mapper.CreateUserMapper;
import com.hexagonal.database.repository.UserRespository;
import com.hexagonal.domain.user.CreateUser;
import com.hexagonal.ports.output.CreateUserOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateUserAdapter implements CreateUserOutputPort {
    private final UserRespository userRespository;
    private final CreateUserMapper createUserMapper;

    @Override
    public CreateUser createUser(CreateUser user) {
        var createdUser = userRespository.save(createUserMapper.toUserEntity(user));
        return createUserMapper.toCreateUser(createdUser);
    }
}
