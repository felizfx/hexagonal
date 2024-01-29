package com.hexagonal.usecase;

import com.hexagonal.domain.user.User;
import com.hexagonal.exception.UserNotFoundException;
import com.hexagonal.ports.input.FetchUserByCpfInputPort;
import com.hexagonal.ports.output.FetchUserByCpfOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FetchUserByCpfUseCase implements FetchUserByCpfInputPort {
    private final FetchUserByCpfOutputPort fetchUserByCpfOutputPort;
    @Override
    public User fetch(String cpf) {
        var user = fetchUserByCpfOutputPort.fetch(cpf);

        if(user == null) {
            throw new UserNotFoundException("User not found by this cpf");
        }

        return user;
    }
}
