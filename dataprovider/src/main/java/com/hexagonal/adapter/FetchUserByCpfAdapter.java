package com.hexagonal.adapter;

import com.hexagonal.adapter.mapper.FetchUserMapper;
import com.hexagonal.database.entity.UserEntity;
import com.hexagonal.database.repository.UserRespository;
import com.hexagonal.domain.user.User;
import com.hexagonal.ports.output.FetchUserByCpfOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FetchUserByCpfAdapter implements FetchUserByCpfOutputPort {
    private final UserRespository userRespository;
    private final FetchUserMapper fetchUserMapper;

    @Override
    public User fetch(String cpf) {
        UserEntity user = userRespository.findUserByCpf(cpf);
        return fetchUserMapper.toUser(user);
    }
}
