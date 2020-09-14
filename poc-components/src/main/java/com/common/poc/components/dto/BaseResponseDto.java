package com.common.poc.components.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class BaseResponseDto<T> implements Serializable {

  private String code;
  private String message;
  private T data;
  private Iterable<? extends BaseErrorDto> errors;

  public static BaseResponseDto ok() {
    return BaseResponseDto.builder()
        .code(RESPONSE_SUCCESS_CODE)
        .message(RESPONSE_SUCCESS_MESSAGE)
        .build();
  }

  public static <T> BaseResponseDto ok(T data) {
    return BaseResponseDto.builder()
        .code(RESPONSE_SUCCESS_CODE)
        .message(RESPONSE_SUCCESS_MESSAGE)
        .data(data)
        .build();
  }

  public static BaseResponseDto fail() {
    return BaseResponseDto.builder()
        .code(RESPONSE_FAILURE_CODE)
        .message(RESPONSE_FAILURE_MESSAGE)
        .build();
  }

  public static <T> BaseResponseDto fail(T data) {
    return BaseResponseDto.builder()
        .code(RESPONSE_FAILURE_CODE)
        .message(RESPONSE_FAILURE_MESSAGE)
        .data(data)
        .build();
  }

  public static BaseResponseDto fail(
      Iterable<? extends BaseErrorDto> errors) {
    return BaseResponseDto.builder()
        .code(RESPONSE_FAILURE_CODE)
        .message(RESPONSE_FAILURE_MESSAGE)
        .errors(errors)
        .build();
  }

  public static <T> BaseResponseDto fail(
      T data,
      Iterable<? extends BaseErrorDto> errors) {
    return BaseResponseDto.builder()
        .code(RESPONSE_FAILURE_CODE)
        .message(RESPONSE_FAILURE_MESSAGE)
        .data(data)
        .errors(errors)
        .build();
  }

  private static final String RESPONSE_SUCCESS_CODE = "1";
  private static final String RESPONSE_SUCCESS_MESSAGE = "OK";
  private static final String RESPONSE_FAILURE_CODE = "0";
  private static final String RESPONSE_FAILURE_MESSAGE = "Failed";
}
