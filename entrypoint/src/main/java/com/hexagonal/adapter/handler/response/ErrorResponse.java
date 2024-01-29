package com.hexagonal.adapter.handler.response;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
@JsonInclude(NON_NULL)
public class ErrorResponse {
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String errorCode;
    private String path;
}
