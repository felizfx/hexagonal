package com.hexagonal.adapter.handler.response;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
@ToString
@JsonInclude(NON_NULL)
public class BadRequestResponse extends ErrorResponse{
    private List<FieldErrorResponse> errors;
}
