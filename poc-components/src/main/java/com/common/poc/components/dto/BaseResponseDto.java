package com.common.poc.components.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponseDto<T> {

  private String code;
  private String message;
  private T data;
  private Iterable<? extends BaseErrorDto> errors;
}
