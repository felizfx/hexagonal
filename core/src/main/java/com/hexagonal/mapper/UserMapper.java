package com.hexagonal.mapper;

import com.hexagonal.domain.user.CreateUser;
import com.hexagonal.domain.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface UserMapper {
    User toUser(CreateUser createUser);
}
