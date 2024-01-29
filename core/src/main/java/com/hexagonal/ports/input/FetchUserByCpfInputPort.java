package com.hexagonal.ports.input;

import com.hexagonal.domain.user.User;

public interface FetchUserByCpfInputPort {
    public User fetch(String cpf);
}
