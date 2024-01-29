package com.hexagonal.domain.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponse {
    @Schema(description = "Quote id", example = "6589fba35395d3e63b62a185")
    private String id;

    @Schema(description = "Quote name", example = "Nome Sobrenome")
    private String name;

    @Schema(description = "Quote cpf", example = "123456789-10")
    private String cpf;

    @Schema(description = "Quote email", example = "example@gmail.com")
    private String email;

    @Schema(description = "Quote email", example = "1000")
    private Double wallet;
}
