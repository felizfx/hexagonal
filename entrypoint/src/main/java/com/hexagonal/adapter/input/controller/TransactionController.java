package com.hexagonal.adapter.input.controller;

import com.hexagonal.adapter.input.controller.contract.TransactionContract;
import com.hexagonal.adapter.input.controller.mapper.EntrypointTransactionMapper;
import com.hexagonal.adapter.input.controller.mapper.EntrypointUserMapper;
import com.hexagonal.domain.request.TransactionRequest;
import com.hexagonal.domain.response.UserResponse;
import com.hexagonal.ports.output.CreateTransactionOutputPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController implements TransactionContract {

    private final CreateTransactionOutputPort createTransactionOutputPort;
    private final EntrypointTransactionMapper transactionMapper;
    private final EntrypointUserMapper userMapper;

    @Override
    @PostMapping
    @Transactional
    public ResponseEntity<UserResponse> transfer(@RequestBody TransactionRequest request) {
        System.out.println(request);
        var transaction = createTransactionOutputPort.createTransaction(transactionMapper.toCreateTransaction(request));
        return ResponseEntity.status(HttpStatus.OK).body(userMapper.toUserResponse(transaction));
    }

}
