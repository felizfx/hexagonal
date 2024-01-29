package com.hexagonal.adapter.mapper;

import com.hexagonal.database.entity.UserEntity;
import com.hexagonal.domain.user.CreateUser;
import com.hexagonal.domain.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateUserMapper {
    UserEntity toUserEntity (CreateUser user);
    CreateUser toCreateUser (UserEntity user);
    User toUser(UserEntity userEntity);
}
