package com.hexagonal.database.repository;

import com.hexagonal.database.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends MongoRepository<UserEntity, String> {
    UserEntity findUserByCpf(String cpf);
}
