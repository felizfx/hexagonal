package com.hexagonal.ports.input;

import com.hexagonal.domain.transaction.CreateTransaction;
import com.hexagonal.domain.user.User;

public interface TransactionInputPort {
    public User transfer(CreateTransaction transaction);
}
