package com.hexagonal.ports.output;

import com.hexagonal.domain.user.User;

public interface FetchUserByCpfOutputPort {
    public User fetch(String cpf);
}
