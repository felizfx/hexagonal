package com.hexagonal.adapter.input.controller.mapper;

import com.hexagonal.database.repository.UserRespository;
import com.hexagonal.domain.request.TransactionRequest;
import com.hexagonal.domain.response.UserResponse;
import com.hexagonal.domain.transaction.CreateTransaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface EntrypointTransactionMapper {
    CreateTransaction toCreateTransaction(TransactionRequest request);
}
