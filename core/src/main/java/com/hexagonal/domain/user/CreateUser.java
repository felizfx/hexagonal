package com.hexagonal.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreateUser {
    private String id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private Double wallet;
}
