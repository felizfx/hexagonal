package com.hexagonal.ports.output;

import com.hexagonal.domain.transaction.CreateTransaction;
import com.hexagonal.domain.user.CreateUser;
import com.hexagonal.domain.user.User;

public interface CreateTransactionOutputPort {
    User createTransaction(CreateTransaction transaction);
}
