package com.hexagonal.adapter.input.controller.contract;

import com.hexagonal.adapter.handler.response.ErrorResponse;
import com.hexagonal.domain.request.CreateUserRequest;
import com.hexagonal.domain.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

@Tag(name = "User")
public interface UserContract {
    @Operation(summary = "Create new user", description = "Create a new user")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "User created successfully",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class)) }
            ),
//            @ApiResponse(responseCode = "400", description = "Bad Request",
//                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BadRequestResponse.class))}
//            ),
//            @ApiResponse(responseCode = "404", description = "Not found",
//                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}
//            ),
            @ApiResponse(responseCode = "500", description = "Unexpected error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}
            )
    } )
    ResponseEntity<UserResponse> createUser(@Valid CreateUserRequest request);

    @Operation(summary = "Get user", description = "Get user by CPF")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Fetch user successfully",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class)) }
            ),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }
            ),
            @ApiResponse(responseCode = "500", description = "Unexpected error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}
            )
    } )
    ResponseEntity<UserResponse> getUserByCpf(String cpf);
}
