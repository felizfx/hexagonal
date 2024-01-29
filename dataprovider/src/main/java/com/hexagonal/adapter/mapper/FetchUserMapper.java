package com.hexagonal.adapter.mapper;

import com.hexagonal.database.entity.UserEntity;
import com.hexagonal.domain.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface FetchUserMapper {
    User toUser(UserEntity userEntity);
}
