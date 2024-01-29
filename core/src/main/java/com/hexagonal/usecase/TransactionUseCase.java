package com.hexagonal.usecase;

import com.hexagonal.domain.transaction.CreateTransaction;
import com.hexagonal.domain.user.User;
import com.hexagonal.exception.UserNotFoundException;
import com.hexagonal.ports.input.TransactionInputPort;
import com.hexagonal.ports.output.CreateTransactionOutputPort;
import com.hexagonal.ports.output.FetchUserByCpfOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionUseCase implements TransactionInputPort {
    private final CreateTransactionOutputPort createTransactionOutputPort;
    private final FetchUserByCpfOutputPort fetchUserByCpfOutputPort;

    @Override
    public User transfer(CreateTransaction transaction) {
        var payeer = fetchUserByCpfOutputPort.fetch(transaction.getPayeer());
        var payee = fetchUserByCpfOutputPort.fetch(transaction.getPayee());

        if(payeer == null || payee == null) {
            throw new UserNotFoundException("User not found");
        }

        return createTransactionOutputPort.createTransaction(transaction);
    }
}