package com.hexagonal.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "users")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserEntity {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "cpf")
    private String cpf;

    @Field(name = "email")
    private String email;

    @Field(name = "password")
    private String password;

    @Field(name = "wallet")
    private Double wallet;
}