package com.hexagonal.adapter.input.controller.contract;

import com.hexagonal.adapter.handler.response.ErrorResponse;
import com.hexagonal.domain.request.TransactionRequest;
import com.hexagonal.domain.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

@Tag(name = "Transaction")
public interface TransactionContract {
    @Operation(summary = "Create new transaction", description = "Create a new transaction")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "User created successfully",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class)) }
            ),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}
            ),
            @ApiResponse(responseCode = "500", description = "Unexpected error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}
            )
    } )
    public ResponseEntity<UserResponse> transfer(@Valid TransactionRequest request);
}
