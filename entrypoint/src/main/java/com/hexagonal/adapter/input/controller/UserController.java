package com.hexagonal.adapter.input.controller;

import com.hexagonal.adapter.input.controller.contract.UserContract;
import com.hexagonal.adapter.input.controller.mapper.EntrypointUserMapper;
import com.hexagonal.domain.request.CreateUserRequest;
import com.hexagonal.domain.response.UserResponse;
import com.hexagonal.domain.user.CreateUser;
import com.hexagonal.domain.user.User;
import com.hexagonal.ports.input.CreateUserInputPort;
import com.hexagonal.ports.input.FetchUserByCpfInputPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController implements UserContract {

    private final CreateUserInputPort createUserInputPort;
    private final FetchUserByCpfInputPort fetchUserByCpfInputPort;
    private final EntrypointUserMapper entrypointUserMapper;

    @Override
    @PostMapping
    @Transactional
    public ResponseEntity<UserResponse> createUser (@RequestBody CreateUserRequest request){
        CreateUser user = entrypointUserMapper.toCreateUser(request);
        System.out.println(user);
        User createdUser = createUserInputPort.createUser(user);
        System.out.println(createdUser);
        UserResponse response = entrypointUserMapper.toUserResponse(createdUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("/{cpf}")
    public ResponseEntity<UserResponse> getUserByCpf(@PathVariable String cpf) {
        var user = fetchUserByCpfInputPort.fetch(cpf);

        return ResponseEntity.status(HttpStatus.OK).body(entrypointUserMapper.toUserResponse(user));
    }


}
