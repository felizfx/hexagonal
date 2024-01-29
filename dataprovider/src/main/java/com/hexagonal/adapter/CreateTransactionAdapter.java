package com.hexagonal.adapter;

import com.hexagonal.adapter.mapper.CreateUserMapper;
import com.hexagonal.database.entity.UserEntity;
import com.hexagonal.database.repository.UserRespository;
import com.hexagonal.domain.transaction.CreateTransaction;
import com.hexagonal.domain.user.User;
import com.hexagonal.ports.output.CreateTransactionOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateTransactionAdapter implements CreateTransactionOutputPort {
    private final UserRespository userRespository;
    private final CreateUserMapper userMapper;
    @Override
    public User createTransaction(CreateTransaction transaction) {
        var payeer = userRespository.findUserByCpf(transaction.getPayeer());
        var payee = userRespository.findUserByCpf(transaction.getPayee());

        payeer.setWallet(payeer.getWallet() - transaction.getValue());
        payee.setWallet(payee.getWallet() + transaction.getValue());

        userRespository.save(payee);
        userRespository.save(payeer);

        return userMapper.toUser(payee);
    }
}
