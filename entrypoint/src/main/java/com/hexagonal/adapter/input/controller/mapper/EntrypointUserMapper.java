package com.hexagonal.adapter.input.controller.mapper;

import com.hexagonal.domain.request.CreateUserRequest;
import com.hexagonal.domain.response.UserResponse;
import com.hexagonal.domain.user.CreateUser;
import com.hexagonal.domain.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface EntrypointUserMapper {
    CreateUser toCreateUser(CreateUserRequest createUserRequest);
    UserResponse toUserResponse(User user);
}
